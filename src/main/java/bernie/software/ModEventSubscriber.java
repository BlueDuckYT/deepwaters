package bernie.software;

import bernie.software.biome.CoralFieldsBiome;
import bernie.software.client.renderer.entity.*;
import bernie.software.entity.*;
import bernie.software.registry.DeepWatersBiomes;
import bernie.software.registry.DeepWatersEntities;
import bernie.software.registry.DeepWatersWorldCarvers;
import bernie.software.world.DeepWatersModDimension;
import bernie.software.world.gen.carver.CoralFieldsCaveWorldCarver;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ObjectHolder;

import javax.swing.text.DefaultEditorKit;

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

	@SubscribeEvent
	public static void onEntityRegisterEvent(final RegistryEvent.Register<EntityType<?>> event)
	{
		CoralFieldsBiome biome = (CoralFieldsBiome) DeepWatersBiomes.CoralFieldsBiome.get();

		biome.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(DeepWatersEntities.BLUFFERFISH.get(), 150, 4, 30));
		biome.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(DeepWatersEntities.KILLER_WIGGLER.get(), 2, 1, 1));
		biome.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(DeepWatersEntities.STING_RAY.get(), 20, 1, 3));
		biome.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.COD, 100, 5, 30));
		biome.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.SALMON, 100, 5, 30));
		biome.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(DeepWatersEntities.BABY_KRACKEN.get(), 10, 1, 2));
		biome.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(DeepWatersEntities.CLAM.get(), 300, 1, 2));
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
