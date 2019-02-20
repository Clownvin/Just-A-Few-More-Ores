package com.clownvin.earthenbounty.items;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class Jerky extends ItemFood {

    public Jerky()
    {
        super(3, 3.75f,true);
        setUnlocalizedName("jerky");
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 16;
    }
}
