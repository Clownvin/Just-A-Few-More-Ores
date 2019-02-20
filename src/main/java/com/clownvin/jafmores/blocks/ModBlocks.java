package com.clownvin.jafmores.blocks;

import com.clownvin.jafmores.JAFMOres;
import com.clownvin.jafmores.ModResource;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JAFMOres.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {

    public static Block copper_ore_block;
    public static Block tin_ore_block;
    public static Block bronze_block;
    public static Block mithril_block;
    public static Block mithril_ore_block;
    public static Block platinum_block;
    public static Block platinum_ore_block;
    public static Block salt_block;
    public static Block salt_ore_block;
    public static Block black_diamond_block;
    public static Block black_diamond_ore_block;
    public static Block sulfur_ore_block;
    private static Block[] blocks;

    public static void preInit() {
        copper_ore_block = new ModBlockOre(ModResource.COPPER);
        tin_ore_block = new ModBlockOre(ModResource.TIN);
        bronze_block = new ModBlockMineral(ModResource.BRONZE);
        mithril_block = new ModBlockMineral(ModResource.MITHRIL);
        mithril_ore_block = new ModBlockOre(ModResource.MITHRIL);
        platinum_block = new ModBlockMineral(ModResource.PLATINUM);
        platinum_ore_block = new ModBlockOre(ModResource.PLATINUM);
        salt_block = new ModBlock(ModResource.SALT);
        salt_ore_block = new ModBlockOre(ModResource.SALT);
        black_diamond_block = new ModBlockMineral(ModResource.BLACK_DIAMOND);
        black_diamond_ore_block = new ModBlockOre(ModResource.BLACK_DIAMOND);
        sulfur_ore_block = new ModBlockOre(ModResource.SULFUR);
        blocks = new Block[] {copper_ore_block, tin_ore_block, bronze_block, mithril_block, mithril_ore_block, platinum_block, platinum_ore_block, salt_block, salt_ore_block, black_diamond_block, black_diamond_ore_block, sulfur_ore_block};
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        //System.out.println("Registering block...2");
        for (Block block : blocks) {
            //System.out.println("Registering block: "+block.getRegistryName());
            event.getRegistry().register(block);
        }
        //System.out.println("Finished registering block");
    }
}
