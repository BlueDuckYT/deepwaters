package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.world.gen.features.CrystalineCoral;
import bernie.software.world.gen.structures.DeepWatersPortalStructure;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.CountConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DeepWatersStructures
{
	public static final DeferredRegister<Feature<?>> STRUCTURES = new DeferredRegister<Feature<?>>(
			ForgeRegistries.FEATURES, DeepWatersMod.ModID);

	public static final RegistryObject<Feature<CountConfig>> CRYSTALINE_CORAL = STRUCTURES.register("crystalinecoral",
			() -> new CrystalineCoral(CountConfig::deserialize));

	public static final RegistryObject<Feature<?>> PORTAL_STRUCTURE = STRUCTURES.register(
			"deepwatersportal", () -> new DeepWatersPortalStructure(NoFeatureConfig::deserialize));
}
