package bernie.software;

import bernie.software.block.aquastone.AquastoneColor;
import bernie.software.client.ClientEvents;
import bernie.software.datagen.DeepWatersBlockStates;
import bernie.software.datagen.DeepWatersItemModels;
import bernie.software.datagen.DeepWatersLootTables;
import bernie.software.datagen.DeepWatersRecipes;
import bernie.software.registry.DeepWatersContainerTypes;
import bernie.software.gui.surge.OpenSurgeGuiPacket;
import bernie.software.registry.*;
import bernie.software.utils.network.NetBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(DeepWatersMod.ModID)
public class DeepWatersMod
{
	public static Logger logger;
	public static final String ModID = "deepwaters";
	public static boolean noFogMod = false;

	public static final SimpleChannel CHANNEL = new NetBuilder(new ResourceLocation(ModID, "main"))
			.version(1).optionalServer().requiredClient()
			.serverbound(OpenSurgeGuiPacket::new).consumer(() -> OpenSurgeGuiPacket::handle)
			.build();

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
		DeepWatersContainerTypes.CONTAINER_TYPES.register(bus);
		DeepWatersTileEntities.TILE_ENTITIES.register(bus);


	}

	@OnlyIn(Dist.CLIENT)
	private void clientSetup(FMLClientSetupEvent event)
	{
		Minecraft.getInstance().getBlockColors().register(new AquastoneColor(), DeepWatersBlocks.AQUA_STONE.get());
		ClientEvents.registerBlockRenderers();
		ClientEvents.registerTESRs();
	}

	private void setup(FMLCommonSetupEvent event)
	{
		DeepWatersBiomes.addBiomeTypes();
		DeepWatersEntities.spawnPlacements();

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