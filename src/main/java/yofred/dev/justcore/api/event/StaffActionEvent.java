package yofred.dev.justcore.api.event;

import net.neoforged.bus.api.Event;
import yofred.dev.justcore.api.AuditEntry;

/** Fired whenever a Just mod records a staff action. */
public final class StaffActionEvent extends Event {
    private final AuditEntry entry;
    public StaffActionEvent(AuditEntry entry) { this.entry = entry; }
    public AuditEntry entry() { return entry; }
}
