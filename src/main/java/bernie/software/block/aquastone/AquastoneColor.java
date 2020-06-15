package bernie.software.block.aquastone;

import bernie.software.block.aquastone.AquastoneDust;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ILightReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.awt.*;

@OnlyIn(Dist.CLIENT)
public class AquastoneColor implements  IBlockColor {
    public int getColorAquastone(BlockState p_getColor_1_, @Nullable ILightReader p_getColor_2_, @Nullable BlockPos p_getColor_3_, int p_getColor_4_) {
        try
        {
            float power = p_getColor_1_.get(AquastoneDust.POWER) / 15f;
            int color1R = 2;
            int color1G = 188;
            int color1B = 255;
            int color2R = 1;
            int color2G = 29;
            int color2B = 38;
            float fade = ((power) * 1);
            int red = (int) (((fade * color1R) + ((1 - fade) * color2R)) * 1);
            int green = (int) (((fade * color1G) + ((1 - fade) * color2G)) * 1);
            int blue = (int) (((fade * color1B) + ((1 - fade) * color2B)) * 1);
            Color color = new Color(red, green, blue);
            return color.getRGB();
        }
        catch (Exception err)
        {
            return 0;
        }
    }


    @Override
    public int getColor(BlockState p_getColor_1_, @Nullable ILightReader p_getColor_2_, @Nullable BlockPos p_getColor_3_, int p_getColor_4_) {
        if (p_getColor_1_.getBlock() instanceof AquastoneDust) {
            return getColorAquastone(p_getColor_1_,p_getColor_2_,p_getColor_3_,p_getColor_4_);
        }
        return 0;
    }
}
