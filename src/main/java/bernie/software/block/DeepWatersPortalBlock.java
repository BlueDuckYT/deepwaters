package bernie.software.block;

import bernie.software.ForgeBusEventSubscriber;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ToolType;

public class DeepWatersPortalBlock extends Block {

    public DeepWatersPortalBlock(Material material, float hardness, float resist, SoundType sound, int harvestlvl, ToolType tool) {
        super(Properties.create(material)
                .hardnessAndResistance(hardness,resist)
                .sound(sound)
                .harvestLevel(harvestlvl)
                .harvestTool(tool)
                .doesNotBlockMovement()
        );
    }

    public DeepWatersPortalBlock(Material material, float hardness, float resist, SoundType sound, int harvestlvl, ToolType tool, int light) {
        super(Properties.create(material)
                .hardnessAndResistance(hardness,resist)
                .sound(sound)
                .harvestLevel(harvestlvl)
                .harvestTool(tool)
                .lightValue(light)
                .doesNotBlockMovement()
        );
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (!worldIn.isRemote && !entityIn.isPassenger() && !entityIn.isBeingRidden() && entityIn.isNonBoss() && VoxelShapes.compare(VoxelShapes.create(entityIn.getBoundingBox().offset((double)(-pos.getX()), (double)(-pos.getY()), (double)(-pos.getZ()))), state.getShape(worldIn, pos), IBooleanFunction.AND)) {
            if (!entityIn.getEntityWorld().getDimension().getType().equals(DimensionType.byName(ForgeBusEventSubscriber.DIMENSION_TYPE_RL))) {
                entityIn.changeDimension(DimensionType.byName(ForgeBusEventSubscriber.DIMENSION_TYPE_RL));
            }
            else {
                entityIn.changeDimension(DimensionType.OVERWORLD);
            }
        }

    }


}
