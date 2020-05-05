package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.commands.ForceSpawnCommand;
import bernie.software.commands.TeleportDimensionCommand;
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
