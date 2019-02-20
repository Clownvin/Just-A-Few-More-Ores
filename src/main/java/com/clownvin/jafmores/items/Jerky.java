package com.clownvin.jafmores.items;

import com.clownvin.jafmores.JAFMOres;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Jerky extends ItemFood {

    public Jerky()
    {
        super(3, 3.75f,true, new Item.Properties().group(ItemGroup.FOOD));
        setRegistryName(JAFMOres.MODID, "jerky");
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 16;
    }
}
