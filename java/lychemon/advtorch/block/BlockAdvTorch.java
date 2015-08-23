package lychemon.advtorch.block;

import lychemon.advtorch.AdvancedTorch;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAdvTorch extends Block
{
	public BlockAdvTorch()
	{
		super(Material.anvil);

			this.setBlockName("OMG");
			this.setBlockTextureName("advancedtorch:block_advtorch");
			this.setCreativeTab(AdvancedTorch.tabAdvTorch);

	}
}
