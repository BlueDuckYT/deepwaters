package bernie.software.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.Quaternion;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class Utils {
    public static void applyFlop(Entity entity, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        float f = 4.3F * MathHelper.sin(0.6F * ageInTicks);
		matrixStackIn.rotate(new Quaternion(0.0F, f, 0.0F, true));
		if (!entity.isInWater()) {
			matrixStackIn.translate(0.05F, 0.1F, -0.05F);
            matrixStackIn.rotate(new Quaternion(90.0F, 90.0F, 0.0F, true));
		}
    }
}
