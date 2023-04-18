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

			if (!pLivingEntity.isInvisible() && pLivingEntity.getWood2Type().getTextureLocation() != null && !pLivingEntity.getWood2Type().getTextureLocation().isEmpty() && !pLivingEntity.getWood2Type().getTextureLocation().isBlank()) {
				VertexConsumer vertexconsumer = pBuffer.getBuffer(RenderType.entityTranslucent(new ResourceLocation(pLivingEntity.getWood2Type().getTextureLocation())));
				this.getParentModel().renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, pLivingEntity.hurtTime > 0 || pLivingEntity.deathTime > 0 ? OverlayTexture.RED_OVERLAY_V : OverlayTexture.NO_OVERLAY, 1.0F,
						1.0F, 1.0F, 1.0F);
			}
		
	}
}