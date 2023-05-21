package com.infamous.infamous_legends.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.capabilities.MobHorde;
import com.infamous.infamous_legends.capabilities.MobHordeProvider;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

@Mixin(LivingEntityRenderer.class)
public class LivingRendererMixin<T extends LivingEntity, M extends EntityModel<T>> {

    @ModifyVariable(method = "Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;getRenderType(Lnet/minecraft/world/entity/LivingEntity;ZZZ)Lnet/minecraft/client/renderer/RenderType;", at = @At("STORE"), ordinal = 0)
    private ResourceLocation infamous_legends_getRenderType(ResourceLocation value, T entity, boolean p_115323_, boolean p_115324_, boolean p_115325_) {
    	MobHorde mobHorde = entity.getCapability(MobHordeProvider.HORDE).orElse(new MobHorde());
    	if (mobHorde.getHorde() != null) {
    		ResourceLocation newTexture = new ResourceLocation(value.toString().replace(".png", "_" + mobHorde.getHorde().getName() + ".png"));
    		if (Minecraft.getInstance().getResourceManager().getResource(newTexture).isPresent()) {
    			return newTexture;
    		}
    	}
        return value;
    }
}