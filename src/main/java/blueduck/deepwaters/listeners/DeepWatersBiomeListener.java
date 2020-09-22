package blueduck.deepwaters.listeners;

import blueduck.deepwaters.registry.DeepWatersBiomes;
import blueduck.deepwaters.world.biome.WaterBiomeBase;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;

public class DeepWatersBiomeListener
{
	public static void addSpawnsToBiomes()
	{
		for(RegistryObject<Biome> biome : DeepWatersBiomes.BIOMES.getEntries())
		{
			((WaterBiomeBase) biome.get()).addSpawns();
		}
	}

	public static void addCarversToBiomes()
	{
		for(RegistryObject<Biome> biome : DeepWatersBiomes.BIOMES.getEntries())
		{
			((WaterBiomeBase) biome.get()).addWorldCarvers();
		}
	}

	public static void addFeaturesToBiomes()
	{
		for(RegistryObject<Biome> biome : DeepWatersBiomes.BIOMES.getEntries())
		{
			((WaterBiomeBase) biome.get()).addFeatures();
		}
	}
}
