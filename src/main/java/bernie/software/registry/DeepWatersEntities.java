package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.entity.*;
import bernie.software.entity.vehicle.SurgeVehicle;
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

public class DeepWatersEntities
{

	public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, DeepWatersMod.ModID);

	public static final RegistryObject<EntityType<KillerWiggler>> KILLER_WIGGLER = EntityUtils.BuildWaterEntity(KillerWiggler::new, KillerWiggler.class, 10.387F, 2.4375F);
	public static final RegistryObject<EntityType<BlufferFish>> BLUFFERFISH = EntityUtils.BuildWaterEntity(BlufferFish::new, BlufferFish.class, 1.125F, 1F);
	public static final RegistryObject<EntityType<Clam>> CLAM = EntityUtils.BuildWaterLandEntity(Clam::new, Clam.class, 1F, 0.4F);
	public static final RegistryObject<EntityType<Stingray>> STING_RAY = EntityUtils.BuildWaterEntity(Stingray::new, Stingray.class, 2.845F, 0.3125F);
	public static final RegistryObject<EntityType<BabyKracken>> BABY_KRACKEN = EntityUtils.BuildWaterEntity(BabyKracken::new, BabyKracken.class, 1, 2);
	public static final RegistryObject<EntityType<MuckGulper>> MUCK_GULPER = EntityUtils.BuildWaterEntity(MuckGulper::new, MuckGulper.class, .7F, .2F);
	public static final RegistryObject<EntityType<CoralCrawler>> CORAL_CRAWLER = EntityUtils.BuildWaterLandEntity(CoralCrawler::new, CoralCrawler.class, .8F, 1.5F);
	public static final RegistryObject<EntityType<DonutFish>> DONUT_FISH = EntityUtils.BuildWaterEntity(DonutFish::new, DonutFish.class, .6F, .6F);
	public static final RegistryObject<EntityType<ColorfulFish>> COLORFUL_FISH = EntityUtils.BuildWaterEntity(ColorfulFish::new, ColorfulFish.class, .3F, .1F);
	public static final RegistryObject<EntityType<LegFish>> LEG_FISH = EntityUtils.BuildWaterEntity(LegFish::new, LegFish.class, 1.3F, .7F);
	public static final RegistryObject<EntityType<DeepGlider>> DEEP_GLIDER = EntityUtils.BuildWaterEntity(DeepGlider::new, DeepGlider.class, .6F, .6F);
	public static final RegistryObject<EntityType<SkullFish>> SKULL_FISH = EntityUtils.BuildWaterEntity(SkullFish::new, SkullFish.class, 0.3F, 0.3F);
	public static final RegistryObject<EntityType<SurgeVehicle>> SURGE = EntityUtils.BuildEntity(SurgeVehicle::new, SurgeVehicle.class, 1.5F, 0.5F);

}
