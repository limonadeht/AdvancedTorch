package lychemon.advtorch.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class NBTUtil
{
	public static void readItemStackArrayFromNBT(ItemStack[] inventory, NBTTagCompound tag)
	{
		NBTTagList nbttaglist = tag.getTagList("Items", 10);

		for(int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompoundl = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompoundl.getByte("Slot");

			if(b0 >= 0 && b0 < inventory.length)
			{
				inventory[b0] = ItemStack.loadItemStackFromNBT(nbttagcompoundl);
			}
		}
	}
	public static void writeItemStackArrayToNBT(ItemStack[] inventory, NBTTagCompound tag)
	{
		NBTTagList nbttaglist = new NBTTagList();

		for(int i = 0; i < inventory.length; ++i)
		{
			NBTTagCompound nbttagcompoundl = new NBTTagCompound();
			nbttagcompoundl.setByte("Slot", (byte) i);
			inventory[i].writeToNBT(nbttagcompoundl);
			nbttaglist.appendTag(nbttagcompoundl);
		}
		tag.setTag("Items", nbttaglist);
	}
}
