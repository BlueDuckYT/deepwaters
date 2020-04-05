package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.world.gen.carver.CoralFieldsCaveWorldCarver;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DeepWatersWorldCarvers {

    public static final DeferredRegister<WorldCarver<?>> WORLD_CARVERS = new DeferredRegister<>(ForgeRegistries.WORLD_CARVERS, DeepWatersMod.ModID);

    public static final RegistryObject<WorldCarver<ProbabilityConfig>> CORAL_CAVE_CARVER = WORLD_CARVERS.register(
            "coral_carver", () -> new CoralFieldsCaveWorldCarver(ProbabilityConfig::deserialize));
}
