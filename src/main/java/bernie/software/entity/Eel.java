package bernie.software.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class Eel extends AbstractWormEntity {
    @Override
    public int getLength() {
        return 4;
    }
    @Override
    public float getSegmentDistance() {
        return 0.33475f;
    }
    public Eel(EntityType<? extends CreatureEntity> p_i48575_1_, World p_i48575_2_) {
        super(p_i48575_1_, p_i48575_2_);
    }
    @Override
    public int getAir() {
        return 9;
    }

    @Override
    public float getYRenderOffset() {
        return 1.4f;
    }
}
