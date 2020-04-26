package bernie.software.block.blockbase;

import net.minecraft.block.LanternBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DeepWatersLantern extends LanternBlock {
    public DeepWatersLantern(Properties p_i49980_1_) {
        super(p_i49980_1_);
    }

    public DeepWatersLantern(Material material, float hardness, float resist, SoundType sound, int harvestlvl, ToolType tool) {
        super(Properties.create(material)
                .hardnessAndResistance(hardness,resist)
                .sound(sound)
                .harvestLevel(harvestlvl)
                .harvestTool(tool)
        );
    }
}
