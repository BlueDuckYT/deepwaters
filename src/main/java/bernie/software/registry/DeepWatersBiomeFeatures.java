package bernie.software.registry;

import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

import static net.minecraft.world.biome.Biome.createCarver;

public class DeepWatersBiomeFeatures {

    public static OreFeatureConfig.FillerBlockType OCEAN_FLOOR = OreFeatureConfig.FillerBlockType.create(
            "OCEAN_FLOOR", "ocean_floor", new BlockMatcher(DeepWatersBlocks.OCEAN_FLOOR.get()));

    public static void addDeepWatersOres(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OCEAN_FLOOR, DeepWatersBlocks.SALT_ORE.get().getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(8, 5,10,128)));
    }

    public static void addCarvers(Biome biome) {
        //biome.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(DeepWatersWorldCarvers.CORAL_CAVE_CARVER.get(), new ProbabilityConfig(0.15F)));
        biome.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.02F)));
    }
}

