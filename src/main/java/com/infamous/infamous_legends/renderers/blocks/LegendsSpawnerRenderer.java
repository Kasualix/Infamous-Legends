package com.infamous.infamous_legends.renderers.blocks;

import com.infamous.infamous_legends.blocks.entities.LegendsSpawnerBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LegendsSpawnerRenderer implements BlockEntityRenderer<LegendsSpawnerBlockEntity> {
   private final EntityRenderDispatcher entityRenderer;

   public LegendsSpawnerRenderer(BlockEntityRendererProvider.Context pContext) {
      this.entityRenderer = pContext.getEntityRenderer();
   }

   @SuppressWarnings({ "unchecked", "rawtypes" })
	public void render(LegendsSpawnerBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
	      pPoseStack.pushPose();
	      pPoseStack.translate(0.5D, 1.0D, 0.5D);
	      if (pBlockEntity.getLegendsSpawnerData() != null) {
	      Entity entity = pBlockEntity.getLegendsSpawnerData().getEntityType().create(pBlockEntity.getLevel());
		      if (entity != null) {
			     pPoseStack.translate(0.0D, (double)0.4F, 0.0D);
			     pPoseStack.mulPose(Vector3f.YP.rotationDegrees((float)Mth.lerp((double)pPartialTick * 0.5, pBlockEntity.tickCount, pBlockEntity.tickCount * 1.0F)));
			     pPoseStack.translate(0.0D, (double)-0.2F, 0.0D);
			     pPoseStack.scale(1, -1, 1);
			     pPoseStack.translate(0.0D, (double)-1.45F, 0.0D);
		         if (this.entityRenderer.getRenderer(entity) != null && this.entityRenderer.getRenderer(entity) instanceof LivingEntityRenderer) {
		        	 LivingEntityRenderer livingRenderer = ((LivingEntityRenderer)this.entityRenderer.getRenderer(entity));
		        	 
		        	 RenderType renderType = RenderType.entityTranslucent(livingRenderer.getTextureLocation(entity));
		        	 
		        	 EntityModel model = livingRenderer.getModel();
		        	 
		        	 model.setupAnim(entity, 0, 0, pPartialTick, 0, 0);
		        	 model.renderToBuffer(pPoseStack, pBufferSource.getBuffer(renderType), 15728640, OverlayTexture.NO_OVERLAY, 0.65F, 0.65F, 1.0F, 0.75F);
		         }
		      }
	      }
	      
	      pPoseStack.popPose();
	   }
	}