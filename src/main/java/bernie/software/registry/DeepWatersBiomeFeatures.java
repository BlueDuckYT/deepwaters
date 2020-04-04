package bernie.software.registry;

import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

public class DeepWatersBiomeFeatures {

    public static OreFeatureConfig.FillerBlockType OCEAN_FLOOR = OreFeatureConfig.FillerBlockType.create(
            "OCEAN_FLOOR", "ocean_floor", new BlockMatcher(DeepWatersBlocks.OCEAN_FLOOR.get()));

    public static void addDeepWatersOres(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OCEAN_FLOOR, DeepWatersBlocks.SALT_ORE.get().getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(8, 5,10,128)));
    }
}

