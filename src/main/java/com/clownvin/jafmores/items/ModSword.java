package com.clownvin.jafmores.items;

import com.clownvin.jafmores.JAFMOres;
import com.clownvin.jafmores.ModResource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemSword;

public class ModSword extends ItemSword {

    public ModSword(ModResource resource) {
        super(resource.itemTier, 3, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT));
        this.setRegistryName(JAFMOres.MODID, resource.name + "_sword");
    }
}
