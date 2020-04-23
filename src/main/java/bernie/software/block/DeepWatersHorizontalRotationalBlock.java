package bernie.software.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.common.ToolType;

public class DeepWatersHorizontalRotationalBlock extends Block {
    public DeepWatersHorizontalRotationalBlock(Properties properties) {
        super(properties);
    }

    public DeepWatersHorizontalRotationalBlock(Material material, float hardness, float resist, SoundType sound, int harvestlvl, ToolType tool) {
        super(Properties.create(material)
                .hardnessAndResistance(hardness,resist)
                .sound(sound)
                .harvestLevel(harvestlvl)
                .harvestTool(tool)
        );
    }

    public DeepWatersHorizontalRotationalBlock(Material material, float hardness, float resist, SoundType sound, int harvestlvl, ToolType tool, int light) {
        super(Properties.create(material)
                .hardnessAndResistance(hardness,resist)
                .sound(sound)
                .harvestLevel(harvestlvl)
                .harvestTool(tool)
                .lightValue(light)
        );
    }

    public static final EnumProperty ROTATION = BlockStateProperties.HORIZONTAL_FACING;

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(ROTATION);
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(ROTATION, context.getPlacementHorizontalFacing().getOpposite());
    }

}
