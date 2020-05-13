package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.entity.*;
import bernie.software.entity.SurgeVehicle;
import bernie.software.utils.EntityUtils;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DeepWatersEntities
{

	public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, DeepWatersMod.ModID);

	public static final RegistryObject<EntityType<KillerWiggler>> KILLER_WIGGLER = EntityUtils.BuildWaterEntity(KillerWiggler::new, KillerWiggler.class, 10.387F, 2.4375F);
	public static final RegistryObject<EntityType<BlufferFish>> BLUFFERFISH = EntityUtils.BuildWaterEntity(BlufferFish::new, BlufferFish.class, 1.125F, 1F);
	public static final RegistryObject<EntityType<Stingray>> STING_RAY = EntityUtils.BuildWaterEntity(Stingray::new, Stingray.class, 2.845F, 0.3125F);
	public static final RegistryObject<EntityType<BabyKracken>> BABY_KRACKEN = EntityUtils.BuildWaterEntity(BabyKracken::new, BabyKracken.class, 1, 2);
	public static final RegistryObject<EntityType<MuckGulper>> MUCK_GULPER = EntityUtils.BuildWaterEntity(MuckGulper::new, MuckGulper.class, .7F, .2F);
	public static final RegistryObject<EntityType<DonutFish>> DONUT_FISH = EntityUtils.BuildWaterEntity(DonutFish::new, DonutFish.class, .6F, .6F);
	public static final RegistryObject<EntityType<ColorfulFish>> COLORFUL_FISH = EntityUtils.BuildWaterEntity(ColorfulFish::new, ColorfulFish.class, .3F, .1F);
	public static final RegistryObject<EntityType<LegFish>> LEG_FISH = EntityUtils.BuildWaterEntity(LegFish::new, LegFish.class, 1.3F, .7F);
	public static final RegistryObject<EntityType<DeepGlider>> DEEP_GLIDER = EntityUtils.BuildWaterEntity(DeepGlider::new, DeepGlider.class, .6F, .6F);
	public static final RegistryObject<EntityType<SkullFish>> SKULL_FISH = EntityUtils.BuildWaterEntity(SkullFish::new, SkullFish.class, 0.3F, 0.3F);
	public static final RegistryObject<EntityType<SurgeVehicle>> SURGE = EntityUtils.BuildEntity(SurgeVehicle::new, SurgeVehicle.class, 1.5F, 0.5F);
	public static final RegistryObject<EntityType<JungleFish>> JUNGLE_FISH = EntityUtils.BuildWaterEntity(JungleFish::new, JungleFish.class, 0.3F, 0.3F);
	public static final RegistryObject<EntityType<SeaUrchin>> SEA_URCHIN = EntityUtils.BuildWaterEntity(SeaUrchin::new, SeaUrchin.class, 1F, 0.4F);
	public static final RegistryObject<EntityType<SeaAngel>> SEA_ANGEL = EntityUtils.BuildWaterEntity(SeaAngel::new, SeaAngel.class, 0.3F, 0.9F);
	public static final RegistryObject<EntityType<Shark>> SHARK = EntityUtils.BuildWaterEntity(Shark::new, Shark.class, .7F, .8F);
	public static final RegistryObject<EntityType<Jellyfish>> JELLYFISH = EntityUtils.BuildWaterEntity(Jellyfish::new, Jellyfish.class, .5F, .9F);
	public static final RegistryObject<EntityType<SunkenWanderer>> SUNKEN_WANDERER = EntityUtils.BuildWaterEntity(SunkenWanderer::new, SunkenWanderer.class, .5F, .9F);


	public static final RegistryObject<EntityType<CoralCrawler>> CORAL_CRAWLER = EntityUtils.BuildWaterLandEntity(CoralCrawler::new, CoralCrawler.class, .8F, 1.5F);
	public static final RegistryObject<EntityType<Sneagle>> SNEAGLE = EntityUtils.BuildWaterLandEntity(Sneagle::new, Sneagle.class, 1.2F, .3F);


	public static void spawnPlacements() {
		EntityType<CoralCrawler> coral_crawler = CORAL_CRAWLER.get();
		EntitySpawnPlacementRegistry.register(coral_crawler, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.WORLD_SURFACE, CoralCrawler::canCoralCrawlerSpawn);

		EntityType<Sneagle> sneagle = SNEAGLE.get();
		EntitySpawnPlacementRegistry.register(sneagle, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.WORLD_SURFACE, Sneagle::canSpawn);
	}
}
