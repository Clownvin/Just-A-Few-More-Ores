package com.clownvin.earthenbounty.blocks;

import com.clownvin.earthenbounty.EarthenBounty;
import com.clownvin.earthenbounty.ModResource;
import com.clownvin.earthenbounty.items.ModItems;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class ModBlockOre extends BlockOre {

    public final ModResource resource;

    public ModBlockOre(ModResource resource) {
        this.resource = resource;
        setUnlocalizedName(resource.getOreName());
        setHardness(resource.hardness);
        setResistance(resource.resistance);
        setSoundType(resource.getOreSoundType());
        setRegistryName(EarthenBounty.MODID, resource.getOreName());
        setHarvestLevel("pickaxe", resource.harvestLevel);
    }

    @Override
    public int quantityDropped(Random random)
    {
        return resource == ModResource.SALT ? 4 + random.nextInt(5) : ( resource == ModResource.SULFUR ? 1 + random.nextInt(3) : 1);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        switch (resource) {
            case TIN:
                return ModItems.tinOre;
            case COPPER:
                return ModItems.copperOre;
            case SALT:
                return ModItems.salt;
            case SULFUR:
                return ModItems.sulfur;
            case MITHRIL:
                return ModItems.mithrilOre;
            case PLATINUM:
                return ModItems.platinumOre;
            case BLACK_DIAMOND:
                return ModItems.blackDiamond;
        }
        throw new RuntimeException("ModBlockOre has no resource??? WTF");
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            int i = 0;

            switch (resource) {
                case SALT:
                    i = MathHelper.getInt(rand, 0, 3);
                    break;
                case SULFUR:
                    i = MathHelper.getInt(rand, 1, 3);
                    break;
                case BLACK_DIAMOND:
                    i = MathHelper.getInt(rand, 5, 10);
                    break;
            }

            return i;
        }
        return 0;
    }

}
