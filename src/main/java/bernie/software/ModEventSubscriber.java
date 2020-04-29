package bernie.software;

import bernie.software.client.renderer.model.*;
import bernie.software.client.renderer.tileentity.renderer.aquafan;
import bernie.software.gui.VehicleContainer;
import bernie.software.gui.VehicleContainerTypes;
import bernie.software.gui.surge.SurgeScreen;
import bernie.software.registry.DeepWatersEntities;
import bernie.software.registry.DeepWatersStructures;
import bernie.software.registry.DeepWatersTileEntities;
import bernie.software.utils.GeneralUtils;
import bernie.software.client.renderer.entity.*;
import bernie.software.entity.*;
import bernie.software.item.ModdedSpawnEggItem;
import bernie.software.event.SwordEventSubscriber;
import bernie.software.utils.StructureUtils;
import bernie.software.world.DeepWatersModDimension;
import bernie.software.listeners.DeepWatersBiomeListener;
import bernie.software.world.biome.SunkenWastesBiome;
import bernie.software.world.biome.WaterBiomeBase;
import bernie.software.world.gen.structures.DeepWatersStructureInit;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.EntityType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = DeepWatersMod.ModID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventSubscriber
{

	@ObjectHolder("deepwaters:deepwatersdimension")
	public static final ModDimension DeepWatersDimension = null;

	@SubscribeEvent
	public static void onDimensionRegistryEvent(final RegistryEvent.Register<ModDimension> event)
	{
		event.getRegistry().register(
				new DeepWatersModDimension().setRegistryName(GeneralUtils.Location("deepwatersdimension")));
	}

	@SubscribeEvent
	public static void onWorldCarverRegistryEvent(final RegistryEvent.Register<WorldCarver<?>> event)
	{
		DeepWatersBiomeListener.addCarversToBiomes();
	}

	@SubscribeEvent
	public static void onFeatureRegistryEvent(final RegistryEvent.Register<Feature<?>> event)
	{
		DeepWatersBiomeListener.addFeaturesToBiomes();
	}

	@SubscribeEvent
	public static void onServerInit(final FMLCommonSetupEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new SwordEventSubscriber());
		for (Biome biome : ForgeRegistries.BIOMES)
		{
			if (biome.getCategory() == Biome.Category.OCEAN && !(biome instanceof WaterBiomeBase))
			{
				StructureUtils.addStructure().accept(biome, DeepWatersStructures.PORTAL_STRUCTURE);
			}
			if(biome instanceof SunkenWastesBiome)
			{
				StructureUtils.addStructure().accept(biome, DeepWatersStructures.SUNKEN_SHIP);
			}
		}
	}

	@SubscribeEvent
	public static void onEntityRegisterEvent(final RegistryEvent.Register<EntityType<?>> event)
	{
		ModdedSpawnEggItem.initUnaddedEggs();
		DeepWatersBiomeListener.addSpawnsToBiomes();
	}


	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event){
		ScreenManager.registerFactory(VehicleContainerTypes.SURGE.get(), SurgeScreen::new);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void doClientStuff(final FMLClientSetupEvent event)
	{
		RenderingRegistry.registerEntityRenderingHandler(DeepWatersEntities.KILLER_WIGGLER.get(),
				manager -> new WormRenderer(manager, new KillerWigglerHead(), new KillerWigglerBody(), new KillerWigglerTail(), KillerWiggler.class,
						new ResourceLocation("deepwaters" + ":textures/model/entity/killerwiggler.png"), true));
		RenderingRegistry.registerEntityRenderingHandler(DeepWatersEntities.BLUFFERFISH.get(),
				manager -> new BlufferFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DeepWatersEntities.STING_RAY.get(), manager -> new StingrayRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DeepWatersEntities.BABY_KRACKEN.get(),
				manager -> new BabyKrackenRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DeepWatersEntities.MUCK_GULPER.get(), manager -> new MuckGulperRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DeepWatersEntities.CORAL_CRAWLER.get(),
				manager -> new CoralCrawlerRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DeepWatersEntities.DONUT_FISH.get(), manager -> new DonutFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DeepWatersEntities.COLORFUL_FISH.get(),
				manager -> new ColorfulFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DeepWatersEntities.LEG_FISH.get(), manager -> new LegFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DeepWatersEntities.DEEP_GLIDER.get(), manager -> new DeepGliderRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DeepWatersEntities.SKULL_FISH.get(), manager -> new SkullFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DeepWatersEntities.SURGE.get(), manager -> new SurgeRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DeepWatersEntities.JUNGLE_FISH.get(), manager -> new JungleFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DeepWatersEntities.SEA_URCHIN.get(), manager -> new SeaUrchinRenderer(manager));
//		ClientRegistry.bindTileEntityRenderer(DeepWatersTileEntities.AQUASTONE_FAN.get(), new Function<TileEntityRendererDispatcher, TileEntityRenderer<? super TileEntity>>() {
//			@Override
//			public TileEntityRenderer<? super TileEntity> apply(TileEntityRendererDispatcher tileEntityRendererDispatcher) {
//				return (TileEntityRenderer)new aquafan(tileEntityRendererDispatcher);
//			}
//		});

	}

	@SubscribeEvent
	public static void onRegisterFeaturesEvent(final RegistryEvent.Register<Feature<?>> event)
	{
		Registry.register(Registry.STRUCTURE_PIECE, "portal_piece", DeepWatersStructureInit.PortalPieceType);
		Registry.register(Registry.STRUCTURE_PIECE, "sunken_ship", DeepWatersStructureInit.SunkenShipPieceType);

	}
}
