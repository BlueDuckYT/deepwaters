package blueduck.deepwaters.world.gen;

import blueduck.deepwaters.world.biome.WaterBiomeBase;
import it.unimi.dsi.fastutil.ints.IntSortedSet;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.OctavesNoiseGenerator;

public class DeepWatersNoiseGenerator extends OctavesNoiseGenerator {
    public DeepWatersNoiseGenerator(SharedSeedRandom p_i225878_1_, int p_i225878_2_, int p_i225878_3_) {
        super(p_i225878_1_, p_i225878_2_, p_i225878_3_);
    }

    public DeepWatersNoiseGenerator(SharedSeedRandom p_i225879_1_, IntSortedSet p_i225879_2_) {
        super(p_i225879_1_, p_i225879_2_);
    }

    @Override
    public double noiseAt(double x, double y, double z, double p_215460_7_) {
        return super.noiseAt(x, y, z, p_215460_7_);
    }

    public double noiseAt(double x, double y, double z, double p_215460_7_,Biome biome) {
        return super.noiseAt(x,y,z,p_215460_7_)*((WaterBiomeBase)biome).getNoiseFactor();
    }
}
