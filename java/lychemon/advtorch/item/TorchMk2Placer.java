package lychemon.advtorch.item;

import cpw.mods.fml.common.registry.GameRegistry;
import lychemon.advtorch.AdvancedTorch;
import lychemon.advtorch.block.BlockTorchMk2;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
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
		if (par7 == 0)
		{
			return false;
		}
		else if (!par3World.getBlock(x, y, z).getMaterial().isSolid())
		{
			return false;
		}
		else
		{
			if (par7 == 1)
			{
				++y;
			}

			if (par7 == 2)
			{
				--z;
			}

			if (par7 == 3)
			{
				++z;
			}

			if (par7 == 4)
			{
				--x;
			}

			if (par7 == 5)
			{
				++x;
			}

			if (!par2EntityPlayer.canPlayerEdit(x, y, z, par7, par1ItemStack))
			{
				return false;
			}
			else if (!AdvancedTorch.BlockTorchMk2.canPlaceBlockAt(par3World, x, z, y))
			{
				return false;
			}
			else if (par3World.isRemote)
			{
				return true;
			}
			else
			{
				if (par7 == 1)
				{
					int i1 = MathHelper.floor_double((double)((par2EntityPlayer.rotationYaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
					par3World.setBlock(x, y, z, AdvancedTorch.BlockTorchMk2, i1, 3);
				}
				else
				{
					par3World.setBlock(x, y, z, AdvancedTorch.BlockTorchMk2, par7, 3);
				}

				--par1ItemStack.stackSize;
				BlockTorchMk2 blocktorchmk2 = (BlockTorchMk2)par3World.getBlock(x, y, z);

				return true;
			}
		}
	}
}
