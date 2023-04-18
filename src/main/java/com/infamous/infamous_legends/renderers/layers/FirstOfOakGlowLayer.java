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
public class FirstOfOakGlowLayer<T extends FirstOfOak> extends RenderLayer<T, FirstOfOakModel<T>> {

   public FirstOfOakGlowLayer(RenderLayerParent<T, FirstOfOakModel<T>> p_116964_) {
      super(p_116964_);
   }
   
	public void render(PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity,
			float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw,
			float pHeadPitch) {

			if (pLivingEntity.getWood1Type().getGlowTextureLocation() != null && !pLivingEntity.getWood1Type().getGlowTextureLocation().isEmpty() && !pLivingEntity.getWood1Type().getGlowTextureLocation().isBlank()) {
				VertexConsumer vertexconsumer = pBuffer.getBuffer(RenderType.entityTranslucentEmissive(new ResourceLocation(pLivingEntity.getWood1Type().getGlowTextureLocation())));
				this.getParentModel().renderToBuffer(pMatrixStack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F,
						1.0F, 1.0F, 1.0F);
			}

			if (pLivingEntity.getWood2Type().getGlowTextureLocation() != null && !pLivingEntity.getWood2Type().getGlowTextureLocation().isEmpty() && !pLivingEntity.getWood2Type().getGlowTextureLocation().isBlank()) {
				VertexConsumer vertexconsumer = pBuffer.getBuffer(RenderType.entityTranslucentEmissive(new ResourceLocation(pLivingEntity.getWood2Type().getGlowTextureLocation())));
				this.getParentModel().renderToBuffer(pMatrixStack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F,
						1.0F, 1.0F, 1.0F);
			}	
	}
}