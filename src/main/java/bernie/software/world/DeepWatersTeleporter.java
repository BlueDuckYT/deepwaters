package bernie.software.world;

import bernie.software.registry.DeepWatersBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;

import java.util.function.Predicate;

public class DeepWatersTeleporter extends Teleporter
{
	public DeepWatersTeleporter(ServerWorld worldIn)
	{
		super(worldIn);
	}

	public static DeepWatersTeleporter getTeleporterForDim(MinecraftServer server, DimensionType dim)
	{
		ServerWorld ws = server.getWorld(dim);

		for (Teleporter t : ws.customTeleporters)
		{
			if (t instanceof DeepWatersTeleporter)
			{
				return (DeepWatersTeleporter) t;
			}
		}

		DeepWatersTeleporter tp = new DeepWatersTeleporter(ws);
		ws.customTeleporters.add(tp);
		return tp;
	}

	public static int getGroundLevel(World world, int x, int z)
	{
		// go from sea level up.  If we get grass, return that, otherwise return the last dirt, stone or gravel we got
		Chunk chunk = world.getChunk(x >> 4, z >> 4);
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		int lastDirt = 229;
		for (int y = 229; y < 256 - 1; y++)
		{
			Block block = chunk.getBlockState(pos.setPos(x, y, z)).getBlock();
			if (block == Blocks.SAND || block == DeepWatersBlocks.OCEAN_FLOOR.get())
			{
				return y + 1;
			}
		}
		return lastDirt;
	}

}
