package bernie.software;

import bernie.software.client.renderer.model.*;
import bernie.software.entity.vehicle.SurgeVehicle;
import bernie.software.listeners.DeepWatersFeatureListener;
import bernie.software.registry.DeepWatersEntities;
import bernie.software.registry.DeepWatersStructures;
import bernie.software.utils.GeneralUtils;
import bernie.software.client.renderer.entity.*;
import bernie.software.entity.*;
import bernie.software.item.ModdedSpawnEggItem;
import bernie.software.item.events.SwordEventSubscriber;
import bernie.software.world.DeepWatersModDimension;
import bernie.software.listeners.DeepWatersBiomeListener;
import bernie.software.world.biome.SunkenWastesBiome;
import bernie.software.world.biome.WaterBiomeBase;
import bernie.software.world.gen.structures.StructureInit;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.CountConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
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
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = DeepWatersMod.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
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
		DeepWatersFeatureListener.addFeaturesToBiomes();
	}

	@SubscribeEvent
	public static void onServerInit(final FMLCommonSetupEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new SwordEventSubscriber());
		for (Biome biome : ForgeRegistries.BIOMES)
		{
			if (biome.getCategory() == Biome.Category.OCEAN && !(biome instanceof WaterBiomeBase))
			{
				Feature<NoFeatureConfig> portal = (Feature<NoFeatureConfig>) DeepWatersStructures.PORTAL_STRUCTURE.get();
				biome.addStructure((Structure<NoFeatureConfig>) portal, IFeatureConfig.NO_FEATURE_CONFIG);
				biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
						createDecoratedFeature(portal, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE,
								IPlacementConfig.NO_PLACEMENT_CONFIG));
			}
			if (biome instanceof SunkenWastesBiome)
			{
				Feature<CountConfig> crystaline = DeepWatersStructures.CRYSTALINE_CORAL.get();
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						createDecoratedFeature(crystaline, new CountConfig(1),
								Placement.CHANCE_TOP_SOLID_HEIGHTMAP, new ChanceConfig(100)));
			}
		}
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
		RenderingRegistry.registerEntityRenderingHandler(DeepWatersEntities.EEL.get(),
				manager -> new WormRenderer(manager, new EelHead(), new EelBody(), new EelTail(),Eel.class,
						new ResourceLocation("deepwaters" + ":textures/model/entity/eel.png"), false));
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
	}

	@SubscribeEvent
	public static void onRegisterFeaturesEvent(final RegistryEvent.Register<Feature<?>> event)
	{
		Registry.register(Registry.STRUCTURE_PIECE, "portal_piece", StructureInit.PortalPieceType);
	}
}
