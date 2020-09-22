package blueduck.deepwaters.datagen.provider;

import blueduck.deepwaters.DeepWatersMod;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

public abstract class DeepWatersBlockModelProvider extends BlockModelProvider {

    public DeepWatersBlockModelProvider(DataGenerator dataGenerator, ExistingFileHelper fileHelper) {
        super(dataGenerator, DeepWatersMod.ModID, fileHelper);
    }

    public BlockModelBuilder sideBottomTop(Block block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
        return withExistingParent(block.getRegistryName().getPath(), modLoc("block/grass_block"))
                .texture("side", side)
                .texture("bottom", bottom)
                .texture("top", top);
    }

}
