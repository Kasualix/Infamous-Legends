package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.Badger;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.BadgerModel;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BadgerRenderer extends MobRenderer<Badger, BadgerModel<Badger>> {

	public BadgerRenderer(EntityRendererProvider.Context context) {
		super(context, new BadgerModel<>(context.bakeLayer(ModelLayerInit.BADGER)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Badger p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/badger.png");
	}

}
