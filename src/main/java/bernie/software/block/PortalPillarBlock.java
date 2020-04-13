package bernie.software.block;

import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class PortalPillarBlock extends RotatedPillarBlock {

    public PortalPillarBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(3F, 50F)
                .sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE)
        );
    }

    public PortalPillarBlock(int light) {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(3F, 50F)
                .sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE)
                .lightValue(light)
        );
    }
}
