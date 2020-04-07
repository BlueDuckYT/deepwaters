package bernie.software.datagen;

import bernie.software.datagen.provider.DeepWatersRecipeProvider;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;

import java.util.function.Consumer;

public class DeepWatersRecipes extends DeepWatersRecipeProvider {

    public DeepWatersRecipes(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public String getName() {
        return "Deepwaters Recipes";
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        makeIngotToNugget(DeepWatersItems.PRISMARINE_NUGGET, DeepWatersItems.PRISMARINE_INGOT);

        makeNuggetToIngot(DeepWatersItems.PRISMARINE_INGOT, DeepWatersItems.PRISMARINE_NUGGET);

        makeIngotToBlock(DeepWatersBlocks.PEARL_BLOCK, DeepWatersItems.PEARL);
        makeIngotToBlock(DeepWatersBlocks.PRISMARINE_BLOCK, DeepWatersItems.PRISMARINE_INGOT);

        makeBlockToIngot(DeepWatersItems.PEARL, DeepWatersBlocks.PEARL_BLOCK);
        makeBlockToIngot(DeepWatersItems.PRISMARINE_INGOT, DeepWatersBlocks.PRISMARINE_BLOCK);

        makeSword(DeepWatersItems.PRISMARINE_SWORD, DeepWatersItems.PRISMARINE_INGOT);
        makePickaxe(DeepWatersItems.PRISMARINE_PICKAXE, DeepWatersItems.PRISMARINE_INGOT);
        makeAxe(DeepWatersItems.PRISMARINE_AXE, DeepWatersItems.PRISMARINE_INGOT);
        makeShovel(DeepWatersItems.PRISMARINE_SHOVEL, DeepWatersItems.PRISMARINE_INGOT);
    }

}
