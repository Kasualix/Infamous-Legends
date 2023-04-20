package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.BigBeak;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.BigBeakModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SaddleLayer;
import net.minecraft.resources.ResourceLocation;

public class BigBeakRenderer extends MobRenderer<BigBeak, BigBeakModel<BigBeak>> {

	public BigBeakRenderer(EntityRendererProvider.Context context) {
		super(context, new BigBeakModel<>(context.bakeLayer(ModelLayerInit.BIG_BEAK)), 1F);
	      this.addLayer(new SaddleLayer<>(this, new BigBeakModel<>(context.bakeLayer(ModelLayerInit.BIG_BEAK_SADDLE)), new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/big_beak_saddle.png")));
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.BIG_BEAK_INNER_ARMOUR, ModelLayerInit.BIG_BEAK_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(BigBeak p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/big_beak.png");
	}

}
