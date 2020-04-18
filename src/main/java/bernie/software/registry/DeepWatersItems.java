package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.block.aquastone.RedstoneTorch;
import bernie.software.item.DeepWatersAbstractRuneItem;
import bernie.software.item.DeepWatersItem;
import bernie.software.item.ModdedSpawnEggItem;
import bernie.software.item.armor.DeepWatersArmorItem;
import bernie.software.item.events.ShieldEvents;
import bernie.software.item.tool.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.awt.*;

public class DeepWatersItems
{

	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, DeepWatersMod.ModID);

	public static final RegistryObject<Item> SALT_CRYSTAL = ITEMS.register("salt_crystal", () -> new DeepWatersItem());
	public static final RegistryObject<Item> PEARL = ITEMS.register("pearl", () -> new DeepWatersItem());
	public static final RegistryObject<Item> PRISMARINE_INGOT = ITEMS.register("prismarine_ingot", () -> new DeepWatersItem());
	public static final RegistryObject<Item> PRISMARINE_NUGGET = ITEMS.register("prismarine_nugget", () -> new DeepWatersItem());
	public static final RegistryObject<Item> BLUFFERFISH = ITEMS.register("blufferfish", () -> new DeepWatersItem(DeepWatersFoods.BLUFFERFISH));
	public static final RegistryObject<Item> COOKED_BLUFFERFISH = ITEMS.register("cooked_blufferfish", () -> new DeepWatersItem(DeepWatersFoods.COOKED_BLUFFERFISH));
	public static final RegistryObject<Item> SALTED_BLUFFERFISH = ITEMS.register("salted_blufferfish", () -> new DeepWatersItem(DeepWatersFoods.SALTED_BLUFFERFISH));
	public static final RegistryObject<Item> MUCK_GULPER = ITEMS.register("muck_gulper", () -> new DeepWatersItem(DeepWatersFoods.MUCK_GULPER));
	public static final RegistryObject<Item> COOKED_MUCK_GULPER = ITEMS.register("cooked_muck_gulper", () -> new DeepWatersItem(DeepWatersFoods.COOKED_MUCK_GULPER));
	public static final RegistryObject<Item> SALTED_MUCK_GULPER = ITEMS.register("salted_muck_gulper", () -> new DeepWatersItem(DeepWatersFoods.SALTED_MUCK_GULPER));
	public static final RegistryObject<Item> AQUASTONE_TORCH = ITEMS.register("aquastone_torch", () -> new RedstoneTorch.Item(new Item.Properties().group(DeepWatersItemGroups.DEEPWATERS_ITEMS)));

	public static final RegistryObject<Item> PRISMARINE_SWORD = ITEMS.register("prismarine_sword", () -> new DeepWatersSwordItem(DeepWatersItemTiers.PRISMARINE).addToolTip("Increased damage underwater"));
	public static final RegistryObject<Item> PRISMARINE_PICKAXE = ITEMS.register("prismarine_pickaxe", () -> new DeepWatersPickaxeItem(DeepWatersItemTiers.PRISMARINE).addToolTip("Increased mining speed underwater"));
	public static final RegistryObject<Item> PRISMARINE_AXE = ITEMS.register("prismarine_axe", () -> new DeepWatersAxeItem(DeepWatersItemTiers.PRISMARINE).addToolTip("Increased breaking speed underwater"));
	public static final RegistryObject<Item> PRISMARINE_SHOVEL = ITEMS.register("prismarine_shovel", () -> new DeepWatersShovelItem(DeepWatersItemTiers.PRISMARINE).addToolTip("Increased breaking speed underwater"));
	public static final RegistryObject<Item> PRISMARINE_SHIELD = ITEMS.register("prismarine_shield", () -> new DeepWatersShieldItem(DeepWatersShieldProperties.PRISMARINE,new ShieldEvents.Prismarine().getClass()).addToolTip("Allows you to dash in water"));

	public static final RegistryObject<Item> PRISMARINE_HELMET = ITEMS.register("prismarine_helmet", () -> new DeepWatersArmorItem(DeepWatersArmorMaterials.PRISMARINE, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> PRISMARINE_CHESTPLATE = ITEMS.register("prismarine_chestplate", () -> new DeepWatersArmorItem(DeepWatersArmorMaterials.PRISMARINE, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> PRISMARINE_LEGGINGS = ITEMS.register("prismarine_leggings", () -> new DeepWatersArmorItem(DeepWatersArmorMaterials.PRISMARINE, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> PRISMARINE_BOOTS = ITEMS.register("prismarine_boots", () -> new DeepWatersArmorItem(DeepWatersArmorMaterials.PRISMARINE, EquipmentSlotType.FEET));

	public static final RegistryObject<Item> POWER_STONE = ITEMS.register("power_stone", () -> new DeepWatersAbstractRuneItem(new Item.Properties().maxStackSize(1).group(DeepWatersItemGroups.DEEPWATERS_ITEMS)));

	public static final RegistryObject<Item> SHARK_TOOTH = ITEMS.register("sharktooth", () -> new DeepWatersItem());
	public static final RegistryObject<Item> PEAL_WAND = ITEMS.register("pearl_wand", () -> new DeepWatersItem()); //replace with PearlWandItem when the time comes

	public static final RegistryObject<Item> KILLER_WIGGLER_SPAWN_EGG = ITEMS.register("killer_wiggler_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.KILLER_WIGGLER, 2892056, 12337464));
	public static final RegistryObject<Item> EEL_SPAWN_EGG = ITEMS.register("eel_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.EEL, Color.RED.getRed(), Color.GREEN.getRGB()));
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


}
