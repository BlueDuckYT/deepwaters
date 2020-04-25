package bernie.software.listeners;

import bernie.software.registry.DeepWatersBiomes;
import bernie.software.registry.DeepWatersFeatures;
import bernie.software.registry.DeepWatersStructures;
import bernie.software.world.biome.CoralFieldsBiome;
import bernie.software.world.biome.SunkenWastesBiome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.CountConfig;

public class DeepWatersFeatureListener
{
	public static void addFeaturesToBiomes()
	{
		SunkenWastesBiome sunkenWastesBiome = (SunkenWastesBiome) DeepWatersBiomes.SunkenWastesBiome.get();
		sunkenWastesBiome.addFeatures();
	}
}
