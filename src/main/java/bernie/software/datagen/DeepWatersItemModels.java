package bernie.software.datagen;

import bernie.software.datagen.provider.DeepWatersItemModelProvider;
import bernie.software.registry.DeepWatersBlocks;
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
    }
}
