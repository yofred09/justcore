package yofred.dev.justcore.api;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.UUID;
import com.mojang.logging.LogUtils;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.storage.LevelResource;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;
import yofred.dev.justcore.api.event.StaffActionEvent;

/** Central append-only audit log used by Just server mods. */
public final class AuditService {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static AuditEntry record(MinecraftServer server, String moduleId, String action, UUID actor, UUID target, String details) {
        AuditEntry entry = new AuditEntry(Instant.now(), moduleId, action, actor, target, details);
        NeoForge.EVENT_BUS.post(new StaffActionEvent(entry));
        Path directory = server.getWorldPath(LevelResource.ROOT).resolve("justcore");
        Path log = directory.resolve("audit.jsonl");
        try {
            Files.createDirectories(directory);
            Files.writeString(log, json(entry) + System.lineSeparator(), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException exception) {
            LOGGER.error("Could not write Just Core audit entry", exception);
        }
        return entry;
    }

    private static String json(AuditEntry entry) {
        return "{\"timestamp\":\"" + entry.timestamp() + "\",\"module\":\"" + escape(entry.moduleId()) + "\",\"action\":\"" + escape(entry.action())
                + "\",\"actor\":" + uuid(entry.actor()) + ",\"target\":" + uuid(entry.target()) + ",\"details\":\"" + escape(entry.details()) + "\"}";
    }

    private static String uuid(UUID value) { return value == null ? "null" : "\"" + value + "\""; }
    private static String escape(String value) { return value.replace("\\", "\\\\").replace("\"", "\\\"").replace("\r", "\\r").replace("\n", "\\n"); }
    public static void close() { /* Reserved for buffered audit backends. */ }
    private AuditService() {}
}
