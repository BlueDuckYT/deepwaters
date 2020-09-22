package blueduck.deepwaters.block.blockbase;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DeepWatersTrapdoor extends TrapDoorBlock implements IWaterLoggable {
    public DeepWatersTrapdoor(Properties properties) {
        super(properties.notSolid());
    }
    public DeepWatersTrapdoor(Material material, float hardness, float resist, SoundType sound, int harvestlvl, ToolType tool) {
        super(Properties.create(material)
                .hardnessAndResistance(hardness,resist)
                .sound(sound)
                .harvestLevel(harvestlvl)
                .harvestTool(tool).notSolid()
        );
    }


}
