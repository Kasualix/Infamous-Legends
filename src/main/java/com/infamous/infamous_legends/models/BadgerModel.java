package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.keyframe_animations.definition.BadgerKeyframeAnimations;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.BadgerSineWaveAnimations;
import com.infamous.infamous_legends.entities.Badger;

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

// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class BadgerModel<T extends Badger> extends HierarchicalModel<T> {
	private final ModelPart root;
	public final ModelPart everything;
	public final ModelPart leftFrontLeg;
	public final ModelPart rightFrontLeg;
	public final ModelPart leftBackLeg;
	public final ModelPart rightBackLeg;
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart leftEar;
	public final ModelPart rightEar;
	public final ModelPart tail;

	public BadgerModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.everything = root.getChild("everything");
		this.leftFrontLeg = everything.getChild("leftFrontLeg");
		this.rightFrontLeg = everything.getChild("rightFrontLeg");
		this.leftBackLeg = everything.getChild("leftBackLeg");
		this.rightBackLeg = everything.getChild("rightBackLeg");
		this.body = everything.getChild("body");
		this.head = body.getChild("head");
		this.leftEar = head.getChild("leftEar");
		this.rightEar = head.getChild("rightEar");
		this.tail = body.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 2.0F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 11).addBox(-5.0F, -7.0F, -7.0F, 10.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -1.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(1, 0).addBox(-4.0F, -1.0F, -7.0F, 8.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(-1.5F, -1.0F, -10.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -7.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition leftEar = head.addOrReplaceChild("leftEar", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.0F, -1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -1.0F, 0.0F));

		PartDefinition rightEar = head.addOrReplaceChild("rightEar", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.0F, -1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -1.0F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(32, 0).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 7.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition rightFrontLeg = everything.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(48, 11).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -4.0F, -6.0F));

		PartDefinition rightBackLeg = everything.addOrReplaceChild("rightBackLeg", CubeListBuilder.create().texOffs(48, 18).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -4.0F, 4.0F));

		PartDefinition leftFrontLeg = everything.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(35, 11).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -4.0F, -6.0F));

		PartDefinition leftBackLeg = everything.addOrReplaceChild("leftBackLeg", CubeListBuilder.create().texOffs(35, 18).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -4.0F, 4.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				

		boolean shouldPlayWalkAnimation = speed > 0 && entity.attackAnimationTick <= 0;
		
		boolean shouldPlayIdleAnimation = !shouldPlayWalkAnimation && entity.attackAnimationTick <= 0 && !entity.alertAnimationState.isStarted();
		
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
		BadgerSineWaveAnimations.badgerWalkAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 17.5F, shouldPlayWalkAnimation ? 1 : 0);
		BadgerSineWaveAnimations.badgerIdleAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayIdleAnimation ? 1 : 0);
		if (!shouldPlayWalkAnimation) {
			this.animate(entity.alertAnimationState, BadgerKeyframeAnimations.BADGER_ALERT, ageInTicks);
		}
		this.animate(entity.attackAnimationState, BadgerKeyframeAnimations.BADGER_ATTACK, ageInTicks);
	}
	
	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.xRot = (xRot + 35) * ((float) Math.PI / 180F);
		this.head.yRot = yRot * ((float) Math.PI / 180F);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}