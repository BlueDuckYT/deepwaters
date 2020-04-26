package bernie.software.block.blockbase;

import net.minecraft.block.LadderBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DeepWatersLadder extends LadderBlock {
    public DeepWatersLadder(Properties builder) {
        super(builder);
    }

    public DeepWatersLadder(Material material, float hardness, float resist, SoundType sound, int harvestlvl, ToolType tool) {
        super(Properties.create(material)
                .hardnessAndResistance(hardness,resist)
                .sound(sound)
                .harvestLevel(harvestlvl)
                .harvestTool(tool)
        );
    }
}
