package bernie.software.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SunkenGravelBlock extends DeepWatersFallingBlock {

    public SunkenGravelBlock() {
        super(Properties.create(Material.EARTH)
                .hardnessAndResistance(0.6F, 0.6F)
                .sound(SoundType.GROUND)
                .harvestLevel(0)
                .harvestTool(ToolType.SHOVEL)
        );
    }
}
