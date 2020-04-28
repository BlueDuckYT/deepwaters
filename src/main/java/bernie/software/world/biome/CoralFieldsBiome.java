package bernie.software.world.biome;

import bernie.software.registry.*;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.surfacebuilders.DefaultSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.awt.*;

public class CoralFieldsBiome extends WaterBiomeBase
{
	public CoralFieldsBiome()
	{
		super((new Biome.Builder()).surfaceBuilder(new DefaultSurfaceBuilder(SurfaceBuilderConfig::deserialize),
				new SurfaceBuilderConfig(Blocks.SAND.getDefaultState(),
						DeepWatersBlocks.OCEAN_FLOOR.get().getDefaultState(),
						DeepWatersBlocks.MOSSY_OCEAN_FLOOR.get().getDefaultState())).precipitation(
				Biome.RainType.NONE).category(Category.OCEAN).depth(0.1F).scale(0.2F).temperature(2.0F).downfall(
				0.0F).waterColor(42892).waterFogColor(42892));

		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SIMPLE_RANDOM_SELECTOR.withConfiguration(new SingleRandomFeature(ImmutableList.of(Feature.CORAL_TREE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG), Feature.CORAL_CLAW.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG), Feature.CORAL_MUSHROOM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)))).withPlacement(Placement.TOP_SOLID_HEIGHTMAP_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(20, 400.0D, 1.0D, Heightmap.Type.OCEAN_FLOOR_WG))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEA_PICKLE.withConfiguration(new CountConfig(20)).withPlacement(Placement.CHANCE_TOP_SOLID_HEIGHTMAP.configure(new ChanceConfig(16))));
		DefaultBiomeFeatures.addKelp(this);
		DefaultBiomeFeatures.addSeagrass(this);
		DeepWatersBiomeFeatures.addDeepWatersOres(this);
		DeepWatersBiomeFeatures.addSedimentDisks(this);
		DeepWatersBiomeFeatures.addStoneVariants(this);

	}

	@Override
	public int getSkyColor() {
		return new Color(125, 235, 220).getRGB();
	}

	@Override
	public void addWorldCarvers()
	{
		WorldCarver<ProbabilityConfig> carver = DeepWatersWorldCarvers.CORAL_CAVE_CARVER.get();
		addCarver(GenerationStage.Carving.AIR, createCarver(carver, new ProbabilityConfig(15F)));
	}

	@Override
	public void addSpawns()
	{
		addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.DONUT_FISH.get(), 3, 75, 100));
		addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.DONUT_FISH.get(), 30, 5, 20));

		addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.BLUFFERFISH.get(), 30, 4, 10));
		addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.KILLER_WIGGLER.get(), 1, 1, 1));
		addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(EntityType.SALMON, 30, 5, 10));
		addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(EntityType.TROPICAL_FISH, 25, 6, 12));
		addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.BABY_KRACKEN.get(), 2, 1, 2));
		addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.STING_RAY.get(), 4, 1, 4));
		addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.MUCK_GULPER.get(), 30, 1, 10));
		addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.DONUT_FISH.get(), 30, 5, 20));
		addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.COLORFUL_FISH.get(), 30, 6, 20));
		addWaterLandPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.CORAL_CRAWLER.get(), 30, 1, 4));
	}

	/**
	 * returns the chance a creature has to spawn.
	 */
	@Override
	public float getSpawningChance()
	{
		return 0.2F;
	}


	@Override
	public void addFeatures() { }


}
