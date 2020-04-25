package bernie.software.listeners;

import bernie.software.registry.DeepWatersBiomes;
import bernie.software.world.biome.CoralFieldsBiome;
import bernie.software.world.biome.SunkenWastesBiome;

public class DeepWatersBiomeListener
{
	public static void addSpawnsToBiomes()
	{
		CoralFieldsBiome coralFieldsBiome = (CoralFieldsBiome) DeepWatersBiomes.CoralFieldsBiome.get();
		coralFieldsBiome.addSpawns();
		SunkenWastesBiome sunkenWastesBiome = (SunkenWastesBiome) DeepWatersBiomes.SunkenWastesBiome.get();
		sunkenWastesBiome.addSpawns();
	}

	public static void addCarversToBiomes()
	{
		CoralFieldsBiome biome = (CoralFieldsBiome) DeepWatersBiomes.CoralFieldsBiome.get();
		biome.AddWorldCarver();
	}
}
