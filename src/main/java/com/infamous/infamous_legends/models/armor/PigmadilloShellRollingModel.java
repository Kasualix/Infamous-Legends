package com.infamous.infamous_legends.models.armor;

import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class PigmadilloShellRollingModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart root;
	public final ModelPart shell;

	public PigmadilloShellRollingModel(ModelPart root) {
		this.root = root;
		this.shell = root.getChild("shell");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition shell = partdefinition.addOrReplaceChild("shell", CubeListBuilder.create(), PartPose.offset(0.0F, 17.0F, 0.0F));

		PartDefinition shell1 = shell.addOrReplaceChild("shell1", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1F, -1.0F, -5.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition shell1_r1 = shell1.addOrReplaceChild("shell1_r1", CubeListBuilder.create().texOffs(45, 5).addBox(-5.0F, 15.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(45, 5).addBox(-11.0F, 15.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 0).addBox(-14.0F, 14.0F, 0.0F, 14.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -20.0F, 3.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition shell2 = shell.addOrReplaceChild("shell2", CubeListBuilder.create().texOffs(0, 16).addBox(-8.5F, -6.0F, -2.0F, 17.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -1.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition shell2_r1 = shell2.addOrReplaceChild("shell2_r1", CubeListBuilder.create().texOffs(45, 5).addBox(-8.0F, 25.0F, -6.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(64, 13).addBox(-4.0F, 21.0F, -5.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(45, 5).addBox(-12.0F, 21.0F, -6.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -23.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition shell4 = shell.addOrReplaceChild("shell4", CubeListBuilder.create().texOffs(3, 0).addBox(-7.0F, -6.0F, -2.0F, 14.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, -1.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition shell3 = shell.addOrReplaceChild("shell3", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-8.0F, -6.5F, -2.0F, 16.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition shell3_r1 = shell3.addOrReplaceChild("shell3_r1", CubeListBuilder.create().texOffs(64, 13).addBox(-4.0F, 33.0F, -4.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(45, 5).addBox(-12.0F, 33.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -32.0F, 2.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition left_arm = shell.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(46, 27).mirror().addBox(1.0F, -3.0F, -3.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 0.5F, -0.4F));

		PartDefinition right_arm = shell.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(46, 27).addBox(-9.0F, -25.0F, -3.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.5F, -0.5F));

		return LayerDefinition.create(meshdefinition, 100, 100);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw,
			float pHeadPitch) {
		
	}
}