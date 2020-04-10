package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.block.DeepWatersBlock;
import bernie.software.block.DeepWatersOreBlock;
import bernie.software.block.MossyOceanFloorBlock;
import bernie.software.block.SunkenGravelBlock;
import bernie.software.datagen.DeepWatersBlockStates;
import bernie.software.datagen.DeepWatersItemModels;
import bernie.software.datagen.DeepWatersLootTables;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class DeepWatersBlocks
{

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, DeepWatersMod.ModID);

	public static final RegistryObject<Block> MOSSY_OCEAN_FLOOR = registerNormalBlock("mossy_ocean_floor", () -> new MossyOceanFloorBlock(), false);
	public static final RegistryObject<Block> OCEAN_FLOOR = registerNormalBlock("ocean_floor", () -> new DeepWatersBlock(
			Material.ROCK, 1.5F, 6.0F, SoundType.STONE, 0, ToolType.PICKAXE), true);
	public static final RegistryObject<Block> SALT_ORE = registerNormalBlock("salt_ore", () -> new DeepWatersOreBlock(1), false);
	public static final RegistryObject<Block> PRISMARINE_CRYSTAL_ORE = registerNormalBlock("prismarine_crystal_ore", () -> new DeepWatersOreBlock(2), true);
	public static final RegistryObject<Block> AQUALITE_ORE = registerNormalBlock("aqualite_ore", () -> new DeepWatersOreBlock(2), true);
	public static final RegistryObject<Block> SUNKEN_GRAVEL = registerNormalBlock("sunken_gravel", () -> new SunkenGravelBlock(), true);
	public static final RegistryObject<Block> PEARL_BLOCK = registerNormalBlock("pearl_block", () -> new DeepWatersBlock(
			Material.IRON, 1.0F, 0F, SoundType.GLASS, 0, ToolType.PICKAXE), true);
	public static final RegistryObject<Block> PRISMARINE_BLOCK = registerNormalBlock("prismarine_block", () -> new DeepWatersBlock(
			Material.IRON, 5.0F, 6.0F, SoundType.METAL, 2, ToolType.PICKAXE), true);
	public static final RegistryObject<Block> METALLIC_BLOCK_YELLOW = registerNormalBlock("metallic_block_yellow", () -> new DeepWatersBlock(
			Material.ROCK, 3.0F, 3.0F, SoundType.STONE, 2, ToolType.PICKAXE), true);
	public static final RegistryObject<Block> METALLIC_BLOCK_CYAN = registerNormalBlock("metallic_block_cyan", () -> new DeepWatersBlock(
			Material.ROCK, 3.0F, 3.0F, SoundType.STONE, 2, ToolType.PICKAXE), true);
	public static final RegistryObject<Block> METALLIC_BLOCK_ORANGE = registerNormalBlock("metallic_block_orange", () -> new DeepWatersBlock(
			Material.ROCK, 3.0F, 3.0F, SoundType.STONE, 2, ToolType.PICKAXE), true);
	public static final RegistryObject<Block> METALLIC_BLOCK_WHITE = registerNormalBlock("metallic_block_white", () -> new DeepWatersBlock(
			Material.ROCK, 3.0F, 3.0F, SoundType.STONE, 2, ToolType.PICKAXE), true);
	public static final RegistryObject<Block> METALLIC_BLOCK_RED = registerNormalBlock("metallic_block_red", () -> new DeepWatersBlock(
			Material.ROCK, 3.0F, 3.0F, SoundType.STONE, 2, ToolType.PICKAXE), true);
	public static final RegistryObject<Block> METALLIC_BLOCK_BLUE = registerNormalBlock("metallic_block_blue", () -> new DeepWatersBlock(
			Material.ROCK, 3.0F, 3.0F, SoundType.STONE, 2, ToolType.PICKAXE), true);

	public static final RegistryObject<Block> CORAL_BLOCK_ORANGE = registerNormalBlock("coral_block_orange", () -> new DeepWatersBlock(
			Material.CORAL, 2.0F, 6.0F, SoundType.CORAL, 1, ToolType.PICKAXE), true);
	public static final RegistryObject<Block> CORAL_BLOCK_GREEN = registerNormalBlock("coral_block_green", () -> new DeepWatersBlock(
			Material.CORAL, 2.0F, 6.0F, SoundType.CORAL, 1, ToolType.PICKAXE), true);

	//public static final RegistryObject<Block> SALT_PILE = registerNormalBlock("salt_pile", () -> new DeepWatersBlock(
	//		Material.SAND, 2.0F, 3.0F, SoundType.SAND, 1, ToolType.SHOVEL), true);

	public static final RegistryObject<Block> LIMESTONE = registerNormalBlock("limestone", () -> new DeepWatersBlock(
			Material.ROCK, 3F, 6.0F, SoundType.STONE, 2, ToolType.PICKAXE), true);
	public static final RegistryObject<Block> MAGMATIC_ROCK = registerNormalBlock("magmatic_rock", () -> new DeepWatersBlock(
			Material.ROCK, -1F, -1F, SoundType.STONE, 8, ToolType.PICKAXE), true);


	private static <T extends Block> RegistryObject<T> baseRegister(String name, Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item)
	{
		RegistryObject<T> register = BLOCKS.register(name, block);
		DeepWatersItems.ITEMS.register(name, item.apply(register));
		return register;
	}

	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<? extends Block> block)
	{
		return (RegistryObject<T>) baseRegister(name, block, DeepWatersBlocks::registerBlockItem);
	}

	private static <T extends Block> RegistryObject<T> registerNormalBlock(String name, Supplier<? extends Block> block, boolean dropsItself)
	{

		RegistryObject<T> registryObject = (RegistryObject<T>) baseRegister(name, block,
				DeepWatersBlocks::registerBlockItem);
		DeepWatersItemModels.NormalItemBlocks.add((RegistryObject<Block>) registryObject);
		if (dropsItself) {
			DeepWatersBlockStates.NormalBlocks.add((RegistryObject<Block>) registryObject);
			DeepWatersLootTables.NormalItemDropBlocks.add((RegistryObject<Block>) registryObject);

		}
		return registryObject;
	}

	private static <T extends Block> Supplier<BlockItem> registerBlockItem(final RegistryObject<T> block)
	{
		return () -> new BlockItem(Objects.requireNonNull(block.get()),
				new Item.Properties().group(DeepWatersItemGroups.DEEPWATERS_BLOCKS));
	}
}
