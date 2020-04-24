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
				ForgeBusEventSubscriber.DIMENSION_TYPE_RL))
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

	@SubscribeEvent
	public static void entitySpawnEvent(LivingSpawnEvent.CheckSpawn event)
	{
		try
		{
			SpawnReason spawnReason = event.getSpawnReason();
			if (spawnReason.equals(SpawnReason.NATURAL) || spawnReason.equals(SpawnReason.CHUNK_GENERATION))
			{
				Entity entity = event.getEntity();
				IWorld world = event.getWorld();
				if (entity instanceof CoralCrawler)
				{
					if (!attemptLandFind(event))
					{
						if (!attemptLandFind(event))
						{
							if (!attemptLandFind(event))
							{
								if (!attemptLandFind(event))
								{
									entity.remove();
									//event.setCanceled(true);
								}
							}
						}
					}

					int i = 0;
					for (i = 0; i <= 10; i++)
					{
						if (world.hasWater(entity.getPosition().down(i)))
						{
							entity.remove();
							event.setCanceled(true);
						}
					}
				}
				else if (entity instanceof AbstractFishEntity)
				{
					if (!world.hasWater(new BlockPos(event.getX(), event.getY() - 1, event.getZ())) &&
							!world.hasWater(new BlockPos(event.getX(), event.getY(), event.getZ())))
					{
						entity.remove();
						event.setCanceled(true);
					}
				}
			}
		}
		catch (Exception err)
		{
			DeepWatersMod.logger.log(Level.ERROR, err);
		}
	}

	private static boolean attemptLandFind(LivingSpawnEvent event)
	{
		IWorld world = event.getWorld();
		Entity entity = event.getEntity();
		BlockPos pos = entity.getPosition();
		int height = world.getHeight(Heightmap.Type.MOTION_BLOCKING, (int) entity.posX, (int) entity.posZ);

		if (HasWaterBelow(world, pos))
		{
			Random random = world.getRandom();
			Vec3d newPos = new Vec3d(random.nextInt(100), 0, random.nextInt(100));
			newPos = newPos.add(entity.getPositionVec());
			entity.setPosition(newPos.getX(), newPos.getY(), newPos.getZ());
			entity.setPosition(entity.posX, height + 1, entity.posZ);
			if (HasWaterBelow(world, new BlockPos(newPos)))
			{
				return false;
			}
		}
		return true;
	}

	static double fogCount1=0;
	static double prevFogCount=0;
	static double blendProgress=0;
	static double colorBlendProgress=0;
	static Color fogColor=Color.GREEN;
	static Color prevfogColor=Color.RED;

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void renderFog(RenderWorldLastEvent event) {
		try {
			PlayerEntity playerEntity = Minecraft.getInstance().player;
			if (playerEntity.posY<128) {
				if (playerEntity.dimension.getRegistryName().equals(ModEventSubscriber.DeepWatersDimension.getRegistryName())) {
					World world=playerEntity.world;
					GlStateManager.pushMatrix();
					GlStateManager.disableAlphaTest();
					GlStateManager.setProfile(GlStateManager.Profile.TRANSPARENT_MODEL);
					GlStateManager.enableBlend();
					GlStateManager.disableCull();
					GlStateManager.disableLighting();
					GlStateManager.disableTexture();
					net.minecraft.client.renderer.RenderHelper.disableStandardItemLighting();
					double fogDist=((playerEntity.getPositionVec().y/256))*500;
					try {
						fogDist*=(playerEntity.getActivePotionEffect(Effects.NIGHT_VISION).getAmplifier()+2)*2;
					} catch (Exception err) {}
//				double fogCount=((1-(playerEntity.getPositionVec().y/256))*1);
					double fogCount=0;
					if (blendProgress>=120) {
						if (playerEntity.posY>=128&&fogCount1!=0) {
							fogCount=0;
							fogCount1=fogCount;
							blendProgress=0;
						} else if (playerEntity.posY>=64&&playerEntity.posY<128&&fogCount1!=0.5) {
							fogCount=0.5;
							fogCount1=fogCount;
							blendProgress=0;
						} else if (fogCount1!=1&&playerEntity.posY<64) {
							fogCount=1;
							fogCount1=fogCount;
							blendProgress=0;
						} else {
							prevFogCount=fogCount1;
						}
					} else {
						blendProgress+=1;
					}
					if (colorBlendProgress>=120) {
						fogColor=prevfogColor;
						if (fogColor.getRGB()!=world.getBiome(playerEntity.getPosition()).getWaterFogColor()) {
							prevfogColor=new Color(world.getBiome(playerEntity.getPosition()).getWaterFogColor());
							colorBlendProgress=0;
						}
					} else {
						colorBlendProgress+=1;
					}
					float temp=(world.getBiome(playerEntity.getPosition()).getDefaultTemperature());
					for (int x=0; x<=(36); x++) {
						for (int y=0; y<=(36); y++) {
							for (int z2=0; z2<=1; z2++) {
								GlStateManager.pushMatrix();
								double z=((z2)*2f);
								int multiple=10;
								int yMultiple=10;
								double y1 = Math.cos(y * yMultiple) * (z);
								double y2 = Math.cos((y+1) * yMultiple) * (z);
								double y3 = Math.sin((y+1) * yMultiple) * (z);
								double y4 = Math.sin(y * yMultiple) * (z);
//							double x1 = Math.cos((x-y1) * multiple) * (z * fogDist);
								double x1 = ((Math.cos((x)*multiple))*(z*fogDist))-(y1*fogDist);
								double z1 = ((Math.sin((x)*multiple))*(z*fogDist))-(y4*fogDist);
								RenderHelper.triangle tri=new RenderHelper.triangle(
										((Math.cos((x+1)*multiple))*(z*fogDist))-(y2*fogDist),
										x1,
										x1,
										y1 * (fogDist),
										y1 * (fogDist),
										y2 * (fogDist),
										z1,
										((Math.sin((x+1)*multiple))*(z*fogDist))-(y3*fogDist),
										z1
								);
								Vec3d vec=playerEntity.getPositionVec();
								float totalLight=0;
								for (double i:new double[]{tri.x1,tri.x3}) {
									for (double j:new double[]{tri.y1,tri.y2}) {
										for (double k:new double[]{tri.z1,tri.z3}) {
											totalLight+=world.getLight(new BlockPos(vec.x+(i),vec.y+(j),vec.z+(k)));
											totalLight+=world.getLight(new BlockPos(vec.x+(i),vec.y,vec.z+(k)))/4;
											totalLight+=world.getLight(new BlockPos(vec.x,vec.y,vec.z+(k)))/8;
											totalLight+=world.getLight(new BlockPos(vec.x+(j),vec.y,vec.z))/8;
											totalLight+=world.getLight(new BlockPos(vec.x,vec.y,vec.z))/128;
										}
									}
								}
//							if (
//									world.getLight(new BlockPos(vec.x+tri.x2,vec.y,vec.z+tri.z1))<=0||
//									world.getLight(new BlockPos(vec.x+tri.x1,vec.y,vec.z+tri.z3))<=0
//							) {
								if (playerEntity.isInWater()) {
									double amt=blendProgress/120f;
									double amt2=colorBlendProgress/120f;
									double divisor=MathHelper.lerp((amt),prevFogCount,fogCount1);
									double colorRed=MathHelper.lerp((amt2),fogColor.getRed()/255f,prevfogColor.getRed()/255f);
									double colorBlue=MathHelper.lerp((amt2),fogColor.getBlue()/255f,prevfogColor.getBlue()/255f);
									double colorGreen=MathHelper.lerp((amt2),fogColor.getGreen()/255f,prevfogColor.getGreen()/255f);
									double colorAlpha=MathHelper.lerp((amt2),fogColor.getAlpha()/255f,prevfogColor.getAlpha()/255f);
									double alphaMultiplier=1f;
									if (playerEntity.posY>=100) {
										alphaMultiplier=playerEntity.posY-100;
										if (alphaMultiplier>=28) {
											alphaMultiplier=28;
										}
										alphaMultiplier/=4;
										alphaMultiplier+=1;
									}
									if (totalLight<=5) {
										RenderHelper.drawTriangle(tri,colorRed,colorBlue,colorGreen,((((fogCount1-(z/fogDist))/(10+(totalLight)))*divisor)/1)/(alphaMultiplier));
									}
//									RenderHelper.drawTriangle(tri,1,0,0,0.01);
								}
//							}
								if(true) {
								}
								GlStateManager.popMatrix();
							}
						}
					}
					GlStateManager.enableCull();
					GlStateManager.enableTexture();
					GlStateManager.unsetProfile(GlStateManager.Profile.TRANSPARENT_MODEL);
				}
			}
			GlStateManager.popMatrix();
		} catch (Exception err) {
			DeepWatersMod.logger.log(Level.WARN,"Render Failiure.");
		}
	}

	private static boolean HasWaterBelow(IWorld world, BlockPos pos)
	{
		return world.hasWater(pos) || world.hasWater(pos.down()) || world.hasWater(pos.down(2)) || world.hasWater(
				pos.down(3));
	}

}
