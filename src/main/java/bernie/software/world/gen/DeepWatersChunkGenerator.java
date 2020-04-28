package bernie.software.world.gen;

import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.*;

public class DeepWatersChunkGenerator extends NoiseChunkGenerator<DeepWatersGenSettings>
{
	private final double[] field_222573_h = this.func_222572_j();
	private final DeepWatersNoiseGenerator surfaceDepthNoise;

	public DeepWatersChunkGenerator(World p_i48694_1_, BiomeProvider p_i48694_2_, DeepWatersGenSettings p_i48694_3_)
	{
		super(p_i48694_1_, p_i48694_2_, 2, 16, 250, p_i48694_3_, false);
		this.surfaceDepthNoise = (new DeepWatersNoiseGenerator(this.randomSeed, 3, 0));
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

		this.makeBedrock(p_225551_2_, sharedseedrandom);
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

}