package com.infamous.infamous_legends.renderers.blocks;

import com.infamous.infamous_legends.blocks.entities.PreservedMobBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PreservedMobRenderer implements BlockEntityRenderer<PreservedMobBlockEntity> {
   private final EntityRenderDispatcher entityRenderer;
   private final ItemRenderer itemRenderer;
   
   public PreservedMobRenderer(BlockEntityRendererProvider.Context pContext) {
      this.entityRenderer = pContext.getEntityRenderer();
      this.itemRenderer = pContext.getItemRenderer();
   }
	   
   @SuppressWarnings({ "unchecked", "rawtypes" })
	public void render(PreservedMobBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
	      pPoseStack.pushPose();
	      pPoseStack.translate(0.5D, 0.0D, 0.5D);
	      if (pBlockEntity.getEntityType() != null) {
	      Entity entity = pBlockEntity.getEntityType().create(pBlockEntity.getLevel());
		      if (entity != null) {
		          if (!pBlockEntity.tag.isEmpty()) {
		              CompoundTag compoundnbt = pBlockEntity.tag.copy();
		              entity.load(compoundnbt);
		          }
				 pPoseStack.translate((double)pBlockEntity.renderTranslation.getX() / 10, (double)pBlockEntity.renderTranslation.getY() / 10, (double)pBlockEntity.renderTranslation.getZ() / 10);
			     pPoseStack.mulPose(Vector3f.XP.rotationDegrees((float)pBlockEntity.renderRotation.getX()));
			     pPoseStack.mulPose(Vector3f.YP.rotationDegrees((float)pBlockEntity.renderRotation.getY()));
			     pPoseStack.mulPose(Vector3f.ZP.rotationDegrees((float)pBlockEntity.renderRotation.getZ()));
			     pPoseStack.scale((float)pBlockEntity.renderScale.getX() / 10, (float)pBlockEntity.renderScale.getY() / 10, (float)pBlockEntity.renderScale.getZ() / 10);
		         if (this.entityRenderer.getRenderer(entity) != null && this.entityRenderer.getRenderer(entity) instanceof EntityRenderer) {
		        	 EntityRenderer renderer = ((EntityRenderer)this.entityRenderer.getRenderer(entity));

		        	 if (entity instanceof ItemEntity) {
		        		 BakedModel bakedmodel = this.itemRenderer.getModel(((ItemEntity)entity).getItem(), entity.level, (LivingEntity)null, entity.getId());
		        		 this.itemRenderer.render(((ItemEntity)entity).getItem(), ItemTransforms.TransformType.GROUND, false, pPoseStack, pBufferSource, 15728640, OverlayTexture.NO_OVERLAY, bakedmodel);
		        	 } else {
		        		 renderer.render(entity, 0, pPartialTick, pPoseStack, pBufferSource, 15728640);
		        	 }
		         }
		      }
	      }
	      
	      pPoseStack.popPose();
	   }
	}