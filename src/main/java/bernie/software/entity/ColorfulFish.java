package bernie.software.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class ColorfulFish extends AbstractUnderwaterEntity
{

	StringNBT color;

	public ColorfulFish(EntityType<? extends AbstractUnderwaterEntity> entityType, World world)
	{
		super(entityType, world, true, true);
		String[] colors = {"blue", "red", "green", "purple", "yellow"};
		try {
			String str = color.getString();
		}
		catch (Exception e) {
			color = StringNBT.valueOf(colors[(int) (Math.random() * 5)]);
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