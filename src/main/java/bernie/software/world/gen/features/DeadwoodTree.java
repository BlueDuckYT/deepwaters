package bernie.software.world.gen.features;

import bernie.software.registry.DeepWatersBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.*;

import java.util.Random;
import java.util.function.Function;


public class DeadwoodTree extends Feature {

    public DeadwoodTree(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator generator, Random rand, BlockPos pos, IFeatureConfig config) {
        int i = 0;
        int j = worldIn.getHeight(Heightmap.Type.OCEAN_FLOOR, pos.getX(), pos.getZ());
        BlockPos blockpos = new BlockPos(pos.getX(), j, pos.getZ());

        Block deadWoodLog = DeepWatersBlocks.DEADWOOD_LOG.get();

        if (worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER &&
                !(worldIn.getBlockState(blockpos.down()).getBlock() == deadWoodLog )) {
            BlockState blockstate = DeepWatersBlocks.DEADWOOD_LOG.get().getDefaultState();
            int k = 1 + rand.nextInt(7);
//
//            if (rand.nextInt(1000) <= 1) {
//                worldIn.setBlockState(pos.down(), DeepWatersBlocks.AQUASTONE_ORE.get().getDefaultState(), 2);
//            }

            for (int l = 0; l <= k; ++l) {
                if (worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.up()).getBlock() == Blocks.WATER && blockstate.isValidPosition(worldIn, blockpos)) {
                    if (l == k) {

                        worldIn.setBlockState(blockpos, deadWoodLog.getDefaultState(), 2);
                        ++i;
                    } else {
                        worldIn.setBlockState(blockpos, deadWoodLog.getDefaultState(), 2);
                    }
                } else if (l > 0) {
                    BlockPos blockpos1 = blockpos.down();
                    if (blockstate.isValidPosition(worldIn, blockpos1) && worldIn.getBlockState(blockpos1.down()).getBlock() != blockstate.getBlock()) {
                        worldIn.setBlockState(blockpos, deadWoodLog.getDefaultState(), 2);
                        ++i;
                    }
                    break;
                }

                blockpos = blockpos.up();
            }
        }

        return i > 0;
    }
}


