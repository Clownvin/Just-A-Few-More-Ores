package com.clownvin.earthenbounty.config;

import com.clownvin.earthenbounty.EarthenBounty;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = EarthenBounty.MODID)
@Config.LangKey("earthenbounty.config.title")
public class JAFMOresConfig {
    public static General general = new General();

    @Mod.EventBusSubscriber(modid = EarthenBounty.MODID)
    private static class EventHandler {
        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(EarthenBounty.MODID))
                ConfigManager.sync(EarthenBounty.MODID, Config.Type.INSTANCE);
        }
    }

    public static class General {
        @Config.Name("Show Ingame Update Notifications")
        @Config.Comment("Changes whether or not the mod will alert you ingame to new updates for your version.")
        public boolean showUpdateNotifications = false;
    }
}
