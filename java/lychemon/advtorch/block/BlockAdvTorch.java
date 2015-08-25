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
			this.setBlockTextureName("advancedtorch:model_tv");
			this.setCreativeTab(AdvancedTorch.tabAdvTorch);
			this.setStepSound(soundTypeAnvil);

	}
}
