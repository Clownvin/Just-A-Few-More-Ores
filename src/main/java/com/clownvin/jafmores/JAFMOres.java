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
    }

    private static CompositeFeature<?, ?> getOreGenFeature(Block ore, int size, int count, int avgHeight, int spread) {
        return Biome.createCompositeFeature(Feature.MINABLE, new MinableConfig((blockState) -> Tags.Blocks.STONE.contains(blockState.getBlock()) || Tags.Blocks.ORES.contains(blockState.getBlock()), ore.getDefaultState(), size), Biome.DEPTH_AVERAGE, new DepthAverageConfig(count, avgHeight, spread));
    }

    private static CompositeFeature<?, ?> getNetherOreGenFeature(Block ore, int size, int count) {
        return Biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(BlockMatcher.forBlock(Blocks.NETHERRACK), ore.getDefaultState(), size), Biome.COUNT_RANGE, new CountRangeConfig(count, 10, 20, 128));
    }

    @SubscribeEvent
    public static void onJoinGame(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
        if (!Config.COMMON.showNewUpdateNotifications.get())
            return;
        IModInfo info = ModList.get().getModContainerById(MODID).get().getModInfo();
        VersionChecker.CheckResult result = VersionChecker.getResult(info);
        if (result.target == null || result.target.getCanonical().compareTo(info.getVersion().getQualifier()) <= 0) {
            return;
        }
        event.getPlayer().sendMessage(new TextComponentTranslation("text.new_update_notification", "jafmores-"+result.target.getCanonical()));
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