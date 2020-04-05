package bernie.software.datagen;

import bernie.software.datagen.provider.DeepWatersItemModelProvider;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

public class DeepWatersItemModels extends DeepWatersItemModelProvider {

    public DeepWatersItemModels(DataGenerator dataGenerator, ExistingFileHelper fileHelper) {
        super(dataGenerator, fileHelper);
    }

    @Override
    public String getName() {
        return "Deepwaters Item Models";
    }

    @Override
    protected void registerModels() {
        itemBlock(DeepWatersBlocks.OCEAN_FLOOR);
        itemBlock(DeepWatersBlocks.SUNKEN_GRAVEL);
        itemBlock(DeepWatersBlocks.MOSSY_OCEAN_FLOOR);
        itemBlock(DeepWatersBlocks.SALT_ORE);
        itemBlock(DeepWatersBlocks.METALLIC_BLOCK_BLACK);
        itemBlock(DeepWatersBlocks.METALLIC_BLOCK_CYAN);
        itemBlock(DeepWatersBlocks.METALLIC_BLOCK_ORANGE);
        itemBlock(DeepWatersBlocks.LIMESTONE);
        itemBlock(DeepWatersBlocks.MAGMATIC_ROCK);
        itemBlock(DeepWatersBlocks.PRISMARINE_CRYSTAL_ORE);
        itemBlock(DeepWatersBlocks.PEARL_BLOCK);

        normalItem(DeepWatersItems.SALT_CRYSTAL);
        normalItem(DeepWatersItems.SHARK_TOOTH);
        normalItem(DeepWatersItems.PEAL_WAND);

        normalItem(DeepWatersItems.PEARL);
    }
}
