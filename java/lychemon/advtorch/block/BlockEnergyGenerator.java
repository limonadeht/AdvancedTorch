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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
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
			player.openGui(AdvancedTorch.INSTANCEE, GuiIds.POWER_GENERATOR, world, x, y, z);
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
}
