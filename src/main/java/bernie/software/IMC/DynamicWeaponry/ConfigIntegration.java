package bernie.software.IMC.DynamicWeaponry;

import bernie.software.DeepWatersMod;
import bernie.software.item.DeepWatersIngotItem;
import bernie.software.registry.DeepWatersItems;
import com.google.common.collect.ImmutableList;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import tfc.dynamic_weaponary.API.Events.SetupConfigsEvent;
import tfc.dynamic_weaponary.API.RegistryHelper;
import tfc.dynamic_weaponary.CalculationRegistry;
import tfc.dynamic_weaponary.Other.Config;
import tfc.dynamic_weaponary.Utils.CFGHelper;
import tfc.dynamic_weaponary.Utils.Tool.Material;

import java.io.File;

public class ConfigIntegration {
	private static void GenConfig(File path,String text)
	{
		Config.createAndWrite(path, DeepWatersMod.ModID, text);
	
	}
	
	private static final ImmutableList<RegistryObject<Item>> ingots=ImmutableList.of(
			DeepWatersItems.PRISMARINE_INGOT,
			DeepWatersItems.AQUALITE_INGOT
	);
	
	public static void GenConfig(File path)
	{
		StringBuilder text= new StringBuilder();
		ingots.forEach((item)-> text.append(getStringFromRegistry(item)));
		GenConfig(path, text.toString());
	
	}
	
	private static String getStringFromRegistry(RegistryObject<Item> itemRegistryObject)
	{
		if (itemRegistryObject.get() instanceof DeepWatersIngotItem)
		{
			Material mat=getMaterialFromIngotItem((DeepWatersIngotItem)itemRegistryObject.get());
			return new CFGHelper.matString(itemRegistryObject.get(),mat.durability,mat.strength,mat.weight,mat.color).toString();
		
		}
		return  "";
		
	}
	
	private static Material getMaterialFromIngotItem(DeepWatersIngotItem ingotItem)
	{
		return new Material(ingotItem.Durability,ingotItem.Strength,ingotItem.Weight,ingotItem.Color);

	}
	
	public static void Register(IEventBus bus)
	{
		bus.addListener(ConfigIntegration::setupConfigs);
		bus.addListener(ConfigIntegration::registerEvents);
	
	}
	
	private static void setupConfigs(SetupConfigsEvent.MakeFiles event)
	{
		GenConfig(event.path);
		
	}
	
	private static void registerEvents(FMLCommonSetupEvent event)
	{
		ingots.forEach((ingot)->{
			System.out.println(ingot.get().getRegistryName());
			if (ingot.get() instanceof DeepWatersIngotItem) {
				DeepWatersIngotItem item=(DeepWatersIngotItem)ingot.get();
				RegistryHelper.RegisterEvent(item.InvTickMethod, RegistryHelper.eventTypes.INV_TICK,item);
				CalculationRegistry.registerEvent(item.getRegistryName(), "AttackBoost", item.AttackBoostFunction);
			}
		});
		
	}
}
