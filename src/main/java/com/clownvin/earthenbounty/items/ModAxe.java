package com.clownvin.earthenbounty.items;

import net.minecraft.item.ItemAxe;

public class ModAxe extends ItemAxe {
    public ModAxe(ToolMaterial material) {
        super(material, material.getAttackDamage(), -3.0f);
    }
}
