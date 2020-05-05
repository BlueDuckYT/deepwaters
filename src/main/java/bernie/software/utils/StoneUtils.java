package bernie.software.utils;

import net.minecraft.state.EnumProperty;
import net.minecraft.util.IStringSerializable;

public class StoneUtils {

    public enum StoneColors implements IStringSerializable {
        BLUE("blue"),
        GREEN("green"),
        ORANGE("orange"),
        PURPLE("purple"),
        RED("red"),
        YELLOW("yellow");

        private final String name;

        private StoneColors(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return null;
        }

        public String toString() {
            return this.getName();
        }

    }

    public static final EnumProperty<StoneColors> STONE_COLORS = EnumProperty.create("color", StoneColors.class);



}
