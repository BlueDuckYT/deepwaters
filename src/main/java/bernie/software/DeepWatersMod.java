package bernie.software;

import bernie.software.block.aquastone.AquastoneDust;
import bernie.software.datagen.DeepWatersBlockStates;
import bernie.software.datagen.DeepWatersItemModels;
import bernie.software.datagen.DeepWatersLootTables;
import bernie.software.datagen.DeepWatersRecipes;
import bernie.software.registry.*;
import net.minecraft.client.Minecraft;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
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

	public DeepWatersMod()
	{
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		logger = LogManager.getLogger();

		bus.addListener(this::setup);
		bus.addListener(this::gatherData);
		bus.addListener(this::clientSetup);

		DeepWatersBiomes.BIOMES.register(bus);
		DeepWatersBlocks.BLOCKS.register(bus);
		DeepWatersItems.ITEMS.register(bus);
		DeepWatersEntities.ENTITIES.register(bus);
		DeepWatersWorldCarvers.WORLD_CARVERS.register(bus);
	}

	public void clientSetup(FMLClientSetupEvent event)
	{
		Minecraft.getInstance().getBlockColors().register(new AquastoneDust.Colors(), DeepWatersBlocks.AQUA_STONE.get());
	}

	public void setup(FMLCommonSetupEvent event)
	{
		DeepWatersBiomes.addBiomeTypes();
		ArrayList<Biome> biomes = new ArrayList<>();
		biomes.add(Biomes.DEEP_OCEAN);
	}


	public void gatherData(GatherDataEvent event)
	{
		DataGenerator generator = event.getGenerator();

		generator.addProvider(new DeepWatersRecipes(generator));
		generator.addProvider(new DeepWatersBlockStates(generator, event.getExistingFileHelper()));
		generator.addProvider(new DeepWatersItemModels(generator, event.getExistingFileHelper()));
		generator.addProvider(new DeepWatersLootTables(generator));
	}

}