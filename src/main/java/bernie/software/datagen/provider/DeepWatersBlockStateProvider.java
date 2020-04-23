package bernie.software.datagen.provider;

import bernie.software.DeepWatersMod;
import net.minecraft.block.Block;
import net.minecraft.block.LogBlock;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.generators.*;

import java.util.function.Supplier;

public abstract class DeepWatersBlockStateProvider extends BlockStateProvider {

    private static DeepWatersBlockModelProvider provider;

    public DeepWatersBlockStateProvider(DataGenerator dataGenerator, ExistingFileHelper fileHelper) {
        super(dataGenerator, DeepWatersMod.ModID, fileHelper);

        provider = new DeepWatersBlockModelProvider(generator, fileHelper) {
            @Override
            public String getName() {
                return DeepWatersBlockStateProvider.this.getName();
            }

            @Override
            protected void registerModels() {

            }
        };
    }

    public DeepWatersBlockModelProvider models() {
        return provider;
    }

    protected ResourceLocation textureLoc(String name) {
        return modLoc("block/" + name);
    }

    protected String blockName(Supplier<? extends Block> block) {
        return block.get().getRegistryName().getPath();
    }

    public void normalBlock(Supplier<? extends Block> block) {
        simpleBlock(block.get());
    }

    public void pillarBlock(Supplier<? extends RotatedPillarBlock> block, String name) {
        axisBlock(block.get(), textureLoc(name));
    }

    public void logBlock(Supplier<? extends LogBlock> block, String name) {
        axisBlock(block.get(), textureLoc(name));
    }

    public void rotational(Supplier<? extends Block> block, String name) {
        horizontalBlock(block.get(), new ModelBuilder.UncheckedModelFile(name));
    }

    public void rotationalWithVerticle(Supplier<? extends Block> block, String name) {
        directionalBlock(block.get(), new ModelBuilder.UncheckedModelFile(name));
    }

    public void redstone(Supplier<? extends Block> block, String name) {
        fourWayMultipart(getMultipartBuilder(block.get().getBlock()), new ModelBuilder.UncheckedModelFile(name));
    }

    public void grassBlock(Supplier<? extends Block> block, String bottom) {
        String baseName = blockName(block);
        ModelFile model = models().sideBottomTop(
                block.get(),
                textureLoc(baseName + "_side"),
                textureLoc(bottom),
                textureLoc(baseName + "_top"));
        grassBlock(block, model);
    }

    private void grassBlock(Supplier<? extends Block> block, ModelFile model) {
        getVariantBuilder(block.get()).forAllStates(state -> ConfiguredModel.allYRotations(model, 0, false));
    }

}
