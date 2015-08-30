package lychemon.advtorch.block;

import java.util.Random;

import lychemon.advtorch.AdvancedTorch;
import lychemon.advtorch.GuiIds;
import lychemon.advtorch.Names;
import lychemon.advtorch.tileentity.TileEntityEnergyGenerator;
import lychemon.advtorch.util.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEnergyGenerator extends Block
{
	private IIcon[] icons = new IIcon[3];
	private static boolean keepInventory;
	private Random rand = new Random();

	public BlockEnergyGenerator()
	{
		super(Material.iron);
		this.setCreativeTab(AdvancedTorch.tabAdvTorch);
		this.setBlockName(Names.ENERGY_GENERATOR);
		this.setHardness(3.5F);
		this.setResistance(17.5F);
		this.setStepSound(soundTypeMetal);
		this.setHarvestLevel("pickaxe", 1);
	}

	public TileEntity createTileEntity(World world, int meta)
	{
		return new TileEntityEnergyGenerator();
	}

	public boolean hasTileEntity(int meta)
	{
		return true;
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			player.openGui(AdvancedTorch.instance, GuiIds.POWER_GENERATOR, world, x, y, z);
		}
		return true;
	}

	public void registerBlockIcons(IIconRegister iconRegister)
	{
		icons[0] = iconRegister.registerIcon("advancedtorch:tile.machineBase");
		icons[1] = iconRegister.registerIcon("advancedtorch:tile.energyGeneratorFrontOff");
		icons[2] = iconRegister.registerIcon("advancedtorch:tile.energyGeneratorFrontOn");
	}

	public IIcon getIcon(int side, int meta)
	{
		if(meta == 0 && side == 3)
		{
			return icons[1];
		}
		return icons[0];
	}

	public IIcon registerIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		int meta = world.getBlockMetadata(x, y, z);
		if(meta == 0)
		{
			TileEntityEnergyGenerator tileentity = (TileEntityEnergyGenerator) world.getTileEntity(x, y, z);
			if(side == tileentity.rotation)
			{
				if(tileentity.burnTime > 0)
				{
					return icons[2];
				}
				else
				{
					return icons[1];
				}
			}
		}
		return icons[0];
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving player, ItemStack itemstack)
	{
		int meta = world.getBlockMetadata(x, y, z);
		if(meta == 0)
		{
			TileEntityEnergyGenerator tileentity = (TileEntityEnergyGenerator) world.getTileEntity(x, y, z);
			tileentity.rotation = BlockUtil.determineMetadataBasedOnPlayerOrientation(player);

		}
	}

	public void breakBlock(World world, int x, int y, int z, Block oldBlock, int oldMetadata)
    {
                if(!keepInventory)
                {
                        TileEntityEnergyGenerator tileEntity = (TileEntityEnergyGenerator)world.getTileEntity(x, y, z);

                        if(tileEntity != null)
                        {
                                for(int i = 0; i < tileEntity.getSizeInventory(); i++)
                                {
                                        ItemStack itemStack = tileEntity.getStackInSlot(i);

                                        if(itemStack != null)
                                        {
                                                float f = this.rand.nextFloat() * 0.8F + 0.1F;
                                                float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
                                                float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

                                                while(itemStack.stackSize > 0)
                                                {
                                                        int j = this.rand.nextInt(21) + 10;

                                                        if(j > itemStack.stackSize)
                                                                j = itemStack.stackSize;

                                                        itemStack.stackSize -= j;

                                                        EntityItem item = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemStack.getItem(), j, itemStack.getItemDamage()));

                                                        if(itemStack.hasTagCompound())
                                                                item.getEntityItem().setTagCompound((NBTTagCompound)itemStack.getTagCompound().copy());

                                                        world.spawnEntityInWorld(item);
                                                }
                                        }
                                }
                                world.func_147453_f(x, y, z, oldBlock);
                        }
                }
                super.breakBlock(world, x, y, z, oldBlock, oldMetadata);
        }
}
