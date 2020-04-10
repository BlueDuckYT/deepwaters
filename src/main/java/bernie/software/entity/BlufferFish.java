package bernie.software.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.entity.passive.fish.PufferfishEntity;
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
		return null;
	}

	@Override
	protected SoundEvent getFlopSound()
	{
		return null;
	}

}