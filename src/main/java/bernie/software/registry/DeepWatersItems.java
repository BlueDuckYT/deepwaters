package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.item.DeepWatersItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public class DeepWatersItems {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, DeepWatersMod.ModID);

    public static final RegistryObject<Item> SALT_CRYSTAL = ITEMS.register("salt_crystal", () -> new DeepWatersItem());
    public static final RegistryObject<Item> PEARL = ITEMS.register("pearl", () -> new DeepWatersItem());
    public static final RegistryObject<Item> SHARK_TOOTH = ITEMS.register("sharktooth", () -> new DeepWatersItem());
    public static final RegistryObject<Item> PEAL_WAND = ITEMS.register("pearl_wand", () -> new DeepWatersItem());

}
