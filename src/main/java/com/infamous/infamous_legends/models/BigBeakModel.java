package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.BigBeakSineWaveAnimations;
import com.infamous.infamous_legends.entities.BigBeak;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

// Made with Blockbench 4.7.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class BigBeakModel<T extends BigBeak> extends HierarchicalModel<T> {
	private final ModelPart root;
	public final ModelPart everything;
	public final ModelPart body;
	public final ModelPart tail;
	public final ModelPart leftWing;
	public final ModelPart rightWing;
	public final ModelPart head;
	public final ModelPart leftLeg;
	public final ModelPart leftLegLower;
	public final ModelPart leftFoot;
	public final ModelPart leftFrontToe;
	public final ModelPart leftBackToe;
	public final ModelPart leftLeftToe;
	public final ModelPart leftRightToe;
	public final ModelPart rightLeg;
	public final ModelPart rightLegLower;
	public final ModelPart rightFoot;
	public final ModelPart rightFrontToe;
	public final ModelPart rightBackToe;
	public final ModelPart rightLeftToe;
	public final ModelPart rightRightToe;

	public BigBeakModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.everything = root.getChild("everything");
		this.body = this.everything.getChild("body");
		this.tail = this.body.getChild("tail");
		this.leftWing = this.body.getChild("leftWing");
		this.rightWing = this.body.getChild("rightWing");
		this.head = this.body.getChild("head");
		this.leftLeg = this.everything.getChild("leftLeg");
		this.leftLegLower = this.leftLeg.getChild("leftLegLower");
		this.leftFoot = this.leftLegLower.getChild("leftFoot");
		this.leftFrontToe = this.leftFoot.getChild("leftFrontToe");
		this.leftBackToe = this.leftFoot.getChild("leftBackToe");
		this.leftLeftToe = this.leftFoot.getChild("leftLeftToe");
		this.leftRightToe = this.leftFoot.getChild("leftRightToe");
		this.rightLeg = this.everything.getChild("rightLeg");
		this.rightLegLower = this.rightLeg.getChild("rightLegLower");
		this.rightFoot = this.rightLegLower.getChild("rightFoot");
		this.rightFrontToe = this.rightFoot.getChild("rightFrontToe");
		this.rightBackToe = this.rightFoot.getChild("rightBackToe");
		this.rightLeftToe = this.rightFoot.getChild("rightLeftToe");
		this.rightRightToe = this.rightFoot.getChild("rightRightToe");
	}

	public static LayerDefinition createBodyLayer(CubeDeformation pCubeDeformation) {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(30, 16).addBox(-5.5F, -9.0F, -12.0F, 11.0F, 9.0F, 21.0F, pCubeDeformation), PartPose.offset(0.0F, 0.0F, 2.5F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(32, 89).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 19.0F, pCubeDeformation), PartPose.offset(0.0F, -8.0F, 9.0F));

		PartDefinition leftWing = body.addOrReplaceChild("leftWing", CubeListBuilder.create().texOffs(49, 56).mirror().addBox(0.0F, 0.0F, -1.0F, 2.0F, 9.0F, 19.0F, pCubeDeformation).mirror(false), PartPose.offset(5.5F, -9.0F, -11.0F));

		PartDefinition rightWing = body.addOrReplaceChild("rightWing", CubeListBuilder.create().texOffs(49, 56).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 9.0F, 19.0F, pCubeDeformation), PartPose.offset(-5.5F, -9.0F, -11.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(85, 85).addBox(-4.0F, -17.0F, -7.0F, 8.0F, 20.0F, 8.0F, pCubeDeformation)
		.texOffs(11, 92).addBox(-2.5F, -18.0F, -15.0F, 5.0F, 7.0F, 11.0F, pCubeDeformation)
		.texOffs(4, 88).addBox(-2.5F, -18.0F, -17.0F, 5.0F, 6.0F, 2.0F, pCubeDeformation), PartPose.offset(0.0F, -6.0F, -11.0F));

		PartDefinition leftLeg = everything.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(17, 52).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, pCubeDeformation), PartPose.offset(3.5F, 0.0F, 2.5F));

		PartDefinition leftLegLower = leftLeg.addOrReplaceChild("leftLegLower", CubeListBuilder.create().texOffs(17, 63).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.05F)), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition leftFoot = leftLegLower.addOrReplaceChild("leftFoot", CubeListBuilder.create(), PartPose.offset(0.0F, 9.0F, 0.5F));

		PartDefinition leftFrontToe = leftFoot.addOrReplaceChild("leftFrontToe", CubeListBuilder.create().texOffs(16, 82).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, pCubeDeformation), PartPose.offset(0.0F, -0.1F, -2.0F));

		PartDefinition leftBackToe = leftFoot.addOrReplaceChild("leftBackToe", CubeListBuilder.create().texOffs(27, 82).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, pCubeDeformation), PartPose.offset(0.0F, -0.1F, 1.0F));

		PartDefinition leftLeftToe = leftFoot.addOrReplaceChild("leftLeftToe", CubeListBuilder.create().texOffs(33, 82).addBox(0.0F, 0.0F, -1.5F, 2.0F, 0.0F, 3.0F, pCubeDeformation), PartPose.offset(1.5F, -0.1F, -0.5F));

		PartDefinition leftRightToe = leftFoot.addOrReplaceChild("leftRightToe", CubeListBuilder.create().texOffs(33, 82).mirror().addBox(-2.0F, 0.0F, -1.5F, 2.0F, 0.0F, 3.0F, pCubeDeformation).mirror(false), PartPose.offset(-1.5F, -0.1F, -0.5F));

		PartDefinition rightLeg = everything.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(17, 52).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, pCubeDeformation).mirror(false), PartPose.offset(-3.5F, 0.0F, 2.5F));

		PartDefinition rightLegLower = rightLeg.addOrReplaceChild("rightLegLower", CubeListBuilder.create().texOffs(17, 63).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition rightFoot = rightLegLower.addOrReplaceChild("rightFoot", CubeListBuilder.create(), PartPose.offset(0.0F, 9.0F, 0.5F));

		PartDefinition rightFrontToe = rightFoot.addOrReplaceChild("rightFrontToe", CubeListBuilder.create().texOffs(16, 82).mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, pCubeDeformation).mirror(false), PartPose.offset(0.0F, -0.1F, -2.0F));

		PartDefinition rightBackToe = rightFoot.addOrReplaceChild("rightBackToe", CubeListBuilder.create().texOffs(27, 82).mirror().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, pCubeDeformation).mirror(false), PartPose.offset(0.0F, -0.1F, 1.0F));

		PartDefinition rightLeftToe = rightFoot.addOrReplaceChild("rightLeftToe", CubeListBuilder.create().texOffs(33, 82).addBox(0.0F, 0.0F, -1.5F, 2.0F, 0.0F, 3.0F, pCubeDeformation), PartPose.offset(1.5F, -0.1F, -0.5F));

		PartDefinition rightRightToe = rightFoot.addOrReplaceChild("rightRightToe", CubeListBuilder.create().texOffs(33, 82).mirror().addBox(-2.0F, 0.0F, -1.5F, 2.0F, 0.0F, 3.0F, pCubeDeformation).mirror(false), PartPose.offset(-1.5F, -0.1F, -0.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	
	public static LayerDefinition createBodyLayer() {
		return BigBeakModel.createBodyLayer(new CubeDeformation(0.0F));
	}
	
	public static LayerDefinition createSaddleLayer() {
		return BigBeakModel.createBodyLayer(new CubeDeformation(0.5F));
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		boolean shouldPlayJumpingAnimation = entity.isJumping();
		
		boolean shouldPlayGlidingAnimation = entity.isGliding() && !shouldPlayJumpingAnimation;
		
		boolean shouldPlayWalkAnimation = speed > 0 && !shouldPlayJumpingAnimation && !shouldPlayGlidingAnimation;
		
		boolean shouldPlayIdleAnimation = !shouldPlayWalkAnimation && !shouldPlayJumpingAnimation && !shouldPlayGlidingAnimation;
		
		if (entity.isBaby()) {
			this.root.y = 12;
			this.root.xScale = 0.5F;
			this.root.yScale = 0.5F;
			this.root.zScale = 0.5F;
			this.head.xScale = 1.5F;
			this.head.yScale = 1.5F;
			this.head.zScale = 1.5F;
		} else {
			
		}
		
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		BigBeakSineWaveAnimations.bigBeakJumpingAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayJumpingAnimation ? 1 : 0);
		BigBeakSineWaveAnimations.bigBeakGlidingAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayGlidingAnimation ? 1 : 0);
		BigBeakSineWaveAnimations.bigBeakWalkAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 12.5F, shouldPlayWalkAnimation ? 1 : 0);
		BigBeakSineWaveAnimations.bigBeakIdleAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayIdleAnimation ? 1 : 0);
	}
	
	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.xRot = xRot * ((float) Math.PI / 180F);
		this.head.yRot = yRot * ((float) Math.PI / 180F);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}