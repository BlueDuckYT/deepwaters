package blueduck.deepwaters.entity;

import blueduck.deepwaters.registry.DeepWatersItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class LegFish extends AbstractFishEntity
{
	boolean socks = false;

	public LegFish(EntityType<? extends AbstractFishEntity> p_i50248_1_, World p_i50248_2_)
	{
		super(p_i50248_1_, p_i50248_2_);
		if ((int) (Math.random() * 100 ) == 1) {
			socks = true;
		}
	}

	@Override
	protected ItemStack getFishBucket()
	{
		return new ItemStack(DeepWatersItems.LEGFISH_ITEM_BUCKET.get());
	}

	@Override
	protected SoundEvent getFlopSound()
	{
		return null;
	}

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
	}

	//Possibly make it kill players

	public boolean getsocks() {
		return socks;
	}


}