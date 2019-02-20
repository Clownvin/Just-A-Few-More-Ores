package com.clownvin.jafmores.items;

import com.clownvin.jafmores.JAFMOres;
import com.clownvin.jafmores.ModResource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemSpade;

public class ModSpade extends ItemSpade {

    public ModSpade(ModResource resource) {
        super(resource.itemTier, 1.5F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS));
        this.setRegistryName(JAFMOres.MODID, resource.name + "_shovel");
    }
}
