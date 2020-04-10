package bernie.software.tags;

import bernie.software.ModEventSubscriber;
import bernie.software.utils.GeneralUtils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;

public class DeepWatersTags
{
	public static Tag<Item> getItemTag(String tagName)
	{
		return ItemTags.getCollection().getOrCreate(GeneralUtils.Location(tagName));
	}

	public static Tag<Block> getBlock(String tagName)
	{
		return BlockTags.getCollection().getOrCreate(GeneralUtils.Location(tagName));
	}
}
