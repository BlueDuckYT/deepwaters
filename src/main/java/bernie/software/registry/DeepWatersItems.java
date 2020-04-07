package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.item.DeepWatersItem;
import bernie.software.item.tool.DeepWatersAxeItem;
import bernie.software.item.tool.DeepWatersPickaxeItem;
import bernie.software.item.tool.DeepWatersShovelItem;
import bernie.software.item.tool.DeepWatersSwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DeepWatersItems {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, DeepWatersMod.ModID);

    public static final RegistryObject<Item> SALT_CRYSTAL = ITEMS.register("salt_crystal", () -> new DeepWatersItem());
    public static final RegistryObject<Item> PEARL = ITEMS.register("pearl", () -> new DeepWatersItem());
    public static final RegistryObject<Item> PRISMARINE_INGOT = ITEMS.register("prismarine_ingot", () -> new DeepWatersItem());
    public static final RegistryObject<Item> PRISMARINE_NUGGET = ITEMS.register("prismarine_nugget", () -> new DeepWatersItem());

    public static final RegistryObject<Item> PRISMARINE_SWORD = ITEMS.register("prismarine_sword", () -> new DeepWatersSwordItem(DeepWatersItemTiers.PRISMARINE));
    public static final RegistryObject<Item> PRISMARINE_PICKAXE = ITEMS.register("prismarine_pickaxe", () -> new DeepWatersPickaxeItem(DeepWatersItemTiers.PRISMARINE));
    public static final RegistryObject<Item> PRISMARINE_AXE = ITEMS.register("prismarine_axe", () -> new DeepWatersAxeItem(DeepWatersItemTiers.PRISMARINE));
    public static final RegistryObject<Item> PRISMARINE_SHOVEL = ITEMS.register("prismarine_shovel", () -> new DeepWatersShovelItem(DeepWatersItemTiers.PRISMARINE));


    public static final RegistryObject<Item> SHARK_TOOTH = ITEMS.register("sharktooth", () -> new DeepWatersItem());
    public static final RegistryObject<Item> PEAL_WAND = ITEMS.register("pearl_wand", () -> new DeepWatersItem()); //replace with PearlWandItem when the time comes

}
