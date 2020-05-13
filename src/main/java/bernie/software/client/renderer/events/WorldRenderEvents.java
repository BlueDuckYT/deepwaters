package bernie.software.client.renderer.events;

import bernie.software.DeepWatersMod;
import bernie.software.ModEventSubscriber;
import bernie.software.client.renderer.Utils;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.CoralFanBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;

import java.awt.*;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class WorldRenderEvents {

    static double fogDensity = 0;
    static double prevFogDensity = 0;
    static double blendProgress = 120;
    static double colorBlendProgress = 120;
    static Utils.ColorHelper fogColor = Utils.ColorHelper.BLUE;
    static Utils.ColorHelper prevfogColor = Utils.ColorHelper.BLUE;

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void renderFog(RenderWorldLastEvent event)
    {
//		try {
//			PlayerEntity playerEntity = Minecraft.getInstance().player;
//			if (playerEntity.getPosY()<128) {
//				if (playerEntity.dimension.getRegistryName().equals(ModEventSubscriber.DeepWatersDimension.getRegistryName())) {
//					World world=playerEntity.world;
//					GlStateManager.pushMatrix();
//					GlStateManager.disableAlphaTest();
//					GlStateManager.setProfile(GlStateManager.Profile.TRANSPARENT_MODEL);
//					GlStateManager.enableBlend();
//					GlStateManager.disableCull();
//					GlStateManager.disableLighting();
//					GlStateManager.disableTexture();
//					net.minecraft.client.renderer.RenderHelper.disableStandardItemLighting();
//					double fogDist=((playerEntity.getPositionVec().y/256))*500;
//					try {
//						fogDist*=(playerEntity.getActivePotionEffect(Effects.NIGHT_VISION).getAmplifier()+2)*2;
//					} catch (Exception err) {}
////				double fogCount=((1-(playerEntity.getPositionVec().y/256))*1);
//					double fogCount=0;
//					if (blendProgress>=120) {
//						if (playerEntity.getPosY()>=128&&fogCount1!=0) {
//							fogCount=0;
//							fogCount1=fogCount;
//							blendProgress=0;
//						} else if (playerEntity.getPosY()>=64&&playerEntity.getPosY()<128&&fogCount1!=0.5) {
//							fogCount=0.5;
//							fogCount1=fogCount;
//							blendProgress=0;
//						} else if (fogCount1!=1&&playerEntity.getPosY()<64) {
//							fogCount=1;
//							fogCount1=fogCount;
//							blendProgress=0;
//						} else {
//							prevFogCount=fogCount1;
//						}
//					} else {
//						blendProgress+=1;
//					}
//					if (colorBlendProgress>=120) {
//						fogColor=prevfogColor;
//						if (fogColor.getRGB()!=world.getBiome(playerEntity.getPosition()).getWaterFogColor()) {
//							prevfogColor=new Color(world.getBiome(playerEntity.getPosition()).getWaterFogColor());
//							colorBlendProgress=0;
//						}
//					} else {
//						colorBlendProgress+=1;
//					}
//					float temp=(world.getBiome(playerEntity.getPosition()).getDefaultTemperature());
//					for (int x=0; x<=(36); x++) {
//						for (int y=0; y<=(36); y++) {
//							for (int z2=0; z2<=1; z2++) {
//								GlStateManager.pushMatrix();
//								double z=((z2)*2f);
//								int multiple=10;
//								int yMultiple=10;
//								double y1 = Math.cos(y * yMultiple) * (z);
//								double y2 = Math.cos((y+1) * yMultiple) * (z);
//								double y3 = Math.sin((y+1) * yMultiple) * (z);
//								double y4 = Math.sin(y * yMultiple) * (z);
////							double x1 = Math.cos((x-y1) * multiple) * (z * fogDist);
//								double x1 = ((Math.cos((x)*multiple))*(z*fogDist))-(y1*fogDist);
//								double z1 = ((Math.sin((x)*multiple))*(z*fogDist))-(y4*fogDist);
//								RenderHelper.triangle tri=new RenderHelper.triangle(
//										((Math.cos((x+1)*multiple))*(z*fogDist))-(y2*fogDist),
//										x1,
//										x1,
//										y1 * (fogDist),
//										y1 * (fogDist),
//										y2 * (fogDist),
//										z1,
//										((Math.sin((x+1)*multiple))*(z*fogDist))-(y3*fogDist),
//										z1
//								);
//								Vec3d vec=playerEntity.getPositionVec();
//								float totalLight=0;
//								for (double i:new double[]{tri.x1,tri.x3}) {
//									for (double j:new double[]{tri.y1,tri.y2}) {
//										for (double k:new double[]{tri.z1,tri.z3}) {
//											totalLight+=world.getLight(new BlockPos(vec.x+(i),vec.y+(j),vec.z+(k)));
//											totalLight+=world.getLight(new BlockPos(vec.x+(i),vec.y,vec.z+(k)))/4;
//											totalLight+=world.getLight(new BlockPos(vec.x,vec.y,vec.z+(k)))/8;
//											totalLight+=world.getLight(new BlockPos(vec.x+(j),vec.y,vec.z))/8;
//											totalLight+=world.getLight(new BlockPos(vec.x,vec.y,vec.z))/128;
//										}
//									}
//								}
////							if (
////									world.getLight(new BlockPos(vec.x+tri.x2,vec.y,vec.z+tri.z1))<=0||
////									world.getLight(new BlockPos(vec.x+tri.x1,vec.y,vec.z+tri.z3))<=0
////							) {
//								if (playerEntity.isInWater()) {
//									double amt=blendProgress/120f;
//									double amt2=colorBlendProgress/120f;
//									double divisor=MathHelper.lerp((amt),prevFogCount,fogCount1);
//									double colorRed=MathHelper.lerp((amt2),fogColor.getRed()/255f,prevfogColor.getRed()/255f);
//									double colorBlue=MathHelper.lerp((amt2),fogColor.getBlue()/255f,prevfogColor.getBlue()/255f);
//									double colorGreen=MathHelper.lerp((amt2),fogColor.getGreen()/255f,prevfogColor.getGreen()/255f);
//									double colorAlpha=MathHelper.lerp((amt2),fogColor.getAlpha()/255f,prevfogColor.getAlpha()/255f);
//									double alphaMultiplier=1f;
//									if (playerEntity.getPosY()>=100) {
//										alphaMultiplier=playerEntity.getPosY()-100;
//										if (alphaMultiplier>=28) {
//											alphaMultiplier=28;
//										}
//										alphaMultiplier/=4;
//										alphaMultiplier+=1;
//									}
//									if (totalLight<=5) {
//										RenderHelper.drawTriangle(tri,colorRed,colorBlue,colorGreen,((((fogCount1-(z/fogDist))/(10+(totalLight)))*divisor)/1)/(alphaMultiplier));
//									}
////									RenderHelper.drawTriangle(tri,1,0,0,0.01);
//								}
////							}
//								if(true) {
//								}
//								GlStateManager.popMatrix();
//							}
//						}
//					}
//					GlStateManager.enableCull();
//					GlStateManager.enableTexture();
//					GlStateManager.unsetProfile(GlStateManager.Profile.TRANSPARENT_MODEL);
//				}
//				GlStateManager.popMatrix();
//			}
//		} catch (Exception err) {
//			DeepWatersMod.logger.log(Level.WARN,"Render Failiure.");
//		}
    }

    @SubscribeEvent
    public static void fogEvent(EntityViewRenderEvent event)
    {
        PlayerEntity playerEntity = Minecraft.getInstance().player;
        World world = playerEntity.world;
        Vec3d vec = playerEntity.getPositionVec();
        boolean waterlogged=false;
        if (event.getInfo().getBlockAtCamera().getBlock() instanceof IWaterLoggable) {
            try {
                waterlogged=event.getInfo().getBlockAtCamera().getBlockState().get(CoralFanBlock.WATERLOGGED);
            } catch (Exception err) {
                waterlogged=true;
            }

        } else if (event.getInfo().getBlockAtCamera().getFluidState().getFluid().equals(Fluids.WATER.getFluid())) {
            waterlogged=true;
        }
        if (playerEntity.dimension.getRegistryName().equals(ModEventSubscriber.DeepWatersDimension.getRegistryName())&&
            (event.getInfo().getBlockAtCamera().getMaterial().isLiquid()||
            waterlogged)) {
            float baseDensity = 1 - ((float) (playerEntity.getPosY()) / 200);
            float defaultDensity=0.025f;
            float density = defaultDensity;
            if (playerEntity.getPosY() <= 20)
            {
                density = 1;
            }
            else if (playerEntity.getPosY() <= 31)
            {
                density = baseDensity / 3;
            }
            if (playerEntity.getPosY() <= 63)
            {
                density = baseDensity / 6;
            }
            else if (playerEntity.getPosY() <= 128)
            {
                density = baseDensity / 12;
            }
            try
            {
                density /= (playerEntity.getActivePotionEffect(Effects.NIGHT_VISION).getAmplifier() + 2) * 2;
            }
            catch (Exception err)
            {
            }
            int totalLight = world.getLight(new BlockPos(vec.x, vec.y, vec.z)) + 6;
            density /= (totalLight / 6f);
            if (density<=defaultDensity) {
                density=defaultDensity;
            }
            if (event instanceof EntityViewRenderEvent.FogDensity)
            {
                if ((prevFogDensity - density) != 0)
                {
                    if (blendProgress >= 120)
                    {
                        blendProgress = 0;
                        prevFogDensity = fogDensity;
                    }
                    else if (blendProgress == 0)
                    {
                        blendProgress += 1;
                        fogDensity = density;
                    }
                    else
                    {
                        blendProgress += 1;
                    }
                }
//			((EntityViewRenderEvent.FogDensity)event).setDensity(1f-(1f/(float)(fogCount*fogDist)));
                double amt = blendProgress / 120f;
//			DeepWatersMod.logger.log(Level.INFO,"1:"+amt);
                double renderDensity = (MathHelper.lerp(amt, prevFogDensity, fogDensity));
                ((EntityViewRenderEvent.FogDensity) event).setDensity((float) renderDensity);
            }

            if (event instanceof EntityViewRenderEvent.FogColors&&playerEntity.getPosY()<=256)
            {
                double amt = blendProgress / 120f;
                double renderDensity = (MathHelper.lerp(amt, prevFogDensity, fogDensity));
                if (colorBlendProgress >= 120)
                {
                    fogColor = prevfogColor;
                    if (fogColor.getRGB() != world.getBiome(playerEntity.getPosition()).getWaterFogColor())
                    {
                        prevfogColor = new Utils.ColorHelper(world.getBiome(playerEntity.getPosition()).getWaterFogColor());
                        if (playerEntity.getPosY()<=128) {
                            prevfogColor = new Utils.ColorHelper(
                                    (int) (prevfogColor.getRed() * (1 - (renderDensity * 4))),
                                    (int) (prevfogColor.getGreen() * (1 - (renderDensity * 4))),
                                    (int) (prevfogColor.getBlue() * (1 - (renderDensity * 4)))
                            );
                        }
                        colorBlendProgress = 0;
                    }
                }
                else
                {
                    colorBlendProgress += 1;
                }
                double amt2 = colorBlendProgress / 120f;
                double colorRed = MathHelper.lerp((amt2), fogColor.getRed() / 255f, prevfogColor.getRed() / 255f);
                double colorBlue = MathHelper.lerp((amt2), fogColor.getBlue() / 255f, prevfogColor.getBlue() / 255f);
                double colorGreen = MathHelper.lerp((amt2), fogColor.getGreen() / 255f, prevfogColor.getGreen() / 255f);
                colorRed=MathHelper.lerp(renderDensity*4,colorRed,fogColor.darker(0.23).getRed()/255f);
                colorBlue=MathHelper.lerp(renderDensity*4,colorBlue,fogColor.darker(0.23).getBlue()/255f);
                colorGreen=MathHelper.lerp(renderDensity*5,colorGreen,fogColor.darker(0.23).getGreen()/255f);
//                DeepWatersMod.logger.log(Level.INFO,renderDensity);
//                if (playerEntity.getPosY()>=128) {
//                    DeepWatersMod.logger.log(Level.INFO,1-renderDensity);
//                    DeepWatersMod.logger.log(Level.INFO,colorBlue);
//                    colorRed = MathHelper.lerp((renderDensity), colorRed, fogColor.getRed() / 255f);
//                    colorBlue = MathHelper.lerp((renderDensity), colorBlue, fogColor.getBlue() / 255f);
//                    colorGreen = MathHelper.lerp((renderDensity), colorGreen, fogColor.getGreen() / 255f);
//                    DeepWatersMod.logger.log(Level.INFO,colorBlue);
//                }
                ((EntityViewRenderEvent.FogColors) event).setRed((float) colorRed);
                ((EntityViewRenderEvent.FogColors) event).setBlue((float) colorBlue);
                ((EntityViewRenderEvent.FogColors) event).setGreen((float) colorGreen);
            }
            else if (event instanceof EntityViewRenderEvent.RenderFogEvent)
            {
            }
            if (event.isCancelable())
            {
                RenderSystem.fogStart((1 - density));
                RenderSystem.fogEnd((1 - density));
                event.setCanceled(true);
            }
        } else {
            prevfogColor = new Utils.ColorHelper(world.getBiome(playerEntity.getPosition()).getWaterFogColor());
            fogColor = prevfogColor;
            colorBlendProgress = 0;
        }
    }
}
