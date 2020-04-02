package bernie.software.datagen.provider;

import bernie.software.DeepWatersMod;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;

import java.util.function.Supplier;

public abstract class DeepWatersItemModelProvider extends ItemModelProvider {

    public DeepWatersItemModelProvider(DataGenerator dataGenerator, ExistingFileHelper fileHelper) {
        super(dataGenerator, DeepWatersMod.ModID, fileHelper);
    }

    public String blockName(Supplier<? extends Block> block) {
        return block.get().getRegistryName().getPath();
    }

    public ItemModelBuilder itemBlock(Supplier<? extends Block> block) {
        return itemBlock(block, blockName(block));
    }

    public ItemModelBuilder itemBlock(Supplier<? extends Block> block, String model) {
        return withExistingParent(blockName(block), modLoc("block/" + model));
    }

    public ItemModelBuilder itemBlockFlat(Supplier<? extends Block> block) {
        return withExistingParent(blockName(block), mcLoc("item/generated"))
                .texture("layer0", modLoc("block/" + blockName(block)));
    }

    public ItemModelBuilder normalItem(Supplier<? extends Item> item) {
        return withExistingParent(item.get().getRegistryName().getPath(), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + item.get().getRegistryName().getPath()));
    }

    public ItemModelBuilder toolItem(Supplier<? extends Item> item) {
        return withExistingParent(item.get().getRegistryName().getPath(), mcLoc("item/handheld"))
                .texture("layer0", modLoc("item/" + item.get().getRegistryName().getPath()));
    }


}
