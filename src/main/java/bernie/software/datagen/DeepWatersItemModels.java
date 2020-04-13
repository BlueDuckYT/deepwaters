package bernie.software.datagen;

import bernie.software.datagen.provider.DeepWatersItemModelProvider;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersItems;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class DeepWatersItemModels extends DeepWatersItemModelProvider
{

	public DeepWatersItemModels(DataGenerator dataGenerator, ExistingFileHelper fileHelper)
	{
		super(dataGenerator, fileHelper);
	}

	public static List<RegistryObject<Block>> NormalItemBlocks = new ArrayList<>();


	@Override
	public String getName()
	{
		return "Deepwaters Item Models";
	}

	@Override
	protected void registerModels()
	{
		for (RegistryObject<Block> block : NormalItemBlocks) {
			itemBlock(block);
		}

		normalItem(DeepWatersItems.SALT_CRYSTAL);
		normalItem(DeepWatersItems.SHARK_TOOTH);
		toolItem(DeepWatersItems.PEAL_WAND);
		normalItem(DeepWatersItems.PEARL);
		normalItem(DeepWatersItems.PRISMARINE_INGOT);
		normalItem(DeepWatersItems.PRISMARINE_NUGGET);
		normalItem(DeepWatersItems.PRISMARINE_HELMET);
		normalItem(DeepWatersItems.PRISMARINE_CHESTPLATE);
		normalItem(DeepWatersItems.PRISMARINE_LEGGINGS);
		normalItem(DeepWatersItems.PRISMARINE_BOOTS);
		normalItem(DeepWatersItems.BLUFFERFISH);
		normalItem(DeepWatersItems.COOKED_BLUFFERFISH);
		normalItem(DeepWatersItems.SALTED_BLUFFERFISH);
		normalItem(DeepWatersItems.MUCK_GULPER);
		normalItem(DeepWatersItems.COOKED_MUCK_GULPER);

		toolItem(DeepWatersItems.PRISMARINE_SWORD);
		toolItem(DeepWatersItems.PRISMARINE_PICKAXE);
		toolItem(DeepWatersItems.PRISMARINE_AXE);
		toolItem(DeepWatersItems.PRISMARINE_SHOVEL);
		toolItem(DeepWatersItems.PRISMARINE_SHIELD);

		spawnEgg(DeepWatersItems.KILLER_WIGGLER_SPAWN_EGG);
		spawnEgg(DeepWatersItems.BLUFFERFISH_SPAWN_EGG);
		spawnEgg(DeepWatersItems.CLAM_SPAWN_EGG);
		spawnEgg(DeepWatersItems.STING_RAY_SPAWN_EGG);
		spawnEgg(DeepWatersItems.BABY_KRACKEN_SPAWN_EGG);
		spawnEgg(DeepWatersItems.MUCK_GULPER_SPAWN_EGG);
		spawnEgg(DeepWatersItems.COLORFUL_FISH_SPAWN_EGG);
		spawnEgg(DeepWatersItems.DEEP_GLIDER_SPAWN_EGG);
		spawnEgg(DeepWatersItems.SKULL_FISH_SPAWN_EGG);
		spawnEgg(DeepWatersItems.LEG_FISH_SPAWN_EGG);
		spawnEgg(DeepWatersItems.DONUT_FISH_SPAWN_EGG);
		spawnEgg(DeepWatersItems.CORAL_CRAWLER_SPAWN_EGG);
	}
}
