package blueduck.deepwaters.item;

import blueduck.deepwaters.registry.DeepWatersItemGroups;
import blueduck.deepwaters.utils.misc.Lazy;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import java.util.ArrayList;
import java.util.List;

public class ModdedFishBucketItem extends FishBucketItem
{

	private final Lazy<? extends EntityType<?>> entityTypeSupplier;

	public ModdedFishBucketItem(final RegistryObject<? extends EntityType<?>> entityTypeSupplier)
	{
		super(entityTypeSupplier, Fluids.WATER.delegate, new Item.Properties().group(DeepWatersItemGroups.DEEPWATERS_ITEMS));
		this.entityTypeSupplier = Lazy.of(entityTypeSupplier);
	}

	@Override
	protected EntityType<?> getFishType()
	{
		return entityTypeSupplier.get();
	}
}