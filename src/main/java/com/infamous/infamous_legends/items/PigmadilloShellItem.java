package com.infamous.infamous_legends.items;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.armor.PigmadilloShellModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class PigmadilloShellItem extends ArmorItem implements IClientItemExtensions {

	private static final String TAG_ROLL_DEGREES = "RollDegrees";
	
	public PigmadilloShellItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
		super(pMaterial, pSlot, pProperties);
	}
	
	 public static float getRollDegrees(ItemStack stack) {
	      CompoundTag compoundtag = stack.getTag();
	      return compoundtag != null ? compoundtag.getFloat(TAG_ROLL_DEGREES) : 0;
	   }

	   public static void setRollDegrees(ItemStack stack, float pIsCharged) {
	      CompoundTag compoundtag = stack.getOrCreateTag();
	      compoundtag.putFloat(TAG_ROLL_DEGREES, pIsCharged);
	   }
	
	@Override
	public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return InfamousLegends.MOD_ID + ":textures/armor/pigmadillo_shell.png";
	}
	 
	 @Override 
	    public void initializeClient(Consumer<IClientItemExtensions> consumer)
	    {
		 super.initializeClient(consumer);
	        consumer.accept(new IClientItemExtensions()
	        {
	        	 @Override
	        		public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
	        				EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
	                return new PigmadilloShellModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayerInit.PIGMADILLO_SHELL));
	            }
	        });
	    }
	
}
