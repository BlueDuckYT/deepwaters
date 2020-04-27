package bernie.software.world.biome.provider;

import bernie.software.registry.DeepWatersBiomes;
import bernie.software.world.layer.DeepWatersBiomeLayer;
import bernie.software.utils.misc.VoroniZoomLayer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.layer.*;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.LongFunction;

public class DeepWatersBiomeProvider extends BiomeProvider
{
	private final Layer genBiomes;
	private final Layer biomeFactoryLayer;
	private static final Set<Biome> biomes = ImmutableSet.of(
			DeepWatersBiomes.CoralFieldsBiome.get(),
			DeepWatersBiomes.SunkenWastesBiome.get(),
			DeepWatersBiomes.ThickKelpForest.get()
	);

	protected DeepWatersBiomeProvider(long seed, WorldType worldType)
	{
		super(biomes);
		Layer[] agenlayer = buildDeepWaters(seed, worldType);
		this.genBiomes = agenlayer[0];
		this.biomeFactoryLayer = agenlayer[1];
	}

	public DeepWatersBiomeProvider(DeepWatersBiomeProviderSettings settings) {
		super(biomes);
		Layer[] agenlayer = buildDeepWaters(settings.getSeed(), settings.getWorldInfo().getGenerator());
		this.genBiomes = agenlayer[0];
		this.biomeFactoryLayer = agenlayer[1];
	}

	@Override
	public Biome getNoiseBiome(int i, int i1, int i2)
	{
		return getBiomeForNoiseGen(i,i1,i2);
	}

	public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> repeat(long seed, IAreaTransformer1 parent, IAreaFactory<T> p_202829_3_, int count, LongFunction<C> contextFactory)
{
	IAreaFactory<T> iareafactory = p_202829_3_;

	for (int i = 0; i < count; ++i)
	{
		iareafactory = parent.apply(contextFactory.apply(seed + i), iareafactory);
	}

	return iareafactory;
}


	public static Layer[] buildDeepWaters(long seed, WorldType typeIn)
	{
		ImmutableList<IAreaFactory<LazyArea>> immutablelist = buildDeepWaters(typeIn, (p_215737_2_) ->
		{
			return new LazyAreaLayerContext(25, seed, p_215737_2_);
		});
		Layer genlayer = new Layer(immutablelist.get(0));
		Layer genlayer1 = new Layer(immutablelist.get(1));
		Layer genlayer2 = new Layer(immutablelist.get(2));
		return new Layer[] { genlayer, genlayer1, genlayer2 };
	}
	public static <T extends IArea, C extends IExtendedNoiseRandom<T>> ImmutableList<IAreaFactory<T>> buildDeepWaters(WorldType worldTypeIn, LongFunction<C> contextFactory)
	{
		IAreaFactory<T> biomes = new DeepWatersBiomeLayer().apply(contextFactory.apply(1L));

		biomes = ZoomLayer.NORMAL.apply(contextFactory.apply(1000), biomes);
		biomes = ZoomLayer.NORMAL.apply(contextFactory.apply(1001), biomes);
		biomes = ZoomLayer.NORMAL.apply(contextFactory.apply(1002), biomes);
		biomes = ZoomLayer.NORMAL.apply(contextFactory.apply(1003), biomes);
		biomes = ZoomLayer.NORMAL.apply(contextFactory.apply(1004), biomes);
		biomes = ZoomLayer.NORMAL.apply(contextFactory.apply(1005), biomes);
		biomes = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, biomes, 1, contextFactory);

		IAreaFactory<T> genlayervoronoizoom = VoroniZoomLayer.INSTANCE.apply(contextFactory.apply(10L), biomes);
		return ImmutableList.of(biomes, genlayervoronoizoom, biomes);

	}


	@Override
	public Set<Biome> getBiomes(int centerX, int centerY, int centerZ, int sideLength)
	{
		int i = centerX - sideLength >> 2;
		int j = centerY - sideLength >> 2;
		int k = centerZ - sideLength >> 2;
		int l = centerX + sideLength >> 2;
		int i1 = centerY + sideLength >> 2;
		int j1 = centerZ + sideLength >> 2;
		int k1 = l - i + 1;
		int l1 = i1 - j + 1;
		int i2 = j1 - k + 1;
		Set<Biome> set = Sets.newHashSet();

		for (int j2 = 0; j2 < i2; ++j2)
		{
			for (int k2 = 0; k2 < k1; ++k2)
			{
				for (int l2 = 0; l2 < l1; ++l2)
				{
					int i3 = i + k2;
					int j3 = j + l2;
					int k3 = k + j2;
					set.add(this.getBiomeForNoiseGen(i3, j3, k3));
				}
			}
		}
		return set;
	}


	@Nullable
	public BlockPos locateBiome(int x, int z, int range, List<Biome> biomes, Random random)
	{
		int i = x - range >> 2;
		int j = z - range >> 2;
		int k = x + range >> 2;
		int l = z + range >> 2;
		int i1 = k - i + 1;
		int j1 = l - j + 1;
		BlockPos blockpos = null;
		int k1 = 0;

		for (int l1 = 0; l1 < i1 * j1; ++l1)
		{
			int i2 = i + l1 % i1 << 2;
			int j2 = j + l1 / i1 << 2;
			if (biomes.contains(this.getBiomeForNoiseGen(i2, k1, j2)))
			{
				if (blockpos == null || random.nextInt(k1 + 1) == 0)
				{
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
		return this.hasStructureCache.computeIfAbsent(structureIn, (p_205006_1_) ->
		{
			for (Biome biome : this.biomes)
			{
				if (biome.hasStructure(p_205006_1_))
				{
					return true;
				}
			}

			return false;
		});
	}


	@Override
	public Set<BlockState> getSurfaceBlocks()
	{
		if (this.topBlocksCache.isEmpty())
		{
			for (Biome biome : this.biomes)
			{
				this.topBlocksCache.add(biome.getSurfaceBuilderConfig().getTop());
			}
		}

		return this.topBlocksCache;
	}

	public Biome getBiomeForNoiseGen(int x, int y, int z) {
		return this.genBiomes.func_215738_a(x, z);
	}
}
