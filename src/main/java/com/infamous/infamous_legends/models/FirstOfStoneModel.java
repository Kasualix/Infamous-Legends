package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.keyframe_animations.definition.FirstOfStoneKeyframeAnimations;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.FirstOfStoneSineWaveAnimations;
import com.infamous.infamous_legends.entities.FirstOfStone;
import com.infamous.infamous_legends.interfaces.ArmourWearingModel;
import com.infamous.infamous_legends.interfaces.CustomHeadedModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer.ArmourModelPart;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;

import net.minecraft.client.model.ArmedModel;
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
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.phys.Vec3;

// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class FirstOfStoneModel<T extends FirstOfStone> extends HierarchicalModel<T> implements ArmedModel, CustomHeadedModel, ArmourWearingModel {
	private final ModelPart root;
	public final ModelPart everything;
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart nose;
	public final ModelPart leftArm;
	public final ModelPart grassPatch7;
	public final ModelPart rightArm;
	public final ModelPart grassPatch5;
	public final ModelPart grassPatch6;
	public final ModelPart vine1;
	public final ModelPart vine2;
	public final ModelPart vine3;
	public final ModelPart vine4;
	public final ModelPart vine5;
	public final ModelPart grassPatch1;
	public final ModelPart grassPatch2;
	public final ModelPart grassPatch3;
	public final ModelPart grassPatch4;
	public final ModelPart pelvis;
	public final ModelPart rightLeg;
	public final ModelPart leftLeg;

	public FirstOfStoneModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.everything = root.getChild("everything");
		this.body = everything.getChild("body");
		this.head = body.getChild("head");
		this.nose = head.getChild("nose");
		this.leftArm = body.getChild("leftArm");
		this.grassPatch7 = leftArm.getChild("grassPatch7");
		this.rightArm = body.getChild("rightArm");
		this.grassPatch5 = rightArm.getChild("grassPatch5");
		this.grassPatch6 = rightArm.getChild("grassPatch6");
		this.vine1 = body.getChild("vine1");
		this.vine2 = body.getChild("vine2");
		this.vine3 = body.getChild("vine3");
		this.vine4 = body.getChild("vine4");
		this.vine5 = body.getChild("vine5");
		this.grassPatch1 = body.getChild("grassPatch1");
		this.grassPatch2 = body.getChild("grassPatch2");
		this.grassPatch3 = body.getChild("grassPatch3");
		this.grassPatch4 = body.getChild("grassPatch4");
		this.pelvis = body.getChild("pelvis");
		this.rightLeg = pelvis.getChild("rightLeg");
		this.leftLeg = pelvis.getChild("leftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -38.0F, -19.0F, 38.0F, 38.0F, 38.0F, new CubeDeformation(0.0F))
		.texOffs(170, 194).addBox(-8.0F, -27.0F, -19.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(71, 212).addBox(-8.0F, -9.0F, -3.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.0F, -17.0F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(114, 0).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.5F, -3.0F));

		PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(153, 0).addBox(0.0F, -8.0F, -9.0F, 14.0F, 66.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(200, 67).addBox(9.0F, 24.0F, -9.0F, 5.0F, 10.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(162, 87).addBox(0.0F, 48.0F, 9.0F, 14.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(19.0F, -30.0F, 0.0F));

		PartDefinition grassPatch7 = leftArm.addOrReplaceChild("grassPatch7", CubeListBuilder.create(), PartPose.offsetAndRotation(9.0F, -8.0F, -5.0F, 0.0F, 1.0036F, 0.0F));

		PartDefinition grass13 = grassPatch7.addOrReplaceChild("grass13", CubeListBuilder.create().texOffs(5, 119).addBox(-6.0F, -8.0F, 1.0F, 11.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, -1.0F));

		PartDefinition grass14 = grassPatch7.addOrReplaceChild("grass14", CubeListBuilder.create().texOffs(5, 110).addBox(-4.5F, -8.0F, 0.0F, 11.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(153, 107).addBox(-14.0F, -8.0F, -9.0F, 14.0F, 66.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(124, 89).addBox(-14.0F, -8.0F, -9.0F, 5.0F, 3.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(200, 105).addBox(-14.0F, 48.0F, 9.0F, 14.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-19.0F, -30.0F, 0.0F));

		PartDefinition grassPatch5 = rightArm.addOrReplaceChild("grassPatch5", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.0F, -5.0F, -6.0F, 0.0F, 0.829F, 0.0F));

		PartDefinition grass9 = grassPatch5.addOrReplaceChild("grass9", CubeListBuilder.create().texOffs(34, 123).addBox(-3.0F, -5.0F, 1.0F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, -1.0F));

		PartDefinition grass10 = grassPatch5.addOrReplaceChild("grass10", CubeListBuilder.create().texOffs(34, 129).addBox(-2.5F, -5.0F, -1.0F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition grassPatch6 = rightArm.addOrReplaceChild("grassPatch6", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, -8.0F, 5.0F, 0.0F, -0.3054F, 0.0F));

		PartDefinition grass11 = grassPatch6.addOrReplaceChild("grass11", CubeListBuilder.create().texOffs(18, 130).addBox(0.0F, -4.0F, 1.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, -1.0F));

		PartDefinition grass12 = grassPatch6.addOrReplaceChild("grass12", CubeListBuilder.create().texOffs(18, 134).addBox(-1.5F, -4.0F, -2.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition vine1 = body.addOrReplaceChild("vine1", CubeListBuilder.create().texOffs(99, 167).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(15.5F, 0.0F, -19.0F));

		PartDefinition vine2 = body.addOrReplaceChild("vine2", CubeListBuilder.create().texOffs(90, 167).addBox(-2.5F, 0.0F, 0.0F, 3.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(13.5F, 0.0F, -19.0F));

		PartDefinition vine3 = body.addOrReplaceChild("vine3", CubeListBuilder.create().texOffs(80, 167).addBox(-1.5F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 0.0F, -19.0F));

		PartDefinition vine4 = body.addOrReplaceChild("vine4", CubeListBuilder.create().texOffs(107, 167).addBox(-1.5F, 0.0F, -1.0F, 2.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(9.5F, 0.0F, 19.0F));

		PartDefinition vine5 = body.addOrReplaceChild("vine5", CubeListBuilder.create().texOffs(118, 167).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.5F, 0.0F, 19.0F));

		PartDefinition grassPatch1 = body.addOrReplaceChild("grassPatch1", CubeListBuilder.create(), PartPose.offsetAndRotation(13.0F, -38.0F, 9.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition grass1 = grassPatch1.addOrReplaceChild("grass1", CubeListBuilder.create().texOffs(34, 153).addBox(-5.0F, -7.0F, 1.0F, 10.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, -1.0F));

		PartDefinition grass2 = grassPatch1.addOrReplaceChild("grass2", CubeListBuilder.create().texOffs(34, 161).addBox(-3.5F, -7.0F, 0.0F, 10.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition grassPatch2 = body.addOrReplaceChild("grassPatch2", CubeListBuilder.create(), PartPose.offsetAndRotation(-15.0F, -38.0F, -15.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition grass3 = grassPatch2.addOrReplaceChild("grass3", CubeListBuilder.create().texOffs(27, 172).addBox(-3.0F, -5.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, -1.0F));

		PartDefinition grass4 = grassPatch2.addOrReplaceChild("grass4", CubeListBuilder.create().texOffs(27, 178).addBox(-2.5F, -5.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition grassPatch3 = body.addOrReplaceChild("grassPatch3", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.5F, -38.0F, 12.0F, 0.0F, 2.4871F, 0.0F));

		PartDefinition grass5 = grassPatch3.addOrReplaceChild("grass5", CubeListBuilder.create().texOffs(41, 176).addBox(-6.0F, -7.0F, 1.0F, 13.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, -1.0F));

		PartDefinition grass6 = grassPatch3.addOrReplaceChild("grass6", CubeListBuilder.create().texOffs(41, 184).addBox(-6.5F, -7.0F, 0.0F, 13.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition grassPatch4 = body.addOrReplaceChild("grassPatch4", CubeListBuilder.create(), PartPose.offsetAndRotation(13.0F, -38.0F, -16.0F, 0.0F, 0.1309F, 0.0F));

		PartDefinition grass7 = grassPatch4.addOrReplaceChild("grass7", CubeListBuilder.create().texOffs(6, 149).addBox(-3.0F, -9.0F, 1.0F, 8.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, -1.0F));

		PartDefinition grass8 = grassPatch4.addOrReplaceChild("grass8", CubeListBuilder.create().texOffs(6, 159).addBox(-1.5F, -9.0F, 0.0F, 8.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition pelvis = body.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(0, 77).addBox(-10.0F, 0.0F, -7.0F, 20.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightLeg = pelvis.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(69, 77).addBox(-5.0F, 0.0F, -9.0F, 8.0F, 21.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 7.0F, 0.0F));

		PartDefinition leftLeg = pelvis.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(69, 117).addBox(-5.0F, 0.0F, -9.0F, 8.0F, 11.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(44, 129).addBox(-5.0F, 8.0F, -9.0F, 3.0F, 3.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 7.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		boolean shouldPlayRunAnimation = speed > 0.15 && entity.attackAnimationTick <= 0 && entity.rangedAttackAnimationTick <= 0 && entity.isAwakened();
		
		boolean shouldPlayWalkAnimation = !shouldPlayRunAnimation && speed > 0 && entity.attackAnimationTick <= 0 && entity.rangedAttackAnimationTick <= 0 && entity.isAwakened();
		
		boolean shouldPlayIdleAnimation = !shouldPlayWalkAnimation && !shouldPlayRunAnimation && entity.attackAnimationTick <= 0 && entity.rangedAttackAnimationTick <= 0 && entity.isAwakened();	
		
		if (entity.attackAnimationTick <= 0 && entity.rangedAttackAnimationTick <= 0) {
			this.animateHeadLookTarget(netHeadYaw, headPitch);
		}
		FirstOfStoneSineWaveAnimations.firstOfStoneRunAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 7.5F, shouldPlayRunAnimation ? 1 : 0);
		FirstOfStoneSineWaveAnimations.firstOfStoneWalkAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 12.5F, shouldPlayWalkAnimation ? 1 : 0);
		FirstOfStoneSineWaveAnimations.firstOfStoneIdleAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayIdleAnimation ? 1 : 0);
		this.animate(entity.attackAnimationState, FirstOfStoneKeyframeAnimations.FIRST_OF_STONE_ATTACK, ageInTicks);
		this.animate(entity.rangedAttackAnimationState, FirstOfStoneKeyframeAnimations.FIRST_OF_STONE_RANGED_ATTACK, ageInTicks);
		this.animate(entity.inactiveAnimationState, FirstOfStoneKeyframeAnimations.FIRST_OF_STONE_INACTIVE, ageInTicks);
		this.animate(entity.awakenAnimationState, FirstOfStoneKeyframeAnimations.FIRST_OF_STONE_AWAKEN, ageInTicks);
	}
	
	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.xRot = xRot * ((float) Math.PI / 180F);
		this.head.yRot = yRot * ((float) Math.PI / 180F);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

	private ModelPart getArm(HumanoidArm arm) {
		return arm == HumanoidArm.LEFT ? this.leftArm : this.rightArm;
	}

	@Override
	public void translateToHand(HumanoidArm arm, PoseStack stack) {
		this.root().translateAndRotate(stack);
		this.everything.translateAndRotate(stack);
		this.body.translateAndRotate(stack);
		this.getArm(arm).translateAndRotate(stack);
		stack.translate(arm == HumanoidArm.RIGHT ? -5F / 16.0F : 5F / 16.0F, 70 / 16.0F, 14 / 16.0F);
		stack.mulPose(Vector3f.XP.rotationDegrees(180));
		stack.scale(2F, 2F, 2F);
	}

	@Override
	public void translateToHead(PoseStack stack) {
		this.root().translateAndRotate(stack);
		this.everything.translateAndRotate(stack);
		this.body.translateAndRotate(stack);
	}

	@Override
	public void translateArmour(ArmourModelPart modelPart, PoseStack stack, boolean innerModel) {
		switch (modelPart) {
		case HEAD:
			this.root().translateAndRotate(stack);
			this.everything.translateAndRotate(stack);
			this.body.translateAndRotate(stack);
			stack.translate(0, -12 / 16.0F, 0);
			stack.scale(4F, 3F, 4F);
			break;
		case BODY:
			if (!innerModel) {
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				stack.translate(0, -12 / 16.0F, 0);
				stack.scale(4F, 1.25F, 6.5F);
			} else {
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				this.pelvis.translateAndRotate(stack);
				stack.translate(0, -14.5 / 16.0F, 0);
				stack.scale(3F, 2.0F, 3F);
			}
			break;
		case RIGHT_ARM:
			this.root().translateAndRotate(stack);
			this.everything.translateAndRotate(stack);
			this.body.translateAndRotate(stack);
			this.rightArm.translateAndRotate(stack);
			stack.translate(8 / 16.0F, -6 / 16.0F, 0);
			stack.scale(2.5F, 2.5F, 3F);
			break;
		case LEFT_ARM:
			this.root().translateAndRotate(stack);
			this.everything.translateAndRotate(stack);
			this.body.translateAndRotate(stack);
			this.leftArm.translateAndRotate(stack);
			stack.translate(-8 / 16.0F, -6 / 16.0F, 0);
			stack.scale(2.5F, 2.5F, 3F);
			break;
		case RIGHT_LEG:
			this.root().translateAndRotate(stack);
			this.everything.translateAndRotate(stack);
			this.body.translateAndRotate(stack);
			this.pelvis.translateAndRotate(stack);
			this.rightLeg.translateAndRotate(stack);
			stack.translate(2.5F / 16.0F, -28 / 16.0F, 0);
			stack.scale(2, 2F, 4F);
			break;
		case LEFT_LEG:
			if (innerModel) {
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				this.pelvis.translateAndRotate(stack);
				this.leftLeg.translateAndRotate(stack);
				stack.translate(-5F / 16.0F, -28 / 16.0F, 0);
				stack.scale(2, 2F, 4F);
			} else {
				stack.scale(0, 0, 0);
			}
			break;
		}
	}
}