package lychemon.advtorch.block;

import lychemon.advtorch.AdvancedTorch;
import lychemon.advtorch.tileentity.TileEntityTvBlock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTv extends BlockContainer
{

	public BlockTv(Material material)
	{
		super(material);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setCreativeTab(AdvancedTorch.tabAdvTorch);
	}

	public int getRenderType()
	{
		return -1;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	/*
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName());
    }
    */

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TileEntityTvBlock();
	}

}
