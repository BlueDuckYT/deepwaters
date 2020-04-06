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
        makeIngotToBlock(DeepWatersBlocks.PEARL_BLOCK, DeepWatersItems.PEARL);

        makeBlockToIngot(DeepWatersItems.PEARL, DeepWatersBlocks.PEARL_BLOCK);
    }

}
