package blueduck.deepwaters.world.biome;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.DefaultSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class SurfaceBuilderBase extends DefaultSurfaceBuilder {
	public SurfaceBuilderBase(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51315_1_) {
		super(p_i51315_1_);
	}
	
	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		this.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, config.getTop(), config.getUnder(), config.getUnderWaterMaterial(), seaLevel);
	}
	
	@Override
	protected void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, BlockState top, BlockState middle, BlockState bottom, int sealevel)
	{
		BlockState topBlock = top;
		BlockState middleBlock = middle;
		BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable();
		int genMiddleOrTop = -1;
		double noise2 = noise;
		if (biomeIn instanceof WaterBiomeBase) {
			noise2=(noise2*((WaterBiomeBase)biomeIn).getNoiseFactor());
		}
		double randomNumber = random.nextDouble();
		if (biomeIn instanceof WaterBiomeBase) {
			randomNumber=(randomNumber*((WaterBiomeBase)biomeIn).getNoiseFactor());
		}
		int height = ((int)((noise2 / 3.0D + 3.0D + randomNumber * 0.25D)));
		int chunkCoordsX = x & 15;
		int chunkCoordsY = z & 15;
		
		for(int yCoord = startHeight; yCoord >= 0; --yCoord)
		{
			mutableBlockPos.setPos(chunkCoordsX, yCoord, chunkCoordsY);
			BlockState CurrentState = chunkIn.getBlockState(mutableBlockPos);
			if (CurrentState.isAir())
			{
				genMiddleOrTop = -1;
			} else if (CurrentState.getBlock() == defaultBlock.getBlock())
			{
				if (genMiddleOrTop == -1)
				{
					if (height <= 0)
					{
						topBlock = Blocks.AIR.getDefaultState();
						middleBlock = defaultBlock;
					} else if (yCoord >= sealevel - 4 && yCoord <= sealevel + 1)
					{
						topBlock = top;
						middleBlock = middle;
					}
					
					if (yCoord < sealevel && (topBlock == null || topBlock.isAir()))
					{
						if (biomeIn.getTemperature(mutableBlockPos.setPos(x, yCoord, z)) < 0.15F)
						{
							topBlock = Blocks.ICE.getDefaultState();
						} else
						{
							topBlock = defaultFluid;
						}
						
						mutableBlockPos.setPos(chunkCoordsX, yCoord, chunkCoordsY);
					}
					
					genMiddleOrTop = height;
					if (yCoord >= sealevel - 1)
					{
						chunkIn.setBlockState(mutableBlockPos, topBlock, false);
					} else if (yCoord < sealevel - 7 - height)
					{
						topBlock = Blocks.AIR.getDefaultState();
						middleBlock = defaultBlock;
						chunkIn.setBlockState(mutableBlockPos, bottom, false);
					} else
					{
						chunkIn.setBlockState(mutableBlockPos, middleBlock, false);
					}
				} else if (genMiddleOrTop > 0)
				{
					--genMiddleOrTop;
					chunkIn.setBlockState(mutableBlockPos, middleBlock, false);
					if (genMiddleOrTop == 0 && middleBlock.getBlock() == Blocks.SAND && height > 1)
					{
						genMiddleOrTop = random.nextInt(4) + Math.max(0, yCoord - 63);
						middleBlock = middleBlock.getBlock() == Blocks.RED_SAND ? Blocks.RED_SANDSTONE.getDefaultState() : Blocks.SANDSTONE.getDefaultState();
					}
				}
			}
		}
		
//		chunkIn.setBlockState(new BlockPos(x,height,z),Blocks.RED_STAINED_GLASS.getDefaultState(),false);
	}
}
