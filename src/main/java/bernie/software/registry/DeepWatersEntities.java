package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.entity.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DeepWatersEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, DeepWatersMod.ModID);

    public static final EntityType<KillerWiggler> killer_wiggler = EntityType.Builder.create(KillerWiggler::new, EntityClassification.MONSTER)
            .size(10.387F, 2.4375F).build("killer_wiggler");
    public static final EntityType<BlufferFish> blufferfish = EntityType.Builder.create(BlufferFish::new, EntityClassification.WATER_CREATURE)
            .size(0.8125F, 0.5F).build("blufferfish");
    public static final EntityType<Clam> clam = EntityType.Builder.create(Clam::new, EntityClassification.WATER_CREATURE)
            .size(1,1).build("clam");

    public static final RegistryObject<EntityType<KillerWiggler>> KILLER_WIGGLER = ENTITIES.register("killer_wiggler", () -> killer_wiggler);
    public static final RegistryObject<EntityType<BlufferFish>> BLUFFERFISH = ENTITIES.register("blufferfish", () -> blufferfish);
    public static final RegistryObject<EntityType<Clam>> CLAM = ENTITIES.register("clam", () -> clam);
}
