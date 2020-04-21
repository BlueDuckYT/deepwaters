package bernie.software.utils;

import bernie.software.ForgeBusEventSubscriber;
import bernie.software.block.DeepWatersPortalPillarEnd;
import bernie.software.registry.DeepWatersBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;

public class WorldUtils
{
	public static int getDeepWatersSpawnHeight(ServerWorld deepWatersWorld, BlockPos location)
	{
		return deepWatersWorld.getHeight(Heightmap.Type.WORLD_SURFACE, location).getY() + 1;
	}

	public static BlockPos findPortalCenter(World world, BlockPos pos)
	{
		for (Direction dir : new Direction[]{Direction.WEST, Direction.EAST, Direction.SOUTH, Direction.NORTH})
		{
			for (int i = 1; i <= 4; i++)
			{
				Block block = world.getBlockState(
						pos.offset(dir, i)).getBlock();
				Block block1 = world.getBlockState(
						pos.offset(dir, i).east(1)).getBlock();
				Block block2 = world.getBlockState(
						pos.offset(dir, i).west(1)).getBlock();
				Block block3 = world.getBlockState(
						pos.offset(dir, i).south(1)).getBlock();
				Block block4 = world.getBlockState(
						pos.offset(dir, i).north(1)).getBlock();
				DeepWatersPortalPillarEnd pillarEnd = DeepWatersBlocks.ACTIVATED_PORTAL_PILLAR_END.get();
				if (block == pillarEnd)
				{
					return pos.offset(dir, i);
				}
				if (block1 == pillarEnd)
				{
					return pos.offset(dir, i).east(1);
				}
				if (block2 == pillarEnd)
				{
					return pos.offset(dir, i).west(1);
				}
				if (block3 == pillarEnd)
				{
					return pos.offset(dir, i).south(1);
				}
				if (block4 == pillarEnd)
				{
					return pos.offset(dir, i).north(1);
				}
			}
		}
		return null;
	}

	public static DimensionType getDeepWatersDimension()
	{
		return DimensionType.byName(ForgeBusEventSubscriber.DEEPWATERSDIMENSION);
	}
}
