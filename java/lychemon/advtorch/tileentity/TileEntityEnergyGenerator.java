package lychemon.advtorch.tileentity;

import lychemon.advtorch.power.BlockType;
import lychemon.advtorch.power.EnergyBar;
import lychemon.advtorch.power.EnergyNet;
import lychemon.advtorch.power.IEnergy;
import lychemon.advtorch.util.InventoryUtil;
import lychemon.advtorch.util.NBTUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityEnergyGenerator extends TileEntity implements IEnergy, IInventory, ISidedInventory
{
	private EnergyBar energyBar = new EnergyBar(4000);
	private ItemStack[] inventory = new ItemStack[7];
	public int burnTime;
	public int currentItemBurnTime;
	public int rotation = 3;
	private float modifier = 17.5F;
	private float defaultModifier = 17.5F;
	public int burnTimeRemovedPerTick = 3;

	public void updateTileEntity()
	{
		updateGenerating();
	}
	private void updateGenerating()
	{
		boolean modified = burnTime > 0;
		if(burnTime > 0)
		{
			if(burnTime > burnTimeRemovedPerTick)
			{
				burnTime -= burnTimeRemovedPerTick;
				energyBar.addEnergyWithRemaining(burnTimeRemovedPerTick);
			}
			else
			{
				energyBar.addEnergyWithRemaining(burnTime);
				burnTime = 0;
			}
		}
		else if(burnTime > 0)
		{
			energyBar.addEnergyWithRemaining(burnTime);
			burnTime = 0;
		}

		if(burnTime == 0 && (TileEntityFurnace.isItemFuel(inventory[0]) || TileEntityFurnace.isItemFuel(inventory[5]) || TileEntityFurnace.isItemFuel(inventory[6])))
		{
			currentItemBurnTime = burnTime += (int) (TileEntityFurnace.getItemBurnTime(inventory[0]) * modifier) + (int) (TileEntityFurnace.getItemBurnTime(inventory[6]) * modifier);
			if(inventory[0] != null);
			{
				inventory[0].stackSize--;
				if(inventory[0].stackSize <= 0)
				{
					inventory[0] = null;
				}
			}

			if(inventory[5] != null)
			{
				inventory[5].stackSize--;
				if(inventory[5].stackSize <= 0)
				{
					inventory[5] = null;
				}
			}

			if(inventory[6] != null)
			{
				inventory[6].stackSize--;
				if(inventory[6].stackSize <= 0)
				{
					inventory[6] = null;
				}
			}
		}
		EnergyNet.disttributeEnergyToSurrounding(worldObj, xCoord, yCoord, zCoord, energyBar);
		if(modified != burnTime > 0)
		{
			getWorldObj().markBlockForUpdate(xCoord, yCoord, zCoord);
		}
	}

	@Override
	public boolean canAddEnergyOnSide(ForgeDirection direction)
	{
		return false;
	}

	@Override
	public boolean canConnect(ForgeDirection direction)
	{
		return true;
	}

	@Override
	public EnergyBar getEnergyBar()
	{
		return energyBar;
	}

	@Override
	public void SetLeastRecivedDirection(ForgeDirection direction)
	{

	}

	@Override
	public int getEnergyTransferRate()
	{
		return 10;
	}

	public Packet getDesciptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
	}

	public void onDataPacket(NetworkManager manager, S35PacketUpdateTileEntity packet)
	{
		readFromNBT(packet.func_148857_g());
	}

	@Override
	public int getSizeInventory()
	{
		return InventoryUtil.getSizeInventory(inventory);
	}

	@Override
	public ItemStack getStackInSlot(int slot)
	{
		return InventoryUtil.getStackInSlot(inventory, slot);
	}

	@Override
	public ItemStack decrStackSize(int slot, int count)
	{
		return InventoryUtil.decrStackSize(inventory, slot, count);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot)
	{
		return InventoryUtil.getStackInSlotOnClosing(inventory, slot);
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack)
	{
		InventoryUtil.setInventorySlotContents(this, inventory, slot, itemstack);
	}

	@Override
	public String getInventoryName()
	{
		return "container.powerGenerator";
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return false;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return true;
	}

	@Override
	public void openInventory()
	{

	}

	@Override
	public void closeInventory()
	{

	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack)
	{
		switch(slot)
		{
		case 0:
		return TileEntityFurnace.isItemFuel(itemstack);
		}
		return false;
	}

	public int getBurnTime()
	{
		return burnTime;
	}

	public boolean isBurning()
	{
		return burnTime > 0;
	}

	public int getBurnTimeScaled(int scale)
	{
		return burnTime * scale / currentItemBurnTime;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int slot)
	{
		return new int[] {0};
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack itemstack, int side)
	{
		return isItemValidForSlot(slot, itemstack);
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack itemstack, int side)
	{
		return false;
	}

	@Override
	public BlockType getTypeofBlock()
	{
		return BlockType.MACHINE;
	}

	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);
		energyBar.writeToNBT(tag);
		tag.setInteger("rotation", rotation);
		tag.setInteger("burnTime", burnTime);
		tag.setInteger("currentItemBurnTime", currentItemBurnTime);
		NBTUtil.writeItemStackArrayToNBT(inventory, tag);
	}

	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		energyBar.readFromNBT(tag);
		rotation = tag.getInteger("rotation");
		burnTime = tag.getInteger("burnTime");
		currentItemBurnTime = tag.getInteger("currentItemBurnTime");
		NBTUtil.readItemStackArrayFromNBT(inventory, tag);
	}
}
