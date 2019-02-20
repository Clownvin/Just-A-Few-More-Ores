package com.clownvin.earthenbounty.blocks;

import com.clownvin.earthenbounty.EarthenBounty;
import com.clownvin.earthenbounty.ModResource;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

public class ModBlock extends Block {

    public ModBlock(ModResource resource) {
        super(Material.ROCK);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setUnlocalizedName(resource.getBlockName());
        setHardness(resource.hardness);
        setResistance(resource.resistance);
        setSoundType(resource.getBlockSoundType());
        setRegistryName(EarthenBounty.MODID, resource.getBlockName());
        setHarvestLevel("pickaxe", resource.harvestLevel);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }
}
