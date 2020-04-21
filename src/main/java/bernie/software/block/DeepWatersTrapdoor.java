package bernie.software.block;

import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SoundType;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DeepWatersTrapdoor extends TrapDoorBlock implements IWaterLoggable {
    public DeepWatersTrapdoor(Properties properties) {
        super(properties);
    }
    public DeepWatersTrapdoor(Material material, float hardness, float resist, SoundType sound, int harvestlvl, ToolType tool) {
        super(Properties.create(material)
                .hardnessAndResistance(hardness,resist)
                .sound(sound)
                .harvestLevel(harvestlvl)
                .harvestTool(tool)
        );
    }
}
