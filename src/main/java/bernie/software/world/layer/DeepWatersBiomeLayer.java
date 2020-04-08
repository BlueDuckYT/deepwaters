package bernie.software.world.layer;

import bernie.software.registry.DeepWatersBiomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public class DeepWatersBiomeLayer implements IAreaTransformer0
{

	private static final int UNCOMMON_BIOME_CHANCE = 8;
	private static final int RARE_BIOME_CHANCE = 16;
	protected LazyInt[] commonBiomes = new LazyInt[]{
			DeepWatersLayerUtil.lazyId(DeepWatersBiomes.CoralFieldsBiome),
			DeepWatersLayerUtil.lazyId(DeepWatersBiomes.SunkenWastesBiome)

	};
	protected LazyInt[] uncommonBiomes = (new LazyInt[]{
			// add uncommon biomes here
			DeepWatersLayerUtil.lazyId(DeepWatersBiomes.CoralFieldsBiome),

	});
	protected LazyInt[] rareBiomes = (new LazyInt[]{
			// add rare biomes here
			DeepWatersLayerUtil.lazyId(DeepWatersBiomes.CoralFieldsBiome),

	});

	public DeepWatersBiomeLayer()
	{
	}

	@Override
	public int apply(INoiseRandom iNoiseRandom, int rand1, int rand2)
	{
		if (iNoiseRandom.random(RARE_BIOME_CHANCE) == 0) {
			//magic number!
			return rareBiomes[iNoiseRandom.random(rareBiomes.length)].getAsInt();
		} else if (iNoiseRandom.random(UNCOMMON_BIOME_CHANCE) == 0) {
			//Well, it's no rare biome, but it will suffice
			return uncommonBiomes[iNoiseRandom.random(uncommonBiomes.length)].getAsInt();
		} else {
			//aww...
			return commonBiomes[iNoiseRandom.random(commonBiomes.length)].getAsInt();
		}
	}
}