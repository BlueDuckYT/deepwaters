package blueduck.deepwaters.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class DonutFish extends AbstractGroupFishEntity
{
	public net.minecraft.util.ResourceLocation ResourceLocation;

	public DonutFish(EntityType<? extends AbstractGroupFishEntity> type, World worldIn)
	{
		super(type, worldIn);
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
