package com.clownvin.jafmores.items;

import com.clownvin.jafmores.JAFMOres;
import com.clownvin.jafmores.ModResource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPickaxe;

public class ModPickaxe extends ItemPickaxe {

    protected ModPickaxe(ModResource resource) {
        super(resource.itemTier, 1, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS));
        this.setRegistryName(JAFMOres.MODID, resource.name + "_pickaxe");
    }
}
