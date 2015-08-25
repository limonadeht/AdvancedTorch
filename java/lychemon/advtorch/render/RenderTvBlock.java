package lychemon.advtorch.render;

import org.lwjgl.opengl.GL11;

import lychemon.advtorch.model.ModelTv;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderTvBlock extends TileEntitySpecialRenderer
{

	private static final ResourceLocation texture = new ResourceLocation("advancedtorch:Model");

	private ModelTv model;

	public RenderTvBlock()
	{
		this.model = new ModelTv();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0, 0, 1);
		this.bindTexture(texture);

		GL11.glPushMatrix();
		this.model.renderModel(0.0625F);
		GL11.glPopMatrix();

		GL11.glPopMatrix();
	}

}
