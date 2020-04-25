package bernie.software.world.gen.tree;

import bernie.software.world.gen.feature.DeadwoodFeature;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class DeadwoodTree extends Tree {

    @Nullable
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
        return new DeadwoodFeature(NoFeatureConfig::deserialize, true);
    }
}
