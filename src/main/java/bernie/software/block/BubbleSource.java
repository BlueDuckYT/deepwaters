package bernie.software.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class BubbleSource extends Block {
	public BubbleSource(Properties properties) {
		super(properties);
	}
	
	public boolean isSource(Direction side, IWorldReader world, BlockPos pos, BlockState state) {
		return false;
	}
	
	public boolean shouldGetDeleted() {
		return true;
	}
	
	public BlockState getBubbleState(BlockState state) {
		return Blocks.AIR.getBlock().getDefaultState();
	}
	
	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		boolean hasSource=false;
		try {
			for (Direction dir:Direction.values()) {
				BlockState state1=worldIn.getBlockState(pos.offset(dir));
				if (state1.getBlock() instanceof BubbleSource) {
					if (((BubbleSource)state1.getBlock()).isSource(dir.getOpposite(),worldIn,pos,state1)) {
						hasSource=true;
					}
				}
				if (!fromPos.equals(pos.offset(dir))) {
					if (isSource(dir,worldIn,pos,state)) {
						if (worldIn.getBlockState(pos.offset(dir)).getFluidState().equals(getBubbleState(state).getFluidState())) {
							if (worldIn.getBlockState(pos.offset(dir)).equals(Blocks.WATER.getDefaultState())) {
								worldIn.setBlockState(pos.offset(dir),getBubbleState(state));
								worldIn.notifyNeighborsOfStateExcept(pos,getBubbleState(state).getBlock(),dir.getOpposite());
							}
						}
					}
				}
			}
			if (!hasSource) {
				if (shouldGetDeleted()) {
					worldIn.setBlockState(pos,Blocks.WATER.getDefaultState());
					worldIn.notifyNeighbors(pos,Blocks.WATER.getBlock());
				}
			}
		} catch (Exception err) {}
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return VoxelShapes.create(0,0,0,0,0,0);
	}
}
