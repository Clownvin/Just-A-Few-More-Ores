package com.clownvin.jafmores.items;

import com.clownvin.jafmores.JAFMOres;
import com.clownvin.jafmores.ModResource;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemGroup;

public class ModArmor extends ItemArmor {

    public ModArmor(ModResource resource, EntityEquipmentSlot slots) {
        super(resource.armorMaterial, slots, new Item.Properties().group(ItemGroup.COMBAT));
        this.setRegistryName(JAFMOres.MODID, resource.name + getPrefix(slots));
    }

    private String getPrefix(EntityEquipmentSlot slot) {
        switch (slot) {
            case LEGS:
                return "_legs";
            case FEET:
                return "_boots";
            case CHEST:
                return "_chestplate";
            case HEAD:
                return "_helmet";
        }
        return "_" + slot.getName();
    }
}
