package com.infamous.infamous_legends.renderers.layers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.Sporeback;
import com.infamous.infamous_legends.models.SporebackModel;
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
public class SporebackGlowLayer<T extends Sporeback> extends RenderLayer<T, SporebackModel<T>> {

   public SporebackGlowLayer(RenderLayerParent<T, SporebackModel<T>> p_116964_) {
      super(p_116964_);
   }
   
	public void render(PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity,
			float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw,
			float pHeadPitch) {
		VertexConsumer vertexconsumer = pBuffer.getBuffer(RenderType.eyes(
				new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/sporeback_glow.png")));
		this.getParentModel().renderToBuffer(pMatrixStack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F,
				1.0F, 1.0F, 1.0F);
	}
}