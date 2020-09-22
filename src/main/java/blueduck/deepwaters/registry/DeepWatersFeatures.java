package blueduck.deepwaters.registry;

import blueduck.deepwaters.DeepWatersMod;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import org.apache.logging.log4j.Level;

import java.util.ArrayList;

public class DeepWatersFeatures {

    public static void registerFeature(Feature feature, ArrayList<Biome> biomes, GenerationStage.Decoration deco) {
        DeepWatersMod.logger.log(Level.INFO,"h");
        for (Biome biome:biomes) {
            DeepWatersMod.logger.log(Level.INFO,"h2");
            biome.addFeature(deco, feature.withConfiguration(new NoFeatureConfig()));
        }
    }
    public static void registerStructure(Structure structure, ArrayList<Biome> biomes) {
        DeepWatersMod.logger.log(Level.INFO,"h");
        for (Biome biome:biomes) {
            DeepWatersMod.logger.log(Level.INFO,"h2");
            biome.addStructure(structure.withConfiguration(new NoFeatureConfig()));
        }
    }
}
