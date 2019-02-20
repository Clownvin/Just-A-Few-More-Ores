package com.clownvin.jafmores.items;

import com.clownvin.jafmores.ModResource;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {
    BRONZE(2, 180, 5.0F, 1.5F, 10, () -> {
        return Ingredient.fromTag(ModResource.BRONZE.itemTag);
    }),
    //3, 731, 7f, 2.5f, 16
    MITHRIL(3, 751, 7.0F, 2.5F, 16, () -> {
        return Ingredient.fromTag(ModResource.MITHRIL.itemTag);
    }),
    //4, 3055, 13.0f, 3.75f, 14
    BLACK_DIAMOND(4, 3055, 10.0F, 4.0F, 14, () -> {
        return Ingredient.fromTag(ModResource.BLACK_DIAMOND.itemTag);
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadBase<Ingredient> repairMaterial;

    ModItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyLoadBase(repairMaterialIn);
    }

    public int getMaxUses() {
        return this.maxUses;
    }

    public float getEfficiency() {
        return this.efficiency;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}
