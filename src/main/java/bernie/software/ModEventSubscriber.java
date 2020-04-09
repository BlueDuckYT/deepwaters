package bernie.software;

import bernie.software.world.biome.CoralFieldsBiome;
import bernie.software.client.renderer.entity.*;
import bernie.software.entity.*;
import bernie.software.item.ModdedSpawnEggItem;
import bernie.software.item.tool.SwordEventSubscriber;
import bernie.software.registry.DeepWatersBiomes;
import bernie.software.registry.DeepWatersEntities;
import bernie.software.world.DeepWatersModDimension;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
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
		event.getRegistry().register(new DeepWatersModDimension().setRegistryName(Location("deepwatersdimension")));
	}

	@SubscribeEvent
	public static void onWorldCarverRegistryEvent(final RegistryEvent.Register<WorldCarver<?>> event)
	{
		CoralFieldsBiome biome = (CoralFieldsBiome) DeepWatersBiomes.CoralFieldsBiome.get();
		biome.AddWorldCarver();
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
		CoralFieldsBiome biome = (CoralFieldsBiome) DeepWatersBiomes.CoralFieldsBiome.get();
		biome.addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.BLUFFERFISH.get(), 30, 4, 10));
		biome.addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.KILLER_WIGGLER.get(), 1, 1, 1));
		biome.addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(EntityType.SALMON, 30, 5, 10));
		biome.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.TROPICAL_FISH, 25, 8, 8));
		biome.addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.BABY_KRACKEN.get(), 2, 1, 2));
		biome.addWaterLandPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.CLAM.get(), 12, 1, 2));
		biome.addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.STING_RAY.get(), 4, 1, 4));
		biome.addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.MUCK_GULPER.get(), 30, 1, 10));

	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void doClientStuff(final FMLClientSetupEvent event)
	{
		RenderingRegistry.registerEntityRenderingHandler(KillerWiggler.class, manager -> new KillerWigglerRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(BlufferFish.class, manager -> new BlufferFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(Clam.class, manager -> new ClamRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(Stingray.class, manager -> new StingrayRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(BabyKracken.class, manager -> new BabyKrackenRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(MuckGulper.class, manager -> new MuckGulperRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(CoralCrawler.class, manager -> new CoralCrawlerRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DonutFish.class, manager -> new DonutFishRenderer(manager));

	}

	public static ResourceLocation Location(String name)
	{
		return new ResourceLocation(DeepWatersMod.ModID, name);
	}
}
