package bernie.software.registry;

import com.google.common.collect.Lists;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class DeepWatersBiomeFeatures {

        public static OreFeatureConfig.FillerBlockType OCEAN_FLOOR = OreFeatureConfig.FillerBlockType
                        .create("OCEAN_FLOOR", "ocean_floor", new BlockMatcher(DeepWatersBlocks.OCEAN_FLOOR.get()));

        public static void addDeepWatersOres(Biome biome) {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OCEAN_FLOOR, DeepWatersBlocks.SALT_ORE.get().getDefaultState(), 17)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OCEAN_FLOOR, DeepWatersBlocks.PRISMARINE_CRYSTAL_ORE.get().getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 200))));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OCEAN_FLOOR, DeepWatersBlocks.AQUALITE_ORE.get().getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0,0, 200))));
        }

        public static void addSedimentDisks(Biome biomeIn) {
                biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(Blocks.SAND.getDefaultState(), 7, 2, Lists.newArrayList(DeepWatersBlocks.OCEAN_FLOOR.get().getDefaultState()))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(3))));
                biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(Blocks.CLAY.getDefaultState(), 4, 1, Lists.newArrayList(DeepWatersBlocks.OCEAN_FLOOR.get().getDefaultState()))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
                biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(DeepWatersBlocks.SUNKEN_GRAVEL.get().getDefaultState(), 6, 2, Lists.newArrayList(DeepWatersBlocks.OCEAN_FLOOR.get().getDefaultState()))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
        }

        public static void addStoneVariants(Biome biomeIn) {
                biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OCEAN_FLOOR, DeepWatersBlocks.LIMESTONE.get().getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 256))));
                biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OCEAN_FLOOR, Blocks.PRISMARINE.getDefaultState(), 55)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 64))));
        }
}
