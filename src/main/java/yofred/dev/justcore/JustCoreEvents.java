package yofred.dev.justcore;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.server.ServerStoppedEvent;
import yofred.dev.justcore.api.AuditService;

@EventBusSubscriber(modid = JustCore.MODID)
public final class JustCoreEvents {
    @SubscribeEvent
    public static void commands(RegisterCommandsEvent event) { JustCoreCommands.register(event.getDispatcher()); }

    @SubscribeEvent
    public static void stopped(ServerStoppedEvent event) { AuditService.close(); }

    private JustCoreEvents() {}
}
