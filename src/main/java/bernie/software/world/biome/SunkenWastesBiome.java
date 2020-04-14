package bernie.software.world.biome;

import bernie.software.registry.DeepWatersBiomeFeatures;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersEntities;
import bernie.software.registry.DeepWatersWorldCarvers;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.DefaultSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class SunkenWastesBiome extends WaterBiomeBase
{

	public SunkenWastesBiome()
	{
		super((new Biome.Builder()).surfaceBuilder(new DefaultSurfaceBuilder(SurfaceBuilderConfig::deserialize), new SurfaceBuilderConfig(DeepWatersBlocks.SUNKEN_GRAVEL.get().getDefaultState(), DeepWatersBlocks.OCEAN_FLOOR.get().getDefaultState(), DeepWatersBlocks.SUNKEN_GRAVEL.get().getDefaultState())).precipitation(RainType.NONE).category(Category.OCEAN).depth(0.1F).scale(0.2F).temperature(2.0F).downfall(0.0F).waterColor(6952).waterFogColor(6952));

		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createDecoratedFeature(Feature.SEAGRASS, new SeaGrassConfig(24, 3), Placement.TOP_SOLID_HEIGHTMAP, IPlacementConfig.NO_PLACEMENT_CONFIG));
		DeepWatersBiomeFeatures.addDeepWatersOres(this);
		DeepWatersBiomeFeatures.addSedimentDisks(this);
		DeepWatersBiomeFeatures.addStoneVariants(this);
	}

	@Override
	public void addSpawns()
	{
		addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.DEEP_GLIDER.get(), 30, 1, 3));
		addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.SKULL_FISH.get(), 30, 3, 7));
		addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.LEG_FISH.get(), 10, 1, 3));
		addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.JUNGLE_FISH.get(), 10, 4, 10));
	}

	@Override
	public void addWorldCarvers()
	{
		WorldCarver<ProbabilityConfig> carver = DeepWatersWorldCarvers.CORAL_CAVE_CARVER.get();
		this.addCarver(GenerationStage.Carving.AIR, createCarver(carver, new ProbabilityConfig(20F)));
	}
}
