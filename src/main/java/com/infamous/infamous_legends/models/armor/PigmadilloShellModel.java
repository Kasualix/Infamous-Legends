package com.infamous.infamous_legends.models.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.LivingEntity;

public class PigmadilloShellModel<T extends LivingEntity> extends HumanoidModel<T> {
	
	public PigmadilloShellModel(ModelPart pRoot) {
		super(pRoot);
	}

	public static LayerDefinition createBodyLayer() {
		  MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
	      PartDefinition partdefinition = meshdefinition.getRoot();
	      PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(46, 27).addBox(-4.0F, -3.0F, -3.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
	    			.texOffs(45, 40).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.6F)), PartPose.offset(-5.0F, 14.0F, 0.0F));

	    			PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(46, 27).mirror().addBox(-1.0F, -3.0F, -3.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
	    			.texOffs(45, 40).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.6F)).mirror(false), PartPose.offset(5.0F, 14.0F, 0.0F));

	    			PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(72, 22).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.5F))
	    			.texOffs(0, 33).mirror().addBox(-8.0F, 4.0F, 2.0F, 16.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
	    			.texOffs(3, 0).addBox(-7.0F, 9.0F, 1.0F, 14.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
	    			.texOffs(0, 16).addBox(-8.5F, -3.0F, 4.0F, 17.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

	    			PartDefinition shell1_r1 = body.addOrReplaceChild("shell1_r1", CubeListBuilder.create().texOffs(3, 0).addBox(-14.0F, 14.0F, 0.0F, 14.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
	    			.texOffs(45, 5).addBox(-11.0F, 15.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
	    			.texOffs(45, 5).addBox(-5.0F, 15.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
	    			.texOffs(45, 5).addBox(-12.0F, 22.0F, -6.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
	    			.texOffs(64, 13).addBox(-4.0F, 22.0F, -5.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
	    			.texOffs(45, 5).addBox(-8.0F, 26.0F, -6.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
	    			.texOffs(64, 13).addBox(-4.0F, 33.0F, -4.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
	    			.texOffs(45, 5).addBox(-12.0F, 33.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -21.0F, 6.0F, 0.0F, 3.1416F, 0.0F));

	    			return LayerDefinition.create(meshdefinition, 100, 100);
	    		}
}
