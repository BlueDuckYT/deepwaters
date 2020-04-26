package bernie.software.world.gen.structures;

import bernie.software.registry.DeepWatersBlocks;
import bernie.software.utils.GeneralUtils;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SeaPickleBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.CountConfig;

import java.util.Random;
import java.util.function.Function;

public class CrystalineCoral extends Feature<CountConfig>
{
	public CrystalineCoral(Function<Dynamic<?>, ? extends CountConfig> p_i51442_1_)
	{
		super(p_i51442_1_);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<?> generator, Random rand, BlockPos pos, CountConfig config)
	{
		int i = 0;

		for (int j = 0; j < config.count; ++j)
		{
			int k = rand.nextInt(8) - rand.nextInt(8);
			int l = rand.nextInt(8) - rand.nextInt(8);
			int f = rand.nextInt(8) - rand.nextInt(8);
			if (f <= 0)
			{
				int i1 = worldIn.getHeight(Heightmap.Type.OCEAN_FLOOR, pos.getX() + k, pos.getZ() + l);
				BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
				BlockState blockstate = DeepWatersBlocks.CRYSTALINE_CORAL.get().getDefaultState();
				if (worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && blockstate.isValidPosition(worldIn,
						blockpos))
				{
					worldIn.setBlockState(blockpos, blockstate, 2);
					++i;
				}
			}
		}

		return i > 0;
	}
}
