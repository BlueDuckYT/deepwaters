package bernie.software;

import bernie.software.client.renderer.entity.BlufferFishRenderer;
import bernie.software.client.renderer.entity.ClamRenderer;
import bernie.software.entity.BlufferFish;
import bernie.software.entity.Clam;
import bernie.software.entity.KillerWiggler;
import bernie.software.client.renderer.entity.KillerWigglerRenderer;
import bernie.software.world.DeepWatersModDimension;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
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

@Mod.EventBusSubscriber(modid = DeepWatersMod.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber
{
	public static EntityType<KillerWiggler> killerWigglerEntityType;
	public static EntityType<BlufferFish> blufferfishEntityType;
	public static EntityType<Clam> clamEntityType;

	@ObjectHolder("deepwaters:deepwatersdimension")
	public static final ModDimension DeepWatersDimension = null;
	//@ObjectHolder("deepwaters:defaultwaterbiome")
	//public static  Biome DefaultWaterBiomeInstance = null;

	@SubscribeEvent
	public static void onDimensionRegistryEvent(final RegistryEvent.Register<ModDimension> event)
	{
		event.getRegistry().register(new DeepWatersModDimension().setRegistryName("deepwaters:deepwatersdimension"));

	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void doClientStuff(final FMLClientSetupEvent event)
	{
		RenderingRegistry.registerEntityRenderingHandler(KillerWiggler.class, new IRenderFactory<KillerWiggler>()
		{
			@Override
			public EntityRenderer<? super KillerWiggler> createRenderFor(EntityRendererManager manager)
			{
				return new KillerWigglerRenderer(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(BlufferFish.class, new IRenderFactory<BlufferFish>()
		{
			@Override
			public EntityRenderer<? super BlufferFish> createRenderFor(EntityRendererManager manager)
			{
				return new BlufferFishRenderer(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(Clam.class, new IRenderFactory<Clam>()
		{
			@Override
			public EntityRenderer<? super Clam> createRenderFor(EntityRendererManager manager)
			{
				return new ClamRenderer(manager);
			}
		});
	}
	/*
	@SubscribeEvent
	public static void onBiomeRegistryEvent(final RegistryEvent.Register<Biome> event)
	{
		DefaultWaterBiomeInstance = new DefaultWaterBiome().setRegistryName("deepwaters:defaultwaterbiome");
		event.getRegistry().register(DefaultWaterBiomeInstance);
		BiomeDictionary.addTypes(DefaultWaterBiomeInstance, BiomeDictionary.Type.NETHER);
	}
	*/
	@SubscribeEvent
	public static void onEntityRegistryEvent(final RegistryEvent.Register<EntityType<?>> event)
	{
		killerWigglerEntityType = EntityType.Builder.create(KillerWiggler::new, EntityClassification.MONSTER).size(10.387F, 2.4375F).build("entitymobtest");
		blufferfishEntityType = EntityType.Builder.create(BlufferFish::new, EntityClassification.WATER_CREATURE).size(0.8125F, 0.5F).build("blufferfish");
		clamEntityType = EntityType.Builder.create(Clam::new, EntityClassification.WATER_CREATURE).size(1,1).build("clam");

		event.getRegistry().register(killerWigglerEntityType.setRegistryName(Location("killerwiggler")));
		event.getRegistry().register(blufferfishEntityType.setRegistryName(Location("blufferfish")));
		event.getRegistry().register(clamEntityType.setRegistryName(Location("clam")));

	}
	/*
	@SubscribeEvent
	public static void onBlockRegistryEvent(final RegistryEvent.Register<Block> event
	{

		event.getRegistry().registerAll(BlockList.OceanFloorBlock = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.STONE)).setRegistryName(Location("oceanfloorblock")));

	}
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {

		ItemList.OceanFloorItemBlockBlock = new BlockItem(BlockList.OceanFloorBlock, new Item.Properties().group(ItemGroup.MATERIALS));
		ItemList.OceanFloorItemBlockBlock.setRegistryName(BlockList.OceanFloorBlock.getRegistryName());
		event.getRegistry().registerAll(ItemList.OceanFloorItemBlockBlock);
	}
	*/
	public static ResourceLocation Location(String name)
	{
		return new ResourceLocation(DeepWatersMod.ModID, name);
	}
}
