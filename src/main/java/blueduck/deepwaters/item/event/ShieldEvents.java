package blueduck.deepwaters.item.event;

import blueduck.deepwaters.item.tool.DeepWatersShieldItem.ShieldEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.LongNBT;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Date;

public class ShieldEvents
{
	public static class PrismarineShielfEvent extends ShieldEvent
	{
		public int cooldown=20000;
		@Override
		public int cooldown(){
			return cooldown;
		};
		@Override
		public void onUse(World world, PlayerEntity playerEntity, Hand hand)
		{
			ItemStack stack = playerEntity.getHeldItem(hand);
			if (playerEntity.isInWater()&&playerEntity.isSneaking())
			{
				Long time = new Date().getTime();
//				DeepWatersMod.logger.log(Level.INFO, time);
//				DeepWatersMod.logger.log(Level.INFO, stack.getTag().getLong("COOLDOWN"));
				if (stack.getTag().getLong("COOLDOWN") <= time)
				{
					try {
						playerEntity.getHeldItem(hand).damageItem(3, playerEntity, playerEntity1 ->
						{
							if (playerEntity1.getHeldItem(hand).getDamage()<=0)
							{
								ItemStack stk;
								stk=new ItemStack(Items.AIR);
								playerEntity1.setHeldItem(hand,stk);
							}
						});
					} catch (Exception err)
					{
					
					}
					double speedFactor = 1;
					stack.setTagInfo("COOLDOWN", LongNBT.valueOf(time+cooldown));
					playerEntity.setVelocity(playerEntity.getLookVec().scale(speedFactor).x, playerEntity.getLookVec().scale(speedFactor).y, playerEntity.getLookVec().scale(speedFactor).z);
				}
			}
		}

		@Override
		public void inInv(ItemStack stack, World world, Entity entityIn, int itemSlot, boolean isSelected)
		{
			if (!stack.hasTag())
			{
				Long time = new Date().getTime()+7500;
				stack.getOrCreateTag();
				stack.setTagInfo("COOLDOWN", LongNBT.valueOf(time));
			}
			if (!stack.getTag().contains("COOLDOWN"))
			{
				Long time = new Date().getTime();
				stack.getOrCreateChildTag("COOLDOWN");
				stack.setTagInfo("COOLDOWN", LongNBT.valueOf(time));
			}
		}
	}
	public static class DarkPrismarine extends ShieldEvent
	{
		public int cooldown=10000;
		@Override
		public int cooldown()
		{
			return cooldown;
		};
		@Override
		public void onUse(World world, PlayerEntity playerEntity, Hand hand)
		{
			ItemStack stack = playerEntity.getHeldItem(hand);
			if (playerEntity.isInWater()&&playerEntity.isSneaking())
			{
				Long time = new Date().getTime();
//				DeepWatersMod.logger.log(Level.INFO, time);
//				DeepWatersMod.logger.log(Level.INFO, stack.getTag().getLong("COOLDOWN"));
				if (stack.getTag().getLong("COOLDOWN") <= time)
				{
					playerEntity.getHeldItem(hand).damageItem(3, playerEntity, playerEntity1 ->
					{
						if (playerEntity1.getHeldItem(hand).getDamage()<=0)
						{
							ItemStack stk;
							stk=new ItemStack(Items.AIR);
							playerEntity1.setHeldItem(hand,stk);
						}
					});
					double speedFactor = 2;
					stack.setTagInfo("COOLDOWN", LongNBT.valueOf(time+cooldown));
					playerEntity.setVelocity(playerEntity.getLookVec().scale(speedFactor).x, playerEntity.getLookVec().scale(speedFactor).y, playerEntity.getLookVec().scale(speedFactor).z);
				}
			}
		}

		@Override
		public void inInv(ItemStack stack, World world, Entity entityIn, int itemSlot, boolean isSelected)
		{
			if (!stack.hasTag())
			{
				Long time = new Date().getTime()+7500;
				stack.getOrCreateTag();
				stack.setTagInfo("COOLDOWN", LongNBT.valueOf(time));
			}
			if (!stack.getTag().contains("COOLDOWN"))
			{
				Long time = new Date().getTime();
				stack.getOrCreateChildTag("COOLDOWN");
				stack.setTagInfo("COOLDOWN", LongNBT.valueOf(time));
			}
		}
	}
}
