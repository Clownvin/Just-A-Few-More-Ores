package com.clownvin.jafmores.items;

import com.clownvin.jafmores.ModResource;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.Tag;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {
    //EnumHelper.addArmorMaterial("bronze", "jafmores:bronze", 12, new int[] { 2, 4, 5, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5f).setRepairItem(new ItemStack(ModItems.bronzeIngot));
    BRONZE("bronze", 12, new int[] {2, 4, 5, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5f, () -> Ingredient.fromTag(ModResource.BRONZE.itemTag)),
    //EnumHelper.addArmorMaterial("mithril", "jafmores:mithril", 22, new int[] { 3, 5, 6, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.5f).setRepairItem(new ItemStack(ModItems.mithrilIngot));
    MITHRIL("mithril", 22, new int[] {3, 5, 6, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.5f, () -> Ingredient.fromTag(ModResource.MITHRIL.itemTag)),
    //EnumHelper.addArmorMaterial("black_diamond", "jafmores:black_diamond", 50, new int[] { 4, 6, 7, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5f).setRepairItem(new ItemStack(ModItems.blackDiamond));
    BLACK_DIAMOND("black_diamond", 50, new int[] {4, 6, 7, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5f, () -> Ingredient.fromTag(ModResource.BLACK_DIAMOND.itemTag)),
    //EnumHelper.addArmorMaterial("platinum", "jafmores:platinum", 33, new int[] { 3, 4, 5, 6}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.25f).setRepairItem(new ItemStack(ModItems.platinumIngot));
    //EnumHelper.addArmorMaterial("platinum_crown", "jafmores:platinum_crown", 45, new int[] { 0, 0, 0, 8}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.25f).setRepairItem(new ItemStack(ModItems.platinumIngot));
    PLATINUM("platinum", 33, new int[] {3, 4, 5, 6}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.25f, () -> Ingredient.fromTag(ModResource.PLATINUM.itemTag))
    ;

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private LazyLoadBase<Ingredient> repairMaterial;
    private final String name;

    ModArmorMaterial(String name, int p_i48533_4_, int[] p_i48533_5_, int p_i48533_6_, SoundEvent p_i48533_7_, float p_i48533_8_, Supplier<Ingredient> repairMaterialIn) {
        this.maxDamageFactor = p_i48533_4_;
        this.damageReductionAmountArray = p_i48533_5_;
        this.enchantability = p_i48533_6_;
        this.soundEvent = p_i48533_7_;
        this.toughness = p_i48533_8_;
        this.repairMaterial = new LazyLoadBase(repairMaterialIn);
        this.name = name;
    }

    public int getDurability(EntityEquipmentSlot slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(EntityEquipmentSlot slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return name;
    }

    public float getToughness() {
        return this.toughness;
    }
}
