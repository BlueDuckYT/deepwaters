package bernie.software;

import bernie.software.client.renderer.entity.*;
import bernie.software.client.renderer.model.KillerWigglerBody;
import bernie.software.client.renderer.model.KillerWigglerHead;
import bernie.software.client.renderer.model.KillerWigglerTail;
import bernie.software.entity.*;
import bernie.software.entity.vehicle.SurgeVehicle;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientEventSusbcriber
{
	@SubscribeEvent
	public static void doClientStuff(final FMLClientSetupEvent event)
	{
		RenderingRegistry.registerEntityRenderingHandler(KillerWiggler.class, manager -> new WormRenderer(manager, new KillerWigglerHead(), new KillerWigglerBody(), new KillerWigglerTail(), new ResourceLocation("deepwaters" + ":textures/model/entity/killerwiggler.png")));
		RenderingRegistry.registerEntityRenderingHandler(BlufferFish.class, manager -> new BlufferFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(Stingray.class, manager -> new StingrayRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(BabyKracken.class, manager -> new BabyKrackenRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(MuckGulper.class, manager -> new MuckGulperRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(CoralCrawler.class, manager -> new CoralCrawlerRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DonutFish.class, manager -> new DonutFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(ColorfulFish.class, manager -> new ColorfulFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(LegFish.class, manager -> new LegFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(DeepGlider.class, manager -> new DeepGliderRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(SkullFish.class, manager -> new SkullFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(SurgeVehicle.class, manager -> new SurgeRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(JungleFish.class, manager -> new JungleFishRenderer(manager));
	}
}
