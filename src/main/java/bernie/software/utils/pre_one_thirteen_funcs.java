package bernie.software.utils;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class pre_one_thirteen_funcs {
    public static void drawRect(double x,double y,double width,double height,double red,double green,double blue,double alpha) {
        Tessellator tessellator=Tessellator.getInstance();
        BufferBuilder buffer=tessellator.getBuffer();
        buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        buffer.pos(x,(y+height),0).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        buffer.pos((x+width),(y+height),0).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        buffer.pos((x+width),y,0).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        buffer.pos(x,y,0).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        tessellator.draw();
    }
}
