package blueduck.deepwaters.registry;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockProperties
{
	public static final Block.Properties ROCK = Block.Properties.create(Material.ROCK);
	public static final Block.Properties OCEAN_FLOOR = Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6F).sound(
			SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE);
	public static final Block.Properties PEARL_BLOCK = Block.Properties.create(Material.IRON).hardnessAndResistance(1F, 0F).sound(
			SoundType.GLASS).harvestLevel(0).harvestTool(ToolType.PICKAXE);
	public static final Block.Properties SALT_BLOCK = Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 3.0F).sound(
			SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE);
	public static final Block.Properties PRISMARINE_BLOCK = Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 6.0F).sound(
			SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE);
	public static final Block.Properties METALLIC_BLOCK = Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).sound(
			SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE);
	public static final Block.Properties UNBREAKABLE = Block.Properties.create(Material.ROCK).hardnessAndResistance(-1, -1).sound(
			SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE);
	public static final Block.Properties DEAD_CORAL = Block.Properties.create(Material.ROCK).hardnessAndResistance( 1.5F, 6F).sound(
			SoundType.STONE).harvestLevel(0).harvestTool(ToolType.PICKAXE);
	public static final Block.Properties CORAL = Block.Properties.create(Material.CORAL).hardnessAndResistance(2F, 6F).sound(SoundType.CORAL);
	public static final Block.Properties CRYSTALINE_CORAL = Block.Properties.create(Material.CORAL).hardnessAndResistance(12F, 24F).sound(SoundType.CORAL);
	public static final Block.Properties IRON_HATCH = Block.Properties.create(Material.IRON).hardnessAndResistance(3.5F, 12.0F).sound(
			SoundType.METAL).harvestLevel(0).harvestTool(ToolType.PICKAXE);
	public static final Block.Properties SCRAP = Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 3.0F).sound(
			SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE);
	public static final Block.Properties LIMESTONE = Block.Properties.create(Material.ROCK).hardnessAndResistance(3F, 6.0F).sound(
			SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE);
	public static final Block.Properties FORGE_STONE = Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE);
	public static final Block.Properties MACHINE = Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 4.0F).harvestLevel(2).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE);

}
