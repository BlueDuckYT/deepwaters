package bernie.software.block;

import bernie.software.DeepWatersMod;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.world.gen.features.ThickKelp;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.ILightReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Level;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.Random;

public class ThickKelpBlock extends Block implements IWaterLoggable
{
    public ThickKelpBlock(Properties properties)
    {
        super(properties.noDrops());
    }

    public ThickKelpBlock()
    {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(-1f, -1f)
                .sound(SoundType.STONE)
                .noDrops()
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        VoxelShape shape1 =
                        Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
        return shape1;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return getShape(state, worldIn, pos, context);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(COLOR, BOTTOM, GROWAQUASTONE);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        try {
            World world=context.getWorld();
            BlockPos pos=context.getPos();
            KelpColor color=KelpColor.values()[new Random(pos.toLong()).nextInt(KelpColor.values().length)];
            if (world.getBlockState(pos.down()).getBlock() instanceof ThickKelpBlock) {
                color=(KelpColor)world.getBlockState(pos.down()).get(COLOR);
            }
            boolean bottom=world.getBlockState(pos.down()).getBlock() instanceof ThickKelpBlock;
            boolean grows_aquastone=world.getBlockState(pos.down()).getBlock() instanceof ThickKelpBlock&&
                    world.getBlockState(pos.down()).get(GROWAQUASTONE);
            return super.getStateForPlacement(context)
                    .with(COLOR, color)
                    .with(BOTTOM, !bottom)
                    .with(GROWAQUASTONE, grows_aquastone);
        } catch (Exception err) {}
        return super.getStateForPlacement(context)
                .with(COLOR, KelpColor.GREEN)
                .with(BOTTOM, true)
                .with(GROWAQUASTONE, false);
    }

    @Override
    public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type)
    {
        return super.canEntitySpawn(state, worldIn, pos, type);
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onBlockAdded(state, worldIn, pos, oldState, isMoving);
        if (state.get(BOTTOM)) {
//            if (worldIn.getBlockState(pos.up()).getBlock() instanceof AirBlock) {
                worldIn.setBlockState(pos.up(), DeepWatersBlocks.THICK_KELP_TOP.get().getDefaultState().with(BOTTOM,false));
//            }
        }
    }

    @Override
    public IFluidState getFluidState(BlockState state)
    {
        return Fluids.WATER.getStillFluidState(false);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getRenderShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return getShape(state,worldIn,pos,null);
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    @Override
    public int tickRate(IWorldReader worldIn) {
        return 20;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        DeepWatersMod.logger.log(Level.INFO,"h0");
        if (state.getBlock() instanceof ThickKelpBlock && (state.getBlock().getClass().toString().toLowerCase().contains("top"))) {
            DeepWatersMod.logger.log(Level.INFO,"h1");
            if (!state.get(BOTTOM)) {
                DeepWatersMod.logger.log(Level.INFO,"h2");
                if (worldIn.getBlockState(pos.up()).getFluidState().equals(Fluids.WATER.getStillFluidState(false))) {
                    DeepWatersMod.logger.log(Level.INFO,"h3");
                    worldIn.setBlockState(pos.up(),DeepWatersBlocks.THICK_KELP_TOP.get().getDefaultState().with(BOTTOM,false));
                }
            }
        }
        super.randomTick(state, worldIn, pos, random);
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
        try {
            if (!(worldIn.getBlockState(pos.down()).getBlock() instanceof ThickKelpBlock)) {
                if (!(worldIn.getBlockState(pos.up()).getBlock() instanceof ThickKelpBlock)) {
                    worldIn.destroyBlock(pos,true);
                } else {
                    worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(BOTTOM,true));
                }
            } else {
                worldIn.setBlockState(pos,getBlockState(state,worldIn,pos));
            }
        } catch (Exception err) {}
    }

    public BlockState getBlockState(BlockState currentState,IWorldReader worldReader,BlockPos pos) {
        BlockState reference=worldReader.getBlockState(pos.down());
        return currentState
                .with(BOTTOM,false)
                .with(COLOR,reference.get(COLOR))
                .with(GROWAQUASTONE,reference.get(GROWAQUASTONE));
    }

    public static final EnumProperty COLOR = EnumProperty.create("color",KelpColor.class);
    public static final BooleanProperty GROWAQUASTONE = BooleanProperty.create("aquastonegrowth");
    public static BooleanProperty BOTTOM = BooleanProperty.create("bottom");

    public enum KelpColor implements IStringSerializable {
        GREEN("green",new Color(0x506B00).getRGB()),
        ORANGE("orange",new Color(0x6B6000).getRGB()),
        DEEPORANGE("deeporange",new Color(0x6B560A).getRGB()),
        LIME("lime",new Color(0x338F00).getRGB()),
        YELLOW("yellow",new Color(0x656B00).getRGB())
        ;

        int Color;
        String name;
        KelpColor(String name,int color) {
            Color = color;
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Colors implements IBlockColor {
        @Override
        public int getColor(BlockState p_getColor_1_, @Nullable ILightReader p_getColor_2_, @Nullable BlockPos p_getColor_3_, int p_getColor_4_) {
            return ((KelpColor)p_getColor_1_.get(COLOR)).Color;
        }
    }
}