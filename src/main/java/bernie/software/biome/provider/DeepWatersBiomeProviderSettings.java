package bernie.software.biome.provider;

import net.minecraft.world.biome.provider.IBiomeProviderSettings;

public class DeepWatersBiomeProviderSettings implements IBiomeProviderSettings {
    private long seed;

    public DeepWatersBiomeProviderSettings setSeed(long seed) {
        this.seed = seed;
        return this;
    }

    public long getSeed() {
        return this.seed;
    }
}
