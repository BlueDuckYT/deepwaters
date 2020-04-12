package bernie.software.commands;

import bernie.software.ForgeBusEventSubscriber;
import bernie.software.ModEventSubscriber;
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
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

import static bernie.software.ModEventSubscriber.DeepWatersDimension;

public class DeepWatersCommand implements Command<CommandSource>
{

	private static final DeepWatersCommand CMD = new DeepWatersCommand();

	public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher)
	{
		return Commands.literal("deepwaters")
				.requires(cs -> cs.hasPermissionLevel(0))
				.executes(CMD);
	}

	@Override
	public int run(CommandContext<CommandSource> context) throws CommandSyntaxException
	{
		ServerPlayerEntity player = context.getSource().asPlayer();
		int x = player.getPosition().getX();
		int z = player.getPosition().getZ();
		DimensionType deepWatersDimensionType = DimensionType.byName(ForgeBusEventSubscriber.DIMENSION_TYPE_RL);
		if (player.dimension.equals(deepWatersDimensionType))
		{
			ServerWorld deepWatersWorld = player.server.getWorld(deepWatersDimensionType);
			ChunkPos spawnChunk = new ChunkPos(0, 0);
			BlockPos spawnPos = deepWatersWorld.dimension.findSpawn(spawnChunk, false);
			player.teleport(deepWatersWorld, spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), 0, 0);
		}
		else
		{

		}
		return 0;
	}
}