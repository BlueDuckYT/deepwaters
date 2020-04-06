package bernie.software;

import bernie.software.biome.CoralFieldsBiome;
import bernie.software.client.renderer.entity.*;
import bernie.software.entity.*;
import bernie.software.registry.DeepWatersBiomes;
import bernie.software.registry.DeepWatersEntities;
import bernie.software.world.DeepWatersModDimension;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = DeepWatersMod.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {

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

	public static boolean coralBiomeSpawned = false;
	@SubscribeEvent
	public static void onEntityRegisterEvent(final RegistryEvent.Register<EntityType<?>> event)
	{
		CoralFieldsBiome biome = (CoralFieldsBiome) DeepWatersBiomes.CoralFieldsBiome.get();
		if(!coralBiomeSpawned) {
			biome.addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.BLUFFERFISH.get(), 10, 4, 10));
			biome.addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.KILLER_WIGGLER.get(), 1, 1, 1));
			biome.addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(EntityType.SALMON, 10, 5, 10));
			biome.addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.BABY_KRACKEN.get(), 5, 1, 2));
			biome.addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.CLAM.get(), 12, 1, 2));
			biome.addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.STING_RAY.get(), 8, 1, 4));
			biome.addWaterPassiveCreatureSpawn(new Biome.SpawnListEntry(DeepWatersEntities.MUCK_GULPER.get(), 10, 1, 10));
			coralBiomeSpawned = true;
		}
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
	}

	public static ResourceLocation Location(String name)
	{
		return new ResourceLocation(DeepWatersMod.ModID, name);
	}
}
