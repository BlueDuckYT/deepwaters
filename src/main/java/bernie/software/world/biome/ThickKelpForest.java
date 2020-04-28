package bernie.software.world.biome;

import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersStructures;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.CountConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidWithNoiseConfig;
import net.minecraft.world.gen.surfacebuilders.DefaultSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.awt.*;

public class ThickKelpForest extends WaterBiomeBase {
    public ThickKelpForest() {
        super((new Biome.Builder()).surfaceBuilder(new DefaultSurfaceBuilder(SurfaceBuilderConfig::deserialize),
                new SurfaceBuilderConfig(Blocks.SAND.getDefaultState(),
                        DeepWatersBlocks.OCEAN_FLOOR.get().getDefaultState(),
                        Blocks.SAND.getDefaultState())).precipitation(RainType.NONE).category(
                Category.OCEAN).depth(0.1F).scale(0.05F).temperature(2.0F).downfall(0.0F).waterColor(
                new Color(0x01B87B).getRGB()).waterFogColor(
                new Color(0x01B87B).getRGB()));
    }

    @Override
    public void addFeatures() {
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, DeepWatersStructures.THICK_KELP.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.TOP_SOLID_HEIGHTMAP_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(200, 80.0D, 0.0D, Heightmap.Type.OCEAN_FLOOR_WG))));
    }

    @Override
    public void addSpawns() {
    }

    @Override
    public void addWorldCarvers() {
    }

    @Override
    public double getNoiseFactor() {
        return 0.01d;
    }
}
