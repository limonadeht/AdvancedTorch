package lychemon.advtorch.item;

import cpw.mods.fml.common.registry.GameRegistry;
import lychemon.advtorch.AdvancedTorch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TorchMk2Placer extends Item
{

	public TorchMk2Placer()
	{
		String name = "Torch Mk2";

		this.setMaxDamage(-20);
		this.setCreativeTab(AdvancedTorch.tabAdvTorch);
		this.setUnlocalizedName(name);
		this.setTextureName("advancedtorch:torch_on");
		this.setMaxStackSize(1);

		GameRegistry.registerItem(this, name);

		return;
	}

	/*
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
	*/

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int x, int y, int z, int par7, float par8, float par9, float par10)
	{
		if(par3World.isRemote)
		{
			if (par1ItemStack.getItemDamage() >= this.getMaxDamage() - 1)
			{
				par3World.setBlock(x, y, z, Blocks.diamond_block);
			}
		}
		return true;
	}
}
