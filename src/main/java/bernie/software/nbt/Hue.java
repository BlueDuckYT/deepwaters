package bernie.software.nbt;

import net.minecraft.nbt.StringNBT;

public class Hue extends StringNBT {

    public static Hue makeHue(String color) {
        return super.valueOf(color);
    }
}
