package lychemon.advtorch.block;

import lychemon.advtorch.AdvancedTorch;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class SampleGuiBlock extends Block
{
	public SampleGuiBlock() {
        super(Material.wood);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        player.openGui(AdvancedTorch.instance, AdvancedTorch.GUI_ID, world, x, y, z);
        return true;
    }
}
