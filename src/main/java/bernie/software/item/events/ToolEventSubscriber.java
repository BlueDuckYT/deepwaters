package bernie.software.item.events;

import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;

@Mod.EventBusSubscriber
public class ToolEventSubscriber
{

	private static Block[] PortalBlocks = {DeepWatersBlocks.PEDESTAL.get(), DeepWatersBlocks.PORTAL_PILLAR.get(), DeepWatersBlocks.PORTAL_PILLAR_END.get(), DeepWatersBlocks.ACTIVATED_PORTAL_PILLAR.get(), DeepWatersBlocks.ACTIVATED_PORTAL_PILLAR_END.get(), DeepWatersBlocks.DEEPWATERSPORTAL.get(), Blocks.PRISMARINE_BRICKS, Blocks.PRISMARINE_BRICK_STAIRS, Blocks.DARK_PRISMARINE};

	@SubscribeEvent
	public static void onBreakSpeedEvent(final PlayerEvent.BreakSpeed event)
	{

		PlayerEntity player = event.getPlayer();

		World world = player.getEntityWorld();
		BlockPos pos = event.getPos();
		if (Arrays.asList(PortalBlocks).contains(world.getBlockState(pos).getBlock()))
		{
			for (Direction dir : Direction.values())
			{
				if (dir == Direction.DOWN || dir == Direction.UP)
				{
					continue;
				}
				BlockPos offset = pos.offset(dir);
				boolean isTouchingPortal = isPortal(world, offset);
				boolean isTouchingPortalBelow = isPortal(world, offset.down(1));

				boolean isPortalBelow = isPortal(world, pos.down(1));
				boolean isPortalAbove = isPortal(world, pos.up(1));
				if ((isTouchingPortal || isTouchingPortalBelow) && !(isPortalBelow || isPortalAbove))
				{
					event.setNewSpeed(0);
					return;
				}
			}
		}

		float originalSpeed = event.getOriginalSpeed();
		Item item = player.getHeldItemMainhand().getItem();
		if (player.isInWater() || player.isSwimming() || player.isInWaterOrBubbleColumn() && player.canHarvestBlock(
				player.getBlockState()))
		{
			if (item == DeepWatersItems.PRISMARINE_AXE.get() || item == DeepWatersItems.PRISMARINE_PICKAXE.get() || item == DeepWatersItems.PRISMARINE_SHOVEL.get())
			{
				event.setNewSpeed(originalSpeed * 10);
			}
			else if (item == DeepWatersItems.AQUALITE_PICKAXE.get())
			{
				event.setNewSpeed(originalSpeed * 20);
			}
		}
	}

	public static boolean isPortal(World world, BlockPos pos)
	{
		return world.getBlockState(pos) == DeepWatersBlocks.DEEPWATERSPORTAL.get().getDefaultState();
	}

}
