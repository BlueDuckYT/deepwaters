package blueduck.deepwaters.utils;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.BiConsumer;

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
