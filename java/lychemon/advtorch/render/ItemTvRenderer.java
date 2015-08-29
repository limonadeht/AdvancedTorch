package lychemon.advtorch.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemTvRenderer implements IItemRenderer
{
	public static final ItemTvRenderer instance = new ItemTvRenderer();
	ResourceLocation TEXTURE = new ResourceLocation("advancedtorch", "textures/models/Model.png");

	@Override
	public boolean handleRenderType(ItemStack itemstack, ItemRenderType type)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		int meta = item.getItemDamage();
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		GL11.glRotatef(180, 0, 0, 1);
		if(meta == 0)
		{
			Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
		}
	}

}
