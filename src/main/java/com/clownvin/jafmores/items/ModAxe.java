package com.clownvin.jafmores.items;

import com.clownvin.jafmores.JAFMOres;
import com.clownvin.jafmores.ModResource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemGroup;

public class ModAxe extends ItemAxe {

    protected ModAxe(ModResource resource) {
        super(resource.itemTier, 6.0F, -3.2F, (new Item.Properties()).group(ItemGroup.TOOLS));
        this.setRegistryName(JAFMOres.MODID, resource.name + "_axe");
    }
}
