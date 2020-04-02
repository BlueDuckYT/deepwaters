package bernie.software.biome.provider;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.annotation.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.gen.feature.structure.Structure;

public class DeepWatersSingleBiomeProvider extends BiomeProvider
{
	private final Biome biome;

	public DeepWatersSingleBiomeProvider(SingleBiomeProviderSettings settings) {
		this.biome = settings.getBiome();
	}

	/**
	 * Gets the biome from the provided coordinates
	 */
	public Biome getBiome(int x, int y) {
		return this.biome;
	}

	public Biome[] getBiomes(int x, int z, int width, int length, boolean cacheFlag) {
		Biome[] abiome = new Biome[width * length];
		Arrays.fill(abiome, 0, width * length, this.biome);
		return abiome;
	}

	@Nullable
	public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random) {
		return biomes.contains(this.biome) ? new BlockPos(x - range + random.nextInt(range * 2 + 1), 0, z - range + random.nextInt(range * 2 + 1)) : null;
	}

	public boolean hasStructure(Structure<?> structureIn) {
		Biome biome = this.biome;
		return this.hasStructureCache.computeIfAbsent(structureIn, this.biome::hasStructure);
	}

	public Set<BlockState> getSurfaceBlocks() {
		if (this.topBlocksCache.isEmpty()) {
			this.topBlocksCache.add(this.biome.getSurfaceBuilderConfig().getTop());
		}

		return this.topBlocksCache;
	}

	public Set<Biome> getBiomesInSquare(int centerX, int centerZ, int sideLength) {
		return Sets.newHashSet(this.biome);
	}
}