package yofred.dev.justcore.api;

import net.minecraft.server.level.ServerPlayer;

/** Exposes a private player state, such as vanish, without hard dependencies between mods. */
public interface PlayerStateProvider {
    String stateId();
    boolean isActive(ServerPlayer player);
    boolean canView(ServerPlayer viewer, ServerPlayer target);
}
