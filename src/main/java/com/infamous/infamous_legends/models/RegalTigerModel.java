package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.keyframe_animations.definition.RegalTigerKeyframeAnimations;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.RegalTigerSineWaveAnimations;
import com.infamous.infamous_legends.entities.RegalTiger;

import net.minecraft.client.model.HierarchicalModel;
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


public class RegalTigerModel<T extends RegalTiger> extends HierarchicalModel<T> {
	private final ModelPart root;
	public final ModelPart everything;
	public final ModelPart body;
	public final ModelPart tail;
	public final ModelPart tailTip;
	public final ModelPart head;
	public final ModelPart leftEar;
	public final ModelPart rightEar;
	public final ModelPart leftFrontLeg;
	public final ModelPart leftBackLeg;
	public final ModelPart rightFrontLeg;
	public final ModelPart rightBackLeg;

	public RegalTigerModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.everything = root.getChild("everything");
		this.body = everything.getChild("body");
		this.tail = body.getChild("tail");
		this.tailTip = tail.getChild("tailTip");
		this.head = body.getChild("head");
		this.leftEar = head.getChild("leftEar");
		this.rightEar = head.getChild("rightEar");
		this.leftFrontLeg = everything.getChild("leftFrontLeg");
		this.leftBackLeg = everything.getChild("leftBackLeg");
		this.rightFrontLeg = everything.getChild("rightFrontLeg");
		this.rightBackLeg = everything.getChild("rightBackLeg");
	}

	public static LayerDefinition createBodyLayer(CubeDeformation pCubeDeformation) {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, -8.0F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-9.0F, -13.0F, -16.0F, 18.0F, 13.0F, 14.0F, pCubeDeformation)
		.texOffs(50, 0).addBox(-8.0F, -12.0F, -2.0F, 16.0F, 12.0F, 18.0F, pCubeDeformation), PartPose.offset(0.0F, 0.0F, 8.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 43).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 14.0F, pCubeDeformation), PartPose.offset(0.0F, -10.0F, 16.0F));

		PartDefinition tailTip = tail.addOrReplaceChild("tailTip", CubeListBuilder.create().texOffs(37, 43).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 14.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.0F, 0.0F, 14.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.0F, -7.0F, 10.0F, 8.0F, 7.0F, pCubeDeformation)
		.texOffs(0, 0).addBox(2.0F, 5.0F, -8.5F, 1.0F, 2.0F, 1.0F, pCubeDeformation)
		.texOffs(0, 0).addBox(-3.0F, 5.0F, -8.5F, 1.0F, 2.0F, 1.0F, pCubeDeformation)
		.texOffs(38, 0).addBox(-3.5F, 1.0F, -9.0F, 7.0F, 4.0F, 2.0F, pCubeDeformation)
		.texOffs(50, 0).addBox(-7.0F, 0.0F, -6.0F, 2.0F, 5.0F, 6.0F, pCubeDeformation)
		.texOffs(50, 0).addBox(5.0F, 0.0F, -6.0F, 2.0F, 5.0F, 6.0F, pCubeDeformation), PartPose.offset(0.0F, -7.0F, -16.0F));

		PartDefinition leftEar = head.addOrReplaceChild("leftEar", CubeListBuilder.create().texOffs(27, 0).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 3.0F, 2.0F, pCubeDeformation), PartPose.offset(2.9F, -3.0F, -1.5F));

		PartDefinition rightEar = head.addOrReplaceChild("rightEar", CubeListBuilder.create().texOffs(27, 0).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 3.0F, 2.0F, pCubeDeformation), PartPose.offset(-3.0F, -3.0F, -1.5F));

		PartDefinition leftFrontLeg = everything.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(82, 31).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 10.0F, 6.0F, pCubeDeformation), PartPose.offset(5.5F, -2.0F, -3.0F));

		PartDefinition leftBackLeg = everything.addOrReplaceChild("leftBackLeg", CubeListBuilder.create().texOffs(82, 48).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 10.0F, 6.0F, pCubeDeformation), PartPose.offset(4.5F, -2.0F, 19.0F));

		PartDefinition rightFrontLeg = everything.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(105, 31).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 10.0F, 6.0F, pCubeDeformation), PartPose.offset(-5.5F, -2.0F, -3.0F));

		PartDefinition rightBackLeg = everything.addOrReplaceChild("rightBackLeg", CubeListBuilder.create().texOffs(105, 48).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 10.0F, 6.0F, pCubeDeformation), PartPose.offset(-4.5F, -2.0F, 19.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	
	public static LayerDefinition createBodyLayer() {
		return RegalTigerModel.createBodyLayer(new CubeDeformation(0.0F));
	}
	
	public static LayerDefinition createSaddleLayer() {
		return RegalTigerModel.createBodyLayer(new CubeDeformation(0.5F));
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		boolean shouldPlayRunAnimation = speed > 0.225 && notCurrentlyPlayingKeyframeAnimation(entity);
		
		boolean shouldPlayWalkAnimation = !shouldPlayRunAnimation && speed > 0 && notCurrentlyPlayingKeyframeAnimation(entity);
		
		boolean shouldPlayIdleSittingAnimation = entity.isSitting() && !shouldPlayWalkAnimation && !shouldPlayRunAnimation && notCurrentlyPlayingKeyframeAnimation(entity);	
		
		boolean shouldPlayIdleAnimation = !shouldPlayIdleSittingAnimation && !shouldPlayWalkAnimation && !shouldPlayRunAnimation && notCurrentlyPlayingKeyframeAnimation(entity);	
		
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
		RegalTigerSineWaveAnimations.regalTigerRunAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 7.5F, shouldPlayRunAnimation ? 1 : 0);
		RegalTigerSineWaveAnimations.regalTigerWalkAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 7.5F, shouldPlayWalkAnimation ? 1 : 0);
		RegalTigerSineWaveAnimations.regalTigerIdleSittingAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayIdleSittingAnimation ? 1 : 0);
		RegalTigerSineWaveAnimations.regalTigerIdleAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayIdleAnimation ? 1 : 0);
		this.animate(entity.sitAnimationState, RegalTigerKeyframeAnimations.REGAL_TIGER_SIT, ageInTicks);
		this.animate(entity.cleanAnimationState, RegalTigerKeyframeAnimations.REGAL_TIGER_CLEAN(entity), ageInTicks);
		this.animate(entity.standAnimationState, RegalTigerKeyframeAnimations.REGAL_TIGER_STAND, ageInTicks);
		this.animate(entity.attackAnimationState, RegalTigerKeyframeAnimations.REGAL_TIGER_ATTACK, ageInTicks);
	}
	
	public boolean notCurrentlyPlayingKeyframeAnimation(RegalTiger entity) {
		return entity.attackAnimationTick <= 0 && entity.sitAnimationTick <= 0 && entity.cleanAnimationTick <= 0 && entity.standAnimationTick <= 0;
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