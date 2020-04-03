package bernie.software.world.gen;

import java.util.ArrayList;
import java.util.List;

import bernie.software.block.DeepWatersBlock;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

public class DeepWatersChunkGenerator extends DeepWatersNoiseChunkGenerator<DeepWatersGenSettings>
{
	private final double[] field_222573_h = this.func_222572_j();

	public DeepWatersChunkGenerator(World p_i48694_1_, BiomeProvider p_i48694_2_, DeepWatersGenSettings p_i48694_3_) {
		super(p_i48694_1_, p_i48694_2_, 2, 16, 260, p_i48694_3_, false);
	}

	protected void fillNoiseColumn(double[] noiseColumn, int noiseX, int noiseZ) {
		double d0 = 684.412D;
		double d1 = 2053.236D;
		double d2 = 8.555150000000001D;
		double d3 = 34.2206D;
		int i = -10;
		int j = 3;
		this.func_222546_a(noiseColumn, noiseX, noiseZ, 684.412D, 2053.236D, 8.555150000000001D, 34.2206D, 3, -10);
	}

	protected double[] getBiomeNoiseColumn(int noiseX, int noiseZ) {
		return new double[]{0.0D, 0.0D};
	}

	protected double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_) {
		return this.field_222573_h[p_222545_5_];
	}

	private double[] func_222572_j() {
		double[] adouble = new double[this.noiseSizeY()];

		for(int i = 0; i < this.noiseSizeY(); ++i) {
			adouble[i] = Math.cos((double)i * Math.PI * 6.0D / (double)this.noiseSizeY()) * 2.0D;
			double d0 = (double)i;
			if (i > this.noiseSizeY() / 2) {
				d0 = (double)(this.noiseSizeY() - 1 - i);
			}

			if (d0 < 4.0D) {
				d0 = 4.0D - d0;
				//adouble[i] -= d0 * d0 * d0 * 10.0D;
			}
		}

		return adouble;
	}

	public List<Biome.SpawnListEntry> getPossibleCreatures(EntityClassification creatureType, BlockPos pos) {

		Block block = world.getBlockState(pos.down()).getBlock();
		if(block == DeepWatersBlocks.OCEAN_FLOOR.get())
		{
			List<Biome.SpawnListEntry> spawns = new ArrayList<Biome.SpawnListEntry>();
			spawns.add(new Biome.SpawnListEntry(DeepWatersEntities.clam, 300, 1, 4));
			return spawns;
		}
		return super.getPossibleCreatures(creatureType, pos);
	}

	public int getGroundHeight() {
		return this.world.getSeaLevel() + 5;
	}

	public int getMaxHeight() {
		return 128;
	}

	public int getSeaLevel() {
		return 256;
	}

}