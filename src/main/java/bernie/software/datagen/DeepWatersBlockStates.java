package bernie.software.datagen;

import bernie.software.datagen.provider.DeepWatersBlockStateProvider;
import bernie.software.registry.DeepWatersBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class DeepWatersBlockStates extends DeepWatersBlockStateProvider
{

	public DeepWatersBlockStates(DataGenerator dataGenerator, ExistingFileHelper fileHelper)
	{
		super(dataGenerator, fileHelper);
	}

	public static List<RegistryObject<Block>> NormalBlocks = new ArrayList<>();

	@Override
	public String getName()
	{
		return "Deepwaters Block States";
	}

	@Override
	protected void registerStatesAndModels()
	{
		doorBlock(DeepWatersBlocks.SCRAP_DOOR.get(), modLoc("block/iron_hatch"), modLoc("block/iron_hatch"));
		doorBlock(DeepWatersBlocks.DEADWOOD_DOOR.get(), modLoc("block/deadwood_door_bottom"), modLoc("block/deadwood_door_top"));
		grassBlock(DeepWatersBlocks.MOSSY_OCEAN_FLOOR, "ocean_floor");
		normalBlock(DeepWatersBlocks.SALT_ORE);
		normalBlock(DeepWatersBlocks.DEEPWATERSPORTAL);
		rotationalWithVerticle(DeepWatersBlocks.PORTAL_PILLAR_END,"portalpillaroff");
		logBlock(DeepWatersBlocks.DEADWOOD_LOG, "deadwood_log");
		pillarBlock(DeepWatersBlocks.PORTAL_PILLAR, "portal_pillar");
		pillarBlock(DeepWatersBlocks.ACTIVATED_PORTAL_PILLAR, "activated_portal_pillar");
		rotational(DeepWatersBlocks.SUNKEN_WASTES_LAMP, "sunkenwastes_lamp");
		rotational(DeepWatersBlocks.PEDESTAL, "pedestal");
		//redstone(DeepWatersBlocks.AQUA_STONE, "aquastone_wire");
		pillarBlock(DeepWatersBlocks.DARK_PRISMARINE_PILLAR, "dark_prismarine_pillar");
		pillarBlock(DeepWatersBlocks.PRISMARINE_PILLAR, "prismarine_pillar");
		pillarBlock(DeepWatersBlocks.CHISELED_DARK_PRISMARINE, "dark_prismarine_chiseled");
		pillarBlock(DeepWatersBlocks.CHISELED_PRISMARINE, "prismarine_chiseled");
		pillarBlock(DeepWatersBlocks.OCEAN_FLOOR_BRICK, "ocean_floor_brick");

		//(DeepWatersBlocks.OXYGENATOR, "oxygenator");
		for (RegistryObject<Block> block : NormalBlocks) {
			normalBlock(block);
		}


	}
}
