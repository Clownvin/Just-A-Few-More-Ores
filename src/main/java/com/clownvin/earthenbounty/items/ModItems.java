package com.clownvin.earthenbounty.items;

import com.clownvin.earthenbounty.EarthenBounty;
import com.clownvin.earthenbounty.ModResource;
import com.clownvin.earthenbounty.blocks.ModBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

@Mod.EventBusSubscriber(modid = EarthenBounty.MODID)
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
    public static Item platinumCrown;
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

    public static void preInit() {
        //System.out.println("Started items preinit");
        copperOre = new ItemBlock(ModBlocks.copper_ore_block);
        tinOre = new ItemBlock(ModBlocks.tin_ore_block);
        copperAndTinOre = (new Item()).setUnlocalizedName("copper_tin_item").setCreativeTab(CreativeTabs.MATERIALS);
        bronzeIngot = (new Item()).setUnlocalizedName("bronze_ingot").setCreativeTab(CreativeTabs.MATERIALS);
        bronzeBlock = new ItemBlock(ModBlocks.bronze_block);
        mithrilOre = new ItemBlock(ModBlocks.mithril_ore_block);
        mithrilIngot = (new Item()).setUnlocalizedName("mithril_ingot").setCreativeTab(CreativeTabs.MATERIALS);
        mithrilBlock = new ItemBlock(ModBlocks.mithril_block);
        platinumOre = new ItemBlock(ModBlocks.platinum_ore_block);
        platinumIngot = (new Item()).setUnlocalizedName("platinum_ingot").setCreativeTab(CreativeTabs.MATERIALS);
        platinumBlock = new ItemBlock(ModBlocks.platinum_block);
        saltOre = new ItemBlock(ModBlocks.salt_ore_block);
        salt = (new Item()).setUnlocalizedName("salt_item").setCreativeTab(CreativeTabs.MATERIALS);
        saltBlock = new ItemBlock(ModBlocks.salt_block);
        blackDiamondOre = new ItemBlock(ModBlocks.black_diamond_ore_block);
        blackDiamond = (new Item()).setUnlocalizedName("black_diamond_item").setCreativeTab(CreativeTabs.MATERIALS);
        blackDiamondBlock = new ItemBlock(ModBlocks.black_diamond_block);
        /*
        LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F),
        CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F),
        IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F),
        GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F),
        DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
         */
        ItemArmor.ArmorMaterial bronzeArmorMaterial = EnumHelper.addArmorMaterial("bronze", "earthenbounty:bronze", 12, new int[] { 2, 4, 5, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5f).setRepairItem(new ItemStack(ModItems.bronzeIngot));
        bronzeChestplate = new ItemArmor(bronzeArmorMaterial, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("bronze_chestplate");
        bronzeHelmet = new ItemArmor(bronzeArmorMaterial, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("bronze_helmet");
        bronzeLegs = new ItemArmor(bronzeArmorMaterial, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("bronze_legs");
        bronzeBoots = new ItemArmor(bronzeArmorMaterial, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("bronze_boots");
        ItemArmor.ArmorMaterial mithrilArmorMaterial = EnumHelper.addArmorMaterial("mithril", "earthenbounty:mithril", 22, new int[] { 3, 5, 6, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.5f).setRepairItem(new ItemStack(ModItems.mithrilIngot));
        mithrilChestplate = new ItemArmor(mithrilArmorMaterial, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("mithril_chestplate");
        mithrilHelmet = new ItemArmor(mithrilArmorMaterial, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("mithril_helmet");
        mithrilLegs = new ItemArmor(mithrilArmorMaterial, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("mithril_legs");
        mithrilBoots = new ItemArmor(mithrilArmorMaterial, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("mithril_boots");
        ItemArmor.ArmorMaterial blackDiamondArmorMaterial = EnumHelper.addArmorMaterial("black_diamond", "earthenbounty:black_diamond", 50, new int[] { 4, 6, 7, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5f).setRepairItem(new ItemStack(ModItems.blackDiamond));
        blackDiamondChestplate = new ItemArmor(blackDiamondArmorMaterial, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("black_diamond_chestplate");
        blackDiamondHelmet = new ItemArmor(blackDiamondArmorMaterial, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("black_diamond_helmet");
        blackDiamondLegs = new ItemArmor(blackDiamondArmorMaterial, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("black_diamond_legs");
        blackDiamondBoots = new ItemArmor(blackDiamondArmorMaterial, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("black_diamond_boots");
        ItemArmor.ArmorMaterial platinumArmorMaterial = EnumHelper.addArmorMaterial("platinum", "earthenbounty:platinum", 33, new int[] { 3, 4, 5, 6}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.25f).setRepairItem(new ItemStack(ModItems.platinumIngot));
        platinumHelmet = new ItemArmor(platinumArmorMaterial, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("platinum_helmet");
        platinumChestplate = new ItemArmor(platinumArmorMaterial, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("platinum_chestplate");
        platinumLegs = new ItemArmor(platinumArmorMaterial, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("platinum_legs");
        platinumBoots = new ItemArmor(platinumArmorMaterial, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("platinum_boots");
        ItemArmor.ArmorMaterial platinumCrownMaterial = EnumHelper.addArmorMaterial("platinum_crown", "earthenbounty:platinum_crown", 45, new int[] { 0, 0, 0, 8}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.25f).setRepairItem(new ItemStack(ModItems.platinumIngot));
        platinumCrown = new ItemArmor(platinumCrownMaterial, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("platinum_crown");
        /*
         WOOD(0, 59, 2.0F, 0.0F, 15),
        STONE(1, 131, 4.0F, 1.0F, 5),
        IRON(2, 250, 6.0F, 2.0F, 14),
        DIAMOND(3, 1561, 8.0F, 3.0F, 10),
        GOLD(0, 32, 12.0F, 0.0F, 22);
         */
        ItemTool.ToolMaterial bronzeToolMaterial = EnumHelper.addToolMaterial("bronze", 2, 180, 5f, 1.75f, 9).setRepairItem(new ItemStack(ModItems.bronzeIngot));
        bronzeSword = new ItemSword(bronzeToolMaterial).setUnlocalizedName("bronze_sword");
        bronzePickaxe = new ModPickaxe(bronzeToolMaterial).setUnlocalizedName("bronze_pickaxe");
        bronzeAxe = new ModAxe(bronzeToolMaterial).setUnlocalizedName("bronze_axe");
        bronzeHoe = new ItemHoe(bronzeToolMaterial).setUnlocalizedName("bronze_hoe");
        bronzeShovel = new ItemSpade(bronzeToolMaterial).setUnlocalizedName("bronze_shovel");
        ItemTool.ToolMaterial mithrilToolMaterial = EnumHelper.addToolMaterial("mithril", 3, 731, 7f, 2.5f, 16).setRepairItem(new ItemStack(ModItems.mithrilIngot));
        mithrilSword = new ItemSword(mithrilToolMaterial).setUnlocalizedName("mithril_sword");
        mithrilPickaxe = new ModPickaxe(mithrilToolMaterial).setUnlocalizedName("mithril_pickaxe");
        mithrilAxe = new ModAxe(mithrilToolMaterial).setUnlocalizedName("mithril_axe");
        mithrilHoe = new ItemHoe(mithrilToolMaterial).setUnlocalizedName("mithril_hoe");
        mithrilShovel = new ItemSpade(mithrilToolMaterial).setUnlocalizedName("mithril_shovel");
        ItemTool.ToolMaterial blackDiamondToolMaterial = EnumHelper.addToolMaterial("black_diamond", 4, 3055, 13.0f, 3.75f, 14).setRepairItem(new ItemStack(ModItems.blackDiamond));
        blackDiamondSword = new ItemSword(blackDiamondToolMaterial).setUnlocalizedName("black_diamond_sword");
        blackDiamondPickaxe = new ModPickaxe(blackDiamondToolMaterial).setUnlocalizedName("black_diamond_pickaxe");
        blackDiamondAxe = new ModAxe(blackDiamondToolMaterial).setUnlocalizedName("black_diamond_axe");
        blackDiamondHoe = new ItemHoe(blackDiamondToolMaterial).setUnlocalizedName("black_diamond_hoe");
        blackDiamondShovel = new ItemSpade(blackDiamondToolMaterial).setUnlocalizedName("black_diamond_shovel");
        jerky = new Jerky();
        sulfurOre = new ItemBlock(ModBlocks.sulfur_ore_block);
        sulfur = (new Item()).setUnlocalizedName("sulfur_item").setCreativeTab(CreativeTabs.MATERIALS);
        items = new Item[]
                {
                        copperOre, tinOre, copperAndTinOre,
                        bronzeIngot, bronzeBlock, mithrilOre,
                        mithrilIngot, mithrilBlock, platinumOre,
                        platinumIngot, platinumBlock, saltOre, salt,
                        saltBlock, blackDiamondOre, blackDiamond, blackDiamondBlock,
                        bronzeChestplate, bronzeHelmet, bronzeLegs, bronzeBoots,
                        mithrilChestplate, mithrilHelmet, mithrilLegs, mithrilBoots,
                        blackDiamondChestplate, blackDiamondHelmet, blackDiamondLegs, blackDiamondBoots, platinumCrown,
                        bronzeSword, bronzePickaxe, bronzeAxe, bronzeHoe, bronzeShovel,
                        mithrilSword, mithrilPickaxe, mithrilAxe, mithrilHoe, mithrilShovel,
                        blackDiamondSword, blackDiamondPickaxe, blackDiamondAxe, blackDiamondHoe, blackDiamondShovel,
                        jerky, sulfur, platinumHelmet, platinumChestplate, platinumLegs, platinumBoots, sulfurOre
                };
        //System.out.println("finished items preinit");preinitFinished = true;

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        //System.out.println("Registering items...");
        for (Item item : items) {
            item.setRegistryName(EarthenBounty.MODID, item.getUnlocalizedName().replace("tile.", "").replace("item.", ""));
            //System.out.println("Registering item with registry name: "+item.getRegistryName());
            event.getRegistry().register(item);
        }
        OreDictionary.registerOre("oreCopper", copperOre);
        OreDictionary.registerOre("oreTin", tinOre);
        OreDictionary.registerOre("blockBronze", bronzeBlock);
        OreDictionary.registerOre("blockMithril", mithrilBlock);
        OreDictionary.registerOre("ironBlockReplacement", bronzeBlock);
        OreDictionary.registerOre("ironBlockReplacement", mithrilBlock);
        OreDictionary.registerOre("ironBlockReplacement", Item.getItemFromBlock(Blocks.IRON_BLOCK));
        OreDictionary.registerOre("oreMithril", mithrilOre);
        OreDictionary.registerOre("blockPlatinum", platinumBlock);
        OreDictionary.registerOre("orePlatinum", platinumOre);
        OreDictionary.registerOre("blockSalt", saltBlock);
        OreDictionary.registerOre("oreSalt", saltOre);
        OreDictionary.registerOre("blockBlackDiamond", blackDiamondBlock);
        OreDictionary.registerOre("oreBlackDiamond", blackDiamondOre);
        OreDictionary.registerOre("ingotPlatinum", platinumIngot);
        OreDictionary.registerOre("ingotMithril", mithrilIngot);
        OreDictionary.registerOre("ingotBronze", bronzeIngot);
        OreDictionary.registerOre("ironIngotReplacement", mithrilIngot);
        OreDictionary.registerOre("ironIngotReplacement", bronzeIngot);
        OreDictionary.registerOre("ironIngotReplacement", Items.IRON_INGOT);
        OreDictionary.registerOre("gemBlackDiamond", blackDiamond);
        OreDictionary.registerOre("salt", salt);
        OreDictionary.registerOre("sulfur", sulfur);
        OreDictionary.registerOre("t1meat", Items.PORKCHOP);
        OreDictionary.registerOre("t1meat", Items.BEEF);
        OreDictionary.registerOre("t2meat", Items.CHICKEN);
        OreDictionary.registerOre("t1meat", Items.MUTTON);
        OreDictionary.registerOre("t2meat", Items.RABBIT);
        OreDictionary.registerOre("t2meat", Items.FISH);
        //System.out.println("Finished registering items");
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        //System.out.println("Registering models for items...");
        for (Item item : items) {
            //item.setRegistryName(EarthenBounty.MODID, item.getUnlocalizedName());
            //System.out.println("Registering model for item with registry name: "+item.getRegistryName());
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
        //System.out.println("Finished registering models for items");
    }
}
