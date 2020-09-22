package blueduck.deepwaters.item;

import blueduck.deepwaters.utils.misc.Lazy;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import java.util.ArrayList;
import java.util.List;

public class ModdedFishBucketItem extends FishBucketItem
{

	protected static final List<ModdedFishBucketItem> UNADDED_EGGS = new ArrayList<>();
	private final Lazy<? extends EntityType<?>> entityTypeSupplier;

	public ModdedFishBucketItem(final RegistryObject<? extends EntityType<?>> entityTypeSupplier)
	{
		super(null, Fluids.WATER, new Item.Properties());
		this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
		UNADDED_EGGS.add(this);
	}

	@Override
	protected EntityType<?> getFishType()
	{
		return entityTypeSupplier.get();
	}
}