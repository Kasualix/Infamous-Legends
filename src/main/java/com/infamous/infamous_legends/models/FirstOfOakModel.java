package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.keyframe_animations.definition.FirstOfOakKeyframeAnimations;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.FirstOfOakSineWaveAnimations;
import com.infamous.infamous_legends.entities.FirstOfOak;
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


public class FirstOfOakModel<T extends FirstOfOak> extends HierarchicalModel<T> implements ArmedModel, CustomHeadedModel, ArmourWearingModel {
	private final ModelPart root;
	public final ModelPart everything;
	public final ModelPart body;
	public final ModelPart nose;
	public final ModelPart leftArm;
	public final ModelPart rightArm;
	public final ModelPart pelvis;
	public final ModelPart rightLeg;
	public final ModelPart leftLeg;

	public FirstOfOakModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.everything = root.getChild("everything");
		this.pelvis = everything.getChild("pelvis");
		this.body = pelvis.getChild("body");
		this.leftArm = body.getChild("leftArm");
		this.rightArm = body.getChild("rightArm");
		this.nose = body.getChild("nose");
		this.rightLeg = everything.getChild("rightLeg");
		this.leftLeg = everything.getChild("leftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition pelvis = everything.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(159, 60).addBox(-10.0F, -10.0F, -7.0F, 20.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));

		PartDefinition body = pelvis.addOrReplaceChild("body", CubeListBuilder.create().texOffs(20, 95).addBox(-19.0F, -38.0F, -19.0F, 38.0F, 38.0F, 38.0F, new CubeDeformation(0.0F))
		.texOffs(148, 216).addBox(-9.0F, -38.0F, 19.0F, 18.0F, 16.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(145, 220).addBox(-5.0F, -34.0F, 41.0F, 10.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(62, 172).addBox(-15.0F, -34.0F, -19.0F, 30.0F, 30.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(90, 218).addBox(6.0F, -24.0F, -17.0F, 9.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(90, 218).mirror().addBox(-15.0F, -24.0F, -17.0F, 9.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(38, 9).addBox(0.0F, -8.0F, -9.0F, 14.0F, 66.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(121, 75).addBox(0.0F, 40.0F, 7.0F, 14.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(138, 24).addBox(12.0F, -8.0F, -9.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(19.0F, -30.0F, 0.0F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(38, 9).mirror().addBox(-14.0F, -8.0F, -9.0F, 14.0F, 66.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(138, 24).mirror().addBox(-14.0F, -8.0F, -9.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(121, 75).mirror().addBox(-14.0F, 40.0F, 7.0F, 14.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-19.0F, -30.0F, 0.0F));

		PartDefinition nose = body.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(154, 153).addBox(-6.0F, -5.0F, -20.0F, 12.0F, 10.0F, 20.0F, new CubeDeformation(-0.05F)), PartPose.offset(0.0F, -19.0F, -17.0F));

		PartDefinition rightLeg = everything.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(186, 89).addBox(-5.0F, 0.0F, -9.0F, 8.0F, 21.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 7.0F, 0.0F));

		PartDefinition leftLeg = everything.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(202, 174).addBox(-5.0F, 0.0F, -9.0F, 8.0F, 19.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(18, 214).addBox(1.0F, 16.0F, -9.0F, 2.0F, 3.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(10, 181).addBox(-5.0F, 12.0F, -9.0F, 2.0F, 7.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 7.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				

		boolean shouldPlayWalkAnimation = speed > 0 && entity.shootAnimationTick <= 0;
		
		boolean shouldPlayIdleAnimation = !shouldPlayWalkAnimation && entity.shootAnimationTick <= 0;	
		
		FirstOfOakSineWaveAnimations.firstOfOakWalkAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 12.5F, shouldPlayWalkAnimation ? 1 : 0);
		FirstOfOakSineWaveAnimations.firstOfOakIdleAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayIdleAnimation ? 1 : 0);
		this.animate(entity.shootAnimationState, FirstOfOakKeyframeAnimations.FIRST_OF_OAK_SHOOT, ageInTicks);
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