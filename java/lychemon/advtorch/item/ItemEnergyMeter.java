package lychemon.advtorch.item;

import lychemon.advtorch.AdvancedTorch;
import lychemon.advtorch.Names;
import lychemon.advtorch.power.IEnergy;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemEnergyMeter extends Item
{
	public ItemEnergyMeter()
	{
		this.setCreativeTab(AdvancedTorch.tabAdvTorch);
		this.setUnlocalizedName(Names.ENERGY_METER);
	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			TileEntity tileentity = world.getTileEntity(x, y, z);
			if(tileentity instanceof IEnergy)
			{
				player.addChatMessage(new ChatComponentText("[" + AdvancedTorch.MOD_ID + "] Energy level = " + ((IEnergy) tileentity).getEnergyBar().getEnergyLevel()));
			}
			return true;
		}
		return false;
	}

	@Override
	public void registerIcons(IIconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon("advancedtorch:energy_meter");
	}

	@Override
	public boolean isFull3D()
	{
		return true;
	}
}
