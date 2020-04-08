package bernie.software.registry;

import net.minecraft.item.Food;

public class DeepWatersFoods {

    public static final Food BLUFFERFISH = (new Food.Builder()).hunger(3).saturation(0.1F).build();
    public static final Food COOKED_BLUFFERFISH = (new Food.Builder()).hunger(6).saturation(0.6F).build();
    public static final Food SALTED_BLUFFERFISH = (new Food.Builder()).hunger(9).saturation(0.3F).build();
    public static final Food MUCK_GULPER = (new Food.Builder()).hunger(1).saturation(0.3F).build();
    public static final Food COOKED_MUCK_GULPER = (new Food.Builder()).hunger(3).saturation(0.9F).build();
    public static final Food SALTED_MUCK_GULPER = (new Food.Builder()).hunger(6).saturation(0.3F).build();
}
