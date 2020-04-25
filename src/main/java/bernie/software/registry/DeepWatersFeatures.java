package bernie.software.registry;

import bernie.software.DeepWatersMod;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.SeaPickleFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.CountConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.DeferredRegister;
import org.apache.logging.log4j.Level;

import java.util.ArrayList;

public class DeepWatersFeatures {

    public static void registerFeature(Feature feature, ArrayList<Biome> biomes, GenerationStage.Decoration deco) {
        DeepWatersMod.logger.log(Level.INFO,"h");
        for (Biome biome:biomes) {
            DeepWatersMod.logger.log(Level.INFO,"h2");
            biome.addFeature(deco,Biome.createDecoratedFeature(feature, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
        }
    }
    public static void registerStructure(Structure structure, ArrayList<Biome> biomes) {
        DeepWatersMod.logger.log(Level.INFO,"h");
        for (Biome biome:biomes) {
            DeepWatersMod.logger.log(Level.INFO,"h2");
            biome.addStructure(structure, new NoFeatureConfig());
        }
    }
}
