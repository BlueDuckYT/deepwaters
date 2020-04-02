package bernie.software;

import bernie.software.registry.DeepWatersBiomes;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DeepWatersMod.ModID)
public class DeepWatersMod
{

	public DeepWatersMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		DeepWatersBlocks.BLOCKS.register(bus);
		DeepWatersItems.ITEMS.register(bus);
		DeepWatersBiomes.BIOMES.register(bus);
	}

	public static final String ModID = "deepwaters";
}