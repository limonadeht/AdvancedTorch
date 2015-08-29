package lychemon.advtorch.item;

import cpw.mods.fml.common.registry.GameRegistry;
import lychemon.advtorch.AdvancedTorch;
import net.minecraft.entity.player.EntityPlayer;
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
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float y2, float z2)
	{
		if(!world.isRemote)
		{
			if (itemstack.getItemDamage() >= this.getMaxDamage() - 1)
			{
			if(side==3)
				world.setBlock(x, y, z+1, AdvancedTorch.BlockTorchMk2);
			if(side==4)
				world.setBlock(x+1, y, z, AdvancedTorch.BlockTorchMk2);
			if(side==5)
				world.setBlock(x+1, y, z, AdvancedTorch.BlockTorchMk2);
			if(side==2)
				world.setBlock(x, y, z-1, AdvancedTorch.BlockTorchMk2);
			if(side==1)
				world.setBlock(x, y+1, z, AdvancedTorch.BlockTorchMk2);
			System.out.println(side);

			return true;
		}
			}

		return false;
	}
}
