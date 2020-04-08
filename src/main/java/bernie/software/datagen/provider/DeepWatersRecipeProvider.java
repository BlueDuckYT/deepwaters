package bernie.software.datagen.provider;

import bernie.software.registry.DeepWatersItems;
import net.minecraft.block.Block;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.data.ForgeRecipeProvider;

import java.util.function.Supplier;

public class DeepWatersRecipeProvider extends ForgeRecipeProvider implements IConditionBuilder {

    public DeepWatersRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    public ShapelessRecipeBuilder saltFood(Supplier<? extends Item> saltedFoodOut, Supplier<? extends Item> foodIn) {
        return ShapelessRecipeBuilder.shapelessRecipe(saltedFoodOut.get())
                .addIngredient(foodIn.get())
                .addIngredient(DeepWatersItems.SALT_CRYSTAL.get())
                .addCriterion("has_" + foodIn.get().getRegistryName().getPath(), hasItem(foodIn.get()));

    }

    public ShapedRecipeBuilder makeNuggetToIngot(Supplier<? extends Item> ingotOut, Supplier<? extends Item> nuggetIn) {
        return ShapedRecipeBuilder.shapedRecipe(ingotOut.get())
                .patternLine("NNN")
                .patternLine("NNN")
                .patternLine("NNN")
                .key('N', nuggetIn.get())
                .addCriterion("has_" + nuggetIn.get().getRegistryName().getPath(), hasItem(nuggetIn.get()));
    }

    public ShapelessRecipeBuilder makeIngotToNugget(Supplier<? extends Item> nuggetOut, Supplier<? extends Item> ingotIn) {
        return ShapelessRecipeBuilder.shapelessRecipe(nuggetOut.get(), 9)
                .addIngredient(ingotIn.get())
                .addCriterion("has_" + ingotIn.get().getRegistryName().getPath(), hasItem(ingotIn.get()));
    }

    public ShapedRecipeBuilder makeIngotToBlock(Supplier<? extends Block> blockOut, Supplier<? extends Item> ingotIn) {
        return ShapedRecipeBuilder.shapedRecipe(blockOut.get())
                .patternLine("###")
                .patternLine("###")
                .patternLine("###")
                .key('#', ingotIn.get())
                .addCriterion("has_" + ingotIn.get().getRegistryName().getPath(), hasItem(ingotIn.get()));
    }

    public ShapelessRecipeBuilder makeBlockToIngot(Supplier<? extends Item> ingotOut, Supplier<? extends Block> blockIn) {
        return ShapelessRecipeBuilder.shapelessRecipe(ingotOut.get(), 9)
                .addIngredient(blockIn.get())
                .addCriterion("has_" + blockIn.get().getRegistryName().getPath(), hasItem(blockIn.get()));
    }

    public ShapedRecipeBuilder makeSword(Supplier<? extends Item> swordOut, Supplier<? extends Item> materialIn) {
        return ShapedRecipeBuilder.shapedRecipe(swordOut.get())
                .patternLine("#")
                .patternLine("#")
                .patternLine("/")
                .key('#', materialIn.get())
                .key('/', Items.STICK)
                .addCriterion("has_" + materialIn.get().getRegistryName().getPath(), hasItem(materialIn.get()));
    }

    public ShapedRecipeBuilder makePickaxe(Supplier<? extends Item> pickaxeOut, Supplier<? extends Item> materialIn) {
        return ShapedRecipeBuilder.shapedRecipe(pickaxeOut.get())
                .patternLine("###")
                .patternLine(" / ")
                .patternLine(" / ")
                .key('#', materialIn.get())
                .key('/', Items.STICK)
                .addCriterion("has_" + materialIn.get().getRegistryName().getPath(), hasItem(materialIn.get()));
    }

    public ShapedRecipeBuilder makeAxe(Supplier<? extends Item> axeOut, Supplier<? extends Item> materialIn) {
        return ShapedRecipeBuilder.shapedRecipe(axeOut.get())
                .patternLine("##")
                .patternLine("#/")
                .patternLine(" /")
                .key('#', materialIn.get())
                .key('/', Items.STICK)
                .addCriterion("has_" + materialIn.get().getRegistryName().getPath(), hasItem(materialIn.get()));
    }

    public ShapedRecipeBuilder makeShovel(Supplier<? extends Item> shovelOut, Supplier<? extends Item> materialIn) {
        return ShapedRecipeBuilder.shapedRecipe(shovelOut.get())
                .patternLine("#")
                .patternLine("/")
                .patternLine("/")
                .key('#', materialIn.get())
                .key('/', Items.STICK)
                .addCriterion("has_" + materialIn.get().getRegistryName().getPath(), hasItem(materialIn.get()));
    }

    public CookingRecipeBuilder smeltingRecipe(IItemProvider result, IItemProvider ingredient, float exp) {
        return smeltingRecipe(result, ingredient, exp, 1);
    }

    public CookingRecipeBuilder smeltingRecipe(IItemProvider result, IItemProvider ingredient, float exp, int count) {
        return CookingRecipeBuilder.smeltingRecipe(Ingredient.fromStacks(new ItemStack(ingredient, count)), result, exp, 200)
                .addCriterion("has_" + ingredient.asItem().getRegistryName(), hasItem(ingredient));
    }

    public CookingRecipeBuilder blastingRecipe(IItemProvider result, IItemProvider ingredient, float exp) {
        return blastingRecipe(result, ingredient, exp, 1);
    }

    public CookingRecipeBuilder blastingRecipe(IItemProvider result, IItemProvider ingredient, float exp, int count) {
        return CookingRecipeBuilder.blastingRecipe(Ingredient.fromStacks(new ItemStack(ingredient, count)), result, exp, 100)
                .addCriterion("has_" + ingredient.asItem().getRegistryName(), hasItem(ingredient));
    }

    public CookingRecipeBuilder smokingRecipe(IItemProvider result, IItemProvider ingredient, float exp) {
        return smokingRecipe(result, ingredient, exp, 1);
    }

    public CookingRecipeBuilder smokingRecipe(IItemProvider result, IItemProvider ingredient, float exp, int count) {
        return CookingRecipeBuilder.cookingRecipe(Ingredient.fromStacks(new ItemStack(ingredient, count)), result, exp, 100, IRecipeSerializer.SMOKING)
                .addCriterion("has_" + ingredient.asItem().getRegistryName(), hasItem(ingredient));
    }

}
