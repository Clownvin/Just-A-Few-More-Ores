package com.clownvin.jafmores;

import com.clownvin.jafmores.items.ModArmorMaterial;
import com.clownvin.jafmores.items.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.item.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum ModResource {
    COPPER("copper", 0, 2.5f, 15.0f, SoundType.METAL, ItemTier.STONE, ArmorMaterial.LEATHER, new ItemTags.Wrapper(new ResourceLocation(JAFMOres.MODID, "ingots/copper")), new BlockTags.Wrapper(new ResourceLocation(JAFMOres.MODID, "ores/copper"))),
    TIN("tin", 0, 2.5f, 15.0f, SoundType.METAL, ItemTier.STONE, ArmorMaterial.LEATHER, new ItemTags.Wrapper(new ResourceLocation(JAFMOres.MODID, "ingots/tin")), new BlockTags.Wrapper(new ResourceLocation(JAFMOres.MODID, "ores/tin"))),
    BRONZE("bronze", 1, 3.0f, 15.0f, SoundType.METAL, ModItemTier.BRONZE, ModArmorMaterial.BRONZE, new ItemTags.Wrapper(new ResourceLocation(JAFMOres.MODID, "ingots/bronze")), new BlockTags.Wrapper(new ResourceLocation(JAFMOres.MODID, "ores/bronze"))),
    MITHRIL("mithril", 2, 3.0f, 15.0f, SoundType.METAL, ModItemTier.MITHRIL, ModArmorMaterial.MITHRIL, new ItemTags.Wrapper(new ResourceLocation(JAFMOres.MODID, "ingots/mithril")), new BlockTags.Wrapper(new ResourceLocation(JAFMOres.MODID, "ores/mithril"))),
    PLATINUM("platinum", 2, 1.5f, 15.0f, SoundType.METAL, ItemTier.DIAMOND, ModArmorMaterial.PLATINUM, new ItemTags.Wrapper(new ResourceLocation(JAFMOres.MODID, "ingots/platinum")), new BlockTags.Wrapper(new ResourceLocation(JAFMOres.MODID, "ores/platinum"))),
    SALT("salt", 0, 1.5f, 7.5f, SoundType.GROUND, null, null, null, null),
    SULFUR("sulfur", 0, 2.0f, 7.5f, SoundType.GROUND, null, null, null, null),
    BLACK_DIAMOND("black_diamond", 2, 3.5f, 30.0f, SoundType.METAL, ModItemTier.BLACK_DIAMOND, ModArmorMaterial.BLACK_DIAMOND, new ItemTags.Wrapper(new ResourceLocation(JAFMOres.MODID, "gems/black_diamond")), new BlockTags.Wrapper(new ResourceLocation(JAFMOres.MODID, "ores/black_diamond")));

    private final Logger LOGGER = LogManager.getLogger(ModResource.class);

    public final String name;
    public final float hardness;
    public final float resistance;
    private final SoundType soundType;
    public final int harvestLevel;
    public final Tag<Item> itemTag;
    public final Tag<Block> blockTag;
    public final IItemTier itemTier;
    public final IArmorMaterial armorMaterial;
    private final ResourceLocation oreDropLocation;
    private final ResourceLocation blockDropLocation;

    ModResource(String name, int harvestLevel, float hardness, float resistance, SoundType soundType, IItemTier itemTier, IArmorMaterial armorMaterial, Tag<Item> itemTag, Tag<Block> blockTag) {
        this.name = name;
        this.hardness = hardness;
        this.resistance = resistance;
        this.soundType = soundType;
        this.harvestLevel = harvestLevel;
        this.itemTag = itemTag;
        this.blockTag = blockTag;
        this.itemTier = itemTier;
        this.armorMaterial = armorMaterial;
        this.oreDropLocation = createOreDropLocation();
        this.blockDropLocation = new ResourceLocation(JAFMOres.MODID, getBlockName());
    }

    private ResourceLocation createOreDropLocation() {
        return new ResourceLocation(JAFMOres.MODID, (name.equals("sulfur") || name.equals("salt")) ? getItemName() : getOreName());
    }

    public String getBlockName() {
        return name+"_block";
    }

    public String getOreName() {
        return name+"_ore";
    }

    public String getItemName() {
        return name+"_item";
    }

    public SoundType getOreSoundType() {
        return SoundType.STONE;
    }

    public SoundType getBlockSoundType() {
        return soundType;
    }

    public Item getOreDrop() {
        return ForgeRegistries.ITEMS.getValue(oreDropLocation);
    }

    public Item getBlockDrop() {
        return ForgeRegistries.ITEMS.getValue(blockDropLocation);
    }
}
