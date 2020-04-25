package bernie.software.block;

import bernie.software.registry.DeepWatersBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.PistonEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;
import java.util.List;

import static bernie.software.item.events.ToolEventSubscriber.isPortal;

@Mod.EventBusSubscriber
public class BlockEventSusbcriber
{
	private static Block[] PortalBlocks = {DeepWatersBlocks.PEDESTAL.get(), DeepWatersBlocks.PORTAL_PILLAR.get(), DeepWatersBlocks.PORTAL_PILLAR_END.get(), DeepWatersBlocks.ACTIVATED_PORTAL_PILLAR.get(), DeepWatersBlocks.ACTIVATED_PORTAL_PILLAR_END.get(), DeepWatersBlocks.DEEPWATERSPORTAL.get(), Blocks.PRISMARINE_BRICKS, Blocks.PRISMARINE_BRICK_STAIRS, Blocks.DARK_PRISMARINE};

	@SubscribeEvent
	public static void onBlockPushEvent(PistonEvent.Pre event)
	{

		BlockPos pos = event.getPos().offset(event.getDirection(), 2);
		World world = (World) event.getWorld();
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

				boolean isPortalAbove = isPortal(world, pos.up(1));
				if ((isTouchingPortal || isTouchingPortalBelow) && !isPortalAbove)
				{
					event.setCanceled(true);
					return;
				}
			}
		}

	}
}
