package bernie.software.world.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersEntities;
import bernie.software.world.biome.ThickKelpForest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.*;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.WorldEntitySpawner;
import net.minecraftforge.common.BiomeDictionary;

public class DeepWatersChunkGenerator extends NoiseChunkGenerator<DeepWatersGenSettings>
{
	private final double[] field_222573_h = this.func_222572_j();
	private final DeepWatersNoiseGenerator surfaceDepthNoise;

	private OverworldChunkGenerator gen1;

	private int verticalNoiseGranularity = 16;
	private int horizontalNoiseGranularity = 2;
	public DeepWatersChunkGenerator(World p_i48694_1_, BiomeProvider p_i48694_2_, DeepWatersGenSettings p_i48694_3_)
	{
		super(p_i48694_1_, p_i48694_2_, 2, 16, 250, p_i48694_3_, false);
		this.surfaceDepthNoise = (new DeepWatersNoiseGenerator(this.randomSeed, 3, 0));
		gen1=new OverworldChunkGenerator(p_i48694_1_,p_i48694_2_,new OverworldGenSettings());
	}

	@Override
	public void spawnMobs(WorldGenRegion region)
	{
		region.getWorld().getProfiler().startSection("spawn");
		int i = region.getMainChunkX();
		int j = region.getMainChunkZ();

		Biome biome = Registry.BIOME.getByValue(region.getChunk(i, j).getBiomes().getBiomeIds()[0]);
		SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
		sharedseedrandom.setDecorationSeed(region.getSeed(), i << 4, j << 4);
		WorldEntitySpawner.performWorldGenSpawning(region, biome, i, j, sharedseedrandom);
		region.getWorld().getProfiler().endSection();

	}

	protected void fillNoiseColumn(double[] noiseColumn, int noiseX, int noiseZ)
	{
		double d0 = 684.412D;
		double d1 = 2053.236D;
		double d2 = 8.555150000000001D;
		double d3 = 34.2206D;
		int i = -10;
		int j = 3;
		this.calcNoiseColumn(noiseColumn, noiseX, noiseZ, 684.412D, 2053.236D, 8.555150000000001D, 34.2206D, 3, -10);
	}

	protected double[] getBiomeNoiseColumn(int noiseX, int noiseZ)
	{
		return new double[]{0.0D, 0.0D};
	}

	@Override
	public void generateSurface(WorldGenRegion p_225551_1_, IChunk p_225551_2_) {

		ChunkPos chunkpos = p_225551_2_.getPos();
		int i = chunkpos.x;
		int j = chunkpos.z;
		SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
		sharedseedrandom.setBaseChunkSeed(i, j);
		if (p_225551_1_.getBiome(p_225551_2_.getPos().asBlockPos()) instanceof ThickKelpForest) {
			gen1.generateSurface(p_225551_1_,p_225551_2_);
		} else {
			ChunkPos chunkpos1 = p_225551_2_.getPos();
			int k = chunkpos1.getXStart();
			int l = chunkpos1.getZStart();
			double d0 = 0.0625D;
			BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

			for(int i1 = 0; i1 < 16; ++i1) {
				for(int j1 = 0; j1 < 16; ++j1) {
					int k1 = k + i1;
					int l1 = l + j1;
					int i2 = p_225551_2_.getTopBlockY(Heightmap.Type.WORLD_SURFACE_WG, i1, j1) + 1;
					double d1 = this.surfaceDepthNoise.noiseAt((double)k1 * 0.0625D, (double)l1 * 0.0625D, 0.0625D, (double)i1 * 0.0625D,p_225551_1_.getBiome(new BlockPos((k1),0,(l1)))) * 15.0D;
					p_225551_1_.getBiome(blockpos$mutable.setPos(k + i1, i2, l + j1)).buildSurface(sharedseedrandom, p_225551_2_, k1, l1, i2, d1, this.getSettings().getDefaultBlock(), this.getSettings().getDefaultFluid(), this.getSeaLevel(), this.world.getSeed());
				}
			}
		}
		this.makeBedrock(p_225551_2_, sharedseedrandom);
	}

