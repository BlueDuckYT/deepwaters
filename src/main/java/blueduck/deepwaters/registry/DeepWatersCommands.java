package blueduck.deepwaters.registry;

import blueduck.deepwaters.DeepWatersMod;
import blueduck.deepwaters.commands.ForceSpawnCommand;
import blueduck.deepwaters.commands.TeleportDimensionCommand;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class DeepWatersCommands {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralCommandNode<CommandSource> commands = dispatcher.register(
                Commands.literal(DeepWatersMod.ModID)
                        .then(TeleportDimensionCommand.register(dispatcher))
                        .then(ForceSpawnCommand.register(dispatcher))
        );
        dispatcher.register(Commands.literal("dw").redirect(commands));
    }
}
