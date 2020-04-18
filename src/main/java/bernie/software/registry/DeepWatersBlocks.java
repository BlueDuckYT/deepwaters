package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.block.*;
import bernie.software.block.aquastone.DeepWatersAquastoneBlock;
import bernie.software.block.aquastone.DeepWatersDiodeComparator;
import bernie.software.block.aquastone.DeepWatersDiodeRepeater;
import bernie.software.block.aquastone.DeepWatersRedstoneDust;
import bernie.software.datagen.DeepWatersBlockStates;
import bernie.software.datagen.DeepWatersItemModels;
import bernie.software.datagen.DeepWatersLootTables;
import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
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
	public static final RegistryObject<Block> SALT_BLOCK = registerNormalBlock("salt_block", () -> new DeepWatersBlock(
			Material.ROCK, 2.0F, 3.0F, SoundType.STONE, 1, ToolType.PICKAXE), true);
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
	public static final RegistryObject<Block> OXYGENATOR = registerNormalBlock("oxygenator", () -> new DeepWatersBlock(
			Material.ROCK, 2.0F, 4.0F, SoundType.STONE, 2, ToolType.PICKAXE), true);
	public static final RegistryObject<Block> DEEPWATERSPORTAL = BLOCKS.register("portal", () -> new DeepWatersPortalBlock(
			Material.ROCK, 500.0F, 500.0F, SoundType.STONE));

	public static final RegistryObject<Block> DEAD_CORAL_BLOCK_ORANGE = registerNormalBlock("dead_coral_block_orange", () -> new DeepWatersBlock(
			Material.ROCK, 1.5F, 6F, SoundType.STONE, 0, ToolType.PICKAXE), true);
	public static final RegistryObject<Block> DEAD_CORAL_BLOCK_GREEN = registerNormalBlock("dead_coral_block_green", () -> new DeepWatersBlock(
			Material.ROCK, 1.5F, 6F, SoundType.STONE, 0, ToolType.PICKAXE), true);

	public static final RegistryObject<Block> CORAL_BLOCK_ORANGE = registerNormalBlock("coral_block_orange", () -> new DeepWatersCoralBlock(
			DEAD_CORAL_BLOCK_ORANGE.get(), Block.Properties.create(Material.CORAL).hardnessAndResistance(2F,6F).sound(SoundType.CORAL)), true);
	public static final RegistryObject<Block> CORAL_BLOCK_GREEN = registerNormalBlock("coral_block_green", () -> new DeepWatersCoralBlock(
			DEAD_CORAL_BLOCK_GREEN.get(), Block.Properties.create(Material.CORAL).hardnessAndResistance(2F, 6F).sound(SoundType.CORAL)), true);

	public static final RegistryObject<Block> SUNKEN_WASTES_LAMP = registerBlock("sunkenwastes_lamp", () -> new DeepWatersLamp());
	public static final RegistryObject<Block> AQUA_STONE = registerBlock("aquastone", () -> new DeepWatersRedstoneDust(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> AQUA_COMPARE = registerBlock("aquastone_comparator", () -> new DeepWatersDiodeComparator(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> AQUA_REPEAT = registerBlock("aquastone_repeater", () -> new DeepWatersDiodeRepeater(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Block> AQUA_BLOCK = registerBlock("aquastone_block", () -> new DeepWatersAquastoneBlock(Block.Properties.create(Material.ROCK)));
//	public static final RegistryObject<Block> AQUA_TORCH = registerBlock("aquastone_torch", () -> new DeepWatersRedstoneTorch.AquastoneTorch());
//	public static final RegistryObject<Block> AQUA_TORCH_WALL = registerBlock("aquastone_walltorch", () -> new DeepWatersRedstoneTorch.AquastoneTorchWall());
	public static final RegistryObject<Block> PEDESTAL = registerBlock("pedestal", () -> new Pedestal());
	public static final RegistryObject<RotatedPillarBlock> PORTAL_PILLAR = registerBlock("portal_pillar", () -> new PortalPillarBlock());
	public static final RegistryObject<DeepWatersPortalPillarEnd> PORTAL_PILLAR_END = registerBlock("portal_pillar_end", () -> new DeepWatersPortalPillarEnd(0));
	public static final RegistryObject<RotatedPillarBlock> ACTIVATED_PORTAL_PILLAR = registerBlock("activated_portal_pillar", () -> new PortalPillarBlock(15));
	public static final RegistryObject<DeepWatersPortalPillarEnd> ACTIVATED_PORTAL_PILLAR_END = registerBlock("activated_portal_pillar_end", () -> new DeepWatersPortalPillarEnd(15));

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
