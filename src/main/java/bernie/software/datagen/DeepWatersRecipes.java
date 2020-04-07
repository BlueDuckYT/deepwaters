package bernie.software.datagen;

import bernie.software.DeepWatersMod;
import bernie.software.datagen.provider.DeepWatersRecipeProvider;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
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

		smeltingRecipe(DeepWatersItems.PRISMARINE_INGOT.get(), DeepWatersBlocks.PRISMARINE_CRYSTAL_ORE.get(), .7F).build(consumer, name("smelt_prismarine_ore"));
		blastingRecipe(DeepWatersItems.PRISMARINE_INGOT.get(), DeepWatersBlocks.PRISMARINE_CRYSTAL_ORE.get(), .7F).build(consumer, name("blast_prismarine_ore"));

		smeltingRecipe(DeepWatersItems.PRISMARINE_NUGGET.get(), DeepWatersItems.PRISMARINE_SWORD.get(), .1F).build(consumer, name("smelt_prismarine_sword"));
		blastingRecipe(DeepWatersItems.PRISMARINE_NUGGET.get(), DeepWatersItems.PRISMARINE_SWORD.get(), .1F).build(consumer, name("blast_prismarine_sword"));
		smeltingRecipe(DeepWatersItems.PRISMARINE_NUGGET.get(), DeepWatersItems.PRISMARINE_PICKAXE.get(), .1F).build(consumer, name("smelt_prismarine_pickaxe"));
		blastingRecipe(DeepWatersItems.PRISMARINE_NUGGET.get(), DeepWatersItems.PRISMARINE_PICKAXE.get(), .1F).build(consumer, name("blast_prismarine_pickaxe"));
		smeltingRecipe(DeepWatersItems.PRISMARINE_NUGGET.get(), DeepWatersItems.PRISMARINE_AXE.get(), .1F).build(consumer, name("smelt_prismarine_axe"));
		blastingRecipe(DeepWatersItems.PRISMARINE_NUGGET.get(), DeepWatersItems.PRISMARINE_AXE.get(), .1F).build(consumer, name("blast_prismarine_axe"));
		smeltingRecipe(DeepWatersItems.PRISMARINE_NUGGET.get(), DeepWatersItems.PRISMARINE_SHOVEL.get(), .1F).build(consumer, name("smelt_prismarine_shovel"));
		blastingRecipe(DeepWatersItems.PRISMARINE_NUGGET.get(), DeepWatersItems.PRISMARINE_SHOVEL.get(), .1F).build(consumer, name("blast_prismarine_shovel"));

		smeltingRecipe(DeepWatersItems.PRISMARINE_NUGGET.get(), DeepWatersItems.PRISMARINE_HELMET.get(), .1F).build(consumer, name("smelt_prismarine_helmet"));
		blastingRecipe(DeepWatersItems.PRISMARINE_NUGGET.get(), DeepWatersItems.PRISMARINE_HELMET.get(), .1F).build(consumer, name("blast_prismarine_helmet"));
		smeltingRecipe(DeepWatersItems.PRISMARINE_NUGGET.get(), DeepWatersItems.PRISMARINE_CHESTPLATE.get(), .1F).build(consumer, name("smelt_prismarine_chestplate"));
		blastingRecipe(DeepWatersItems.PRISMARINE_NUGGET.get(), DeepWatersItems.PRISMARINE_CHESTPLATE.get(), .1F).build(consumer, name("blast_prismarine_chestplate"));
		smeltingRecipe(DeepWatersItems.PRISMARINE_NUGGET.get(), DeepWatersItems.PRISMARINE_LEGGINGS.get(), .1F).build(consumer, name("smelt_prismarine_leggings"));
		blastingRecipe(DeepWatersItems.PRISMARINE_NUGGET.get(), DeepWatersItems.PRISMARINE_LEGGINGS.get(), .1F).build(consumer, name("blast_prismarine_leggings"));
		smeltingRecipe(DeepWatersItems.PRISMARINE_NUGGET.get(), DeepWatersItems.PRISMARINE_BOOTS.get(), .1F).build(consumer, name("smelt_prismarine_boots"));
		blastingRecipe(DeepWatersItems.PRISMARINE_NUGGET.get(), DeepWatersItems.PRISMARINE_BOOTS.get(), .1F).build(consumer, name("blast_prismarine_boots"));

		ShapedRecipeBuilder.shapedRecipe(DeepWatersItems.PRISMARINE_HELMET.get(), 1)
				.patternLine("IBI")
				.patternLine("B B")
				.key('I', DeepWatersItems.PRISMARINE_INGOT.get())
				.key('B', Blocks.PRISMARINE)
				.addCriterion("has_" + DeepWatersItems.PRISMARINE_INGOT.get().getRegistryName().getPath(), hasItem(DeepWatersItems.PRISMARINE_INGOT.get()))
				.build(consumer, name("prismarine_helmet"));

		ShapedRecipeBuilder.shapedRecipe(DeepWatersItems.PRISMARINE_CHESTPLATE.get(), 1)
				.patternLine("I I")
				.patternLine("BBB")
				.patternLine("IBI")
				.key('I', DeepWatersItems.PRISMARINE_INGOT.get())
				.key('B', Blocks.PRISMARINE)
				.addCriterion("has_" + DeepWatersItems.PRISMARINE_INGOT.get().getRegistryName().getPath(), hasItem(DeepWatersItems.PRISMARINE_INGOT.get()))
				.build(consumer, name("prismarine_chestplate"));

		ShapedRecipeBuilder.shapedRecipe(DeepWatersItems.PRISMARINE_LEGGINGS.get(), 1)
				.patternLine("IBI")
				.patternLine("B B")
				.patternLine("B B")
				.key('I', DeepWatersItems.PRISMARINE_INGOT.get())
				.key('B', Blocks.PRISMARINE)
				.addCriterion("has_" + DeepWatersItems.PRISMARINE_INGOT.get().getRegistryName().getPath(), hasItem(DeepWatersItems.PRISMARINE_INGOT.get()))
				.build(consumer, name("prismarine_leggings"));

		ShapedRecipeBuilder.shapedRecipe(DeepWatersItems.PRISMARINE_BOOTS.get(), 1)
				.patternLine("B B")
				.patternLine("I I")
				.key('I', DeepWatersItems.PRISMARINE_INGOT.get())
				.key('B', Blocks.PRISMARINE)
				.addCriterion("has_" + DeepWatersItems.PRISMARINE_INGOT.get().getRegistryName().getPath(), hasItem(DeepWatersItems.PRISMARINE_INGOT.get()))
				.build(consumer, name("prismarine_boots"));
	}

}
