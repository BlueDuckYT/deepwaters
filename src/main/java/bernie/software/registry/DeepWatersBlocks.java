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

    public static final RegistryObject<Block> MOSSY_OCEAN_FLOOR = registerBlock("mossy_ocean_floor", () -> new MossyOceanFloorBlock());
    public static final RegistryObject<Block> OCEAN_FLOOR = registerBlock("ocean_floor", () -> new DeepWatersBlock(
            Material.ROCK, 3.0F, 40.0F, SoundType.STONE, 1, ToolType.PICKAXE));
    public static final RegistryObject<Block> SALT_ORE = registerBlock("salt_ore", () -> new DeepWatersOreBlock(1));
    public static final RegistryObject<Block> PRISMARINE_CRYSTAL_ORE = registerBlock("prismarine_crystal_ore", () -> new DeepWatersOreBlock(2));
    public static final RegistryObject<Block> SUNKEN_GRAVEL = registerBlock("sunken_gravel",() -> new SunkenGravelBlock());
    public static final RegistryObject<Block> PEARL_BLOCK = registerBlock("pearl_block", () -> new DeepWatersBlock(
            Material.GLASS, 1.0F, 0F, SoundType.GLASS, 0, ToolType.PICKAXE));

    public static final RegistryObject<Block> METALLIC_BLOCK_BLACK = registerBlock("metallic_block_black", () -> new DeepWatersBlock(
            Material.ROCK, 3.0F, 3.0F, SoundType.STONE, 2, ToolType.PICKAXE));
    public static final RegistryObject<Block> METALLIC_BLOCK_CYAN = registerBlock("metallic_block_cyan", () -> new DeepWatersBlock(
            Material.ROCK, 3.0F, 3.0F, SoundType.STONE, 2, ToolType.PICKAXE));
    public static final RegistryObject<Block> METALLIC_BLOCK_BLUE = registerBlock("metallic_block_blue", () -> new DeepWatersBlock(
            Material.ROCK, 3.0F, 3.0F, SoundType.STONE, 2, ToolType.PICKAXE));
    public static final RegistryObject<Block> METALLIC_BLOCK_ORANGE = registerBlock("metallic_block_orange", () -> new DeepWatersBlock(
            Material.ROCK, 3.0F, 3.0F, SoundType.STONE, 2, ToolType.PICKAXE));
    public static final RegistryObject<Block> LIMESTONE = registerBlock("limestone", () -> new DeepWatersBlock(
            Material.ROCK, 3.0F, 3.0F, SoundType.STONE, 2, ToolType.PICKAXE));
    public static final RegistryObject<Block> ORANGE_CORAL = registerBlock("orange_coral_block", () -> new DeepWatersBlock(
            Material.ROCK, 3.0F, 3.0F, SoundType.STONE, 1, ToolType.PICKAXE));
    public static final RegistryObject<Block> RED_CORAL = registerBlock("red_coral_block", () -> new DeepWatersBlock(
            Material.ROCK, 3.0F, 3.0F, SoundType.STONE, 1, ToolType.PICKAXE));
    public static final RegistryObject<Block> YELLOW_CORAL = registerBlock("yellow_coral_block", () -> new DeepWatersBlock(
            Material.ROCK, 3.0F, 3.0F, SoundType.STONE, 1, ToolType.PICKAXE));
    public static final RegistryObject<Block> MAGMATIC_ROCK = registerBlock("magmatic_rock", () -> new DeepWatersBlock(
            Material.ROCK, -1F, -1F, SoundType.STONE, 8, ToolType.PICKAXE));



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
