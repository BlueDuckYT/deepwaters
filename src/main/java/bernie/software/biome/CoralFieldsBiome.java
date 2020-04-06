package bernie.software.biome;

import bernie.software.registry.DeepWatersBiomeFeatures;
import bernie.software.registry.DeepWatersWorldCarvers;
import bernie.software.surfacebuilder.CoralFieldsSurfaceBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.*    ;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class CoralFieldsBiome extends WaterBiomeBase
{
	public CoralFieldsBiome()
	{

		super((new Biome.Builder()).surfaceBuilder(new CoralFieldsSurfaceBuilder(SurfaceBuilderConfig::deserialize), new SurfaceBuilderConfig(Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState() ,Blocks.WATER.getDefaultState())).precipitation(Biome.RainType.NONE).category(Category.OCEAN).depth(0.1F).scale(0.2F).temperature(2.0F).downfall(0.0F).waterColor(42892).waterFogColor(42892));

		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createDecoratedFeature(Feature.SEAGRASS, new SeaGrassConfig(48, 0.3D), Placement.TOP_SOLID_HEIGHTMAP, IPlacementConfig.NO_PLACEMENT_CONFIG));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createDecoratedFeature(Feature.SIMPLE_RANDOM_SELECTOR, new SingleRandomFeature(new Feature[]{Feature.CORAL_TREE, Feature.CORAL_CLAW, Feature.CORAL_MUSHROOM}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG}), Placement.TOP_SOLID_HEIGHTMAP_NOISE_BIASED, new TopSolidWithNoiseConfig(20, 400.0D, 1.0D, Heightmap.Type.OCEAN_FLOOR_WG)));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createDecoratedFeature(Feature.SEA_PICKLE, new CountConfig(20), Placement.CHANCE_TOP_SOLID_HEIGHTMAP, new ChanceConfig(16)));
		DefaultBiomeFeatures.addKelp(this);
		DeepWatersBiomeFeatures.addDeepWatersOres(this);
		DeepWatersBiomeFeatures.addSedimentDisks(this);
		DeepWatersBiomeFeatures.addStoneVariants(this);

	}


	public void AddWorldCarver()
	{
		WorldCarver<ProbabilityConfig> carver = DeepWatersWorldCarvers.CORAL_CAVE_CARVER.get();
		this.addCarver(GenerationStage.Carving.AIR, createCarver(carver, new ProbabilityConfig(15F)));
	}



}
