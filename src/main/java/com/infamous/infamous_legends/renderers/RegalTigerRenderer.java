package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.RegalTiger;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.RegalTigerModel;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SaddleLayer;
import net.minecraft.resources.ResourceLocation;

public class RegalTigerRenderer extends MobRenderer<RegalTiger, RegalTigerModel<RegalTiger>> {

	public RegalTigerRenderer(EntityRendererProvider.Context context) {
		super(context, new RegalTigerModel<>(context.bakeLayer(ModelLayerInit.REGAL_TIGER)), 1F);
	      this.addLayer(new SaddleLayer<>(this, new RegalTigerModel<>(context.bakeLayer(ModelLayerInit.REGAL_TIGER_SADDLE)), new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/regal_tiger_saddle.png")));
		//CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.REGAL_TIGER_INNER_ARMOUR, ModelLayerInit.REGAL_TIGER_OUTER_ARMOUR);
	    //this.addLayer(new HeadItemLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(RegalTiger p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/regal_tiger.png");
	}

}
