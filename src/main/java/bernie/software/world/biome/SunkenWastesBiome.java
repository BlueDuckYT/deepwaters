package bernie.software.world.biome;

import bernie.software.registry.*;
import bernie.software.world.gen.features.DeadwoodTree;
import com.google.common.collect.ImmutableList;
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

public class SunkenWastesBiome extends WaterBiomeBase {

    public SunkenWastesBiome() {
        super((new Biome.Builder()).surfaceBuilder(new DefaultSurfaceBuilder(SurfaceBuilderConfig::deserialize),
                new SurfaceBuilderConfig(DeepWatersBlocks.SUNKEN_GRAVEL.get().getDefaultState(),
                        DeepWatersBlocks.OCEAN_FLOOR.get().getDefaultState(),
                        DeepWatersBlocks.SUNKEN_GRAVEL.get().getDefaultState())).precipitation(RainType.NONE).category(
                Category.OCEAN).depth(0.1F).scale(0.2F).temperature(2.0F).downfall(0.0F).waterColor(6952).waterFogColor(
                6952));
        DefaultBiomeFeatures.addSeagrass(this);
        DefaultBiomeFeatures.addTallSeagrassSparse(this);
        DeepWatersBiomeFeatures.addDeepWatersOres(this);
        DeepWatersBiomeFeatures.addSedimentDisks(this);
        DeepWatersBiomeFeatures.addStoneVariants(this);
    }

    @Override
    public void addFeatures() {
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, DeepWatersStructures.CRYSTALINE_CORAL.get().withConfiguration(new CountConfig(5)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(20, 200.0D, 0.0D, Heightmap.Type.OCEAN_FLOOR_WG))));

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                DeepWatersStructures.DEADWOOD_TREE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                        .withPlacement(Placement.TOP_SOLID_HEIGHTMAP_NOISE_BIASED
                                .configure(new TopSolidWithNoiseConfig(
                                        2, 0.1f, 1,
                                        Heightmap.Type.OCEAN_FLOOR_WG))));

    }

    @Override
    public int getSkyColor() {
        return new Color(67, 121, 96).getRGB();
    }

    @Override
    public void addSpawns() {
        addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.DEEP_GLIDER.get(), 30, 1, 3));
        addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.SKULL_FISH.get(), 30, 3, 7));
        addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.LEG_FISH.get(), 10, 1, 3));
        addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.JUNGLE_FISH.get(), 10, 4, 10));
    }

    @Override
    public double getNoiseFactor() {
        return 1.2d;
    }

    @Override
    public void addWorldCarvers() {
        WorldCarver<ProbabilityConfig> carver = DeepWatersWorldCarvers.CORAL_CAVE_CARVER.get();
        addCarver(GenerationStage.Carving.AIR, createCarver(carver, new ProbabilityConfig(20F)));
    }
}
