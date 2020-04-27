package bernie.software;

import bernie.software.block.ThickKelpBlock;
import bernie.software.block.aquastone.AquastoneColor;
import bernie.software.client.renderer.events.WorldRenderEvents;
import bernie.software.datagen.DeepWatersBlockStates;
import bernie.software.datagen.DeepWatersItemModels;
import bernie.software.datagen.DeepWatersLootTables;
import bernie.software.datagen.DeepWatersRecipes;
import bernie.software.event.SwordEventSubscriber;
import bernie.software.registry.*;
import net.minecraft.client.Minecraft;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

@Mod(DeepWatersMod.ModID)
public class DeepWatersMod
{
	public static Logger logger;
	public static final String ModID = "deepwaters";
	public static boolean noFogMod=false;

	public DeepWatersMod()
	{
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		logger = LogManager.getLogger();

		bus.addListener(this::setup);
		bus.addListener(this::gatherData);
		try {
			if (Minecraft.getInstance()!=null) {
				bus.addListener(this::clientSetup);
			}
		} catch (Exception err) {}
		DeepWatersBiomes.BIOMES.register(bus);
		DeepWatersBlocks.BLOCKS.register(bus);
		DeepWatersItems.ITEMS.register(bus);
		DeepWatersEntities.ENTITIES.register(bus);
		DeepWatersWorldCarvers.WORLD_CARVERS.register(bus);
		DeepWatersStructures.STRUCTURES.register(bus);

	}

	@OnlyIn(Dist.CLIENT)
	private void clientSetup(FMLClientSetupEvent event)
	{
		Minecraft.getInstance().getBlockColors().register(new AquastoneColor(), DeepWatersBlocks.AQUA_STONE.get());
		Minecraft.getInstance().getBlockColors().register(new ThickKelpBlock.Colors(), DeepWatersBlocks.THICK_KELP.get());
	}

	private void setup(FMLCommonSetupEvent event)
	{
		DeepWatersBiomes.addBiomeTypes();
		ArrayList<Biome> biomes = new ArrayList<>();
		biomes.add(Biomes.DEEP_OCEAN);
	}


	private void gatherData(GatherDataEvent event)
	{
		DataGenerator generator = event.getGenerator();

		generator.addProvider(new DeepWatersRecipes(generator));
		generator.addProvider(new DeepWatersBlockStates(generator, event.getExistingFileHelper()));
		generator.addProvider(new DeepWatersItemModels(generator, event.getExistingFileHelper()));
		generator.addProvider(new DeepWatersLootTables(generator));
	}

}