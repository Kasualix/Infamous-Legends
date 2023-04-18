package com.infamous.infamous_legends.renderers.layers;

import com.infamous.infamous_legends.entities.FirstOfOak;
import com.infamous.infamous_legends.models.FirstOfOakModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FirstOfOakSecondaryTypeLayer<T extends FirstOfOak> extends RenderLayer<T, FirstOfOakModel<T>> {

   public FirstOfOakSecondaryTypeLayer(RenderLayerParent<T, FirstOfOakModel<T>> p_116964_) {
      super(p_116964_);
   }
   
	public void render(PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity,
			float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw,
			float pHeadPitch) {
		
		pMatrixStack.pushPose();
			if (pLivingEntity.getWood2Type().getTextureLocation() != null && !pLivingEntity.getWood2Type().getTextureLocation().isEmpty() && !pLivingEntity.getWood2Type().getTextureLocation().isBlank()) {
				VertexConsumer vertexconsumer = pBuffer.getBuffer(RenderType.entityTranslucent(new ResourceLocation(pLivingEntity.getWood2Type().getTextureLocation())));
				this.getParentModel().renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F,
						1.0F, 1.0F, 1.0F);
			}
		pMatrixStack.popPose();
		
		pMatrixStack.pushPose();
			if (pLivingEntity.getWood1Type().getGlowTextureLocation() != null && !pLivingEntity.getWood1Type().getGlowTextureLocation().isEmpty() && !pLivingEntity.getWood1Type().getGlowTextureLocation().isBlank()) {
				VertexConsumer vertexconsumer = pBuffer.getBuffer(RenderType.eyes(new ResourceLocation(pLivingEntity.getWood1Type().getGlowTextureLocation())));
				this.getParentModel().renderToBuffer(pMatrixStack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F,
						1.0F, 1.0F, 1.0F);
			}
		pMatrixStack.popPose();
		
		pMatrixStack.pushPose();
			if (pLivingEntity.getWood2Type().getGlowTextureLocation() != null && !pLivingEntity.getWood2Type().getGlowTextureLocation().isEmpty() && !pLivingEntity.getWood2Type().getGlowTextureLocation().isBlank()) {
				VertexConsumer vertexconsumer = pBuffer.getBuffer(RenderType.eyes(new ResourceLocation(pLivingEntity.getWood2Type().getGlowTextureLocation())));
				this.getParentModel().renderToBuffer(pMatrixStack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F,
						1.0F, 1.0F, 1.0F);
			}	
		pMatrixStack.popPose();
		
	}
}