package lychemon.advtorch.power;

import cpw.mods.fml.client.registry.ClientRegistry;
import lychemon.advtorch.AdvancedTorch;
import lychemon.advtorch.render.ItemCableRenderer;
import lychemon.advtorch.render.TileEntityCableRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxyPW extends CommonProxyPW
{

	@Override
	public void registerRenderers()
	{
		ClientRegistry.registerTileEntity(lychemon.advtorch.tileentity.TileEntityCable.class, AdvancedTorch.MODID + ":" + lychemon.advtorch.Names.CABLE, TileEntityCableRenderer.instance);

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(lychemon.advtorch.block.tutBlocks.CABLE), ItemCableRenderer.instance);
	}


}
