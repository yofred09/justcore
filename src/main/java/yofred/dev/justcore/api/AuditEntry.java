package yofred.dev.justcore.api;

import java.time.Instant;
import java.util.UUID;

/** One immutable staff/audit action. */
public record AuditEntry(Instant timestamp, String moduleId, String action, UUID actor, UUID target, String details) {
    public AuditEntry {
        if (timestamp == null) timestamp = Instant.now();
        if (moduleId == null || moduleId.isBlank()) throw new IllegalArgumentException("moduleId cannot be blank");
        if (action == null || action.isBlank()) throw new IllegalArgumentException("action cannot be blank");
        if (details == null) details = "";
    }
}
