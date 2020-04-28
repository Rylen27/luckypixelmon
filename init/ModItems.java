package com.Rylen27.luckypixelmon.init;

import java.util.ArrayList;
import java.util.List;

import com.Rylen27.luckypixelmon.Main;
import com.Rylen27.luckypixelmon.items.AbigailsArrow;
import com.Rylen27.luckypixelmon.items.AbigailsBow;
import com.Rylen27.luckypixelmon.items.ItemBase;
import com.Rylen27.luckypixelmon.items.ItemHorseArmor;
import com.Rylen27.luckypixelmon.items.armor.ArmorBase;
import com.Rylen27.luckypixelmon.items.food.FoodBase;
import com.Rylen27.luckypixelmon.items.food.FoodEffectBase;
import com.Rylen27.luckypixelmon.items.tools.ToolAxe;
import com.Rylen27.luckypixelmon.items.tools.ToolSword;
import com.Rylen27.luckypixelmon.util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems
{

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//materials
	public static final ToolMaterial MATERIAL_HAILEYS_INGOT = EnumHelper.addToolMaterial("material_haileys_ingot", 3, 2010, 9, 8, 10);
	public static final ToolMaterial MATERIAL_EMILYS_INGOT = EnumHelper.addToolMaterial("material_emilys_ingot", 3, 2014, 9, 6, 10);
	public static final ToolMaterial MATERIAL_ABIGAILS_INGOT = EnumHelper.addToolMaterial("material_abigails_ingot", 3, 2008, 9, 9, 10);
	public static final ToolMaterial MATERIAL_DEATHSTEEL_INGOT = EnumHelper.addToolMaterial("material_deathsteel_ingot", 3, 1500, 9, 9, 10);
	public static final ArmorMaterial ARMOR_MATERIAL_HAILEYS = EnumHelper.addArmorMaterial("armor_material_haileys", Reference.MOD_ID + ":haileys", 16, 
			new int[] {3, 6, 8, 3} , 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	//				{boots, legs, chest, helmet}
	public static final ArmorMaterial ARMOR_MATERIAL_TEST = EnumHelper.addArmorMaterial("armor_material_test", Reference.MOD_ID + ":test", 16, 
			new int[] {3, 6, 8, 3} , 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	
	
	
	//Pixelmon Items
	public static final Item FUSION_GEMA = new ItemBase("fusion_gema");
	public static final Item FUSION_GEMB = new ItemBase("fusion_gemb");
	public static final Item MEGA_FUSION_GEM = new ItemBase("mega_fusion_gem");
	
	//Ingots
	public static final Item ALUMINUM_INGOT = new ItemBase("aluminum_ingot");
	public static final Item HAILEYS_INGOT = new ItemBase("haileys_ingot");
	public static final Item ABIGAILS_INGOT = new ItemBase("abigails_ingot");
	public static final Item EMILYS_INGOT = new ItemBase("emilys_ingot");
	public static final Item DEATHSTEEL_INGOT = new ItemBase("deathsteel_ingot");
	
	//Weapon and Tool Parts
	public static final Item HAILEYS_SWORD_BLADE = new ItemBase("haileys_sword_blade");
	public static final Item HAILEYS_SWORD_HILT = new ItemBase("haileys_sword_hilt");
	public static final Item HAILEYS_SWORD_HANDLE = new ItemBase("haileys_sword_handle");
	public static final Item EMILYS_AXE_BLADE = new ItemBase("emilys_axe_blade");
	public static final Item EMILYS_AXE_HEAD = new ItemBase("emilys_axe_head");
	public static final Item EMILYS_AXE_HANDLE = new ItemBase("emilys_axe_handle");
	public static final Item ABIGAILS_ARROW_HEAD = new ItemBase("abigails_arrow_head");
	public static final Item ABIGAILS_ARROW_SHAFT = new ItemBase("abigails_arrow_shaft");
	public static final Item ABIGAILS_BOW_LIMB = new ItemBase("abigails_bow_limb");
	public static final Item ABIGAILS_BOW_GRIP = new ItemBase("abigails_bow_grip");
	public static final Item ABIGAILS_BOW_STRING = new ItemBase("abigails_bow_string");
	public static final Item SOR_SWORD_BLADE = new ItemBase("sor_sword_blade");
	public static final Item SOR_SWORD_HILT = new ItemBase("sor_sword_hilt");
	public static final Item SOR_SWORD_HANDLE = new ItemBase("sor_sword_handle");
	public static final Item DEATHS_EYE = new ItemBase("deaths_eye");
	
	//Weapon and Tools
	public static final ItemSword HAILEYS_SWORD = new ToolSword("haileys_sword", MATERIAL_HAILEYS_INGOT);
	public static final ItemSword SOR_SWORD = new ToolSword("sor_sword", MATERIAL_DEATHSTEEL_INGOT);
	public static final ItemAxe EMILYS_AXE = new ToolAxe("emilys_axe", MATERIAL_EMILYS_INGOT);
	
	
	//Armor
	public static final Item HAILEYS_HELMET = new ArmorBase("haileys_helmet", ARMOR_MATERIAL_HAILEYS, 1, EntityEquipmentSlot.HEAD);
	public static final Item HAILEYS_CHESTPLATE = new ArmorBase("haileys_chestplate", ARMOR_MATERIAL_HAILEYS, 1, EntityEquipmentSlot.CHEST);
	public static final Item HAILEYS_LEGGINGS = new ArmorBase("haileys_leggings", ARMOR_MATERIAL_HAILEYS, 2, EntityEquipmentSlot.LEGS);
	public static final Item HAILEYS_BOOTS = new ArmorBase("haileys_boots", ARMOR_MATERIAL_HAILEYS, 1, EntityEquipmentSlot.FEET);
	
	//Horse Armor
	public static class ModHorseArmor {
		public static final HorseArmorType HAILEYS = EnumHelper.addHorseArmor("haileys", "luckypixelmon:textures/entity/horse/armor/horse_armor_haileys.png", 10);
		public static final HorseArmorType DEATHSTEEL = EnumHelper.addHorseArmor("deathsteel", "luckypixelmon:textures/entity/horse/armor/horse_armor_deathsteel.png", 12);
	}
	public static final Item HAILEYS_HORSE_ARMOR = new ItemHorseArmor(ModHorseArmor.HAILEYS).setCreativeTab(CreativeTabs.COMBAT).setRegistryName("haileys_horse_armor").setUnlocalizedName("horse_armor_haileys");
	public static final Item DEATHSTEEL_HORSE_ARMOR = new ItemHorseArmor(ModHorseArmor.DEATHSTEEL).setCreativeTab(CreativeTabs.COMBAT).setRegistryName("deathsteel_horse_armor").setUnlocalizedName("horse_armor_deathsteel");
	
	//Bows and Arrows
	public static final Item ABIGAILS_BOW = new AbigailsBow("abigails_bow");
	public static final Item ABIGAILS_ARROW = new AbigailsArrow("abigails_arrow");
	
	//Food
	public static final Item DRAGONFRUIT = new FoodBase("dragonfruit", 5, 2.8f, false);
	public static final Item MILK_BOTTLE = new FoodBase("milk_bottle", 1, 2.4f, false);
	public static final Item APPLE_JUICE_BOTTLE = new FoodBase("apple_juice_bottle", 6, 4.8f, false);
	public static final Item CHERRIES = new FoodBase("cherries", 3, 2.4f, false);
	
	//Cooking Supplies
	public static final Item BOTTLE_GLASS = new ItemBase("bottle_glass");
	public static final Item COCOA_POWDER = new ItemBase("cocoa_powder");
	//public static final Item DRAGONFRUIT = new FoodEffectBase("dragonfruit", 5, 2.8f, false, new PotionEffect(MobEffects.NIGHT_VISION, (120*20), 1, false, true));


}
