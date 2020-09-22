package blueduck.deepwaters.entity;

import blueduck.deepwaters.registry.DeepWatersItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class BlufferFish extends AbstractGroupFishEntity
{

	public BlufferFish(EntityType<? extends AbstractGroupFishEntity> p_i50248_1_, World p_i50248_2_)
	{
		super(p_i50248_1_, p_i50248_2_);
	}

	@Override
	protected ItemStack getFishBucket()
	{
		return new ItemStack(DeepWatersItems.BLUFFERFISH_ITEM_BUCKET.get());
	}

	@Override
	protected SoundEvent getFlopSound()
	{
		return null;
	}

}