package lychemon.advtorch.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class SampleContainer extends Container
{
    int xCoord, yCoord, zCorrd;
    public SampleContainer(int x, int y, int z) {
        this.xCoord = x;
        this.yCoord = y;
        this.zCorrd = z;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
//        return player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCorrd + 0.5D) <= 64D;
        return true;
    }
}
