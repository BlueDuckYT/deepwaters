package bernie.software.world.biome.provider;

import bernie.software.registry.DeepWatersBiomes;
import bernie.software.world.layer.DeepWatersLayerUtil;
import com.google.common.collect.Sets;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.block.BlockState;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.SimplexNoiseGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.storage.WorldInfo;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DeepWatersBiomeProvider extends BiomeProvider
{
	private final SimplexNoiseGenerator generator;
	private final SharedSeedRandom random;
	private final Layer genBiomes;
	private final Layer biomeFactoryLayer;
	private final Biome[] biomes = new Biome[]{
			DeepWatersBiomes.CoralFieldsBiome.get(),
			DeepWatersBiomes.SunkenWastesBiome.get()
	};

	public DeepWatersBiomeProvider(DeepWatersBiomeProviderSettings settings)
	{
		WorldInfo worldinfo = settings.getWorldInfo();
		Layer[] alayer = DeepWatersLayerUtil.makeLayers(worldinfo.getSeed());
		this.genBiomes = alayer[0];
		this.biomeFactoryLayer = alayer[1];

		this.random = new SharedSeedRandom(settings.getSeed());
		this.random.skip(17292);
		this.generator = new SimplexNoiseGenerator(this.random);

		getBiomesToSpawnIn().clear();
		getBiomesToSpawnIn().add(DeepWatersBiomes.CoralFieldsBiome.get());
	}


	@Override
	public Biome getBiome(int x, int y)
	{
		return this.biomeFactoryLayer.func_215738_a(x, y);
	}

	@Override
	public Biome getBiomeAtFactorFour(int factorFourX, int factorFourZ)
	{
		return this.genBiomes.func_215738_a(factorFourX, factorFourZ);
	}

	@Override
	public Biome[] getBiomes(int x, int z, int width, int length, boolean cacheFlag)
	{
		return this.biomeFactoryLayer.generateBiomes(x, z, width, length);
	}


	@Override
	public Set<Biome> getBiomesInSquare(int centerX, int centerZ, int sideLength)
	{
		int i = centerX - sideLength >> 2;
		int j = centerZ - sideLength >> 2;
		int k = centerX + sideLength >> 2;
		int l = centerZ + sideLength >> 2;
		int i1 = k - i + 1;
		int j1 = l - j + 1;
		Set<Biome> set = Sets.newHashSet();
		Collections.addAll(set, this.genBiomes.generateBiomes(i, j, i1, j1));
		return set;
	}

	@Override
	public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random)
	{
		int i = x - range >> 2;
		int j = z - range >> 2;
		int k = x + range >> 2;
		int l = z + range >> 2;
		int i1 = k - i + 1;
		int j1 = l - j + 1;
		Biome[] abiome = this.genBiomes.generateBiomes(i, j, i1, j1);
		BlockPos blockpos = null;
		int k1 = 0;

		for (int l1 = 0; l1 < i1 * j1; ++l1) {
			int i2 = i + l1 % i1 << 2;
			int j2 = j + l1 / i1 << 2;
			if (biomes.contains(abiome[l1])) {
				if (blockpos == null || random.nextInt(k1 + 1) == 0) {
					blockpos = new BlockPos(i2, 0, j2);
				}

				++k1;
			}
		}

		return blockpos;
	}

	@Override
	public boolean hasStructure(Structure<?> structureIn)
	{
		return this.hasStructureCache.computeIfAbsent(structureIn, (p_205008_1_) ->
		{
			for (Biome biome : this.biomes) {
				if (biome.hasStructure(p_205008_1_)) {
					return true;
				}
			}

			return false;
		});
	}

	@Override
	public Set<BlockState> getSurfaceBlocks()
	{
		if (this.topBlocksCache.isEmpty()) {
			for (Biome biome : this.biomes) {
				this.topBlocksCache.add(biome.getSurfaceBuilderConfig().getTop());
			}
		}

		return this.topBlocksCache;
	}
}
