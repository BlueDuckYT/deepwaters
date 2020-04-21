package bernie.software.utils.renderutils;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

import java.awt.*;

public class RenderHelper
{
	public static void drawRect(double x, double y, double width, double height, double red, double green, double blue, double alpha)
	{
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();
		buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
		buffer.pos(x, (y + height), 0).color((float) red, (float) green, (float) blue, (float) alpha).endVertex();
		buffer.pos((x + width), (y + height), 0).color((float) red, (float) green, (float) blue,
				(float) alpha).endVertex();
		buffer.pos((x + width), y, 0).color((float) red, (float) green, (float) blue, (float) alpha).endVertex();
		buffer.pos(x, y, 0).color((float) red, (float) green, (float) blue, (float) alpha).endVertex();
		tessellator.draw();
	}

	public static void drawTexturedRect(double x, double y, double u, double v, double texWidth, double texHeight, double width, double height, double red, double green, double blue, double alpha)
	{
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();
		buffer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
		buffer.pos(x, (y + height), 0).tex((double) ((float) u * 0.00390625F),
				(double) ((float) (v + texHeight) * 0.00390625F)).color((float) red, (float) green, (float) blue,
				(float) alpha).endVertex();
		buffer.pos((x + width), (y + height), 0).tex((double) ((float) (u + texWidth) * 0.00390625F),
				(double) ((float) (v + texHeight) * 0.00390625F)).color((float) red, (float) green, (float) blue,
				(float) alpha).endVertex();
		buffer.pos((x + width), y, 0).tex((double) ((float) (u + texWidth) * 0.00390625F),
				(double) ((float) v * 0.00390625F)).color((float) red, (float) green, (float) blue,
				(float) alpha).endVertex();
		buffer.pos(x, y, 0).tex((double) ((float) u * 0.00390625F), (double) ((float) v * 0.00390625F)).color(
				(float) red, (float) green, (float) blue, (float) alpha).endVertex();
		tessellator.draw();
	}

	public static void drawTextured3DRect(double x, double y, double z, double u, double v, double texWidth, double texHeight, double width, double height, double depth, double red, double green, double blue, double alpha)
	{
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();
		buffer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
		buffer.pos(x, (y + height), z + depth).tex((double) ((float) u * 0.00390625F),
				(double) ((float) (v + texHeight) * 0.00390625F)).color((float) red, (float) green, (float) blue,
				(float) alpha).endVertex();
		buffer.pos((x + width), (y + height), z).tex((double) ((float) (u + texWidth) * 0.00390625F),
				(double) ((float) (v + texHeight) * 0.00390625F)).color((float) red, (float) green, (float) blue,
				(float) alpha).endVertex();
		buffer.pos((x + width), y, z).tex((double) ((float) (u + texWidth) * 0.00390625F),
				(double) ((float) v * 0.00390625F)).color((float) red, (float) green, (float) blue,
				(float) alpha).endVertex();
		buffer.pos(x, y, z + depth).tex((double) ((float) u * 0.00390625F), (double) ((float) v * 0.00390625F)).color(
				(float) red, (float) green, (float) blue, (float) alpha).endVertex();
		tessellator.draw();
	}

	public static void drawMultiColoredTexturedRect(double x, double y, double u, double v, double texWidth, double texHeight, double width, double height, Color col1, Color col2, Color col3, Color col4)
	{
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();
		buffer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
		buffer.pos(x, (y + height), 0).tex((double) ((float) u * 0.00390625F),
				(double) ((float) (v + texHeight) * 0.00390625F)).color(col1.getRed(), col1.getGreen(), col1.getBlue(),
				col1.getAlpha()).endVertex();
		buffer.pos((x + width), (y + height), 0).tex((double) ((float) (u + texWidth) * 0.00390625F),
				(double) ((float) (v + texHeight) * 0.00390625F)).color(col2.getRed(), col2.getGreen(), col2.getBlue(),
				col2.getAlpha()).endVertex();
		buffer.pos((x + width), y, 0).tex((double) ((float) (u + texWidth) * 0.00390625F),
				(double) ((float) v * 0.00390625F)).color(col3.getRed(), col3.getGreen(), col3.getBlue(),
				col3.getAlpha()).endVertex();
		buffer.pos(x, y, 0).tex((double) ((float) u * 0.00390625F), (double) ((float) v * 0.00390625F)).color(
				col4.getRed(), col4.getGreen(), col4.getBlue(), col4.getAlpha()).endVertex();
		tessellator.draw();
	}
}
