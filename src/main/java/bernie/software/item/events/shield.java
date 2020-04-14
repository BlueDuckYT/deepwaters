package bernie.software.item.events;

import bernie.software.item.tool.DeepWatersShieldItem.useEvent;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class shield {
    public static class prismarine extends useEvent {
        @Override
        public void onUse(World world, PlayerEntity playerEntity, Hand hand) {
            if (world.getBlockState(playerEntity.getPosition()).getBlock().equals(Blocks.WATER)) {
                double speedFactor=2;
                playerEntity.setVelocity(playerEntity.getLookVec().scale(speedFactor).x,playerEntity.getLookVec().scale(speedFactor).y,playerEntity.getLookVec().scale(speedFactor).z);
            }
        }
    }
}
