package bernie.software.block;

import bernie.software.DeepWatersMod;
import bernie.software.ModEventSubscriber;
import bernie.software.registry.DeepWatersBlocks;
import com.google.common.base.Predicates;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.pattern.BlockMaterialMatcher;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;

import static bernie.software.block.DeepWatersPortalPillarEnd.FACING;

public class Pedestal extends Block implements IWaterLoggable
{
	public Pedestal(Properties properties)
	{
		super(properties);
	}

	// empty = air or portal block
	// p = prismarine brick
	// b = dark prismarine
	// e = pillar end
	// i = pillar
	// d = pedastal
	// s = prismarine brick stairs


	private static BlockPattern portalShape;

	public Pedestal()
	{
		super(Properties.create(Material.ROCK)
				.hardnessAndResistance(-1f, -1f)
				.sound(SoundType.STONE)
				.harvestLevel(0)
		);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		VoxelShape shape = VoxelShapes.or(Block.makeCuboidShape(5.0D, 3.0D, 5.0D, 11.0D, 7.0D, 11.0D),
				Block.makeCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 3.0D, 10.0D));
		return shape;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		return getShape(state, worldIn, pos, context);
	}

	private static final EnumProperty ROTATION = BlockStateProperties.HORIZONTAL_FACING;
	private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static BooleanProperty HASHEART = BooleanProperty.create("hasheart");

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
	{
		builder.add(ROTATION, WATERLOGGED, HASHEART);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context)
	{
		return super.getStateForPlacement(context).with(ROTATION, context.getPlacementHorizontalFacing()).with(
				WATERLOGGED, false).with(HASHEART, false);
	}

	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
	                                BlockRayTraceResult hit)
	{
		if (worldIn.isRemote)
		{
			return false;
		}
		if (player.getHeldItem(handIn).getItem().equals(Items.HEART_OF_THE_SEA))
		{
			if (!worldIn.getBlockState(pos).get(HASHEART))
			{
				worldIn.setBlockState(pos, state.with(HASHEART, true));
				if (!player.isCreative())
				{
					player.getHeldItem(handIn).shrink(1);
				}
				boolean firstPossibleLocation = isPortalComplete(pos.south(1).west(1).down(2), worldIn);
				boolean secondPossibleLocation = isPortalComplete(pos.south(5).west(1).down(2), worldIn);
				boolean thirdPossibleLocation = isPortalComplete(pos.south(5).west(5).down(2), worldIn);
				boolean fourthPossibleLocation = isPortalComplete(pos.south(1).west(5).down(2), worldIn);
				if (firstPossibleLocation || secondPossibleLocation || thirdPossibleLocation || fourthPossibleLocation)
				{
					DeepWatersMod.logger.log(Level.INFO, "WORKS");
				}
				BlockPos centerBottom;
				if (firstPossibleLocation)
				{
					centerBottom = pos.north(2).east(2).down(2);
				}
				else if (secondPossibleLocation)
				{
					centerBottom = pos.south(2).east(2).down(2);
				}
				else if (thirdPossibleLocation)
				{
					centerBottom = pos.south(2).west(2).down(2);
				}
				else if (fourthPossibleLocation)
				{
					centerBottom = pos.north(2).west(2).down(2);
				}
				else
				{
					return false;
				}
				RotatedPillarBlock activePillar = DeepWatersBlocks.ACTIVATED_PORTAL_PILLAR.get();
				Block portal = DeepWatersBlocks.DEEPWATERSPORTAL.get();

				FillPortal(worldIn, centerBottom, activePillar, portal,
						DeepWatersBlocks.ACTIVATED_PORTAL_PILLAR_END.get());
			}
			return true;
		}
		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}

	public static void FillPortal(World worldIn, BlockPos centerBottom, RotatedPillarBlock activePillar, Block portal,
	                              Block portalBlockEnd)
	{
		worldIn.setBlockState(centerBottom,
				portalBlockEnd.getDefaultState().with(FACING,
						Direction.UP));
		worldIn.setBlockState(centerBottom.up(),
				activePillar.getDefaultState());
		worldIn.setBlockState(centerBottom.up(2),
				activePillar.getDefaultState());
		worldIn.setBlockState(centerBottom.up(3),
				activePillar.getDefaultState());

		worldIn.setBlockState(centerBottom.north(1), portal.getDefaultState());
		worldIn.setBlockState(centerBottom.north(2), portal.getDefaultState());
		worldIn.setBlockState(centerBottom.north(-1), portal.getDefaultState());
		worldIn.setBlockState(centerBottom.north(-2), portal.getDefaultState());

		worldIn.setBlockState(centerBottom.east(1), portal.getDefaultState());
		worldIn.setBlockState(centerBottom.east(2), portal.getDefaultState());
		worldIn.setBlockState(centerBottom.east(-1), portal.getDefaultState());
		worldIn.setBlockState(centerBottom.east(-2), portal.getDefaultState());

		worldIn.setBlockState(centerBottom.south(1).east(1), portal.getDefaultState());
		worldIn.setBlockState(centerBottom.south(2).east(1), portal.getDefaultState());
		worldIn.setBlockState(centerBottom.south(1).east(2), portal.getDefaultState());

		worldIn.setBlockState(centerBottom.south(1).west(1), portal.getDefaultState());
		worldIn.setBlockState(centerBottom.south(2).west(1), portal.getDefaultState());
		worldIn.setBlockState(centerBottom.south(1).west(2), portal.getDefaultState());

		worldIn.setBlockState(centerBottom.north(1).east(1), portal.getDefaultState());
		worldIn.setBlockState(centerBottom.north(2).east(1), portal.getDefaultState());
		worldIn.setBlockState(centerBottom.north(1).east(2), portal.getDefaultState());

		worldIn.setBlockState(centerBottom.north(1).west(1), portal.getDefaultState());
		worldIn.setBlockState(centerBottom.north(2).west(1), portal.getDefaultState());
		worldIn.setBlockState(centerBottom.north(1).west(2), portal.getDefaultState());
	}

	private static char[][] firstLayer = {
			{' ', ' ', 'p', 'b', 'p', ' ', ' '},
			{' ', 'b', ' ', ' ', ' ', 'b', ' '},
			{'p', ' ', ' ', ' ', ' ', ' ', 'p'},
			{'b', ' ', ' ', 'e', ' ', ' ', 'b'},
			{'p', ' ', ' ', ' ', ' ', ' ', 'p'},
			{' ', 'b', ' ', ' ', ' ', 'b', ' '},
			{' ', ' ', 'p', 'b', 'p', ' ', ' '}};

	private static char[][] secondLayer = {
			{' ', ' ', 's', 'b', 's', ' ', ' '},
			{' ', 'b', ' ', ' ', ' ', 'b', ' '},
			{'s', ' ', ' ', ' ', ' ', ' ', 's'},
			{'b', ' ', ' ', 'i', ' ', ' ', 'b'},
			{'s', ' ', ' ', ' ', ' ', ' ', 's'},
			{' ', 'b', ' ', ' ', ' ', 'b', ' '},
			{' ', ' ', 's', 'b', 's', ' ', ' '}};

	private static char[][] thirdLayer = {
			{' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', 'd', ' ', ' ', ' ', 'd', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', 'i', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', 'd', ' ', ' ', ' ', 'd', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' '}};

	private static char[][] fourthLayer = {
			{' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', 'i', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' '}};

	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type)
	{
		return super.canEntitySpawn(state, worldIn, pos, type);

	}

	/*
		The blockpos argument here is measured from the bottom left, so the highest Z value, lowest Y value, and lowest X value of the portal
		 */
	public static boolean isPortalComplete(BlockPos pos, World world)
	{
		for (int i = 0; i < firstLayer.length; i++)
		{
			char[] row = firstLayer[i];
			for (int j = 0; j < row.length; j++)
			{
				char column = row[j];
				if (!isBlockCorrect(column, new BlockPos(pos.getX() + j, pos.getY(), pos.getZ() - i), world))
				{
					return false;
				}
			}
		}

		for (int i = 0; i < secondLayer.length; i++)
		{
			char[] row = secondLayer[i];
			for (int j = 0; j < row.length; j++)
			{
				char column = row[j];
				if (!isBlockCorrect(column, new BlockPos(pos.getX() + j, pos.getY() + 1, pos.getZ() - i), world))
				{
					return false;
				}
			}
		}

		for (int i = 0; i < thirdLayer.length; i++)
		{
			char[] row = thirdLayer[i];
			for (int j = 0; j < row.length; j++)
			{
				char column = row[j];
				if (!isBlockCorrect(column, new BlockPos(pos.getX() + j, pos.getY() + 2, pos.getZ() - i), world))
				{
					return false;
				}
			}
		}

		for (int i = 0; i < fourthLayer.length; i++)
		{
			char[] row = fourthLayer[i];
			for (int j = 0; j < row.length; j++)
			{
				char column = row[j];
				if (!isBlockCorrect(column, new BlockPos(pos.getX() + j, pos.getY() + 3, pos.getZ() - i), world))
				{
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isBlockCorrect(char character, BlockPos pos, World world)
	{
		BlockState blockState = world.getBlockState(pos);
		Block block = blockState.getBlock();
		switch (character)
		{
			case ' ':
				return block == Blocks.AIR || block == DeepWatersBlocks.DEEPWATERSPORTAL.get() || block == Blocks.WATER;
			case 'p':
				return block == Blocks.PRISMARINE_BRICKS;
			case 'b':
				return block == Blocks.DARK_PRISMARINE;
			case 'e':
				return block == DeepWatersBlocks.PORTAL_PILLAR_END.get() || block == DeepWatersBlocks.ACTIVATED_PORTAL_PILLAR_END.get();
			case 'i':
				return block == DeepWatersBlocks.PORTAL_PILLAR.get() || block == DeepWatersBlocks.ACTIVATED_PORTAL_PILLAR.get();
			case 'd':
				Boolean aBoolean = blockState.get(HASHEART);
				return block == DeepWatersBlocks.PEDESTAL.get() && blockState.get(HASHEART);
			case 's':
				return block == Blocks.PRISMARINE_BRICK_STAIRS;
		}
		return false;
	}


	@Override
	public IFluidState getFluidState(BlockState state)
	{
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@Override
	public BlockRenderLayer getRenderLayer()
	{
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	public BlockState getStateForPlacement(BlockItemUseContext context, boolean identifier)
	{
		return getDefaultState().with(ROTATION, context.getPlacementHorizontalFacing().getOpposite());
	}
}
