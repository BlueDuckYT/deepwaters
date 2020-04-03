package bernie.software.biome;

import bernie.software.ModEventSubscriber;
import bernie.software.entity.BlufferFish;
import bernie.software.entity.Clam;
import bernie.software.registry.DeepWatersEntities;
import bernie.software.surfacebuilder.DefaultWaterSurfaceBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.OceanBiome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.*    ;
import net.minecraft.world.gen.feature.structure.ShipwreckConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.surfacebuilders.NetherSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class DefaultWaterBiome extends Biome
{
	public DefaultWaterBiome()
	{

		super((new Biome.Builder()).surfaceBuilder(new DefaultWaterSurfaceBuilder(SurfaceBuilderConfig::deserialize), new SurfaceBuilderConfig(Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState() ,Blocks.WATER.getDefaultState())).precipitation(Biome.RainType.NONE).category(Category.OCEAN).depth(0.1F).scale(0.2F).temperature(2.0F).downfall(0.0F).waterColor(28111).waterFogColor(28111));

		this.addCarver(GenerationStage.Carving.AIR, createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.4F)));

		//this.addStructure(Feature.NETHER_BRIDGE, IFeatureConfig.NO_FEATURE_CONFIG);
		//this.addCarver(GenerationStage.Carving.AIR, createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.4F)));
		//this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createDecoratedFeature(Feature.SPRING_FEATURE, new LiquidsConfig(Fluids.LAVA.getDefaultState()), Placement.COUNT_VERY_BIASED_RANGE, new CountRangeConfig(20, 8, 16, 256)));
		//DefaultBiomeFeatures.addMushrooms(this);
		//this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.NETHER_BRIDGE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
		//this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.NETHER_SPRING, new HellLavaConfig(false), Placement.COUNT_RANGE, new CountRangeConfig(8, 4, 8, 128)));
		//this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.HELL_FIRE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.HELL_FIRE, new FrequencyConfig(10)));
		//this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.GLOWSTONE_BLOB, IFeatureConfig.NO_FEATURE_CONFIG, Placement.LIGHT_GEM_CHANCE, new FrequencyConfig(10)));
		//this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.GLOWSTONE_BLOB, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 128)));
		//this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.BUSH, new BushConfig(Blocks.BROWN_MUSHROOM.getDefaultState()), Placement.CHANCE_RANGE, new ChanceRangeConfig(0.5F, 0, 0, 128)));
		//this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.BUSH, new BushConfig(Blocks.RED_MUSHROOM.getDefaultState()), Placement.CHANCE_RANGE, new ChanceRangeConfig(0.5F, 0, 0, 128)));
		//this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Blocks.NETHER_QUARTZ_ORE.getDefaultState(), 14), Placement.COUNT_RANGE, new CountRangeConfig(16, 10, 20, 128)));
		//this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Blocks.MAGMA_BLOCK.getDefaultState(), 33), Placement.MAGMA, new FrequencyConfig(4)));
		//this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.NETHER_SPRING, new HellLavaConfig(true), Placement.COUNT_RANGE, new CountRangeConfig(16, 10, 20, 128)));

		this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(DeepWatersEntities.blufferfish, 75, 4, 30));
		this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(DeepWatersEntities.killer_wiggler, 2, 1, 1));
		this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(DeepWatersEntities.stingRay, 20, 1, 3));
		this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.COD, 10, 3, 6));
		this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.SALMON, 5, 2, 3));

		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createDecoratedFeature(Feature.SEAGRASS, new SeaGrassConfig(48, 0.3D), Placement.TOP_SOLID_HEIGHTMAP, IPlacementConfig.NO_PLACEMENT_CONFIG));
		DefaultBiomeFeatures.addKelp(this);
		DefaultBiomeFeatures.addExtraKelp(this);

		//this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 1, 4, 4));
	}


}
