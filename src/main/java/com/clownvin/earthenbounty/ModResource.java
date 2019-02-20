package com.clownvin.earthenbounty;

import net.minecraft.block.SoundType;
import net.minecraft.client.audio.Sound;

public enum ModResource {
    COPPER("copper", 0, 2.5f, 15.0f, SoundType.METAL),
    TIN("tin", 0, 2.5f, 15.0f, SoundType.METAL),
    BRONZE("bronze", 1, 3.0f, 15.0f, SoundType.METAL),
    MITHRIL("mithril", 2, 3.0f, 15.0f, SoundType.METAL),
    PLATINUM("platinum", 2, 1.5f, 15.0f, SoundType.METAL),
    SALT("salt", 0, 1.5f, 7.5f, SoundType.GROUND),
    SULFUR("sulfur", 0, 2.0f, 7.5f, SoundType.GROUND),
    BLACK_DIAMOND("black_diamond", 2, 3.5f, 30.0f, SoundType.METAL);

    private final String name;
    public final float hardness;
    public final float resistance;
    private final SoundType soundType;
    public final int harvestLevel;

    ModResource(String name, int harvestLevel, float hardness, float resistance, SoundType soundType) {
        this.name = name;
        this.hardness = hardness;
        this.resistance = resistance;
        this.soundType = soundType;
        this.harvestLevel = harvestLevel;
    }

    public String getBlockName() {
        return name+"_block";
    }

    public String getOreName() {
        return name+"_ore";
    }

    public SoundType getOreSoundType() {
        return SoundType.STONE;
    }

    public SoundType getBlockSoundType() {
        return soundType;
    }
}
