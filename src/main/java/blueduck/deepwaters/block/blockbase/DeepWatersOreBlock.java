package blueduck.deepwaters.block.blockbase;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DeepWatersOreBlock extends OreBlock {

    public DeepWatersOreBlock(int harvestlvl) {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(3f,35f)
                .sound(SoundType.STONE)
                .harvestLevel(harvestlvl)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
