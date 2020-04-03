package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.block.DeepWatersBlock;
import bernie.software.block.DeepWatersOreBlock;
import bernie.software.block.MossyOceanFloorBlock;
import bernie.software.block.SunkenGravelBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class DeepWatersBlocks {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, DeepWatersMod.ModID);

    public static final RegistryObject<Block> MOSSY_OCEAN_FLOOR = registerBlock("mossy_ocean_floor", MossyOceanFloorBlock::new);
    public static final RegistryObject<Block> OCEAN_FLOOR = registerBlock("ocean_floor", () -> new DeepWatersBlock(
            Material.ROCK, 3.0F, 3.0F, SoundType.STONE, 1, ToolType.PICKAXE));
    public static final RegistryObject<Block> SALT_ORE = registerBlock("salt_ore", () -> new DeepWatersOreBlock(2));
    public static final RegistryObject<Block> SUNKEN_GRAVEL = registerBlock("sunken_gravel", SunkenGravelBlock::new);


    //this mess automatically creates and registers the BlockItems
    private static <T extends Block> RegistryObject<T> baseRegister(String name, Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> register = BLOCKS.register(name, block);
        DeepWatersItems.ITEMS.register(name, item.apply(register));
        return register;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<? extends Block> block) {
        return (RegistryObject<T>) baseRegister(name, block, DeepWatersBlocks::registerBlockItem);
    }

    private static <T extends Block> Supplier<BlockItem> registerBlockItem(final RegistryObject<T> block) {
        return () -> new BlockItem(Objects.requireNonNull(block.get()), new Item.Properties().group(DeepWatersItemGroups.DEEPWATERS_BLOCKS));
    }
}