	protected void makeBedrock(IChunk chunkIn, Random rand) {
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
		int i = chunkIn.getPos().getXStart();
		int j = chunkIn.getPos().getZStart();
		int k = settings.getBedrockFloorHeight();
		int l = settings.getBedrockRoofHeight();

		for(BlockPos blockpos : BlockPos.getAllInBoxMutable(i, 0, j, i + 15, 0, j + 15)) {
			if (l > 0) {
				for(int i1 = l; i1 >= l - 4; --i1) {
					if (i1 >= l - rand.nextInt(5)) {
						chunkIn.setBlockState(blockpos$mutable.setPos(blockpos.getX(), i1, blockpos.getZ()), DeepWatersBlocks.MAGMATIC_ROCK.get().getDefaultState(), false);
					}
				}
			}

			if (k < 256) {
				for(int j1 = k + 4; j1 >= k; --j1) {
					if (j1 <= k + rand.nextInt(5)) {
						chunkIn.setBlockState(blockpos$mutable.setPos(blockpos.getX(), j1, blockpos.getZ()), DeepWatersBlocks.MAGMATIC_ROCK.get().getDefaultState(), false);
					}
				}
			}
		}

	}

	protected double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_)
	{
		return this.field_222573_h[p_222545_5_];
	}

	private double[] func_222572_j()
	{
		double[] adouble = new double[this.noiseSizeY()];

		for (int i = 0; i < this.noiseSizeY(); ++i)
		{
			adouble[i] = Math.cos((double) i * Math.PI * 6.0D / (double) this.noiseSizeY()) * 2.0D;
			double d0 = (double) i;
			if (i > this.noiseSizeY() / 2)
			{
				d0 = (double) (this.noiseSizeY() - 1 - i);
			}

			// Mess around with this number cause apparently its magical
			if (d0 < 1.0D)
			{
				d0 = 4.0D - d0;
				adouble[i] -= d0 * d0 * d0 * 10.0D;
			}
		}

		return adouble;
	}


	public int getGroundHeight()
	{
		return this.world.getSeaLevel() + 1;
	}

	public int getMaxHeight()
	{
		return 256;
	}

	public int getSeaLevel()
	{
		return 230;
	}

	public int getTopBlock(int p_222529_1_, int p_222529_2_, Heightmap.Type heightmapType, int minYValue, int maxYValue)
	{
		int i = Math.floorDiv(p_222529_1_, this.horizontalNoiseGranularity);
		int j = Math.floorDiv(p_222529_2_, this.horizontalNoiseGranularity);
		int k = Math.floorMod(p_222529_1_, this.horizontalNoiseGranularity);
		int l = Math.floorMod(p_222529_2_, this.horizontalNoiseGranularity);
		double d0 = (double)k / (double)this.horizontalNoiseGranularity;
		double d1 = (double)l / (double)this.horizontalNoiseGranularity;
		double[][] adouble = new double[][]{this.func_222547_b(i, j), this.func_222547_b(i, j + 1), this.func_222547_b(i + 1, j), this.func_222547_b(i + 1, j + 1)};
		int i1 = this.getSeaLevel();

		for(int j1 = this.noiseSizeY() - 2; j1 >= 0; --j1) {
			double d2 = adouble[0][j1];
			double d3 = adouble[1][j1];
			double d4 = adouble[2][j1];
			double d5 = adouble[3][j1];
			double d6 = adouble[0][j1 + 1];
			double d7 = adouble[1][j1 + 1];
			double d8 = adouble[2][j1 + 1];
			double d9 = adouble[3][j1 + 1];

			for(int k1 = this.verticalNoiseGranularity - 1; k1 >= 0; --k1) {
				double d10 = (double)k1 / (double)this.verticalNoiseGranularity;
				double d11 = MathHelper.lerp3(d10, d0, d1, d2, d6, d4, d8, d3, d7, d5, d9);
				int yPos = j1 * this.verticalNoiseGranularity + k1;

				if ((d11 > 0.0D || yPos < i1) && yPos <= maxYValue && yPos >= minYValue) {
					BlockState blockstate;
					if (d11 > 0.0D) {
						blockstate = this.defaultBlock;
					} else {
						blockstate = this.defaultFluid;
					}

					if (heightmapType.getHeightLimitPredicate().test(blockstate)) {
						return yPos + 1;
					}
				}
			}
		}

		return 0;
	}
}