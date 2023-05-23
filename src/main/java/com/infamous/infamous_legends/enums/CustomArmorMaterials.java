package com.infamous.infamous_legends.enums;

import java.util.function.Supplier;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public enum CustomArmorMaterials implements ArmorMaterial {
	   SPORE_MEDIC_MASK("spore_medic_mask", 16, new int[]{1, 2, 3, 2}, 20, SoundEvents.ARMOR_EQUIP_CHAIN, 1.0F, 0.0F, () -> {
		      return Ingredient.of(Items.GOLD_INGOT);
		   }),
	   PIGMADILLO_SHELL("pigmadillo_shell", 25, new int[]{1, 2, 7, 2}, 12, SoundEvents.ARMOR_EQUIP_TURTLE, 2.0F, 0.2F, () -> {
		      return Ingredient.of(Items.BONE_BLOCK);
		   });

		   private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
		   private final String name;
		   private final int durabilityMultiplier;
		   private final int[] slotProtections;
		   private final int enchantmentValue;
		   private final SoundEvent sound;
		   private final float toughness;
		   private final float knockbackResistance;
		   private final LazyLoadedValue<Ingredient> repairIngredient;

		   private CustomArmorMaterials(String pName, int pDurabilityMultiplier, int[] pSlotProtections, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Supplier<Ingredient> pRepairIngredient) {
		      this.name = pName;
		      this.durabilityMultiplier = pDurabilityMultiplier;
		      this.slotProtections = pSlotProtections;
		      this.enchantmentValue = pEnchantmentValue;
		      this.sound = pSound;
		      this.toughness = pToughness;
		      this.knockbackResistance = pKnockbackResistance;
		      this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
		   }

		   public int getDurabilityForSlot(EquipmentSlot pSlot) {
		      return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
		   }

		   public int getDefenseForSlot(EquipmentSlot pSlot) {
		      return this.slotProtections[pSlot.getIndex()];
		   }

		   public int getEnchantmentValue() {
		      return this.enchantmentValue;
		   }

		   public SoundEvent getEquipSound() {
		      return this.sound;
		   }

		   public Ingredient getRepairIngredient() {
		      return this.repairIngredient.get();
		   }

		   public String getName() {
		      return this.name;
		   }

		   public float getToughness() {
		      return this.toughness;
		   }

		   /**
		    * Gets the percentage of knockback resistance provided by armor of the material.
		    */
		   public float getKnockbackResistance() {
		      return this.knockbackResistance;
		   }
		}
