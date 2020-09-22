package blueduck.deepwaters.world.biome;

import blueduck.deepwaters.client.renderer.Utils;
import blueduck.deepwaters.registry.DeepWatersBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ThickKelpForest extends WaterBiomeBase {
    public ThickKelpForest() {
        super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT,
                new SurfaceBuilderConfig(Blocks.SAND.getDefaultState(),
                        DeepWatersBlocks.OCEAN_FLOOR.get().getDefaultState(),
                        Blocks.SAND.getDefaultState())).precipitation(RainType.NONE).category(
                Category.OCEAN).depth(0.1F).scale(0.05F).temperature(2.0F).downfall(0.0F).waterColor(
                new Utils.ColorHelper(0x01B87B).getRGB()).waterFogColor(
                new Utils.ColorHelper(0x01B87B).getRGB()));
    }

    @Override
    public void addFeatures() {
        //this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, DeepWatersStructures.THICK_KELP.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.TOP_SOLID_HEIGHTMAP_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(200, 80.0D, 0.0D, Heightmap.Type.OCEAN_FLOOR_WG))));
    }

    @Override
    public void addSpawns() {
    }

    @Override
    public void addWorldCarvers() {
    }

    @Override
    public double getNoiseFactor() {
        return 1;
    }
}
