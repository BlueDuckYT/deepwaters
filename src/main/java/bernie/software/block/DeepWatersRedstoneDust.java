package bernie.software.block;

import bernie.software.DeepWatersMod;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.minecraft.block.*;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IEnviromentBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import static net.minecraft.block.RedstoneWireBlock.POWER;

public class DeepWatersRedstoneDust extends RedstoneWireBlock implements IWaterLoggable {
    public DeepWatersRedstoneDust(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canProvidePower(BlockState state) {
        return true;
    }
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, POWER, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return super.getStateForPlacement(context).with(WATERLOGGED,false);
    }

    public IFluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return true;
    }

    public static class colors implements IBlockColor {
        @Override
        public int getColor(BlockState p_getColor_1_, @Nullable IEnviromentBlockReader p_getColor_2_, @Nullable BlockPos p_getColor_3_, int p_getColor_4_) {
            try {
                float power=(2f/(p_getColor_1_.get(POWER)));
                int color1R=2;
                int color1G=188;
                int color1B=255;
                int color2R=0;
                int color2G=24;
                int color2B=33;
                float fade=((power)/2);
                int red=(int)(((fade*color1R)+((1-fade)*color2R))*1.5f);
                int gre=(int)(((fade*color1G)+((1-fade)*color2G))*1.5f);
                int blu=(int)(((fade*color1B)+((1-fade)*color2B))*1.5f);
                Color color=new Color(red,gre,blu);
                return color.getRGB();
            } catch (Exception err) {
                return 0;
            }
        }
    }
}
