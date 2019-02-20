package com.clownvin.jafmores.blocks;

import com.clownvin.jafmores.JAFMOres;
import com.clownvin.jafmores.ModResource;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class ModBlock extends Block {

    public final ModResource resource;

    public ModBlock(ModResource resource) {
        super(Properties.create(Material.ROCK).hardnessAndResistance(resource.hardness * 9, resource.resistance * 9).sound(resource.getBlockSoundType()));
        this.resource = resource;
        this.setRegistryName(JAFMOres.MODID, resource.getBlockName());
    }

    @Override
    public ToolType getHarvestTool(IBlockState state) {
        return ToolType.PICKAXE;
    }

    @Override
    public int getHarvestLevel(IBlockState state) {
        return resource.harvestLevel;
    }

    @Override
    public Item getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune)
    {
        return resource.getBlockDrop();
    }
}
