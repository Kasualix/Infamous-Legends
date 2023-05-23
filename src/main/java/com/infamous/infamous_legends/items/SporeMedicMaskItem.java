package com.infamous.infamous_legends.items;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.armor.SporeMedicMaskModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class SporeMedicMaskItem extends ArmorItem implements IClientItemExtensions {

	public SporeMedicMaskItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
		super(pMaterial, pSlot, pProperties);
	}
	
	@Override
	public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return InfamousLegends.MOD_ID + ":textures/armor/spore_medic_mask.png";
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
	                return new SporeMedicMaskModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayerInit.SPORE_MEDIC_MASK));
	            }
	        });
	    }
	
}
