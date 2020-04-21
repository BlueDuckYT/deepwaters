package bernie.software.block;

import net.minecraft.block.LogBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class DeepWatersLogBlock extends LogBlock {

    public DeepWatersLogBlock(MaterialColor verticalColorIn, Properties properties) {
        super(verticalColorIn, Properties.create(Material.WOOD)
                .hardnessAndResistance(2F)
                .sound(SoundType.WOOD)
                .harvestTool(ToolType.AXE)
        );
    }
}
