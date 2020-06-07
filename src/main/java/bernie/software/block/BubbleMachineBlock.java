package bernie.software.block;

import bernie.software.registry.DeepWatersTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class BubbleMachineBlock extends Block{

    public BubbleMachineBlock(Material material, float hardness, float resist, SoundType sound, int harvestlvl, ToolType tool) {
        super(Properties.create(material)
                .hardnessAndResistance(hardness,resist)
                .sound(sound)
                .harvestLevel(harvestlvl)
                .harvestTool(tool)
        );
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    /*@Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return DeepWatersTileEntities.BUBBLE_MACHINE.get().create();
    }*/

}
