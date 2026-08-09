package yofred.dev.justcore.api;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.server.level.ServerPlayer;
import yofred.dev.justcore.JustCore;

/** Stable public entry point shared by all Just server mods. */
public final class JustCoreApi {
    private static final Map<String, JustModule> MODULES = new ConcurrentHashMap<>();
    private static final Map<String, PlayerStateProvider> PLAYER_STATES = new ConcurrentHashMap<>();

    public static String apiVersion() { return JustCore.API_VERSION; }

    public static void registerModule(JustModule module) {
        JustModule previous = MODULES.putIfAbsent(module.id(), module);
        if (previous != null && !previous.equals(module)) throw new IllegalStateException("Module already registered: " + module.id());
    }

    public static List<JustModule> modules() {
        return MODULES.values().stream().sorted(Comparator.comparing(JustModule::id)).toList();
    }

    public static void registerPlayerState(PlayerStateProvider provider) {
        if (provider.stateId() == null || provider.stateId().isBlank()) throw new IllegalArgumentException("stateId cannot be blank");
        PlayerStateProvider previous = PLAYER_STATES.putIfAbsent(provider.stateId(), provider);
        if (previous != null && previous != provider) throw new IllegalStateException("Player state already registered: " + provider.stateId());
    }

    public static Optional<PlayerStateProvider> playerState(String stateId) { return Optional.ofNullable(PLAYER_STATES.get(stateId)); }
    public static boolean hasState(String stateId, ServerPlayer player) { return playerState(stateId).map(provider -> provider.isActive(player)).orElse(false); }
    public static boolean canViewState(String stateId, ServerPlayer viewer, ServerPlayer target) { return playerState(stateId).map(provider -> provider.canView(viewer, target)).orElse(true); }

    private JustCoreApi() {}
}
