package lychemon.advtorch;

import cpw.mods.fml.client.registry.ClientRegistry;
import lychemon.advtorch.render.RenderTvBlock;
import lychemon.advtorch.tileentity.TileEntityTvBlock;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class ClientProxy extends ServerProxy
{
	public void registerRenderThings()
	{
		//TV
		TileEntitySpecialRenderer render = new RenderTvBlock();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTvBlock.class, render);
	}

	public void registerTileEntitySpecialRenderer()
	{

	}
}
