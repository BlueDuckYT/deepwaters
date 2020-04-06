package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.entity.*;
import bernie.software.utils.EntityUtils;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Tuple;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class DeepWatersEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, DeepWatersMod.ModID);

    public static final RegistryObject<EntityType<KillerWiggler>> KILLER_WIGGLER = EntityUtils.BuildWaterEntity(KillerWiggler::new, KillerWiggler.class, 10.387F, 2.4375F);
    public static final RegistryObject<EntityType<BlufferFish>> BLUFFERFISH = EntityUtils.BuildWaterEntity(BlufferFish::new, BlufferFish.class, 1.125F, 1F);
    public static final RegistryObject<EntityType<Clam>> CLAM = EntityUtils.BuildWaterLandEntity(Clam::new, Clam.class, 1F,0.4F);
    public static final RegistryObject<EntityType<Stingray>> STING_RAY = EntityUtils.BuildWaterEntity(Stingray::new, Stingray.class, 2.845F, 0.3125F);
    public static final RegistryObject<EntityType<BabyKracken>> BABY_KRACKEN = EntityUtils.BuildWaterEntity(BabyKracken::new, BabyKracken.class, 1, 2);
    public static final RegistryObject<EntityType<MuckGulper>> MUCK_GULPER = EntityUtils.BuildWaterEntity(MuckGulper::new, MuckGulper.class, .7F,.2F);

}
