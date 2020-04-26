package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.world.biome.CoralFieldsBiome;
import bernie.software.world.biome.SunkenWastesBiome;
import bernie.software.world.biome.ThickKelpForest;
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
	public static final RegistryObject<Biome> ThickKelpForst = BIOMES.register(
			"thickkelpforest", () -> new ThickKelpForest());

	public static void addBiomeTypes()
	{
		BiomeDictionary.addTypes(CoralFieldsBiome.get(), BiomeDictionary.Type.OCEAN);
	}
}
