package blueduck.deepwaters.world.gen.features;

import blueduck.deepwaters.registry.DeepWatersBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
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
        int worldInHeight = worldIn.getHeight(Heightmap.Type.OCEAN_FLOOR, pos.getX(), pos.getZ());
        BlockPos blockpos = new BlockPos(pos.getX(), worldInHeight, pos.getZ());

        Block deadWoodLog = DeepWatersBlocks.DEADWOOD_LOG.get();

        if (worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER &&
                !(worldIn.getBlockState(blockpos.down()).getBlock() == deadWoodLog)) {
            BlockState blockstate = DeepWatersBlocks.DEADWOOD_LOG.get().getDefaultState();
            int treeHeight = 1 + rand.nextInt(7);

            for (int l = 0; l <= treeHeight; ++l) {
                if (worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.up()).getBlock() == Blocks.WATER && blockstate.isValidPosition(worldIn, blockpos)) {
                    if (l == treeHeight) {
                        int height = rand.nextInt(3) + rand.nextInt(3) + 5;

                        Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                        int k2 = height - rand.nextInt(4) - 1;
                        int l2 = 3 - rand.nextInt(3);
                        int i3 = pos.getX();
                        int j3 = pos.getZ();

                        for (int k1 = 0; k1 < height; ++k1) {
                            int l1 = pos.getY() + k1;
                            if (k1 >= k2 && l2 > 0) {
                                i3 += direction.getXOffset();
                                j3 += direction.getZOffset();
                                --l2;
                            }
                            BlockPos blockpos2 = new BlockPos(i3, l1, j3);
                            worldIn.setBlockState(blockpos2, deadWoodLog.getDefaultState(), 2);
                        }

                        Direction direction1 = Direction.Plane.HORIZONTAL.random(rand);
                        if (direction1 != direction) {
                            int i4 = k2 - rand.nextInt(2) - 1;
                            int l4 = 1 + rand.nextInt(3);

                            for (int i2 = i4; i2 < height && l4 > 0; --l4) {
                                if (i2 >= 1) {
                                    int j2 = pos.getY() + i2;
                                    i3 += direction1.getXOffset();
                                    j3 += direction1.getZOffset();
                                    BlockPos blockpos1 = new BlockPos(i3, j2, j3);
                                    worldIn.setBlockState(blockpos1, deadWoodLog.getDefaultState(), 2);
                                }

                                ++i2;
                            }
                        }


                        worldIn.setBlockState(blockpos, deadWoodLog.getDefaultState(), 2);
                    } else {
                        worldIn.setBlockState(blockpos, deadWoodLog.getDefaultState(), 2);
                    }
                } else if (l > 0) {
                    BlockPos blockpos1 = blockpos.down();
                    if (blockstate.isValidPosition(worldIn, blockpos1) && worldIn.getBlockState(blockpos1.down()).getBlock() != blockstate.getBlock()) {
                        worldIn.setBlockState(blockpos, deadWoodLog.getDefaultState(), 2);
                    }
                    break;
                }

                blockpos = blockpos.up();
            }
        }

        return true;
    }


}


