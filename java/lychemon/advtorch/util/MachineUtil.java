package lychemon.advtorch.util;

import lychemon.advtorch.power.EnergyBar;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class MachineUtil
{
	public static void operate(ItemStack[] inventory, EnergyBar energybar, ItemStack result, IInventory inventoryClass, int EnergyUsePerOperation, int stackSizeToDecrease)
	{
		if(result != null)
		{
			if(inventory[1] == null)
			{
				inventory[1] = result.copy();
			}
			else if(inventory[1].isItemEqual(result))
			{
				inventory[1].stackSize += result.stackSize;
			}

			inventory[0].stackSize -= stackSizeToDecrease;

			if(inventory[0].stackSize <= 0)
			{
				inventory[0] = null;
			}
			energybar.removeEnergy(EnergyUsePerOperation);
		}
	}

	public static boolean canOperate(ItemStack[] inventory, EnergyBar energybar, ItemStack result, IInventory inventoryClass, int EnergyUsePerOperation, int stackSizeToDecrease)
	{
		if(inventory[0] == null)
		{
			return false;
		}
		if(result == null) return false;
		if(energybar.canRemoveEnergy(EnergyUsePerOperation)) return false;
		if(inventory[1] == null) return true;
		if(!inventory[1].isItemEqual(result)) return false;
		if(inventory[1].stackSize + stackSizeToDecrease > inventory[1].getMaxStackSize()) return false;
		int resultStack = inventory[1].stackSize + result.stackSize;
		return(resultStack <= inventoryClass.getInventoryStackLimit() && (resultStack <= result.getMaxStackSize()));
	}
}
