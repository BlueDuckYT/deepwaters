package bernie.software.datagen;

import bernie.software.DeepWatersMod;
import bernie.software.datagen.provider.DeepWatersRecipeProvider;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class DeepWatersRecipes extends DeepWatersRecipeProvider
{

	public DeepWatersRecipes(DataGenerator dataGenerator)
	{
		super(dataGenerator);
	}

	@Override
	public String getName()
	{
		return "Deepwaters Recipes";
	}

	private ResourceLocation name(String name)
	{
		return new ResourceLocation(DeepWatersMod.ModID, name);
	}

	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
	{
		makeIngotToNugget(DeepWatersItems.PRISMARINE_NUGGET, DeepWatersItems.PRISMARINE_INGOT).build(consumer, name("prismarine_ingot_to_nugget"));

		makeNuggetToIngot(DeepWatersItems.PRISMARINE_INGOT, DeepWatersItems.PRISMARINE_NUGGET).build(consumer, name("prismarine_nugget_to_ingot"));

		makeIngotToBlock(DeepWatersBlocks.PEARL_BLOCK, DeepWatersItems.PEARL).build(consumer, name("pearl_to_block"));
		makeIngotToBlock(DeepWatersBlocks.PRISMARINE_BLOCK, DeepWatersItems.PRISMARINE_INGOT).build(consumer, name("prismarine_ingot_to_block"));

		makeBlockToIngot(DeepWatersItems.PEARL, DeepWatersBlocks.PEARL_BLOCK).build(consumer, name("block_to_pearl"));
		makeBlockToIngot(DeepWatersItems.PRISMARINE_INGOT, DeepWatersBlocks.PRISMARINE_BLOCK).build(consumer, name("block_to_prismarine_ingot"));

		makeSword(DeepWatersItems.PRISMARINE_SWORD, DeepWatersItems.PRISMARINE_INGOT).build(consumer);
		makePickaxe(DeepWatersItems.PRISMARINE_PICKAXE, DeepWatersItems.PRISMARINE_INGOT).build(consumer);
		makeAxe(DeepWatersItems.PRISMARINE_AXE, DeepWatersItems.PRISMARINE_INGOT).build(consumer);
		makeShovel(DeepWatersItems.PRISMARINE_SHOVEL, DeepWatersItems.PRISMARINE_INGOT).build(consumer);
	}

}
