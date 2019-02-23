package com.clownvin.earthenbounty;

import com.clownvin.earthenbounty.blocks.ModBlocks;
import com.clownvin.earthenbounty.config.JAFMOresConfig;
import com.clownvin.earthenbounty.items.ModItems;
import com.clownvin.earthenbounty.proxy.CommonProxy;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod(name = EarthenBounty.NAME, modid = EarthenBounty.MODID, version = EarthenBounty.VERSION, updateJSON = "https://raw.githubusercontent.com/Clownvin/Just-A-Few-More-Ores/1.12.2/update.json")
@Mod.EventBusSubscriber(modid = EarthenBounty.MODID)
public class EarthenBounty
{
    public static final String MODID = "earthenbounty";
    public static final String VERSION = "2.1.5";
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

    private static boolean isNewerVersion(String v1, String v2) {
        String[] v1s = v1.split("\\.");
        String[] v2s = v2.split("\\.");
        if (v2s.length > v1s.length)
            return true;
        System.out.println(v2s.length+", "+v1s.length);
        for (int i = 0; i < v2s.length; i++) {
            if (v2s[i].length() > v1s[i].length()) {
                return true;
            }
            if (v2s[i].compareTo(v1s[i]) > 0) {
                return true;
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void onJoinGame(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
        if (!JAFMOresConfig.general.showUpdateNotifications)
            return;
        ForgeVersion.CheckResult result = ForgeVersion.getResult(Loader.instance().activeModContainer());
        if (result.target == null || !isNewerVersion(Loader.instance().activeModContainer().getVersion(), result.target.toString())) {//result.target.compareTo(Loader.instance().activeModContainer().getVersion()) <= 0) {
            return;
        }
        event.player.sendMessage(new TextComponentTranslation("text.new_update_notification", MODID+", "+MODID+"-"+result.target.toString()));
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