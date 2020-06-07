package bernie.software.block.blockbase;

import net.minecraft.block.Block;
import net.minecraft.block.CoralBlock;

public class DeepWatersCoralBlock extends CoralBlock {

    private final Block deadBlock;

    public DeepWatersCoralBlock(Block deadBlock, Properties properties) {
        super(deadBlock, properties);

        this.deadBlock = deadBlock;
    }
}
