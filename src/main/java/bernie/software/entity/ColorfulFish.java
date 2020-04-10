package bernie.software.entity;

import bernie.software.nbt.Hue;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class ColorfulFish extends AbstractFishEntity
{

	Hue color;

	public ColorfulFish(EntityType<? extends AbstractFishEntity> p_i50248_1_, World p_i50248_2_)
	{
		super(p_i50248_1_, p_i50248_2_);
		String[] colors = {"blue", "red", "green", "purple", "yellow"};
		try {
			String str = color.getString();
		}
		catch (Exception e) {
			color = new Hue(colors[(int) (Math.random() * 5)]);
		}
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
	public String getColor() {
		return color.getString();
	}
}