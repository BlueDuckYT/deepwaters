package bernie.software.utils;

import bernie.software.registry.DeepWatersStructures;
import net.minecraft.util.Tuple;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class StructureUtils
{
	public static ConfiguredFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> createStructure(RegistryObject<Feature<?>> structure)
	{
		return ((Structure<NoFeatureConfig>) structure.get()).withConfiguration(
				IFeatureConfig.NO_FEATURE_CONFIG);
	}
	public static ConfiguredFeature<?, ?> createFeature(RegistryObject<Feature<?>> structure)
	{

		Feature<NoFeatureConfig> feature = (Feature<NoFeatureConfig>) structure.get();
		return feature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	}

	public static BiConsumer<Biome, RegistryObject<Feature<?>>> addStructure()
	{
		return (biome, structure) -> {
			biome.addStructure(StructureUtils.createStructure(structure));
			biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, StructureUtils.createFeature(structure));
		};
	}
}
