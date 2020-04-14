package bernie.software.item.events;

import bernie.software.DeepWatersMod;
import bernie.software.item.tool.DeepWatersShieldItem.shieldEvent;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.IntNBT;
import net.minecraft.nbt.LongNBT;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;

import java.util.Date;

public class ShieldEvents
{
	public static class Prismarine extends shieldEvent
	{
		@Override
		public void onUse(World world, PlayerEntity playerEntity, Hand hand)
		{
			ItemStack stack = playerEntity.getHeldItem(hand);
			if (playerEntity.isInWater())
			{
				Long time = new Date().getTime();
				DeepWatersMod.log.log(Level.INFO, time);
				DeepWatersMod.log.log(Level.INFO, stack.getTag().getLong("COOLDOWN"));
				if (stack.getTag().getLong("COOLDOWN") <= time - 10000)
				{
					double speedFactor = 2;
					stack.setTagInfo("COOLDOWN", new LongNBT(time));
					playerEntity.setVelocity(playerEntity.getLookVec().scale(speedFactor).x, playerEntity.getLookVec().scale(speedFactor).y, playerEntity.getLookVec().scale(speedFactor).z);
				}
			}
		}

		@Override
		public void inInv(ItemStack stack, World world, Entity entityIn, int itemSlot, boolean isSelected)
		{
			if (!stack.getTag().contains("COOLDOWN"))
			{
				stack.getOrCreateChildTag("COOLDOWN");
				Long time = new Date().getTime();
				stack.setTagInfo("COOLDOWN", new LongNBT(time));
			}
		}
	}
}
