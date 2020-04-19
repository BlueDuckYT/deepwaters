package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.world.biome.CoralFieldsBiome;
import bernie.software.world.gen.structures.DeepWatersPortalStructure;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DeepWatersStructures
{
	public static final DeferredRegister<Feature<?>> STRUCTURES = new DeferredRegister<Feature<?>>(ForgeRegistries.FEATURES, DeepWatersMod.ModID);

	public static final RegistryObject<Feature<?>> PORTAL_STRUCTURE = STRUCTURES.register(
			"deepwatersportal", () -> new DeepWatersPortalStructure(NoFeatureConfig::deserialize));
}
