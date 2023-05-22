package com.infamous.infamous_legends.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class PlayerPortalGuardWreckingBallModel<T extends Entity> extends Model {
	private final ModelPart root;
	private final ModelPart ball;

	public PlayerPortalGuardWreckingBallModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.ball = this.root.getChild("ball");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ball = partdefinition.addOrReplaceChild("ball", CubeListBuilder.create().texOffs(39, 42).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(44, 91).addBox(-2.0F, 7.0F, -5.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(55, 88).addBox(2.0F, 7.0F, 2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 70).addBox(-1.0F, 4.0F, 2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 73).addBox(-1.0F, 7.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(38, 91).addBox(-4.0F, 7.0F, 2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(28, 92).addBox(-5.0F, 3.0F, 2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 91).addBox(-5.0F, 0.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(31, 89).addBox(-2.0F, 0.0F, 2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(52, 88).addBox(-5.0F, 7.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(71, 90).addBox(2.0F, 2.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(38, 94).addBox(2.0F, -1.0F, -5.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(41, 94).addBox(2.0F, 5.0F, -5.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(82, 90).addBox(-1.0F, 2.0F, -5.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(49, 91).addBox(-5.0F, 4.0F, -5.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(17, 89).addBox(-3.0F, 3.5F, -7.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(15, 82).addBox(2.5F, 1.0F, 5.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(29, 84).addBox(5.0F, 7.5F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(15, 84).addBox(-7.0F, 5.0F, 2.5F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(5, 84).addBox(-7.0F, 6.5F, 1.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(25, 84).addBox(5.0F, 6.0F, -1.5F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(18, 77).addBox(1.0F, 2.5F, 5.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(25, 82).addBox(-1.5F, 2.0F, -7.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 89).addBox(0.0F, 10.0F, -1.5F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(19, 86).addBox(1.5F, 10.0F, -3.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 100, 100);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}