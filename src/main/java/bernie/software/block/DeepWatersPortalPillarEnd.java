package bernie.software.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class DeepWatersPortalPillarEnd extends DirectionalBlock
{
	public DeepWatersPortalPillarEnd(Properties builder)
	{
		super(builder);
	}

	public DeepWatersPortalPillarEnd(int light)
	{
		super(Properties.create(Material.ROCK)
				.hardnessAndResistance(-1F, -1F)
				.sound(SoundType.STONE)
				.harvestTool(ToolType.PICKAXE)
				.lightValue(light)
				.noDrops()
		);
	}

	public static final EnumProperty FACING = BlockStateProperties.FACING;

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context)
	{
		return super.getStateForPlacement(context).with(FACING, context.getFace());
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
	{
		builder.add(FACING);
	}
}
