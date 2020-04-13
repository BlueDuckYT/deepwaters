package bernie.software.block;

import net.minecraft.block.Block;
import net.minecraft.block.CoralBlock;

public class DeepWatersCoralBlock extends CoralBlock {

    private final Block deadBlock;

    public DeepWatersCoralBlock(Block block, Properties properties) {
        super(block, properties);

        this.deadBlock = block;
    }
}
