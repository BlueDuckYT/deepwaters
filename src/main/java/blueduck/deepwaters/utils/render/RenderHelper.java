package blueduck.deepwaters.utils.render;

import blueduck.deepwaters.client.renderer.Utils;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class RenderHelper {
    public static class triangle {
        public double x1;
        public double x2;
        public double x3;
        public double y1;
        public double y2;
        public double y3;
        public double z1;
        public double z2;
        public double z3;

        public triangle(double x1, double x2, double x3, double y1, double y2, double y3, double z1, double z2, double z3) {
            this.x1 = x1;
            this.x2 = x2;
            this.x3 = x3;
            this.y1 = y1;
            this.y2 = y2;
            this.y3 = y3;
            this.z1 = z1;
            this.z2 = z2;
            this.z3 = z3;
        }
    }
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
    public static void drawTexturedRect(double x,double y,double u,double v,double texWidth,double texHeight,double width,double height,double red,double green,double blue,double alpha) {
        Tessellator tessellator=Tessellator.getInstance();
        BufferBuilder buffer=tessellator.getBuffer();
        buffer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        buffer.pos(x,(y+height),0).tex((float)((float)u * 0.00390625F), (float)((float)(v + texHeight) * 0.00390625F)).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        buffer.pos((x+width),(y+height),0).tex((float)((float)(u + texWidth) * 0.00390625F), (float)((float)(v + texHeight) * 0.00390625F)).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        buffer.pos((x+width),y,0).tex((float)((float)(u + texWidth) * 0.00390625F), (float)((float)v * 0.00390625F)).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        buffer.pos(x,y,0).tex((float)((float)u * 0.00390625F), (float)((float)v * 0.00390625F)).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        tessellator.draw();
    }
    public static void drawTextured3DRect(double x,double y,double z,double u,double v,double texWidth,double texHeight,double width,double height,double depth,double red,double green,double blue,double alpha) {
        Tessellator tessellator=Tessellator.getInstance();
        BufferBuilder buffer=tessellator.getBuffer();
        buffer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        buffer.pos(x,(y+height),z+depth).tex((float)((float)u * 0.00390625F), (float)((float)(v + texHeight) * 0.00390625F)).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        buffer.pos((x+width),(y+height),z).tex((float)((float)(u + texWidth) * 0.00390625F), (float)((float)(v + texHeight) * 0.00390625F)).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        buffer.pos((x+width),y,z).tex((float)((float)(u + texWidth) * 0.00390625F), (float)((float)v * 0.00390625F)).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        buffer.pos(x,y,z+depth).tex((float)((float)u * 0.00390625F), (float)((float)v * 0.00390625F)).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        tessellator.draw();
    }
    public static void draw3DRect(double x,double y,double z,double width,double height,double depth,double red,double green,double blue,double alpha) {
        Tessellator tessellator=Tessellator.getInstance();
        BufferBuilder buffer=tessellator.getBuffer();
        buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        buffer.pos(x,(y+height),z+depth).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        buffer.pos((x+width),(y+height),z).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        buffer.pos((x+width),y,z).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        buffer.pos(x,y,z+depth).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        tessellator.draw();
    }
    public static void drawTriangle(triangle triangle,double red,double green,double blue,double alpha) {
        Tessellator tessellator=Tessellator.getInstance();
        BufferBuilder buffer=tessellator.getBuffer();
        buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        buffer.pos(triangle.x1,triangle.y1,triangle.z1).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        buffer.pos(triangle.x2,triangle.y2,triangle.z2).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        buffer.pos(triangle.x3,triangle.y3,triangle.z3).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        buffer.pos(triangle.x3,triangle.y3,triangle.z3).color((float)red,(float)green,(float)blue,(float)alpha).endVertex();
        tessellator.draw();
    }
    public static void drawMultiColoredTexturedRect(double x, double y, double u, double v, double texWidth, double texHeight, double width, double height, Utils.ColorHelper col1, Utils.ColorHelper col2, Utils.ColorHelper col3, Utils.ColorHelper col4) {
        Tessellator tessellator=Tessellator.getInstance();
        BufferBuilder buffer=tessellator.getBuffer();
        buffer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        buffer.pos(x,(y+height),0).tex((float)((float)u * 0.00390625F), (float)((float)(v + texHeight) * 0.00390625F)).color(col1.getRed(),col1.getGreen(),col1.getBlue(),col1.getAlpha()).endVertex();
        buffer.pos((x+width),(y+height),0).tex((float)((float)(u + texWidth) * 0.00390625F), (float)((float)(v + texHeight) * 0.00390625F)).color(col2.getRed(),col2.getGreen(),col2.getBlue(),col2.getAlpha()).endVertex();
        buffer.pos((x+width),y,0).tex((float)((float)(u + texWidth) * 0.00390625F), (float)((float)v * 0.00390625F)).color(col3.getRed(),col3.getGreen(),col3.getBlue(),col3.getAlpha()).endVertex();
        buffer.pos(x,y,0).tex((float)((float)u * 0.00390625F), (float)((float)v * 0.00390625F)).color(col4.getRed(),col4.getGreen(),col4.getBlue(),col4.getAlpha()).endVertex();
        tessellator.draw();
    }
}
