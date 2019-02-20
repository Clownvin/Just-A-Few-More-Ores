package com.clownvin.earthenbounty;

import com.clownvin.earthenbounty.blocks.ModBlocks;
import com.clownvin.earthenbounty.items.ModItems;
import com.clownvin.earthenbounty.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(name = EarthenBounty.NAME, modid = EarthenBounty.MODID, version = EarthenBounty.VERSION)
public class EarthenBounty
{
    public static final String MODID = "earthenbounty";
    public static final String VERSION = "2.1.2";
    public static final String NAME = "Just a Few More Ores";

    @SidedProxy(clientSide = "com.clownvin.earthenbounty.proxy.ClientProxy", serverSide = "com.clownvin.earthenbounty.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static EarthenBounty instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        ModBlocks.preInit();
        ModItems.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}