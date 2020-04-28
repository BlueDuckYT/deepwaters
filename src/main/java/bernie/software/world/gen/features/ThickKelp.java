package bernie.software.world.gen.features;

import bernie.software.block.ThickKelpBlock;
import bernie.software.block.ThickKelpTopBlock;
import bernie.software.registry.DeepWatersBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.KelpTopBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.KelpFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

import static bernie.software.block.ThickKelpTopBlock.NEW;

public class ThickKelp extends KelpFeature {
    public ThickKelp(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51487_1_) {
        super(p_i51487_1_);
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int i = 0;
        int j = worldIn.getHeight(Heightmap.Type.OCEAN_FLOOR, pos.getX(), pos.getZ());
        BlockPos blockpos = new BlockPos(pos.getX(), j, pos.getZ());
        if (worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER&&
            !(worldIn.getBlockState(blockpos.down()).getBlock() instanceof ThickKelpBlock)) {
            BlockState blockstate1 = DeepWatersBlocks.THICK_KELP.get().getDefaultState();
            BlockState blockstate = DeepWatersBlocks.THICK_KELP_TOP.get().getDefaultState();
            int k = 1 + rand.nextInt(10);

            if (rand.nextInt(1000)<=1) {
                worldIn.setBlockState(pos.down(),DeepWatersBlocks.AQUASTONE_ORE.get().getDefaultState(),2);
            }

            for(int l = 0; l <= k; ++l) {
                if (worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER && worldIn.getBlockState(blockpos.up()).getBlock() == Blocks.WATER && blockstate1.isValidPosition(worldIn, blockpos)) {
                    if (l == k) {
                        worldIn.setBlockState(blockpos, ((ThickKelpBlock)blockstate.getBlock()).getStateForGeneration(blockstate,worldIn,blockpos).with(NEW,true), 2);
                        ++i;
                    } else {
                        worldIn.setBlockState(blockpos, ((ThickKelpBlock)blockstate1.getBlock()).getStateForGeneration(blockstate1,worldIn,blockpos), 2);
                    }
                } else if (l > 0) {
                    BlockPos blockpos1 = blockpos.down();
                    if (blockstate.isValidPosition(worldIn, blockpos1) && worldIn.getBlockState(blockpos1.down()).getBlock() != blockstate1.getBlock()) {
                        worldIn.setBlockState(blockpos, ((ThickKelpBlock)blockstate1.getBlock()).getStateForGeneration(blockstate,worldIn,blockpos), 2);
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
