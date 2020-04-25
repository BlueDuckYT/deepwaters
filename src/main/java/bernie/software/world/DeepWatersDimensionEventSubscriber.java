package bernie.software.world;

import bernie.software.DeepWatersMod;
import bernie.software.ForgeBusEventSubscriber;
import bernie.software.ModEventSubscriber;
import bernie.software.block.DeepWatersBlock;
import bernie.software.block.Pedestal;
import bernie.software.entity.CoralCrawler;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.utils.renderutils.RenderHelper;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

@Mod.EventBusSubscriber
public class DeepWatersDimensionEventSubscriber
{
	private static BlockState WATER = Blocks.WATER.getDefaultState();

	//Handle Oxygenator
	@SubscribeEvent
	public static void onBlockBroken(final BlockEvent.BreakEvent event)
	{
		boolean replace = true;
		World world = (World) event.getWorld();
		BlockPos pos = event.getPos();
		Block block = world.getBlockState(pos).getBlock();

		int xPos = pos.getX();
		int yPos = pos.getY();
		int zPos = pos.getZ();
		for (int x = -8; x < 9; x++)
		{
			for (int y = -8; y < 9; y++)
			{
				for (int z = -8; z < 9; z++)
				{
					if (world.getBlockState(new BlockPos(xPos + x, yPos + y, zPos + z)).getBlock().equals(
							DeepWatersBlocks.OXYGENATOR.get()))
					{
						replace = false;
					}
				}
			}
		}
		if (!world.getBlockState(new BlockPos(xPos + 1, yPos, zPos)).equals(WATER))
		{
			if (!world.getBlockState(new BlockPos(xPos - 1, yPos, zPos)).equals(WATER))
			{
				if (!world.getBlockState(new BlockPos(xPos, yPos + 1, zPos)).equals(WATER))
				{
					if (!world.getBlockState(new BlockPos(xPos, yPos - 1, zPos)).equals(WATER))
					{
						if (!world.getBlockState(new BlockPos(xPos, yPos, zPos + 1)).equals(WATER))
						{
							if (!world.getBlockState(new BlockPos(xPos, yPos, zPos - 1)).equals(WATER))
							{
								replace = false;
							}
						}
					}
				}
			}
		}

		PlayerEntity player = event.getPlayer();
		if (replace && yPos <= 229 && player.dimension == DimensionType.byName(
				ForgeBusEventSubscriber.DEEPWATERSDIMENSION))
		{
			if (player.canHarvestBlock(event.getState()) && !player.isCreative())
			{
				world.destroyBlock(pos, true);
			}
			else
			{
				world.destroyBlock(pos, false);

			}
			world.setBlockState(pos, WATER, 1);
		}
	}


}
