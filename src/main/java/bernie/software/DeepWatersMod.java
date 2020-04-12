package bernie.software;

import bernie.software.datagen.DeepWatersBlockStates;
import bernie.software.datagen.DeepWatersItemModels;
import bernie.software.datagen.DeepWatersLootTables;
import bernie.software.datagen.DeepWatersRecipes;
import bernie.software.registry.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DeepWatersMod.ModID)
public class DeepWatersMod
{

	public DeepWatersMod()
	{
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		bus.addListener(this::setup);
		bus.addListener(this::clientSetup);
		bus.addListener(this::gatherData);

		DeepWatersBiomes.BIOMES.register(bus);
		DeepWatersBlocks.BLOCKS.register(bus);
		DeepWatersItems.ITEMS.register(bus);
		DeepWatersEntities.ENTITIES.register(bus);
		DeepWatersWorldCarvers.WORLD_CARVERS.register(bus);
	}

	public static final String ModID = "deepwaters";

	public void setup(FMLCommonSetupEvent event)
	{
		DeepWatersBiomes.addBiomeTypes();
	}

	public void clientSetup(FMLClientSetupEvent event)
	{

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