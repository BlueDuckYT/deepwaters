package blueduck.deepwaters.entity;

import blueduck.deepwaters.registry.DeepWatersItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class MuckGulper extends AbstractGroupFishEntity
{
	public MuckGulper(EntityType<? extends AbstractGroupFishEntity> type, World worldIn)
	{
		super(type, worldIn);
	}

	@Override
	protected ItemStack getFishBucket()
	{
		return new ItemStack(DeepWatersItems.MUCKGULPER_ITEM_BUCKET.get());
	}

	@Override
	protected SoundEvent getFlopSound()
	{
		return null;
	}
}
