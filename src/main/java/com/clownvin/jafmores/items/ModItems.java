package com.clownvin.jafmores.items;

import com.clownvin.jafmores.JAFMOres;
import com.clownvin.jafmores.ModResource;
import com.clownvin.jafmores.blocks.ModBlock;
import com.clownvin.jafmores.blocks.ModBlockOre;
import com.clownvin.jafmores.blocks.ModBlocks;
import javafx.geometry.Side;
import net.minecraft.block.Block;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.registry.IRegistry;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = JAFMOres.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {

    public static Item copperOre;
    public static Item tinOre;
    public static Item copperAndTinOre;
    public static Item bronzeIngot;
    public static Item bronzeBlock;
    public static Item mithrilOre;
    public static Item mithrilIngot;
    public static Item mithrilBlock;
    public static Item platinumOre;
    public static Item platinumIngot;
    public static Item platinumBlock;
    public static Item saltOre;
    public static Item salt;
    public static Item saltBlock;
    public static Item blackDiamondOre;
    public static Item blackDiamond;
    public static Item blackDiamondBlock;
    //bronze armor
    public static Item bronzeChestplate;
    public static Item bronzeHelmet;
    public static Item bronzeLegs;
    public static Item bronzeBoots;
    //bronze tools
    public static Item bronzeSword;
    public static Item bronzeHoe;
    public static Item bronzePickaxe;
    public static Item bronzeAxe;
    public static Item bronzeShovel;
    //mithril armor
    public static Item mithrilChestplate;
    public static Item mithrilHelmet;
    public static Item mithrilLegs;
    public static Item mithrilBoots;
    //mithril tools
    public static Item mithrilSword;
    public static Item mithrilHoe;
    public static Item mithrilPickaxe;
    public static Item mithrilAxe;
    public static Item mithrilShovel;
    //black diamond armor
    public static Item blackDiamondChestplate;
    public static Item blackDiamondHelmet;
    public static Item blackDiamondLegs;
    public static Item blackDiamondBoots;
    //black diamond tools
    public static Item blackDiamondSword;
    public static Item blackDiamondHoe;
    public static Item blackDiamondPickaxe;
    public static Item blackDiamondAxe;
    public static Item blackDiamondShovel;
    //platinum equipment
    //public static Item platinumCrown;
    public static Item platinumChestplate;
    public static Item platinumHelmet;
    public static Item platinumLegs;
    public static Item platinumBoots;
    //sulfur
    public static Item sulfur;
    public static Item sulfurOre;
    //jerky
    public static Item jerky;

    private static Item[] items;

    private static ItemBlock wrapBlock(Block block) {
        ItemBlock wrapped = new ItemBlock(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        wrapped.setRegistryName(block.getRegistryName());
        return wrapped;
    }

    public static void preInit() {
        //System.out.println("Started item preinit");
        copperOre = wrapBlock(ModBlocks.copper_ore_block);
        tinOre = wrapBlock(ModBlocks.tin_ore_block);
        copperAndTinOre = (new Item(new Item.Properties().group(ItemGroup.MATERIALS))).setRegistryName(JAFMOres.MODID, "copper_tin_item");
        bronzeIngot = (new Item(new Item.Properties().group(ItemGroup.MATERIALS))).setRegistryName(JAFMOres.MODID, "bronze_ingot");
        bronzeBlock = wrapBlock(ModBlocks.bronze_block);
        mithrilOre = wrapBlock(ModBlocks.mithril_ore_block);
        mithrilIngot = (new Item(new Item.Properties().group(ItemGroup.MATERIALS))).setRegistryName(JAFMOres.MODID, "mithril_ingot");
        mithrilBlock = wrapBlock(ModBlocks.mithril_block);
        platinumOre = wrapBlock(ModBlocks.platinum_ore_block);
        platinumIngot = (new Item(new Item.Properties().group(ItemGroup.MATERIALS))).setRegistryName(JAFMOres.MODID, "platinum_ingot");
        platinumBlock = wrapBlock(ModBlocks.platinum_block);
        saltOre = wrapBlock(ModBlocks.salt_ore_block);
        salt = (new Item(new Item.Properties().group(ItemGroup.MATERIALS))).setRegistryName(JAFMOres.MODID, "salt_item");
        saltBlock = wrapBlock(ModBlocks.salt_block);
        blackDiamondOre = wrapBlock(ModBlocks.black_diamond_ore_block);
        blackDiamond = (new Item(new Item.Properties().group(ItemGroup.MATERIALS))).setRegistryName(JAFMOres.MODID, "black_diamond_item");
        blackDiamondBlock = wrapBlock(ModBlocks.black_diamond_block);
        /*
        LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F),
        CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F),
        IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F),
        GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F),
        DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
         */
        bronzeChestplate = new ModArmor(ModResource.BRONZE, EntityEquipmentSlot.CHEST);
        bronzeHelmet = new ModArmor(ModResource.BRONZE, EntityEquipmentSlot.HEAD);
        bronzeLegs = new ModArmor(ModResource.BRONZE, EntityEquipmentSlot.LEGS);
        bronzeBoots = new ModArmor(ModResource.BRONZE, EntityEquipmentSlot.FEET);
        mithrilChestplate = new ModArmor(ModResource.MITHRIL, EntityEquipmentSlot.CHEST);
        mithrilHelmet = new ModArmor(ModResource.MITHRIL, EntityEquipmentSlot.HEAD);
        mithrilLegs = new ModArmor(ModResource.MITHRIL, EntityEquipmentSlot.LEGS);
        mithrilBoots = new ModArmor(ModResource.MITHRIL, EntityEquipmentSlot.FEET);
        blackDiamondChestplate = new ModArmor(ModResource.BLACK_DIAMOND, EntityEquipmentSlot.CHEST);
        blackDiamondHelmet = new ModArmor(ModResource.BLACK_DIAMOND, EntityEquipmentSlot.HEAD);
        blackDiamondLegs = new ModArmor(ModResource.BLACK_DIAMOND, EntityEquipmentSlot.LEGS);
        blackDiamondBoots = new ModArmor(ModResource.BLACK_DIAMOND, EntityEquipmentSlot.FEET);
        platinumHelmet = new ModArmor(ModResource.PLATINUM, EntityEquipmentSlot.HEAD);
        platinumChestplate = new ModArmor(ModResource.PLATINUM, EntityEquipmentSlot.CHEST);
        platinumLegs = new ModArmor(ModResource.PLATINUM, EntityEquipmentSlot.LEGS);
        platinumBoots = new ModArmor(ModResource.PLATINUM, EntityEquipmentSlot.FEET);
        //platinumCrown = new ItemArmor(platinumCrownMaterial, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("platinum_crown");
        /*
         WOOD(0, 59, 2.0F, 0.0F, 15),
        STONE(1, 131, 4.0F, 1.0F, 5),
        IRON(2, 250, 6.0F, 2.0F, 14),
        DIAMOND(3, 1561, 8.0F, 3.0F, 10),
        GOLD(0, 32, 12.0F, 0.0F, 22);
         */
        bronzeSword = new ModSword(ModResource.BRONZE);
        bronzePickaxe = new ModPickaxe(ModResource.BRONZE);
        bronzeAxe = new ModAxe(ModResource.BRONZE);
        bronzeHoe = new ModHoe(ModResource.BRONZE);
        bronzeShovel = new ModSpade(ModResource.BRONZE);
        mithrilSword = new ModSword(ModResource.MITHRIL);
        mithrilPickaxe = new ModPickaxe(ModResource.MITHRIL);
        mithrilAxe = new ModAxe(ModResource.MITHRIL);
        mithrilHoe = new ModHoe(ModResource.MITHRIL);
        mithrilShovel = new ModSpade(ModResource.MITHRIL);
        blackDiamondSword = new ModSword(ModResource.BLACK_DIAMOND);
        blackDiamondPickaxe = new ModPickaxe(ModResource.BLACK_DIAMOND);
        blackDiamondAxe = new ModAxe(ModResource.BLACK_DIAMOND);
        blackDiamondHoe = new ModHoe(ModResource.BLACK_DIAMOND);
        blackDiamondShovel = new ModSpade(ModResource.BLACK_DIAMOND);
        jerky = new Jerky();
        sulfurOre = wrapBlock(ModBlocks.sulfur_ore_block);
        sulfur = (new Item(new Item.Properties().group(ItemGroup.MATERIALS))).setRegistryName(JAFMOres.MODID, "sulfur_item");
        items = new Item[]
                {
                        copperOre, tinOre, copperAndTinOre,
                        bronzeIngot, bronzeBlock, mithrilOre,
                        mithrilIngot, mithrilBlock, platinumOre,
                        platinumIngot, platinumBlock, saltOre, salt,
                        saltBlock, blackDiamondOre, blackDiamond, blackDiamondBlock,
                        bronzeChestplate, bronzeHelmet, bronzeLegs, bronzeBoots,
                        mithrilChestplate, mithrilHelmet, mithrilLegs, mithrilBoots,
                        blackDiamondChestplate, blackDiamondHelmet, blackDiamondLegs, blackDiamondBoots, /*platinumCrown,*/
                        bronzeSword, bronzePickaxe, bronzeAxe, bronzeHoe, bronzeShovel,
                        mithrilSword, mithrilPickaxe, mithrilAxe, mithrilHoe, mithrilShovel,
                        blackDiamondSword, blackDiamondPickaxe, blackDiamondAxe, blackDiamondHoe, blackDiamondShovel,
                        jerky, sulfur, platinumHelmet, platinumChestplate, platinumLegs, platinumBoots, sulfurOre
                };
        //System.out.println("finished item preinit");preinitFinished = true;

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        //System.out.println("Registering item..2.");
        for (Item item : items) {
            //item.setRegistryName(JAFMOres.MODID, item.getTranslationKey().replace("tile.", "").replace("item.", ""));
            //System.out.println("Registering item: "+item.getRegistryName());
            event.getRegistry().register(item);
        }
        //System.out.println("Finished registering item");
    }
}
