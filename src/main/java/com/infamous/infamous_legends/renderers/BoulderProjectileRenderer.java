package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.entities.BoulderProjectile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BoulderProjectileRenderer extends EntityRenderer<BoulderProjectile> {

	private final BlockRenderDispatcher dispatcher;
	   
   public BoulderProjectileRenderer(EntityRendererProvider.Context p_174420_) {
      super(p_174420_);
      this.shadowRadius = 1.25F;
      this.dispatcher = p_174420_.getBlockRenderDispatcher();
   }
   
   public void render(BoulderProjectile pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
	   pMatrixStack.pushPose();
	   pMatrixStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) + 180.0F));
	   pMatrixStack.mulPose(Vector3f.XP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) + 0.0F));
	   pMatrixStack.translate(0, -0.9, 0.4);
	   for (int i = 0; i < 8; i++) {
		  if (pEntity.getBlockState(i).isPresent()) {
		      BlockState blockstate = pEntity.getBlockState(i).get();
		      if (blockstate.getRenderShape() == RenderShape.MODEL) {
		         Level level = pEntity.getLevel();
		         if (blockstate != level.getBlockState(pEntity.blockPosition()) && blockstate.getRenderShape() != RenderShape.INVISIBLE) {
		            pMatrixStack.pushPose();
		            BlockPos blockpos = new BlockPos(pEntity.getX(), pEntity.getBoundingBox().maxY, pEntity.getZ());
		            pMatrixStack.translate(-0.5D, 1D, -0.5D);
		            this.offsetBlock(i, pMatrixStack);
		            var model = this.dispatcher.getBlockModel(blockstate);
		            for (var renderType : model.getRenderTypes(blockstate, RandomSource.create(blockstate.getSeed(pEntity.getStartPos())), net.minecraftforge.client.model.data.ModelData.EMPTY))
		               this.dispatcher.getModelRenderer().tesselateBlock(level, model, blockstate, blockpos, pMatrixStack, pBuffer.getBuffer(renderType), false, RandomSource.create(), blockstate.getSeed(pEntity.getStartPos()), OverlayTexture.NO_OVERLAY, net.minecraftforge.client.model.data.ModelData.EMPTY, renderType);
		            pMatrixStack.popPose();
		         }
		      }
		  }
	   }
	      pMatrixStack.popPose();
          super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
	   }
   
   public void offsetBlock(int blockIndex, PoseStack stack) {
	   switch (blockIndex) {
		   case 0:
			   stack.translate(0.5, -0.5, 0.5);
			   break;
		   case 1:
			   stack.translate(0.5, -0.5, -0.5);
			   break;
		   case 2:
			   stack.translate(-0.5, -0.5, -0.5);
			   break;
		   case 3:
			   stack.translate(-0.5, -0.5, 0.5);
			   break;
		   case 4:
			   stack.translate(0.5, 0.5, 0.5);
			   break;
		   case 5:
			   stack.translate(0.5, 0.5, -0.5);
			   break;
		   case 6:
			   stack.translate(-0.5, 0.5, -0.5);
			   break;
		   case 7:
			   stack.translate(-0.5, 0.5, 0.5);
			   break;
	   }
   }
   
   @Override
	protected int getBlockLightLevel(BoulderProjectile pEntity, BlockPos pPos) {
		return 15;
	}

   public ResourceLocation getTextureLocation(BoulderProjectile p_116109_) {
      return TextureAtlas.LOCATION_BLOCKS;
   }
}