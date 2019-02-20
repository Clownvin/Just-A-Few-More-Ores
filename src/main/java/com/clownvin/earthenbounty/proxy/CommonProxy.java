package com.clownvin.earthenbounty.proxy;

import com.clownvin.earthenbounty.items.ModItems;
import com.clownvin.earthenbounty.world.gen.feature.ModWorldGen;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
        FurnaceRecipes.instance().addSmelting(ModItems.copperAndTinOre, new ItemStack(ModItems.bronzeIngot, 1), .5f);
        FurnaceRecipes.instance().addSmelting(ModItems.mithrilOre, new ItemStack(ModItems.mithrilIngot, 1), 4);
        FurnaceRecipes.instance().addSmelting(ModItems.platinumOre, new ItemStack(ModItems.platinumIngot, 1), 10);
        FurnaceRecipes.instance().addSmelting(ModItems.blackDiamondOre, new ItemStack(ModItems.blackDiamond, 1), 1);
        FurnaceRecipes.instance().addSmelting(ModItems.saltOre, new ItemStack(ModItems.salt, 3), .25f);
        //Crafting
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}