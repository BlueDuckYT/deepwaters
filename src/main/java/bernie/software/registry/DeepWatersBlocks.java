package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.block.*;
import bernie.software.block.aquastone.*;
import bernie.software.block.blockbase.*;
import bernie.software.client.renderer.tileentity.renderer.AquafanItemStackRenderer;
import bernie.software.client.renderer.tileentity.renderer.AquafanRenderer;
import bernie.software.datagen.DeepWatersBlockStates;
import bernie.software.datagen.DeepWatersItemModels;
import bernie.software.datagen.DeepWatersLootTables;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class DeepWatersBlocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, DeepWatersMod.ModID);

    //Ocean floor
    public static final RegistryObject<Block> MOSSY_OCEAN_FLOOR = registerNormalBlock("mossy_ocean_floor", () -> new MossyOceanFloorBlock(), false);
    public static final RegistryObject<Block> OCEAN_FLOOR = registerNormalBlock("ocean_floor", () -> new Block(BlockProperties.OCEAN_FLOOR), true);
    public static final RegistryObject<RotatedPillarBlock> OCEAN_FLOOR_BRICK = registerBlockAndItem("ocean_floor_brick", () -> new RotatedPillarBlock(BlockProperties.PRISMARINE_BLOCK));

    //Ores
    public static final RegistryObject<Block> SALT_ORE = registerNormalBlock("salt_ore", () -> new DeepWatersOreBlock(1), false);
    public static final RegistryObject<Block> PRISMARINE_CRYSTAL_ORE = registerNormalBlock("prismarine_crystal_ore", () -> new DeepWatersOreBlock(2), true);
    public static final RegistryObject<Block> AQUALITE_ORE = registerNormalBlock("aqualite_ore", () -> new DeepWatersOreBlock(2), true);
    public static final RegistryObject<Block> AQUASTONE_ORE = registerNormalBlock("aquastone_ore", () -> new DeepWatersOreBlock(1), false);

    public static final RegistryObject<Block> ENTITYPUSHER = registerOnlyBlock("entity_pusher", () -> new EntityPusher());

    //Metallic Blocks
    public static final RegistryObject<Block> METALLIC_BLOCK_YELLOW = registerNormalBlock("metallic_block_yellow", () -> new Block(BlockProperties.METALLIC_BLOCK), true);
    public static final RegistryObject<Block> METALLIC_BLOCK_CYAN = registerNormalBlock("metallic_block_cyan", () -> new Block(BlockProperties.METALLIC_BLOCK), true);
    public static final RegistryObject<Block> METALLIC_BLOCK_ORANGE = registerNormalBlock("metallic_block_orange", () -> new Block(BlockProperties.METALLIC_BLOCK), true);
    public static final RegistryObject<Block> METALLIC_BLOCK_WHITE = registerNormalBlock("metallic_block_white", () -> new Block(BlockProperties.METALLIC_BLOCK), true);
    public static final RegistryObject<Block> METALLIC_BLOCK_RED = registerNormalBlock("metallic_block_red", () -> new Block(BlockProperties.METALLIC_BLOCK), true);
    public static final RegistryObject<Block> METALLIC_BLOCK_BLUE = registerNormalBlock("metallic_block_blue", () -> new Block(BlockProperties.METALLIC_BLOCK), true);

    //Portal
    public static final RegistryObject<Block> DEEPWATERSPORTAL = registerOnlyBlock("portal", () -> new DeepWatersPortalBlock(BlockProperties.UNBREAKABLE));
    public static final RegistryObject<PedestalBlock> PEDESTAL = registerBlock("pedestal", () -> new PedestalBlock());
    public static final RegistryObject<RotatedPillarBlock> PORTAL_PILLAR = registerBlockAndItem("portal_pillar", () -> new RotatedPillarBlock(BlockProperties.UNBREAKABLE));
    public static final RegistryObject<RotatedPillarBlock> PORTAL_PILLAR_END = registerBlockAndItem("portal_pillar_end", () -> new RotatedPillarBlock(BlockProperties.UNBREAKABLE));
    public static final RegistryObject<RotatedPillarBlock> ACTIVATED_PORTAL_PILLAR = registerBlockAndItem("activated_portal_pillar", () -> new RotatedPillarBlock(BlockProperties.UNBREAKABLE.lightValue(15)));
    public static final RegistryObject<RotatedPillarBlock> ACTIVATED_PORTAL_PILLAR_END = registerBlockAndItem("activated_portal_pillar_end", () -> new RotatedPillarBlock(BlockProperties.UNBREAKABLE.lightValue(15)));

    //Dead Coral
    public static final RegistryObject<Block> DEAD_CORAL_BLOCK_ORANGE = registerNormalBlock("dead_coral_block_orange", () -> new Block(BlockProperties.DEAD_CORAL), true);
    public static final RegistryObject<Block> DEAD_CORAL_BLOCK_GREEN = registerNormalBlock("dead_coral_block_green", () -> new Block(BlockProperties.DEAD_CORAL), true);
    public static final RegistryObject<Block> DEAD_CRYSTALINE_CORAL = registerNormalBlock("decayed_coral_block_crystal", () -> new Block(BlockProperties.DEAD_CORAL), false);

    //Coral
    public static final RegistryObject<Block> CORAL_BLOCK_ORANGE = registerNormalBlock("coral_block_orange", () -> new DeepWatersCoralBlock(DEAD_CORAL_BLOCK_ORANGE.get(), BlockProperties.CORAL), true);
    public static final RegistryObject<Block> CRYSTALINE_CORAL = registerNormalBlock("coral_block_crystal", () -> new DeepWatersCoralBlock(DEAD_CRYSTALINE_CORAL.get(), BlockProperties.CRYSTALINE_CORAL), false);
    public static final RegistryObject<Block> CORAL_BLOCK_GREEN = registerNormalBlock("coral_block_green", () -> new DeepWatersCoralBlock(DEAD_CORAL_BLOCK_GREEN.get(), BlockProperties.CORAL), true);

    //Aquastone
    public static final RegistryObject<Block> AQUA_STONE = registerBlock("aquastone", () -> new AquastoneDust(BlockProperties.ROCK.doesNotBlockMovement()));
    public static final RegistryObject<Block> AQUA_COMPARATOR = registerBlock("aquastone_comparator", () -> new AquastoneComparator(BlockProperties.ROCK));
    public static final RegistryObject<Block> AQUA_REPEATER = registerBlock("aquastone_repeater", () -> new AquastoneRepeater(BlockProperties.ROCK));
    public static final RegistryObject<Block> AQUA_FAN = registerBlock("aquastone_fan", () -> new AquastoneFan(Block.Properties.create(Material.ROCK)),()->AquafanItemStackRenderer::new);
    public static final RegistryObject<Block> AQUA_BLOCK = registerBlock("aquastone_block", () -> new AquastoneBlock(BlockProperties.ROCK));
    public static final RegistryObject<Block> AQUA_TORCH = registerOnlyBlock("aquastone_torch", () -> new AquastoneTorch.AquastoneTorchBlock());
    public static final RegistryObject<Block> AQUA_TORCH_WALL = registerOnlyBlock("aquastone_walltorch", () -> new AquastoneTorch.AquastoneTorchWall());
    public static final RegistryObject<Block> AQUA_STONE_BUTTON = registerBlock("aquastone_stone_button", () -> AquastoneButton.constructBlock((AbstractButtonBlock) Blocks.STONE_BUTTON));

    //Iron Hatch
    public static final RegistryObject<DeepWatersTrapdoor> IRON_HATCH = registerBlock("iron_hatch", () -> new DeepWatersTrapdoor(BlockProperties.IRON_HATCH.notSolid()));
    public static final RegistryObject<DoorBlock> IRON_HATCH_DOOR = registerBlock("iron_hatch_door", () -> new DeepWatersDoor(BlockProperties.IRON_HATCH.notSolid()));

    //Scrap
    public static final RegistryObject<Block> SCRAP_LADDER = registerBlock("scrap_ladder", () -> new DeepWatersLadder(BlockProperties.SCRAP));
    public static final RegistryObject<Block> SCRAP_LANTERN = registerBlock("scrap_lantern", () -> new DeepWatersLantern(BlockProperties.SCRAP.harvestTool(ToolType.PICKAXE).lightValue(8)));

    //Deadwood
    public static final RegistryObject<LogBlock> DEADWOOD_LOG = registerBlock("deadwood_log", () -> new DeepWatersLogBlock(MaterialColor.WHITE_TERRACOTTA));
    public static final RegistryObject<Block> DEADWOOD_PLANKS = registerNormalBlock("deadwood_planks", () -> new Block(BlockProperties.SCRAP), true);
    public static final RegistryObject<DeepWatersTrapdoor> DEADWOOD_TRAPDOOR = registerBlock("deadwood_trapdoor", () -> new DeepWatersTrapdoor(BlockProperties.SCRAP));
    public static final RegistryObject<DoorBlock> DEADWOOD_DOOR = registerBlock("deadwood_door", () -> new DeepWatersDoor(BlockProperties.SCRAP));

    //Prismarine
    public static final RegistryObject<RotatedPillarBlock> PRISMARINE_PILLAR = registerBlockAndItem("prismarine_pillar", () -> new RotatedPillarBlock(BlockProperties.PRISMARINE_BLOCK));
    public static final RegistryObject<RotatedPillarBlock> CHISELED_PRISMARINE = registerBlockAndItem("prismarine_chiseled", () -> new RotatedPillarBlock(BlockProperties.PRISMARINE_BLOCK));
    public static final RegistryObject<Block> PRISMARINE_BLOCK = registerNormalBlock("prismarine_block", () -> new Block(BlockProperties.PRISMARINE_BLOCK), true);

    //Dark Prismarine
    public static final RegistryObject<RotatedPillarBlock> DARK_PRISMARINE_PILLAR = registerBlockAndItem("dark_prismarine_pillar", () -> new RotatedPillarBlock(BlockProperties.PRISMARINE_BLOCK));
    public static final RegistryObject<RotatedPillarBlock> CHISELED_DARK_PRISMARINE = registerBlockAndItem("dark_prismarine_chiseled", () -> new RotatedPillarBlock(BlockProperties.PRISMARINE_BLOCK));

    //Limestone
    public static final RegistryObject<Block> LIMESTONE = registerNormalBlock("limestone", () -> new Block(BlockProperties.LIMESTONE), true);
    public static final RegistryObject<Block> LIMESTONE_BRICK = registerNormalBlock("limestone_brick", () -> new Block(BlockProperties.OCEAN_FLOOR), true);
    public static final RegistryObject<SlabBlock> LIMESTONE_SLAB = registerBlockAndItem("limestone_slab", () -> new SlabBlock(BlockProperties.OCEAN_FLOOR));
    public static final RegistryObject<Block> LIMESTONE_SMOOTH = registerNormalBlock("limestone_smooth", () -> new Block(BlockProperties.LIMESTONE), true);

    //Unbreakable
    public static final RegistryObject<Block> MAGMATIC_ROCK = registerNormalBlock("magmatic_rock", () -> new Block(BlockProperties.UNBREAKABLE), true);

    //Machines
    //public static final RegistryObject<Block> BUBBLE_MACHINE = registerNormalBlock("bubble_machine", () -> new BubbleMachineBlock(Material.IRON, 4F, 20.0F, SoundType.METAL, 0, ToolType.PICKAXE), true);
    public static final RegistryObject<Block> OXYGENATOR = registerNormalBlock("oxygenator", () -> new DeepWatersHorizontalRotationalBlock(BlockProperties.MACHINE), true);

    // Forge Stones
    public static final RegistryObject<Block> BLUE_FORGE_STONE = registerBlock("blue_forge_stone", () -> new ForgeStoneBlock(BlockProperties.FORGE_STONE));
    public static final RegistryObject<Block> ORANGE_FORGE_STONE = registerBlock("orange_forge_stone", () -> new ForgeStoneBlock(BlockProperties.FORGE_STONE));
    public static final RegistryObject<Block> GREEN_FORGE_STONE = registerBlock("green_forge_stone", () -> new ForgeStoneBlock(BlockProperties.FORGE_STONE));
    public static final RegistryObject<Block> PURPLE_FORGE_STONE = registerBlock("purple_forge_stone", () -> new ForgeStoneBlock(BlockProperties.FORGE_STONE));
    public static final RegistryObject<Block> RED_FORGE_STONE = registerBlock("red_forge_stone", () -> new ForgeStoneBlock(BlockProperties.FORGE_STONE));
    public static final RegistryObject<Block> YELLOW_FORGE_STONE = registerBlock("yellow_forge_stone", () -> new ForgeStoneBlock(BlockProperties.FORGE_STONE));

    //Misc
    public static final RegistryObject<Block> PEARL_BLOCK = registerNormalBlock("pearl_block", () -> new Block(BlockProperties.PEARL_BLOCK), true);
    public static final RegistryObject<Block> SALT_BLOCK = registerNormalBlock("salt_block", () -> new Block(BlockProperties.SALT_BLOCK), true);
    public static final RegistryObject<Block> SUNKEN_WASTES_LAMP = registerBlock("sunkenwastes_lamp", () -> new DeepWatersLamp());
    public static final RegistryObject<Block> SUNKEN_GRAVEL = registerNormalBlock("sunken_gravel", () -> new SunkenGravelBlock(), true);






    private static <T extends Block> RegistryObject<T> baseRegister(String name, Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> register = BLOCKS.register(name, block);
        DeepWatersItems.ITEMS.register(name, item.apply(register));
        return register;
    }

    private static <T extends Block> RegistryObject<T> baseRegister(String name, Supplier<? extends T> block) {
        RegistryObject<T> register = BLOCKS.register(name, block);
        return register;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<? extends Block> block) {
        return (RegistryObject<T>) baseRegister(name, block, DeepWatersBlocks::registerBlockItem);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<? extends Block> block, Supplier<Callable<ItemStackTileEntityRenderer>> isterDoubleSupplier) {
        RegistryObject<Block> registryObject=baseRegister(name,block);
        DeepWatersItems.ITEMS.register(name,DeepWatersBlocks.registerBlockItem(registryObject,isterDoubleSupplier));
        return (RegistryObject<T>) registryObject;
    }

    private static <T extends Block> RegistryObject<T> registerBlockAndItem(String name, Supplier<? extends Block> block) {
        RegistryObject<T> registryObject = (RegistryObject<T>) baseRegister(name, block,
                DeepWatersBlocks::registerBlockItem);
        DeepWatersItemModels.NormalItemBlocks.add((RegistryObject<Block>) registryObject);
        DeepWatersLootTables.NormalItemDropBlocks.add((RegistryObject<Block>) registryObject);

        return registryObject;
    }

    private static <T extends Block> RegistryObject<T> registerBlockAndItemNoDrops(String name, Supplier<? extends Block> block) {
        RegistryObject<T> registryObject = (RegistryObject<T>) baseRegister(name, block,
                DeepWatersBlocks::registerBlockItem);
        DeepWatersItemModels.NormalItemBlocks.add((RegistryObject<Block>) registryObject);
        return registryObject;
    }

    private static <T extends Block> RegistryObject<T> registerOnlyBlock(String name, Supplier<? extends Block> block) {
        return (RegistryObject<T>) baseRegister(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerNormalBlock(String name, Supplier<? extends Block> block, boolean dropsItself) {

        RegistryObject<T> registryObject = (RegistryObject<T>) baseRegister(name, block,
                DeepWatersBlocks::registerBlockItem);
        DeepWatersItemModels.NormalItemBlocks.add((RegistryObject<Block>) registryObject);
        if (dropsItself) {
            DeepWatersBlockStates.NormalBlocks.add((RegistryObject<Block>) registryObject);
            DeepWatersLootTables.NormalItemDropBlocks.add((RegistryObject<Block>) registryObject);
        }
        return registryObject;
    }

    private static <T extends Block> Supplier<BlockItem> registerBlockItem(final RegistryObject<T> block) {
        return () -> new BlockItem(Objects.requireNonNull(block.get()),
                new Item.Properties().group(DeepWatersItemGroups.DEEPWATERS_BLOCKS));
    }

    private static <T extends Block> Supplier<BlockItem> registerBlockItem(final RegistryObject<T> block,Supplier<Callable<ItemStackTileEntityRenderer>> isterDoubleSupplier) {
        return () -> new BlockItem(Objects.requireNonNull(block.get()),
                new Item.Properties().group(DeepWatersItemGroups.DEEPWATERS_BLOCKS).setISTER(isterDoubleSupplier));
    }
}
