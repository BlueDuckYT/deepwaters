package bernie.software.registry;

import net.minecraft.item.Item;

public enum DeepWatersShieldProperties {
    PRISMARINE(450),
    DARKPRISMARINE(900);

    int durability=0;
    DeepWatersShieldProperties(int durability) {
        this.durability=durability;
    }

    public Item.Properties toProperty() {
        Item.Properties prop=new Item.Properties();
        prop.maxDamage(durability);
        return prop;
    }
}
