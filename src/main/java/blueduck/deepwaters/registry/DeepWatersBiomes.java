package blueduck.deepwaters.registry;

import blueduck.deepwaters.DeepWatersMod;
import blueduck.deepwaters.world.biome.CoralFieldsBiome;
import blueduck.deepwaters.world.biome.SunkenWastesBiome;
import blueduck.deepwaters.world.biome.ThickKelpForest;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DeepWatersBiomes
{

	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, DeepWatersMod.ModID);

	public static final RegistryObject<Biome> CoralFieldsBiome = BIOMES.register(
			"coralfields", () -> new CoralFieldsBiome());
	public static final RegistryObject<Biome> SunkenWastesBiome = BIOMES.register(
			"sunkenwastes", () -> new SunkenWastesBiome());
	public static final RegistryObject<Biome> ThickKelpForest = BIOMES.register(
			"thickkelpforest", () -> new ThickKelpForest());

	public static void addBiomeTypes()
	{
		BiomeDictionary.addTypes(CoralFieldsBiome.get(), BiomeDictionary.Type.OCEAN);
		BiomeDictionary.addTypes(SunkenWastesBiome.get(), BiomeDictionary.Type.OCEAN);
		BiomeDictionary.addTypes(ThickKelpForest.get(), BiomeDictionary.Type.OCEAN);
	}
}
