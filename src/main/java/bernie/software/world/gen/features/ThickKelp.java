package bernie.software.world.gen.features;

import com.mojang.datafixers.Dynamic;
import net.minecraft.world.gen.feature.KelpFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.function.Function;

public class ThickKelp extends KelpFeature {
    public ThickKelp(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51487_1_) {
        super(p_i51487_1_);
    }
}
