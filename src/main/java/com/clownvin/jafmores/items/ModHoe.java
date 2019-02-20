package com.clownvin.jafmores.items;

import com.clownvin.jafmores.JAFMOres;
import com.clownvin.jafmores.ModResource;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemHoe;

public class ModHoe extends ItemHoe {

    public ModHoe(ModResource resource) {
        super(resource.itemTier, resource.harvestLevel - 3.5f, (new Item.Properties()).group(ItemGroup.TOOLS));
        this.setRegistryName(JAFMOres.MODID, resource.name + "_hoe");

    }
}
