package bernie.software;

import bernie.software.client.renderer.model.KillerWigglerBody;
import bernie.software.client.renderer.model.KillerWigglerHead;
import bernie.software.client.renderer.model.KillerWigglerTail;
import bernie.software.entity.vehicle.SurgeVehicle;
import bernie.software.utils.GeneralUtils;
import bernie.software.client.renderer.entity.*;
import bernie.software.entity.*;
import bernie.software.item.ModdedSpawnEggItem;
import bernie.software.item.tool.SwordEventSubscriber;
import bernie.software.world.DeepWatersModDimension;
import bernie.software.world.biome.DeepWatersBiomeListener;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = DeepWatersMod.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber
{

	@ObjectHolder("deepwaters:deepwatersdimension")
	public static final ModDimension DeepWatersDimension = null;

	@SubscribeEvent
	public static void onDimensionRegistryEvent(final RegistryEvent.Register<ModDimension> event)
	{
		event.getRegistry().register(new DeepWatersModDimension().setRegistryName(GeneralUtils.Location("deepwatersdimension")));
	}

	@SubscribeEvent
	public static void onWorldCarverRegistryEvent(final RegistryEvent.Register<WorldCarver<?>> event)
	{
		DeepWatersBiomeListener.addCarversToBiomes();
	}

	@SubscribeEvent
	public static void onServerInit(final FMLCommonSetupEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new SwordEventSubscriber());
	}

	@SubscribeEvent
	public static void onEntityRegisterEvent(final RegistryEvent.Register<EntityType<?>> event)
	{
		ModdedSpawnEggItem.initUnaddedEggs();
		DeepWatersBiomeListener.addSpawnsToBiomes();
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void doClientStuff(final FMLClientSetupEvent event)
	{
		RenderingRegistry.registerEntityRenderingHandler(Eel.class, manager -> new WormRenderer(manager, new EelHead(), new EelBody(), new EelTail(), new ResourceLocation("deepwaters" + ":textures/model/entity/eel.png"),false));
		RenderingRegistry.registerEntityRenderingHandler(KillerWiggler.class, manager -> new WormRenderer(manager, new KillerWigglerHead(), new KillerWigglerBody(), new KillerWigglerTail(), new ResourceLocation("deepwaters" + ":textures/model/entity/killerwiggler.png"),true));
		RenderingRegistry.registerEntityRenderingHandler(BlufferFish.class, manager -> new BlufferFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(Stingray.class, manager -> new StingrayRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(BabyKracken.class, manager -> new BabyKrackenRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(MuckGulper.class, manager -> new MuckGulperRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(CoralCrawler.class, manager -> new CoralCrawlerRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DonutFish.class, manager -> new DonutFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(ColorfulFish.class, manager -> new ColorfulFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(LegFish.class, manager -> new LegFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DeepGlider.class, manager -> new DeepGliderRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(SkullFish.class, manager -> new SkullFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(SurgeVehicle.class, manager -> new SurgeRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(JungleFish.class, manager -> new JungleFishRenderer(manager));

	}
}
