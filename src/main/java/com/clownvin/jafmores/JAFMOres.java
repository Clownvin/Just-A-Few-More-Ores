package com.clownvin.jafmores;

import com.clownvin.jafmores.blocks.ModBlocks;
import com.clownvin.jafmores.config.Config;
import com.clownvin.jafmores.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.CompositeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.feature.MinableFeature;
import net.minecraft.world.gen.placement.BasePlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.DepthAverage;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.VersionChecker;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forgespi.language.IModInfo;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(JAFMOres.MODID)
@Mod.EventBusSubscriber(modid = JAFMOres.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class JAFMOres
{
    public static final String MODID = "jafmores";

    public JAFMOres() {
        preInit();
    }

    private static void preInit() {
        MinecraftForge.EVENT_BUS.addListener(JAFMOres::setupEvent);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(JAFMOres::setupEvent);
        ModBlocks.preInit();
        ModItems.preInit();
        Config.init();
    }

    private static CompositeFeature<?, ?> getOreGenFeature(Block ore, int size, int count, int avgHeight, int spread) {
        return Biome.createCompositeFeature(Feature.MINABLE, new MinableConfig((blockState) -> Tags.Blocks.STONE.contains(blockState.getBlock()) || Tags.Blocks.ORES.contains(blockState.getBlock()), ore.getDefaultState(), size), Biome.DEPTH_AVERAGE, new DepthAverageConfig(count, avgHeight, spread));
    }

    private static CompositeFeature<?, ?> getNetherOreGenFeature(Block ore, int size, int count) {
        return Biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(BlockMatcher.forBlock(Blocks.NETHERRACK), ore.getDefaultState(), size), Biome.COUNT_RANGE, new CountRangeConfig(count, 10, 20, 128));
    }

    private static boolean isNewerVersion(String v1, String v2) {
        if (v1 == null || v2 == null) {
            System.err.println("Can't compare versions: local: "+v1+", remote: "+v2);
            return false;
        }
        String[] v1s = v1.split("\\.");
        String[] v2s = v2.split("\\.");
        if (v2s.length > v1s.length)
            return true;
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

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onJoinGame(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
        if (!Config.COMMON.showNewUpdateNotifications.get())
            return;
        System.out.println("Checking for update on join...");
        IModInfo info = ModList.get().getModContainerById(MODID).get().getModInfo();
        VersionChecker.CheckResult result = VersionChecker.getResult(info);
        if (result.target == null)
            return;
        System.out.println("Comparing versions "+info.getVersion().toString()+" and "+result.target.toString());
        if (!isNewerVersion(info.getVersion().toString(), result.target.toString())) {//result.target.compareTo(Loader.instance().activeModContainer().getVersion()) <= 0) {
            return;
        }
        System.out.println("Update available for Just A Few More Ores");
        event.getPlayer().sendMessage(new TextComponentTranslation("text.new_update_notification", "Just A Few More Ores, version "+result.target.toString()));
    }

    @SubscribeEvent
    public static void setupEvent(FMLCommonSetupEvent event) {
        CompositeFeature<?, ?> copperOre = getOreGenFeature(ModBlocks.copper_ore_block, 16, 22, 4, 255);
        CompositeFeature<?, ?> tinOre = getOreGenFeature(ModBlocks.tin_ore_block, 16, 22, 4, 255);
        CompositeFeature<?, ?> saltOre = getOreGenFeature(ModBlocks.salt_ore_block, 20, 4, 64, 10);
        CompositeFeature<?, ?> mithrilOre = getOreGenFeature(ModBlocks.mithril_ore_block, 12, 3, 4, 255);
        CompositeFeature<?, ?> platinumOre = getOreGenFeature(ModBlocks.platinum_ore_block, 4, 1, 4, 255);
        CompositeFeature<?, ?> blackDiamondOre = getOreGenFeature(ModBlocks.black_diamond_ore_block, 6, 1, 4, 255);
        CompositeFeature<?, ?> sulfurOre = getNetherOreGenFeature(ModBlocks.sulfur_ore_block, 14, 26);
        for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
            //System.out.println(biome.getRegistryName());
            if (biome == Biomes.NETHER) {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, sulfurOre);
            } else {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, copperOre);
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, tinOre);
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, saltOre);
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, mithrilOre);
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, platinumOre);
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, blackDiamondOre);
            }
        }
    }
}