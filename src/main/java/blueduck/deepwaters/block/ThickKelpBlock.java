package blueduck.deepwaters.block;

import blueduck.deepwaters.client.renderer.Utils;
import blueduck.deepwaters.registry.DeepWatersBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.PushReaction;
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.Random;

import static blueduck.deepwaters.block.ThickKelpTopBlock.NEW;

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
        if (this instanceof ThickKelpTopBlock) {
            builder.add(NEW);
        }
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
            if (worldIn.getBlockState(pos.up()).getFluidState().getFluid() instanceof WaterFluid.Source) {
                if (worldIn.getBlockState(pos.up()).getBlock().toString().equals("Block{minecraft:water}")) {
                    worldIn.setBlockState(pos.up(), DeepWatersBlocks.AQUA_REPEATER.get().getDefaultState().with(BOTTOM,false));
                }
            }
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
        if (worldIn.getLightFor(LightType.BLOCK,pos)<=5) {
            if (state.getBlock() instanceof ThickKelpTopBlock) {
                if (!state.get(BOTTOM)) {
                    if (worldIn.getBlockState(pos.up()).getBlock().toString().equals("Block{minecraft:water}")) {
                        worldIn.setBlockState(pos.up(),DeepWatersBlocks.AQUA_REPEATER.get().getDefaultState()
                                .with(BOTTOM,false)
                                .with(GROWAQUASTONE,state.get(GROWAQUASTONE))
                                .with(COLOR,state.get(COLOR)));
                    }
                }
            }
        }
        super.randomTick(state, worldIn, pos, random);
    }

    public BlockState getStateForGeneration(BlockState state, IWorld world, BlockPos pos) {
        try {
            KelpColor color=KelpColor.values()[new Random(pos.toLong()).nextInt(KelpColor.values().length)];
            if (world.getBlockState(pos.down()).getBlock() instanceof ThickKelpBlock) {
                color=(KelpColor)world.getBlockState(pos.down()).get(COLOR);
            }
            boolean bottom=world.getBlockState(pos.down()).getBlock() instanceof ThickKelpBlock;
            boolean grows_aquastone=world.getBlockState(pos.down()).getBlock() instanceof ThickKelpBlock&&
                    world.getBlockState(pos.down()).get(GROWAQUASTONE);
            return getDefaultState()
                    .with(COLOR, color)
                    .with(BOTTOM, !bottom)
                    .with(GROWAQUASTONE, grows_aquastone);
        } catch (Exception err) {}
        return getDefaultState()
                .with(COLOR, KelpColor.GREEN)
                .with(BOTTOM, true)
                .with(GROWAQUASTONE, false);
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
            if (worldIn.getBlockState(pos.down()).getBlock().getRegistryName().equals(DeepWatersBlocks.AQUASTONE_ORE.get().getRegistryName())) {
                worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(GROWAQUASTONE,true));
            } else {
                try {
                    BlockState reference=worldIn.getBlockState(pos.down());
                    worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(GROWAQUASTONE,reference.get(GROWAQUASTONE)));
                } catch (Exception err) {
                    worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(GROWAQUASTONE,false));
                }
            }
        } catch (Exception err) {}
    }

    public BlockState getBlockState(BlockState currentState,IWorldReader worldReader,BlockPos pos) {
        BlockState reference=worldReader.getBlockState(pos.down());
        if (!(worldReader.getBlockState(pos.up()).getBlock() instanceof ThickKelpBlock)) {
            return DeepWatersBlocks.AQUA_REPEATER.get().getDefaultState()
                    .with(BOTTOM,false)
                    .with(COLOR,reference.get(COLOR))
                    .with(GROWAQUASTONE,reference.get(GROWAQUASTONE));
        }
        return currentState
                .with(BOTTOM,false)
                .with(COLOR,reference.get(COLOR))
                .with(GROWAQUASTONE,reference.get(GROWAQUASTONE));
    }

    @Override
    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    public static final EnumProperty COLOR = EnumProperty.create("color",KelpColor.class);
    public static final BooleanProperty GROWAQUASTONE = BooleanProperty.create("aquastonegrowth");
    public static BooleanProperty BOTTOM = BooleanProperty.create("bottom");

    public enum KelpColor implements IStringSerializable {
        GREEN("green",new Color(0x506B00).getRGB()),
        DARKGREEN("darkgreen",new Color(0x264000).getRGB()),
        ORANGE("orange",new Color(0x6B6000).getRGB()),
        DEEPORANGE("deeporange",new Color(0x6B560A).getRGB()),
        LIME("lime",new Color(0x2C7700).getRGB()),
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
            try {
                float lightLevel=p_getColor_2_.getLightFor(LightType.BLOCK,p_getColor_3_)/15f;
                if (lightLevel>=(5f/15f)) {
                    return new Utils.ColorHelper(((KelpColor)p_getColor_1_.get(COLOR)).Color).darker(MathHelper.lerp(lightLevel,1,0.3f)).getRGB();
                }
//            if (p_getColor_2_.getLightFor(LightType.BLOCK,p_getColor_3_)>=5) {
//                return new Utils.ColorHelper(((KelpColor)p_getColor_1_.get(COLOR)).Color).darker().darker().getRGB();
//            }
//            if (p_getColor_2_.getLightFor(LightType.BLOCK,p_getColor_3_.up())>=5) {
//                return new Utils.ColorHelper(((KelpColor)p_getColor_1_.get(COLOR)).Color).darker().getRGB();
//            }
//            if (p_getColor_2_.getLightFor(LightType.BLOCK,p_getColor_3_.down())>=5) {
//                return new Utils.ColorHelper(((KelpColor)p_getColor_1_.get(COLOR)).Color).darker().getRGB();
//            }
                int end=255;
                int light=15;
                for (int i=end;i>=0;i--) {
                    try {
                        BlockPos bp=new BlockPos(p_getColor_3_.getX(),i,p_getColor_3_.getZ());
                        light-=1-(p_getColor_2_.getBlockState(bp).getOpacity(p_getColor_2_,bp));
                        if (bp.equals(p_getColor_3_)||light<=0) {
                            i=0;
                            break;
                        }
                    } catch (Exception err) {}
                }
                if (light<=0) {
                    light=0;
                }
//            Color col=new Color(((KelpColor)p_getColor_1_.get(COLOR)).Color);
//            Color col2=new Color(((KelpColor)p_getColor_1_.get(COLOR)).Color).darker().darker().darker();
//            int red=(int)Math.floor(MathHelper.lerp((light/15f),col.getRed(),col2.getRed()));
//            int green=(int)Math.floor(MathHelper.lerp((light/15f),col.getGreen(),col2.getGreen()));
//            int blue=(int)Math.floor(MathHelper.lerp((light/15f),col.getBlue(),col2.getBlue()));
//            if (red>=255) {
//                red=255;
//            }
//            if (green>=255) {
//                green=255;
//            }
//            if (blue>=255) {
//                blue=255;
//            }
//            try {
//                return new Color(red,green,blue).getRGB();
//            } catch (Exception err) {}
                Utils.ColorHelper col1=new Utils.ColorHelper(((KelpColor) p_getColor_1_.get(COLOR)).Color);
                Utils.ColorHelper col2=new Utils.ColorHelper(0x00EBFF);
                if (p_getColor_1_.get(GROWAQUASTONE)) {
                    return new Color(
                            (int)col1.getRed(),
                            (int)MathHelper.lerp(0.2f,col1.getGreen(),col2.getGreen()),
                            (int)MathHelper.lerp(0.2f,col1.getBlue(),col2.getBlue())
                    ).getRGB();
                }
                return col1.getRGB();
            } catch (Exception err) {
                Utils.ColorHelper col1=new Utils.ColorHelper(((KelpColor) p_getColor_1_.get(COLOR)).Color);
                return col1.getRGB();
            }
        }
    }
}