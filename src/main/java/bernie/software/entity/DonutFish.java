package bernie.software.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class DonutFish extends AbstractUnderwaterEntity
{
	public net.minecraft.util.ResourceLocation ResourceLocation;

	public DonutFish(EntityType<? extends AbstractUnderwaterEntity> type, World worldIn)
	{
		super(type, worldIn, true, true);

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
