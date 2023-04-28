package com.infamous.infamous_legends.renderers.layers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.GrindstoneGolem;
import com.infamous.infamous_legends.models.GrindstoneGolemModel;
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
public class GrindstoneGolemGlowLayer<T extends GrindstoneGolem> extends RenderLayer<T, GrindstoneGolemModel<T>> {

   public GrindstoneGolemGlowLayer(RenderLayerParent<T, GrindstoneGolemModel<T>> p_116964_) {
      super(p_116964_);
   }
   
	public void render(PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity,
			float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw,
			float pHeadPitch) {
		VertexConsumer vertexconsumer = pBuffer.getBuffer(RenderType.entityTranslucentEmissive(
				new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/grindstone_golem_glow.png")));
		this.getParentModel().renderToBuffer(pMatrixStack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F,
				1.0F, 1.0F, 1.0F);
	}
}