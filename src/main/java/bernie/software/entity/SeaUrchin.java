package bernie.software.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class SeaUrchin extends AbstractUnderwaterEntity
{
	public SeaUrchin(EntityType<? extends AbstractUnderwaterEntity> type, World worldIn)
	{
		super(type, worldIn, false, false);
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
