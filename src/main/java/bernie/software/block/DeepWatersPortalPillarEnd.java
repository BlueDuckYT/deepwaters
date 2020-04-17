package bernie.software.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;

public class DeepWatersPortalPillarEnd extends DirectionalBlock {
    public DeepWatersPortalPillarEnd(Properties builder) {
        super(builder);
    }
    public DeepWatersPortalPillarEnd(int light) {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(3F, 50F)
                .sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE)
                .lightValue(light)
        );
    }
    public static final EnumProperty FACING = BlockStateProperties.FACING;
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
