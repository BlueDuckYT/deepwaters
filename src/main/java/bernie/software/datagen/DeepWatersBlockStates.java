package bernie.software.datagen;

import bernie.software.datagen.provider.DeepWatersBlockStateProvider;
import bernie.software.registry.DeepWatersBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

public class DeepWatersBlockStates extends DeepWatersBlockStateProvider {

    public DeepWatersBlockStates(DataGenerator dataGenerator, ExistingFileHelper fileHelper) {
        super(dataGenerator, fileHelper);
    }

    @Override
    public String getName() {
        return "Deepwaters Block States";
    }

    @Override
    protected void registerStatesAndModels() {
        grassBlock(DeepWatersBlocks.MOSSY_OCEAN_FLOOR, "ocean_floor");
        normalBlock(DeepWatersBlocks.OCEAN_FLOOR);
        normalBlock(DeepWatersBlocks.SUNKEN_GRAVEL);
        normalBlock(DeepWatersBlocks.SALT_ORE);
    }
}
