package bernie.software.datagen;

import bernie.software.DeepWatersMod;
import bernie.software.datagen.provider.DeepWatersRecipeProvider;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
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
		makeIngotToBlock(DeepWatersBlocks.SALT_BLOCK, DeepWatersItems.SALT_CRYSTAL).build(consumer, name("salt_to_block"));

		makeBlockToIngot(DeepWatersItems.PEARL, DeepWatersBlocks.PEARL_BLOCK).build(consumer, name("block_to_pearl"));
		makeBlockToIngot(DeepWatersItems.PRISMARINE_INGOT, DeepWatersBlocks.PRISMARINE_BLOCK).build(consumer, name("block_to_prismarine_ingot"));
		makeBlockToIngot(DeepWatersItems.SALT_CRYSTAL, DeepWatersBlocks.SALT_BLOCK).build(consumer, name("block_to_salt"));

		makeSword(DeepWatersItems.PRISMARINE_SWORD, DeepWatersItems.PRISMARINE_INGOT).build(consumer);
		makePickaxe(DeepWatersItems.PRISMARINE_PICKAXE, DeepWatersItems.PRISMARINE_INGOT).build(consumer);
		makeAxe(DeepWatersItems.PRISMARINE_AXE, DeepWatersItems.PRISMARINE_INGOT).build(consumer);
		makeShovel(DeepWatersItems.PRISMARINE_SHOVEL, DeepWatersItems.PRISMARINE_INGOT).build(consumer);
		makeShield(DeepWatersItems.PRISMARINE_SHIELD, DeepWatersItems.PRISMARINE_INGOT).build(consumer);

		smeltingRecipe(DeepWatersItems.PRISMARINE_INGOT.get(), DeepWatersBlocks.PRISMARINE_CRYSTAL_ORE.get(), .7F).build(consumer, name("smelt_prismarine_ore"));
		blastingRecipe(DeepWatersItems.PRISMARINE_INGOT.get(), DeepWatersBlocks.PRISMARINE_CRYSTAL_ORE.get(), .7F).build(consumer, name("blast_prismarine_ore"));
		smeltingRecipe(DeepWatersItems.AQUALITE_INGOT.get(), DeepWatersBlocks.AQUALITE_ORE.get(), .7F).build(consumer, name("smelt_aqualite_ore"));
		blastingRecipe(DeepWatersItems.AQUALITE_INGOT.get(), DeepWatersBlocks.AQUALITE_ORE.get(), .7F).build(consumer, name("blast_aqualite_ore"));


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

		smeltingRecipe(DeepWatersBlocks.LIMESTONE_SMOOTH.get(), DeepWatersBlocks.LIMESTONE.get(), .1F).build(consumer, name("smelt_limestone"));
		blastingRecipe(DeepWatersBlocks.LIMESTONE_SMOOTH.get(), DeepWatersBlocks.LIMESTONE.get(), .1F).build(consumer, name("blast_limestone"));

		saltFood(DeepWatersItems.SALTED_BLUFFERFISH, DeepWatersItems.BLUFFERFISH).build(consumer);
		saltFood(DeepWatersItems.SALTED_MUCK_GULPER, DeepWatersItems.MUCK_GULPER).build(consumer);

		smeltingRecipe(DeepWatersItems.COOKED_BLUFFERFISH.get(), DeepWatersItems.BLUFFERFISH.get(), .1F).build(consumer, name("smelt_blufferfish"));
		smokingRecipe(DeepWatersItems.COOKED_BLUFFERFISH.get(), DeepWatersItems.BLUFFERFISH.get(), .1F).build(consumer, name("smoke_blufferfish"));
		smeltingRecipe(DeepWatersItems.COOKED_MUCK_GULPER.get(), DeepWatersItems.MUCK_GULPER.get(), .1F).build(consumer, name("smelt_muck_gulper"));
		smokingRecipe(DeepWatersItems.COOKED_MUCK_GULPER.get(), DeepWatersItems.MUCK_GULPER.get(), .1F).build(consumer, name("smoke_muck_gulper"));


		makePlanks(DeepWatersBlocks.DEADWOOD_PLANKS, DeepWatersBlocks.DEADWOOD_LOG).build(consumer, name("deadwood_planks"));
		makeTrapdoor(DeepWatersBlocks.DEADWOOD_TRAPDOOR, DeepWatersBlocks.DEADWOOD_PLANKS).build(consumer, name("deadwood_trapdoor"));
		makeDoor(DeepWatersBlocks.DEADWOOD_DOOR, DeepWatersBlocks.DEADWOOD_PLANKS).build(consumer, name("deadwood_door"));

		makeBricks(DeepWatersBlocks.LIMESTONE_BRICK, DeepWatersBlocks.LIMESTONE_SMOOTH).build(consumer, name("limestone_brick"));
		makeBricks(DeepWatersBlocks.OCEAN_FLOOR_BRICK, DeepWatersBlocks.OCEAN_FLOOR).build(consumer, name("ocean_floor_brick"));

		makeSlab(DeepWatersBlocks.LIMESTONE_SLAB, DeepWatersBlocks.LIMESTONE).build(consumer, name("limestone_slab"));
		makePillar(DeepWatersBlocks.DARK_PRISMARINE_PILLAR, () -> Blocks.DARK_PRISMARINE).build(consumer, "dark_prismarine_pillar");
		makePillar(DeepWatersBlocks.CHISELED_DARK_PRISMARINE, () -> Blocks.DARK_PRISMARINE_SLAB).build(consumer, "dark_prismarine_chiseled");
		makePillar(DeepWatersBlocks.PRISMARINE_PILLAR, () -> Blocks.PRISMARINE).build(consumer, "prismarine_pillar");
		makePillar(DeepWatersBlocks.CHISELED_PRISMARINE, () -> Blocks.PRISMARINE_SLAB).build(consumer, "prismarine_chiseled");

		makeIngotToBlock(DeepWatersBlocks.AQUA_BLOCK, DeepWatersItems.AQUASTONE_DUST).build(consumer, name("aqua_to_block"));

		ShapelessRecipeBuilder.shapelessRecipe(DeepWatersBlocks.AQUA_STONE.get(), 6).addIngredient(DeepWatersItems.AQUASTONE_DUST.get(), 2).addIngredient(Items.IRON_INGOT, 1)
				.addCriterion("has_" + DeepWatersItems.AQUASTONE_DUST.get().getRegistryName().getPath(), hasItem(DeepWatersItems.AQUASTONE_DUST.get()))
				.build(consumer, name("aquastone_wire"));
		ShapelessRecipeBuilder.shapelessRecipe(DeepWatersBlocks.AQUA_STONE_BUTTON.get(), 2  ).addIngredient(DeepWatersItems.AQUASTONE_DUST.get(), 1).addIngredient(DeepWatersBlocks.OCEAN_FLOOR.get(), 1)
				.addCriterion("has_" + DeepWatersItems.AQUASTONE_DUST.get().getRegistryName().getPath(), hasItem(DeepWatersItems.AQUASTONE_DUST.get()))
				.build(consumer, name("aquastone_button"));

		ShapedRecipeBuilder.shapedRecipe(DeepWatersBlocks.SCRAP_LADDER.get(), 8)
				.patternLine("D D")
				.patternLine("DDD")
				.patternLine("D D")
				.key('D', DeepWatersBlocks.DEADWOOD_PLANKS.get())
				.addCriterion("has_" + DeepWatersBlocks.DEADWOOD_PLANKS.get().getRegistryName().getPath(), hasItem(DeepWatersBlocks.DEADWOOD_PLANKS.get()))
				.build(consumer, name("scrap_ladder"));

		ShapedRecipeBuilder.shapedRecipe(DeepWatersBlocks.SCRAP_LANTERN.get(), 2)
				.patternLine("DDD")
				.patternLine("DTD")
				.patternLine("DDD")
				.key('D', DeepWatersBlocks.DEADWOOD_PLANKS.get())
				.key('T', Blocks.TORCH)
				.addCriterion("has_" + DeepWatersBlocks.DEADWOOD_PLANKS.get().getRegistryName().getPath(), hasItem(DeepWatersBlocks.DEADWOOD_PLANKS.get()))
				.build(consumer, name("scrap_lantern"));

		ShapedRecipeBuilder.shapedRecipe(DeepWatersItems.AQUALITE_SWORD.get(), 1)
				.patternLine("AGA")
				.patternLine(" A ")
				.patternLine(" S ")
				.key('A', DeepWatersItems.AQUALITE_INGOT.get())
				.key('G', Items.GOLD_INGOT)
				.key('S', Items.STICK)
				.addCriterion("has_" + DeepWatersItems.AQUALITE_INGOT.get().getRegistryName().getPath(), hasItem(DeepWatersItems.AQUALITE_INGOT.get()))
				.build(consumer, name("aqualite_sword"));

		ShapedRecipeBuilder.shapedRecipe(DeepWatersItems.AQUALITE_PICKAXE.get(), 1)
				.patternLine("AAA")
				.patternLine(" G ")
				.patternLine(" S ")
				.key('A', DeepWatersItems.AQUALITE_INGOT.get())
				.key('G', Items.GOLD_INGOT)
				.key('S', Items.STICK)
				.addCriterion("has_" + DeepWatersItems.AQUALITE_INGOT.get().getRegistryName().getPath(), hasItem(DeepWatersItems.AQUALITE_INGOT.get()))
				.build(consumer, name("aqualite_pickaxe"));

		ShapedRecipeBuilder.shapedRecipe(DeepWatersItems.AQUALITE_AXE.get(), 1)
				.patternLine("GA ")
				.patternLine("AS ")
				.patternLine(" S ")
				.key('A', DeepWatersItems.AQUALITE_INGOT.get())
				.key('G', Items.GOLD_INGOT)
				.key('S', Items.STICK)
				.addCriterion("has_" + DeepWatersItems.AQUALITE_INGOT.get().getRegistryName().getPath(), hasItem(DeepWatersItems.AQUALITE_INGOT.get()))
				.build(consumer, name("aqualite_axe"));


		ShapedRecipeBuilder.shapedRecipe(DeepWatersItems.AQUALITE_SHOVEL.get(), 1)
				.patternLine(" A ")
				.patternLine(" G ")
				.patternLine(" S ")
				.key('A', DeepWatersItems.AQUALITE_INGOT.get())
				.key('G', Items.GOLD_INGOT)
				.key('S', Items.STICK)
				.addCriterion("has_" + DeepWatersItems.AQUALITE_INGOT.get().getRegistryName().getPath(), hasItem(DeepWatersItems.AQUALITE_INGOT.get()))
				.build(consumer, name("aqualite_shovel"));

		ShapedRecipeBuilder.shapedRecipe(DeepWatersItems.AQUALITE_HOE.get(), 1)
				.patternLine("GA ")
				.patternLine(" S ")
				.patternLine(" S ")
				.key('A', DeepWatersItems.AQUALITE_INGOT.get())
				.key('G', Items.GOLD_INGOT)
				.key('S', Items.STICK)
				.addCriterion("has_" + DeepWatersItems.AQUALITE_INGOT.get().getRegistryName().getPath(), hasItem(DeepWatersItems.AQUALITE_INGOT.get()))
				.build(consumer, name("aqualite_hoe"));

		ShapedRecipeBuilder.shapedRecipe(DeepWatersBlocks.AQUA_FAN.get(), 1)
				.patternLine("IAI")
				.patternLine("AWA")
				.patternLine("IAI")
				.key('A', DeepWatersItems.AQUALITE_INGOT.get())
				.key('I', Items.IRON_INGOT)
				.key('W', DeepWatersBlocks.AQUA_STONE.get())
				.addCriterion("has_" + DeepWatersItems.AQUALITE_INGOT.get().getRegistryName().getPath(), hasItem(DeepWatersItems.AQUALITE_INGOT.get()))
				.addCriterion("has_" + DeepWatersItems.AQUASTONE_DUST.get().getRegistryName().getPath(), hasItem(DeepWatersItems.AQUASTONE_DUST.get()))
				.build(consumer, name("aqua_fan"));

		ShapedRecipeBuilder.shapedRecipe(DeepWatersBlocks.AQUA_COMPARATOR.get(), 1)
				.patternLine(" T ")
				.patternLine("TCT")
				.patternLine("LLL")
				.key('T', DeepWatersBlocks.AQUA_TORCH.get())
				.key('C', DeepWatersItems.CRYSTALINE_CORAL.get())
				.key('L', DeepWatersBlocks.LIMESTONE_SMOOTH.get())
				.addCriterion("has_" + DeepWatersItems.AQUASTONE_DUST.get().getRegistryName().getPath(), hasItem(DeepWatersItems.AQUASTONE_DUST.get()))
				.build(consumer, name("aquastone_comparator"));

		ShapedRecipeBuilder.shapedRecipe(DeepWatersBlocks.AQUA_REPEATER.get(), 1)
				.patternLine("TAT")
				.patternLine("LLL")
				.key('T', DeepWatersBlocks.AQUA_TORCH.get())
				.key('A', DeepWatersBlocks.AQUA_STONE.get())
				.key('L', DeepWatersBlocks.LIMESTONE_SMOOTH.get())
				.addCriterion("has_" + DeepWatersItems.AQUASTONE_DUST.get().getRegistryName().getPath(), hasItem(DeepWatersItems.AQUASTONE_DUST.get()))
				.build(consumer, name("aquastone_repeater"));

		ShapedRecipeBuilder.shapedRecipe(DeepWatersBlocks.AQUA_TORCH.get(), 1)
				.patternLine("A")
				.patternLine("S")
				.key('A', DeepWatersItems.AQUASTONE_DUST.get())
				.key('S', Items.STICK)
				.addCriterion("has_" + DeepWatersItems.AQUASTONE_DUST.get().getRegistryName().getPath(), hasItem(DeepWatersItems.AQUASTONE_DUST.get()))
				.build(consumer, name("aqua_torch"));

		ShapedRecipeBuilder.shapedRecipe(DeepWatersBlocks.IRON_HATCH.get(), 1)
				.patternLine(" A ")
				.patternLine("III")
				.patternLine("III")
				.key('I', Items.IRON_INGOT)
				.key('A', DeepWatersBlocks.AQUA_STONE.get())
				.addCriterion("has_" + DeepWatersBlocks.AQUA_STONE.get().getRegistryName().getPath(), hasItem(DeepWatersBlocks.AQUA_STONE.get()))
				.build(consumer, name("iron_hatch"));

		ShapedRecipeBuilder.shapedRecipe(DeepWatersBlocks.IRON_HATCH_DOOR.get(), 1)
				.patternLine("I I")
				.patternLine("IAI")
				.patternLine("I I")
				.key('I', Items.IRON_INGOT)
				.key('A', DeepWatersBlocks.AQUA_STONE.get())
				.addCriterion("has_" + DeepWatersBlocks.AQUA_STONE.get().getRegistryName().getPath(), hasItem(DeepWatersBlocks.AQUA_STONE.get()))
				.build(consumer, name("iron_hatch_door"));

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
