package blueduck.deepwaters.client.renderer;

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
    
    /**
	* I hear java.awt doesn't work on mac, so I copy/pasted a decent chunk of the color class.
	* (I see no reasons that this clone of java.awt.color should not work)
	* Only cloned the parts I depended on and/or see myself using to debug stuff in this project.
	*/
    public static class ColorHelper {
    	public static ColorHelper BLUE=new ColorHelper(0,0,255);
		int value;
		public ColorHelper(int r, int g, int b) {
			this(r, g, b, 255);
		}
		public ColorHelper(int r, int g, int b, int a) {
			value = ((a & 0xFF) << 24) |
					((r & 0xFF) << 16) |
					((g & 0xFF) << 8)  |
					((b & 0xFF));
//			testColorValueRange(r,g,b,a);
		}
		public Utils.ColorHelper darker() {
			double FACTOR=0.7;
			return new Utils.ColorHelper(Math.max((int)(getRed()*FACTOR), 0),
					Math.max((int)(getGreen()*FACTOR), 0),
					Math.max((int)(getBlue() *FACTOR), 0),
					getAlpha());
		}
		public Utils.ColorHelper darker(double FACTOR) {
			return new Utils.ColorHelper(Math.max((int)(getRed()  *FACTOR), 0),
					Math.max((int)(getGreen()*FACTOR), 0),
					Math.max((int)(getBlue() *FACTOR), 0),
					getAlpha());
		}
		public ColorHelper(int rgb) {
			value = 0xff000000 | rgb;
		}
		public int getRGB() {
			return value;
		}
		public int getRed() {
			return (getRGB() >> 16) & 0xFF;
		}
		public int getGreen() {
			return (getRGB() >> 8) & 0xFF;
		}
		public int getBlue() {
			return (getRGB() >> 0) & 0xFF;
		}
		public int getAlpha() {
			return (getRGB() >> 24) & 0xff;
		}
		public boolean equals(Object obj) {
			return obj instanceof Utils.ColorHelper && ((Utils.ColorHelper)obj).getRGB() == this.getRGB();
		}
		public String toString() {
			return getClass().getName() + "[r=" + getRed() + ",g=" + getGreen() + ",b=" + getBlue() + "]";
		}
	}
}
