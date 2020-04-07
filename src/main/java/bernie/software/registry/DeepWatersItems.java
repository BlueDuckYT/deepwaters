package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.item.DeepWatersItem;
import bernie.software.item.ModdedSpawnEggItem;
import bernie.software.item.armor.DeepWatersArmorItem;
import bernie.software.item.tool.DeepWatersAxeItem;
import bernie.software.item.tool.DeepWatersPickaxeItem;
import bernie.software.item.tool.DeepWatersShovelItem;
import bernie.software.item.tool.DeepWatersSwordItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DeepWatersItems
{

	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, DeepWatersMod.ModID);

	public static final RegistryObject<Item> SALT_CRYSTAL = ITEMS.register("salt_crystal", () -> new DeepWatersItem());
	public static final RegistryObject<Item> PEARL = ITEMS.register("pearl", () -> new DeepWatersItem());
	public static final RegistryObject<Item> PRISMARINE_INGOT = ITEMS.register("prismarine_ingot", () -> new DeepWatersItem());
	public static final RegistryObject<Item> PRISMARINE_NUGGET = ITEMS.register("prismarine_nugget", () -> new DeepWatersItem());

	public static final RegistryObject<Item> PRISMARINE_SWORD = ITEMS.register("prismarine_sword", () -> new DeepWatersSwordItem(DeepWatersItemTiers.PRISMARINE).addToolTip("Increased damage underwater"));
	public static final RegistryObject<Item> PRISMARINE_PICKAXE = ITEMS.register("prismarine_pickaxe", () -> new DeepWatersPickaxeItem(DeepWatersItemTiers.PRISMARINE).addToolTip("Increased mining speed underwater"));
	public static final RegistryObject<Item> PRISMARINE_AXE = ITEMS.register("prismarine_axe", () -> new DeepWatersAxeItem(DeepWatersItemTiers.PRISMARINE).addToolTip("Increased breaking speed underwater"));
	public static final RegistryObject<Item> PRISMARINE_SHOVEL = ITEMS.register("prismarine_shovel", () -> new DeepWatersShovelItem(DeepWatersItemTiers.PRISMARINE).addToolTip("Increased breaking speed underwater"));

	public static final RegistryObject<Item> PRISMARINE_HELMET = ITEMS.register("prismarine_helmet", () -> new DeepWatersArmorItem(DeepWatersArmorMaterials.PRISMARINE, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> PRISMARINE_CHESTPLATE = ITEMS.register("prismarine_chestplate", () -> new DeepWatersArmorItem(DeepWatersArmorMaterials.PRISMARINE, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> PRISMARINE_LEGGINGS = ITEMS.register("prismarine_leggings", () -> new DeepWatersArmorItem(DeepWatersArmorMaterials.PRISMARINE, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> PRISMARINE_BOOTS = ITEMS.register("prismarine_boots", () -> new DeepWatersArmorItem(DeepWatersArmorMaterials.PRISMARINE, EquipmentSlotType.FEET));


	public static final RegistryObject<Item> SHARK_TOOTH = ITEMS.register("sharktooth", () -> new DeepWatersItem());
	public static final RegistryObject<Item> PEAL_WAND = ITEMS.register("pearl_wand", () -> new DeepWatersItem()); //replace with PearlWandItem when the time comes

	public static final RegistryObject<Item> KILLER_WIGGLER_SPAWN_EGG = ITEMS.register("killer_wiggler_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.KILLER_WIGGLER, 2892056, 12337464));
	public static final RegistryObject<Item> BLUFFERFISH_SPAWN_EGG = ITEMS.register("blufferfish_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.BLUFFERFISH, 5793118, 9937052));
	public static final RegistryObject<Item> CLAM_SPAWN_EGG = ITEMS.register("clam_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.CLAM, 14068356, 15501655));
	public static final RegistryObject<Item> STING_RAY_SPAWN_EGG = ITEMS.register("sting_ray_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.STING_RAY, 9009089, 2233927));
	public static final RegistryObject<Item> BABY_KRACKEN_SPAWN_EGG = ITEMS.register("baby_kracken_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.BABY_KRACKEN, 9596323, 9043968));
	public static final RegistryObject<Item> MUCK_GULPER_SPAWN_EGG = ITEMS.register("muck_gulper_spawn_egg", () -> new ModdedSpawnEggItem(
			DeepWatersEntities.MUCK_GULPER, 4337949, 9935773));

}
