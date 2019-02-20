package com.clownvin.jafmores.blocks;

import com.clownvin.jafmores.JAFMOres;
import com.clownvin.jafmores.ModResource;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;

import java.util.Random;

public class ModBlockOre extends BlockOre {

    public final ModResource resource;

    public ModBlockOre(ModResource resource) {
        super(Properties.create(Material.ROCK).hardnessAndResistance(resource.hardness, resource.resistance).sound(resource.getOreSoundType()));
        this.resource = resource;
        this.setRegistryName(JAFMOres.MODID, resource.getOreName());
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
    public int quantityDropped(IBlockState state, Random random)
    {
        return resource == ModResource.SALT ? 4 + random.nextInt(5) : ( resource == ModResource.SULFUR ? 1 + random.nextInt(3) : 1);
    }

    @Override
    public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
        int count = this.getBlock().getItemsToDropCount(state, fortune, world, pos, world.rand);
        LogManager.getLogger().warn("Attempting to drop " + count + " " + resource.getOreDrop() + " from " + resource.name);
        for(int i = 0; i < count; ++i) {
            Item item = getItemDropped(state, world, pos, fortune)
                    .asItem();
            this.canSilkHarvest();
            if (item != Items.AIR) {
                drops.add(new ItemStack(item));
            }
        }

    }

    @Override
    public Item getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune)
    {
        return resource.getOreDrop();
    }

    @Override
    public int getExpDrop(IBlockState state, IWorldReader reader, BlockPos pos, int fortune)
    {
        int i = 0;//this.getDrops();
        switch (resource) {
            case SALT:
                i = (int) Math.round(Math.random() * 3);
                break;
            case SULFUR:
                i = 1 + (int) Math.round(Math.random() * 2);
                break;
            case BLACK_DIAMOND:
                i = 5 + (int) Math.round(Math.random() * 5);
                break;
        }
        return i;
    }

}
