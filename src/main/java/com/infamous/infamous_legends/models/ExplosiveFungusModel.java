package com.infamous.infamous_legends.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;

// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class ExplosiveFungusModel extends Model {
	private final ModelPart root;
	private final ModelPart fungus;

	public ExplosiveFungusModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.fungus = root.getChild("fungus");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition fungus = partdefinition.addOrReplaceChild("fungus", CubeListBuilder.create().texOffs(20, 109).addBox(4.0F, 5.3F, 19.5F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 13.7F, -20.5F));

		PartDefinition fungus_r1 = fungus.addOrReplaceChild("fungus_r1", CubeListBuilder.create().texOffs(0, 90).addBox(-2.0F, 3.3F, -4.25F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, 8.25F, 1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}