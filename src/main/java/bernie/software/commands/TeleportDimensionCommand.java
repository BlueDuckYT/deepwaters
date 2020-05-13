package bernie.software.commands;

import bernie.software.event.ForgeBusEventSubscriber;
import bernie.software.registry.DeepWatersBiomes;
import bernie.software.utils.TeleportUtils;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;

public class TeleportDimensionCommand implements Command<CommandSource> {

    private static final TeleportDimensionCommand CMD = new TeleportDimensionCommand();

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("tp")
                .requires(cs -> cs.hasPermissionLevel(2))
                .executes(CMD);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().asPlayer();
        int x = player.getPosition().getX();
        int z = player.getPosition().getZ();
        DimensionType deepWatersDimensionType = DimensionType.byName(ForgeBusEventSubscriber.DEEPWATERSDIMENSION);

        if (player.dimension.equals(DimensionType.OVERWORLD))
        {
            ServerWorld deepWatersWorld = player.server.getWorld(deepWatersDimensionType);
            ChunkPos pos = new ChunkPos(0, 0);
            BlockPos spawnPos = new BlockPos(0, 230, 0);
            TeleportUtils.SendDimensionChangePackets(deepWatersDimensionType, player, player.getEntityWorld().getWorldInfo());

            xLoop:
            for (int i = 0; i < 300; i++)
            {
                for (int j = 0; j < 300; j++)
                {
                    if (deepWatersWorld.getBiome(
                            new BlockPos(i * 16, 50, j * 16)) == DeepWatersBiomes.CoralFieldsBiome.get())
                    {
                        pos = new ChunkPos(i * 16, j * 16);
                        spawnPos = deepWatersWorld.dimension.findSpawn(pos, false);
                        if (spawnPos != null)
                        {
                            break xLoop;
                        }
                    }
                }
            }
            player.teleport(deepWatersWorld, spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), 0, 0);
        }
        else
        {
            context.getSource().sendFeedback(new TranslationTextComponent("command.deepwaters.wrong_dimension"), false);
        }
        return 1;
    }


}
