package bernie.software.block.aquastone;

import bernie.software.DeepWatersMod;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.minecraft.block.*;
import net.minecraft.block.material.PushReaction;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.RedstoneSide;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.*;
import net.minecraft.world.chunk.Chunk;
import org.apache.logging.log4j.Level;

import javax.annotation.Nullable;
import java.util.*;
import java.util.List;

import static bernie.software.block.blockbase.DeepWatersPortalPillarEnd.FACING;
import static net.minecraft.block.RedstoneDiodeBlock.POWERED;

public class AquastoneDust extends RedstoneWireBlock implements IWaterLoggable
{
	public AquastoneDust(Properties properties)
	{
		super(properties);
	}

	@Override
	public boolean canProvidePower(BlockState state)
	{
		return true;
	}

	private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private static final IntegerProperty LEVEL = BlockStateProperties.LEVEL_0_8;

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
	{
		builder.add(NORTH, EAST, SOUTH, WEST, POWER, WATERLOGGED, LEVEL);
	}

	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (facing == Direction.DOWN) {
			return stateIn;
		} else {
			return facing == Direction.UP ? stateIn.with(WEST, this.getSide(worldIn, currentPos, Direction.WEST)).with(EAST, this.getSide(worldIn, currentPos, Direction.EAST)).with(NORTH, this.getSide(worldIn, currentPos, Direction.NORTH)).with(SOUTH, this.getSide(worldIn, currentPos, Direction.SOUTH)) : stateIn.with(FACING_PROPERTY_MAP.get(facing), this.getSide(worldIn, currentPos, facing));
		}
	}

	@Override
	public BlockState getExtendedState(BlockState state, IBlockReader worldIn, BlockPos pos)
	{
		BlockState state1 = worldIn.getBlockState(pos);
		state1 = state1.with(NORTH, getSide(worldIn, pos, Direction.NORTH));
		state1 = state1.with(SOUTH, getSide(worldIn, pos, Direction.SOUTH));
		state1 = state1.with(EAST, getSide(worldIn, pos, Direction.EAST));
		state1 = state1.with(WEST, getSide(worldIn, pos, Direction.WEST));
		return state1;
	}

	public PushReaction getPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}

	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos)
	{
		return true;
	}

	protected static boolean canConnectTo(BlockState blockState, IBlockReader world, BlockPos pos, @Nullable Direction side)
	{
		Block block = blockState.getBlock();
		if (block instanceof RedstoneWireBlock)
		{
			return true;
		}
		else if (blockState.getBlock() == Blocks.REPEATER)
		{
			Direction direction = blockState.get(RepeaterBlock.HORIZONTAL_FACING);
			return direction == side || direction.getOpposite() == side;
		}
		else if (Blocks.OBSERVER == blockState.getBlock())
		{
			return side == blockState.get(ObserverBlock.FACING);
		}
		else
		{
			return blockState.canConnectRedstone(world, pos, side) && side != null;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context)
	{
		World wo=context.getWorld();
		BlockPos pos=context.getPos();
		int level=0;
		boolean logged=false;
		logged=Blocks.COBBLESTONE_STAIRS.getStateForPlacement(context).get(WATERLOGGED);
		for (Direction dir:Direction.values()) {
			if (wo.getBlockState(pos.offset(dir)).getMaterial().isLiquid()) {
				logged=true;
				level=0;
			}
			try {
				if (wo.getBlockState(pos.offset(dir)).get(WATERLOGGED)) {
					logged=true;
					if (wo.getBlockState(pos.offset(dir)).get(LEVEL)>=1) {
						level=wo.getBlockState(pos.offset(dir)).get(LEVEL)-1;
					}
					if (level<=0) {
						level=0;
						logged=false;
					}
				}
			} catch (Exception err) {}
		}
		return super.getStateForPlacement(context).with(WATERLOGGED, logged).with(LEVEL,level);
	}

	@Override
	public IFluidState getFluidState(BlockState state)
	{
		if (state.get(LEVEL)==0) {
			return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
		} else {
			try {
				return state.get(WATERLOGGED) ? Fluids.WATER.getFlowingFluidState(state.get(LEVEL),false) : super.getFluidState(state);
			} catch (Exception err) {
				return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
			}
		}
	}

	private RedstoneSide getSide(IBlockReader worldIn, BlockPos pos, Direction face)
	{
		BlockPos blockpos = pos.offset(face);
		BlockState blockstate = worldIn.getBlockState(blockpos);
		BlockPos blockpos1 = blockpos.up();
		BlockState blockstate1 = worldIn.getBlockState(blockpos1);

		if ((blockstate1.getBlock() instanceof RedstoneWireBlock))
		{
//			DeepWatersMod.logger.log(Level.INFO,blockstate1);
//			DeepWatersMod.logger.log(Level.INFO,RedstoneSide.UP);
//			DeepWatersMod.logger.log(Level.INFO,"h");
			if (!worldIn.getBlockState(pos.offset(Direction.UP)).isNormalCube(worldIn,pos.offset(Direction.UP))) {
				return RedstoneSide.UP;
			}
		} else if (canConnectTo(blockstate, worldIn, blockpos, face) ||
			canConnectTo(worldIn.getBlockState(blockpos.down()), worldIn, blockpos.down(), null) ||
			blockstate.getBlock() instanceof RedstoneWireBlock ||
			worldIn.getBlockState(blockpos.down()).getBlock() instanceof AquastoneDust ||
			worldIn.getBlockState(blockpos.down()).getBlock() instanceof RedstoneWireBlock)
		{
			return RedstoneSide.SIDE;
		}
		return RedstoneSide.NONE;
	}

	boolean canProvidePower = true;
	private final Set<BlockPos> blocksNeedingUpdate = Sets.newHashSet();

	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving)
	{
		BlockState state1 = worldIn.getBlockState(pos);
		state1 = state1.with(NORTH, getSide(worldIn, pos, Direction.NORTH));
		state1 = state1.with(SOUTH, getSide(worldIn, pos, Direction.SOUTH));
		state1 = state1.with(EAST, getSide(worldIn, pos, Direction.EAST));
		state1 = state1.with(WEST, getSide(worldIn, pos, Direction.WEST));
//		super.neighborChanged(state,worldIn,pos,blockIn,fromPos,isMoving);
		if (!worldIn.isRemote)
		{
			if (state.isValidPosition(worldIn, pos))
			{
//				BlockPos[] poses = new BlockPos[]{
//						new BlockPos(1, 0, 0),
//						new BlockPos(0, 0, 1),
//						new BlockPos(0, 0, -1),
//						new BlockPos(-1, 0, 0)
//				};
				BlockState newState = state;
				int oldPower = state.get(POWER);
//				for (BlockPos pos1 : poses)
//				{
//					if (!pos1.add(pos).equals(fromPos))
//					{
////						if (blockIn!=this) {
////						if (!isMoving) {
////							newState=forcePower(pos, pos1, worldIn, oldPower);
////						}
////						}
//						try {
//						} catch (Exception err) {}
//					}
//				}
				worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(POWER,getPowerForPos(worldIn,pos)));
				newState=worldIn.getBlockState(pos);
				int newPower = newState.get(POWER);
				if (newPower!=oldPower) {
//					try {
//						updateSurroundingRedstone(worldIn,pos,newState);
//					} catch (Exception err) {}
//					worldIn.setBlockState(pos,state1);
					updateDiagonalNeighbors(newState,worldIn,pos,0);
					try
					{
					for (Direction direction:Direction.values()) {
						worldIn.notifyNeighbors(pos.offset(direction), this);
					}
					}
					catch (Exception err)
					{
					}
				}
			}
			else
			{
				spawnDrops(state, worldIn, pos);
				worldIn.removeBlock(pos, false);
			}
		}
	}

	private BlockState updateSurroundingRedstone(World worldIn, BlockPos pos, BlockState state) {
		state = this.getState(worldIn, pos, state);
		List<BlockPos> list = Lists.newArrayList(this.blocksNeedingUpdate);
		this.blocksNeedingUpdate.clear();

		for(BlockPos blockpos : list) {
			worldIn.notifyNeighborsOfStateChange(blockpos, this);
		}

		return state;
	}

	@Override
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random random) {
		super.animateTick(state, worldIn, pos, random);
//		BlockState state1 = worldIn.getBlockState(pos);
//		worldIn.setBlockState(pos, state1
//				.with(NORTH, getSide(worldIn, pos, Direction.NORTH))
//				.with(SOUTH, getSide(worldIn, pos, Direction.SOUTH))
//				.with(EAST, getSide(worldIn, pos, Direction.EAST))
//				.with(WEST, getSide(worldIn, pos, Direction.WEST))
//		);
	}

	@Override
	public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side)
	{
		ArrayList<Direction> dirsPowered=new ArrayList<>();
		if (!blockState.get(NORTH).equals(RedstoneSide.NONE)) {
			dirsPowered.add(Direction.NORTH);
		}
		if (!blockState.get(SOUTH).equals(RedstoneSide.NONE)) {
			dirsPowered.add(Direction.SOUTH);
		}
		if (!blockState.get(EAST).equals(RedstoneSide.NONE)) {
			dirsPowered.add(Direction.EAST);
		}
		if (!blockState.get(WEST).equals(RedstoneSide.NONE)) {
			dirsPowered.add(Direction.WEST);
		}
		if (dirsPowered.contains(Direction.EAST)&&!(dirsPowered.size()>=2)) {
			dirsPowered.add(Direction.WEST);
		}
		if (dirsPowered.contains(Direction.WEST)&&!(dirsPowered.size()>=2)) {
			dirsPowered.add(Direction.EAST);
		}
		if (dirsPowered.contains(Direction.NORTH)&&!(dirsPowered.size()>=2)) {
			dirsPowered.add(Direction.SOUTH);
		}
		if (dirsPowered.contains(Direction.SOUTH)&&!(dirsPowered.size()>=2)) {
			dirsPowered.add(Direction.NORTH);
		}
		if (dirsPowered.isEmpty()) {
			dirsPowered.add(Direction.NORTH);
			dirsPowered.add(Direction.SOUTH);
			dirsPowered.add(Direction.EAST);
			dirsPowered.add(Direction.WEST);
		}
		boolean worksVertically=false;
		side=side.getOpposite();
		if (blockAccess.getBlockState(pos.offset(side)).getBlock() instanceof RedstoneDiodeBlock) {
			dirsPowered.add(Direction.DOWN);
			worksVertically = (!(side.equals(Direction.DOWN)||side.equals(Direction.UP)));
			if (worksVertically) {
				if (dirsPowered.contains(side)) {
					worksVertically=true;
				} else {
					worksVertically=false;
				}
			}
		} else {
			dirsPowered.add(Direction.DOWN);
			worksVertically = (!(side.equals(Direction.DOWN)||side.equals(Direction.UP)));
			if (worksVertically) {
				if (dirsPowered.contains(side)) {
					worksVertically=true;
				} else {
					worksVertically=false;
				}
			}
		}
		boolean canPower=false;
		if (dirsPowered.contains(side)) {
			canPower=true;
		} else if (blockState.get(WEST).equals(RedstoneSide.NONE)&&
			blockState.get(EAST).equals(RedstoneSide.NONE)&&
			blockState.get(SOUTH).equals(RedstoneSide.NONE)&&
			blockState.get(NORTH).equals(RedstoneSide.NONE)&&
			worksVertically) {
			canPower=true;
		}
		return canPower ? blockAccess.getBlockState(pos).get(POWER):0;
	}

	private boolean isPowerSourceAt(IBlockReader worldIn, BlockPos pos, Direction side) {
		BlockPos blockpos = pos.offset(side);
		BlockState blockstate = worldIn.getBlockState(blockpos);
		boolean flag = blockstate.isNormalCube(worldIn, blockpos);
		BlockPos blockpos1 = pos.up();
		boolean flag1 = worldIn.getBlockState(blockpos1).isNormalCube(worldIn, blockpos1);
		if (!flag1 && flag && canConnectTo(worldIn.getBlockState(blockpos.up()), worldIn, blockpos.up(), null)) {
			return true;
		} else if (canConnectTo(blockstate, worldIn, blockpos, side)) {
			return true;
		} else if (blockstate.getBlock() == Blocks.REPEATER && blockstate.get(POWERED) && blockstate.get(RedstoneDiodeBlock.HORIZONTAL_FACING) == side) {
			return true;
		} else {
			return !flag && canConnectTo(worldIn.getBlockState(blockpos.down()), worldIn, blockpos.down(), null);
		}
	}

	private int getAqualitePower(BlockPos pos, World world)
	{
//		int power=0;
//		Direction[] FACING_VALUES=new Direction[]{
//				Direction.NORTH,
//				Direction.SOUTH,
//				Direction.EAST,
//				Direction.WEST
//		};
//		for(Direction direction : FACING_VALUES) {
//			int power2=world.getBlockState(pos.offset(direction)).getWeakPower(world,pos,direction);
//			if (power<power2) {
//				power=power2;
//			}
//		}
		int power = 0;
		int i = 0;

		Direction[] FACING_VALUES=new Direction[]{
				Direction.NORTH,
				Direction.SOUTH,
				Direction.EAST,
				Direction.WEST,
				Direction.DOWN,
				Direction.UP
		};
		for(Direction direction : FACING_VALUES) {
			int j = world.getRedstonePower(pos.offset(direction), direction);
			boolean diodePower=diodePowered(world,pos.offset(direction),direction.getOpposite());
			boolean otherSource=false;
			if (!(world.getBlockState(pos.offset(direction)).getBlock() instanceof RedstoneWireBlock)&&
				!isPowerSourceAt(world,pos,direction)&&
				!diodePower) {
				j=0;
				otherSource=true;
			}
//			if (otherSource&&
//				!world.getBlockState(pos.offset(direction)).isOpaqueCube(world,pos.offset(direction))) {
//				j=0;
//			}
			if (j >= 15) {
				return 15;
			}

			if (j > i) {
				i = j;
			}
		}

		power= i;
//		int power = world.getRedstonePowerFromNeighbors(pos);
		if (power < world.getStrongPower(pos))
		{
			power = world.getStrongPower(pos);
		}
		int aquaPower = getAqualitePower(pos, (IBlockReader) world);
		if (power < aquaPower)
		{
			power = aquaPower;
		}
		return power;
	}

	public boolean diodePowered(World world, BlockPos pos,Direction facing) {
		for (Direction direction:Direction.values()) {
			if (!direction.equals(facing)) {
				BlockState state=world.getBlockState(pos.offset(direction));
				if (state.getBlock() instanceof RedstoneDiodeBlock&&
						state.get(POWERED)) {
					return true;
				}
				if (state.getBlock() instanceof ObserverBlock&&
					state.get(POWERED)&&
					state.get(FACING).equals(direction)) {
					return true;
				}
				if (state.getBlock() instanceof AbstractButtonBlock&&
					state.get(POWERED)) {
					return true;
				}
				if (state.getBlock() instanceof AbstractPressurePlateBlock&&
					state.get(POWERED)) {
					return true;
				}
			}
		}
		return world.getBlockState(pos.offset(Direction.DOWN)).getBlock() instanceof RedstoneTorchBlock ;
	}

	@Override
	public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side)
	{
//		return getWeakPower(blockState, blockAccess, pos, side);
//		if (blockAccess.getBlockState(pos.offset(side)).getBlock() instanceof RedstoneWireBlock) {
//			return 0;
//		}
		return getWeakPower(blockState,blockAccess,pos,side);
	}

	@Override
	public void updateDiagonalNeighbors(BlockState state, IWorld worldIn, BlockPos pos, int flags)
	{
		try {
			for(Direction direction : Direction.Plane.HORIZONTAL) {
				RedstoneSide redstoneside = state.get(FACING_PROPERTY_MAP.get(direction));
				if (true) {
					if (worldIn.getBlockState(pos.offset(direction).offset(Direction.UP)).getBlock() instanceof RedstoneWireBlock) {
						if (redstoneside==RedstoneSide.UP) {
							if (!worldIn.getBlockState(pos.up()).isNormalCube(worldIn,pos.offset(Direction.UP))) {
								worldIn.setBlockState(pos.offset(direction).offset(Direction.UP),getExtendedState(state,worldIn,pos.offset(direction).offset(Direction.UP)),0);
							}
						} else {
							if (!worldIn.getBlockState(pos.offset(Direction.UP)).isNormalCube(worldIn,pos.offset(Direction.UP))) {
								worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(FACING_PROPERTY_MAP.get(direction),RedstoneSide.UP),0);
							}
						}
					} else if (worldIn.getBlockState(pos.offset(direction).offset(Direction.UP)).getBlock() instanceof RedstoneWireBlock) {
						if (!worldIn.getBlockState(pos.up()).isNormalCube(worldIn,pos.up())) {
							worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(FACING_PROPERTY_MAP.get(direction),RedstoneSide.SIDE),0);
						} else {
							worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(FACING_PROPERTY_MAP.get(direction),RedstoneSide.NONE),0);
						}
					}
				}
			}
		} catch (Exception err) {}
		super.updateDiagonalNeighbors(state,worldIn,pos,flags);
	}

	@Override
	public boolean shouldCheckWeakPower(BlockState state, IWorldReader world, BlockPos pos, Direction side)
	{
		return false;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		VoxelShape shape=Block.makeCuboidShape(5,0D,5,11,0.25D,11);
		VoxelShape lineNorth=Block.makeCuboidShape(5,0D,0,11,0.25D,11);
		VoxelShape lineSouth=Block.makeCuboidShape(5,0D,5,11,0.25D,16);
		VoxelShape lineWest=Block.makeCuboidShape(0,0D,5,11,0.25D,11);
		VoxelShape lineEast=Block.makeCuboidShape(5,0D,5,16,0.25D,11);
		if (!state.get(NORTH).equals(RedstoneSide.NONE)) {
			shape=VoxelShapes.or(shape,lineNorth);
		}
		if (!state.get(WEST).equals(RedstoneSide.NONE)) {
			shape=VoxelShapes.or(shape,lineWest);
		}
		if (!state.get(EAST).equals(RedstoneSide.NONE)) {
			shape=VoxelShapes.or(shape,lineEast);
		}
		if (!state.get(SOUTH).equals(RedstoneSide.NONE)) {
			shape=VoxelShapes.or(shape,lineSouth);
		}
		return shape;
	}

	private int getAqualitePower(BlockPos pos, IBlockReader world)
	{
		int power = 0;
//		for (Direction dir:Direction.values()) {
//			int power2=world.getBlockState(pos.offset(dir)).getWeakPower(world,pos,dir);
//			if (power!=power2&&power2!=0) {
//				power=power2;
//			}
//		}
		BlockPos[] direct = new BlockPos[]{
				new BlockPos(1, 0, 0),
				new BlockPos(0, 0, 1),
				new BlockPos(0, 0, -1),
				new BlockPos(-1, 0, 0)
		};
		try {
			if (world.getBlockState(pos.offset(Direction.DOWN)).isOpaqueCube(world, pos.offset(Direction.DOWN)))
			{
				BlockPos[] indirect = new BlockPos[]{
						new BlockPos(1, -1, 0),
						new BlockPos(0, -1, 1),
						new BlockPos(0, -1, -1),
						new BlockPos(-1, -1, 0)
				};
				for (BlockPos pos1 : indirect)
				{
					if (world.getBlockState(pos.add(pos1)).getBlock() instanceof RedstoneWireBlock)
					{
						if (true||world.getBlockState(pos.add(pos1).offset(Direction.UP)).isOpaqueCube(world, pos.add(pos1).offset(Direction.UP)))
						{
							if (world.getBlockState(pos.add(pos1)).get(POWER) > power)
							{
								power = world.getBlockState(pos.add(pos1)).get(POWER);
							}
						}
					}
				}
			}
			for (BlockPos pos1 : direct)
			{
				if (world.getBlockState(pos.add(pos1)).getBlock() instanceof RedstoneWireBlock)
				{
					if (world.getBlockState(pos.add(pos1)).get(POWER) > power)
					{
						power = world.getBlockState(pos.add(pos1)).get(POWER);
					}
				} else {
					try
					{
						ArrayList<Direction> dirs=new ArrayList<>();
						dirs.add(Direction.WEST);
						dirs.add(Direction.EAST);
						dirs.add(Direction.NORTH);
						Direction dir=Direction.SOUTH;
						for (Direction dir2:dirs) {
							if (new BlockPos(0,0,0).offset(dir2).equals(pos1)) {
								dir=dir2;
							}
						}
						power=world.getBlockState(pos.add(pos1)).getWeakPower(world,pos.add(pos1),dir);
					} catch (Exception err) {}
				}
			}
			BlockPos[] indirect = new BlockPos[]{
					new BlockPos(1, 1, 0),
					new BlockPos(0, 1, 1),
					new BlockPos(0, 1, -1),
					new BlockPos(-1, 1, 0)
			};
			for (BlockPos pos1 : indirect)
			{
				if (world.getBlockState(pos.add(pos1.offset(Direction.DOWN))).isOpaqueCube(world, pos.add(pos1.offset(Direction.DOWN))))
				{
					if (world.getBlockState(pos.add(pos1)).getBlock() instanceof RedstoneWireBlock)
					{
						if (world.getBlockState(pos.add(pos1)).get(POWER) > power)
						{
							if (world.getBlockState(pos.add(pos1.offset(Direction.DOWN))).isSolid())
							{
								power = world.getBlockState(pos.add(pos1)).get(POWER);
							}
						}
					}
				}
			}
		} catch (Exception err) {}
		return power;
	}

	private void tryChangeBlock(BlockPos source, BlockPos offset, World world, int sourcePower)
	{
		if (world.getBlockState(source.add(offset)).getBlock() instanceof RedstoneWireBlock)
		{
			if (world.getBlockState(source.add(offset)).get(POWER) < world.getRedstonePowerFromNeighbors(source))
			{
				try
				{
					if (sourcePower > world.getBlockState(source.add(offset)).get(POWER))
					{
						world.setBlockState(source.add(offset), world.getBlockState(source.add(offset)).with(POWER, sourcePower - 2));
					}
					else
					{
						world.setBlockState(source.add(offset), world.getBlockState(source.add(offset)).with(POWER, 0));
					}
				}
				catch (Exception err)
				{
				}
			}
		}
	}

	public int getPowerForPos(World world,BlockPos source) {
		int subtractAmount = 1;
		if (!world.getBlockState(source).get(WATERLOGGED))
		{
			subtractAmount = 2;
		}
		int power = getAqualitePower(source, world) - subtractAmount;
//        DeepWatersMod.logger.log(Level.INFO,power+subtractAmount);
		if (power <= 0)
		{
			power = 0;
		}
		return power;
	}

	private BlockState forcePower(BlockPos source, BlockPos offset, World world, int oldPower)
	{
		int power=getPowerForPos(world,source);
		if (power > oldPower)
		{
			world.setBlockState(source, world.getBlockState(source).with(POWER, power));
//			turnOn(source,new ArrayList<>(),world);
//			try
//			{
//				tryChangeBlock(source, offset, world, power);
//				if (!world.getBlockState(source.offset(Direction.UP)).isOpaqueCube(world, source.offset(Direction.UP)))
//				{
//					try
//					{
//						tryChangeBlock(source, offset.offset(Direction.UP), world, power);
//					}
//					catch (Exception err)
//					{
//					}
//				}
//				if (world.getBlockState(source.offset(Direction.DOWN)).isOpaqueCube(world, source.offset(Direction.DOWN)))
//				{
//					try
//					{
//						tryChangeBlock(source, offset.offset(Direction.DOWN), world, power);
//					}
//					catch (Exception err)
//					{
//					}
//				}
//				try
//				{
//					world.setBlockState(source, world.getBlockState(source).with(POWER, power));
//				}
//				catch (Exception err)
//				{
//				}
//			}
//			catch (Exception err)
//			{
//			}
		}
		else
		{
			if (power != oldPower)
			{
				try
				{
					turnOff(source,new ArrayList<>(),world,0);
//					try
//					{
//						world.setBlockState(source, world.getBlockState(source).with(POWER, 0));
//					}
//					catch (Exception err)
//					{
//					}
//					try
//					{
//						world.setBlockState(source.add(offset), world.getBlockState(source.add(offset)).with(POWER, 0));
//					}
//					catch (Exception err)
//					{
//					}
//					try
//					{
//						world.setBlockState(source.add(offset.offset(Direction.UP)), world.getBlockState(source.add(offset.offset(Direction.UP))).with(POWER, 0));
//					}
//					catch (Exception err)
//					{
//					}
//					try
//					{
//						world.setBlockState(source.add(offset.offset(Direction.DOWN)), world.getBlockState(source.add(offset.offset(Direction.DOWN))).with(POWER, 0));
//					}
//					catch (Exception err)
//					{
//					}
				}
				catch (Exception err)
				{
				}
			}
		}
		return world.getBlockState(source);
	}

	public void turnOff(BlockPos source,ArrayList<BlockPos> done,World world,int index) {
		for (Direction dir:Direction.values()) {
			if (!done.contains(source.offset(dir))) {
				ArrayList<Direction> horizontal=new ArrayList<>();
				horizontal.add(Direction.NORTH);
				horizontal.add(Direction.SOUTH);
				horizontal.add(Direction.EAST);
				horizontal.add(Direction.WEST);
				BlockPos offset=new BlockPos(0,0,0).offset(dir);
//				if (dir.equals(Direction.UP)||
//					dir.equals(Direction.DOWN)) {
//					for (Direction dir2:directions) {
//						offset=new BlockPos(0,0,0).offset(dir).offset(dir2);
//						if (world.getBlockState(source.offset(dir)).getBlock() instanceof RedstoneWireBlock) {
//							try
//							{
//								if (!done.contains(source.add(offset))) {
//									done.add(source.add(offset));
//									world.setBlockState(source.add(offset), world.getBlockState(source.add(offset)).with(POWER, 0));
////									DeepWatersMod.logger.log(Level.INFO,"h"+dir);
////									turnOff(source.add(offset),done,world);
//								}
//							}
//							catch (Exception err)
//							{
//							}
//						} else {
//						}
//					}
//				}
				if (index<=1000) {
					if (world.getBlockState(source.offset(dir)).getBlock() instanceof RedstoneWireBlock) {
						index+=1;
						done.add(source.offset(dir));
						try
						{
							world.setBlockState(source.offset(dir), world.getBlockState(source.offset(dir)).with(POWER, 0));
						DeepWatersMod.logger.log(Level.INFO,"h"+index);
							if (horizontal.contains(dir)) {
								if (!done.contains(source.offset(dir).offset(Direction.UP))) {
									if (world.getBlockState(source.offset(dir).offset(Direction.UP)).getBlock() instanceof RedstoneWireBlock) {
										world.setBlockState(source.offset(dir).offset(Direction.UP), world.getBlockState(source.offset(dir).offset(Direction.UP)).with(POWER, 0));
										done.add(source.offset(dir).offset(Direction.UP));
										turnOff(source.offset(dir).offset(Direction.UP),done,world,index);
									}
								}
							}
							turnOff(source.offset(dir),done,world,index);
						}
						catch (Exception err)
						{
						}
					} else {
					}
				}
			}
		}
	}

	public void turnOn(BlockPos source,ArrayList<BlockPos> done,World world) {
		int power=getPowerForPos(world,source);
		for (Direction dir:Direction.values()) {
			if (!done.contains(source.offset(dir))) {
				if (world.getBlockState(source.offset(dir)).getBlock() instanceof RedstoneWireBlock) {
					done.add(source.offset(dir));
					try
					{
						Chunk chunk = world.getChunkAt(source.offset(dir));
						chunk.setBlockState(source.offset(dir),world.getBlockState(source.offset(dir)).with(POWER, power),true);
//						world.setBlockState(source.offset(dir), );
						turnOn(source.offset(dir),done,world);
					}
					catch (Exception err)
					{
					}
				}
			}
		}
	}

	private int maxSignal(int existingSignal, BlockState neighbor)
	{
		if (neighbor.getBlock() != this)
		{
			return existingSignal;
		}
		else
		{
			int i = neighbor.get(POWER);
			return Math.max(i, existingSignal);
		}
	}

	private BlockState getState(World world, BlockPos pos, BlockState state)
	{
		BlockState blockstate = state;
		int i = state.get(POWER);
//        this.canProvidePower = false;
		int highestNeighborPower = world.getRedstonePowerFromNeighbors(pos);
//        this.canProvidePower = true;
		int thisPower = 0;
		if (highestNeighborPower < 15)
		{
			for (Direction direction : Direction.Plane.HORIZONTAL)
			{
				BlockPos blockpos = pos.offset(direction);
				BlockState blockstate1 = world.getBlockState(blockpos);
				thisPower = maxSignal(thisPower, blockstate1);
				BlockPos blockpos1 = pos.up();
				if (blockstate1.isNormalCube(world, blockpos) && !world.getBlockState(blockpos1).isNormalCube(world, blockpos1))
				{
					thisPower = maxSignal(thisPower, world.getBlockState(blockpos.up()));
				}
				else if (!blockstate1.isNormalCube(world, blockpos))
				{
					thisPower = maxSignal(thisPower, world.getBlockState(blockpos.down()));
				}
			}
		}

		int setPower = thisPower - 1;
		if (highestNeighborPower > setPower)
		{
			setPower = highestNeighborPower - 1;
		}

		if (i != setPower)
		{
			state = state.with(POWER, setPower);
			if (world.getBlockState(pos) == blockstate)
			{
				world.setBlockState(pos, state, 16);
			}

			blocksNeedingUpdate.add(pos);

			for (Direction direction1 : Direction.values())
			{
				blocksNeedingUpdate.add(pos.offset(direction1));
			}
		}

		return state;
	}

	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type)
	{
		return true;
	}
}
