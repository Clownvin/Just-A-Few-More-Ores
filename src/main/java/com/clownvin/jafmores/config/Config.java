package com.clownvin.jafmores.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

public class Config {

    public static Common COMMON;
    public static ForgeConfigSpec COMMON_SPEC;

    public static void init() {
        Pair<Common, ForgeConfigSpec> commonPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonPair.getRight();
        COMMON = commonPair.getLeft();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_SPEC);
    }

    public static class Common {

        public ForgeConfigSpec.BooleanValue showNewUpdateNotifications;

        private Common(ForgeConfigSpec.Builder builder) {
            builder.push("General");
            showNewUpdateNotifications = builder
                    .comment("Changes whether or not the mod will alert you ingame to new updates for your version.")
                    .translation("text.config.show_new_update_notifications")
                    .define("show_new_update_notifications", true);
            builder.pop();
            //TODO See about adding config for every personality?
            //effectivenessAffectsAllBlocks = false;
        }
    }
}
