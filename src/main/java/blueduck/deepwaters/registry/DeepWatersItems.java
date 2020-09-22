package blueduck.deepwaters.registry;

import blueduck.deepwaters.DeepWatersMod;
import blueduck.deepwaters.block.aquastone.AquastoneTorch;
import blueduck.deepwaters.client.renderer.Utils;
import blueduck.deepwaters.datagen.DeepWatersItemModels;
import blueduck.deepwaters.item.*;
import blueduck.deepwaters.item.armor.DeepWatersArmorItem;
import blueduck.deepwaters.item.event.ShieldEvents;
import blueduck.deepwaters.item.tool.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class DeepWatersItems
{
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, DeepWatersMod.ModID);

	//Ingots
	public static final RegistryObject<Item> AQUALITE_INGOT = ITEMS.register("aqualite_ingot", () -> new DeepWatersIngotItem(1150, 7, 7.4f, new Utils.ColorHelper(43,141,193).getRGB(), DeepWatersDamageFunctions.PRISMARINE_DAMGE,DeepWatersDamageFunctions.PRISMARINE_INVENTORY));
	public static final RegistryObject<Item> PRISMARINE_INGOT = ITEMS.register("prismarine_ingot", () -> new DeepWatersIngotItem(779, 5.5f, 1.6f, new Utils.ColorHelper(143, 195, 181).getRGB(), DeepWatersDamageFunctions.AQUALITE_DAMGE,DeepWatersDamageFunctions.PRISMARINE_INVENTORY));

	//Nuggets
	public static final RegistryObject<Item> PRISMARINE_NUGGET = ITEMS.register("prismarine_nugget", () -> new DeepWatersItem());

	//Food
	public static final RegistryObject<Item> BLUFFERFISH = ITEMS.register("blufferfish", () -> new DeepWatersItem(DeepWatersFoods.BLUFFERFISH));
	public static final RegistryObject<Item> COOKED_BLUFFERFISH = ITEMS.register("cooked_blufferfish", () -> new DeepWatersItem(DeepWatersFoods.COOKED_BLUFFERFISH));
	public static final RegistryObject<Item> SALTED_BLUFFERFISH = ITEMS.register("salted_blufferfish", () -> new DeepWatersItem(DeepWatersFoods.SALTED_BLUFFERFISH));

	public static final RegistryObject<Item> MUCK_GULPER = ITEMS.register("muck_gulper", () -> new DeepWatersItem(DeepWatersFoods.MUCK_GULPER));
	public static final RegistryObject<Item> COOKED_MUCK_GULPER = ITEMS.register("cooked_muck_gulper", () -> new DeepWatersItem(DeepWatersFoods.COOKED_MUCK_GULPER));
	public static final RegistryObject<Item> SALTED_MUCK_GULPER = ITEMS.register("salted_muck_gulper", () -> new DeepWatersItem(DeepWatersFoods.SALTED_MUCK_GULPER));


	//Weapons
	public static final RegistryObject<Item> PRISMARINE_SWORD = ITEMS.register("prismarine_sword", () -> new DeepWatersSwordItem(DeepWatersItemTiers.PRISMARINE).addToolTip("Increased damage underwater"));
	public static final RegistryObject<Item> AQUALITE_SWORD = ITEMS.register("aqualite_sword", () -> new DeepWatersSwordItem(DeepWatersItemTiers.AQUALITE).addToolTip("Increased damage underwater"));

	//Shields
	public static final RegistryObject<Item> PRISMARINE_SHIELD = ITEMS.register("prismarine_shield", () -> new DeepWatersShieldItem(DeepWatersShieldProperties.PRISMARINE,new ShieldEvents.PrismarineShielfEvent().getClass()).addToolTip("Allows you to dash in water."));
	public static final RegistryObject<Item> DARK_PRISMARINE_SHIELD = ITEMS.register("dark_prismarine_shield", () -> new DeepWatersShieldItem(DeepWatersShieldProperties.DARKPRISMARINE,new ShieldEvents.DarkPrismarine().getClass()).addToolTip("Allows you to dash in water.\nHalf the cooldown of the prismarine shield.\nDouble the speed of the prismarine shield."));

	//Tools
	public static final RegistryObject<Item> PRISMARINE_PICKAXE = ITEMS.register("prismarine_pickaxe", () -> new DeepWatersPickaxeItem(DeepWatersItemTiers.PRISMARINE).addToolTip("Increased mining speed underwater"));
	public static final RegistryObject<Item> PRISMARINE_AXE = ITEMS.register("prismarine_axe", () -> new DeepWatersAxeItem(DeepWatersItemTiers.PRISMARINE).addToolTip("Increased breaking speed underwater"));
	public static final RegistryObject<Item> PRISMARINE_SHOVEL = ITEMS.register("prismarine_shovel", () -> new DeepWatersShovelItem(DeepWatersItemTiers.PRISMARINE).addToolTip("Increased breaking speed underwater"));
	public static final RegistryObject<Item> AQUALITE_PICKAXE = ITEMS.register("aqualite_pickaxe", () -> new DeepWatersPickaxeItem(DeepWatersItemTiers.AQUALITE).addToolTip("Increased mining speed underwater"));
	public static final RegistryObject<Item> AQUALITE_AXE = ITEMS.register("aqualite_axe", () -> new DeepWatersAxeItem(DeepWatersItemTiers.AQUALITE).addToolTip("Increased breaking speed underwater"));
	public static final RegistryObject<Item> AQUALITE_SHOVEL = ITEMS.register("aqualite_shovel", () -> new DeepWatersShovelItem(DeepWatersItemTiers.AQUALITE).addToolTip("Increased breaking speed underwater"));
	public static final RegistryObject<Item> AQUALITE_HOE = ITEMS.register("aqualite_hoe", () -> new DeepWatersHoeItem(DeepWatersItemTiers.AQUALITE).addToolTip("Increased hoeing? speed underwater lol"));

	//Armor
	public static final RegistryObject<Item> PRISMARINE_HELMET = ITEMS.register("prismarine_helmet", () -> new DeepWatersArmorItem(DeepWatersArmorMaterials.PRISMARINE, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> PRISMARINE_CHESTPLATE = ITEMS.register("prismarine_chestplate", () -> new DeepWatersArmorItem(DeepWatersArmorMaterials.PRISMARINE, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> PRISMARINE_LEGGINGS = ITEMS.register("prismarine_leggings", () -> new DeepWatersArmorItem(DeepWatersArmorMaterials.PRISMARINE, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> PRISMARINE_BOOTS = ITEMS.register("prismarine_boots", () -> new DeepWatersArmorItem(DeepWatersArmorMaterials.PRISMARINE, EquipmentSlotType.FEET));

	public static final RegistryObject<Item> AQUASTONE_TORCH = ITEMS.register("aquastone_torch", () -> new AquastoneTorch.Item(new Item.Properties().group(DeepWatersItemGroups.DEEPWATERS_BLOCKS)));

	//Misc
	public static final RegistryObject<Item> CRYSTALINE_CORAL = ITEMS.register("crystaline_coral", () -> new DeepWatersItem());
	public static final RegistryObject<Item> DEAD_CRYSTALINE_CORAL = ITEMS.register("decayed_crystaline_coral", () -> new DeepWatersItem());
	public static final RegistryObject<Item> SHARK_TOOTH = ITEMS.register("sharktooth", () -> new DeepWatersItem());
	public static final RegistryObject<Item> PEARL_WAND = ITEMS.register("pearl_wand", () -> new DeepWatersItem()); //replace with PearlWandItem when the time comes
	public static final RegistryObject<Item> POWER_STONE = ITEMS.register("power_stone", () -> new DeepWatersAbstractRuneItem(new Item.Properties().maxStackSize(1).group(DeepWatersItemGroups.DEEPWATERS_ITEMS)));
	public static final RegistryObject<Item> SALT_CRYSTAL = ITEMS.register("salt_crystal", () -> new DeepWatersItem());
	public static final RegistryObject<Item> PEARL = ITEMS.register("pearl", () -> new DeepWatersItem());
	public static final RegistryObject<Item> AQUASTONE_DUST = registerNormalItem("aquastone_dust", () -> new DeepWatersItem());

	//Fish buckets




	//Spawn eggs
	public static final RegistryObject<Item> KILLER_WIGGLER_SPAWN_EGG = ITEMS.register("killer_wiggler_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.KILLER_WIGGLER, 2892056, 12337464));
	public static final RegistryObject<Item> BLUFFERFISH_SPAWN_EGG = ITEMS.register("blufferfish_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.BLUFFERFISH, 5793118, 9937052));
	public static final RegistryObject<Item> STING_RAY_SPAWN_EGG = ITEMS.register("sting_ray_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.STING_RAY, 9009089, 2233927));
	public static final RegistryObject<Item> BABY_KRACKEN_SPAWN_EGG = ITEMS.register("baby_kracken_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.BABY_KRACKEN, 9596323, 9043968));
	public static final RegistryObject<Item> MUCK_GULPER_SPAWN_EGG = ITEMS.register("muck_gulper_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.MUCK_GULPER, 4337949, 9935773));
	public static final RegistryObject<Item> COLORFUL_FISH_SPAWN_EGG = ITEMS.register("colorful_fish_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.COLORFUL_FISH, 11393254, 3329330));
	public static final RegistryObject<Item> DEEP_GLIDER_SPAWN_EGG = ITEMS.register("deep_glider_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.DEEP_GLIDER, 590079, 11393254));
	public static final RegistryObject<Item> SKULL_FISH_SPAWN_EGG = ITEMS.register("skull_fish_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.SKULL_FISH, 16711680, 16768994));
	public static final RegistryObject<Item> DONUT_FISH_SPAWN_EGG = ITEMS.register("donut_fish_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.DONUT_FISH, 11772160, 480893));
	public static final RegistryObject<Item> LEG_FISH_SPAWN_EGG = ITEMS.register("leg_fish_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.LEG_FISH, 524080, 14211862));
	public static final RegistryObject<Item> CORAL_CRAWLER_SPAWN_EGG = ITEMS.register("coral_crawler_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.CORAL_CRAWLER, 3620433, 15482449));
	public static final RegistryObject<Item> JUNGLE_FISH_SPAWN_EGG = ITEMS.register("jungle_fish_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.JUNGLE_FISH, 16716544, 16759552));
	public static final RegistryObject<Item> JELLYFISH_SPAWN_EGG = ITEMS.register("jellyfish_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.JELLYFISH, 3093151, 3085179));
	public static final RegistryObject<Item> SUNKEN_WANDERER_SPAWN_EGG = ITEMS.register("sunken_wanderer_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.SUNKEN_WANDERER, 2560794, 16777215));
	public static final RegistryObject<Item> SHARK_SPAWN_EGG = ITEMS.register("shark_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.SHARK, 20735, 16777215));
	public static final RegistryObject<Item> SEA_ANGEL_SPAWN_EGG = ITEMS.register("sea_angel_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.SEA_ANGEL, 12517478, 4587775));
	public static final RegistryObject<Item> SEA_URCHIN_SPAWN_EGG = ITEMS.register("sea_urchin_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.SEA_URCHIN, 20735, 13617609));
	public static final RegistryObject<Item> PHANTOM_STINGRAY_SPAWN_EGG = ITEMS.register("phantom_stingray_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.PHANTOM_STINGRAY, 6716671, 6716566));
	public static final RegistryObject<Item> SNEAGLE_SPAWN_EGG = ITEMS.register("sneagle_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.SNEAGLE, 1909247, 14971647));
	public static final RegistryObject<Item> BLUFFERFISH_BUCKET = registerNormalItem("bucket_of_blufferfish", () -> new ModdedFishBucketItem(DeepWatersEntities.BLUFFERFISH));


	public static <T extends Item> RegistryObject<T> registerNormalItem(String registryName, Supplier<? extends Item> item)
	{
		RegistryObject<? extends Item> registryObject = ITEMS.register(registryName, item);
		DeepWatersItemModels.NormalItems.add((RegistryObject<Item>) registryObject);
		return (RegistryObject<T>) registryObject;
	}

}
