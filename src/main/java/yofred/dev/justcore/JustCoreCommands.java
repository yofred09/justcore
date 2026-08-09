package yofred.dev.justcore;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import yofred.dev.justcore.api.JustCoreApi;

public final class JustCoreCommands {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("justcore")
                .requires(source -> source.hasPermission(2))
                .then(Commands.literal("info").executes(context -> info(context.getSource())))
                .then(Commands.literal("modules").executes(context -> modules(context.getSource()))));
    }

    private static int info(CommandSourceStack source) {
        source.sendSuccess(() -> Component.literal("Just Core API v" + JustCoreApi.apiVersion() + " | " + JustCoreApi.modules().size() + " registered module(s)"), false);
        return 1;
    }

    private static int modules(CommandSourceStack source) {
        var modules = JustCoreApi.modules();
        source.sendSuccess(() -> Component.literal(modules.isEmpty() ? "No companion modules registered." : "Just modules: " + String.join(", ", modules.stream().map(module -> module.displayName() + " " + module.version()).toList())), false);
        return modules.size();
    }

    private JustCoreCommands() {}
}
