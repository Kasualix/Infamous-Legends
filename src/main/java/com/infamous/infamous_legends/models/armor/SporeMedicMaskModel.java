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

public class SporeMedicMaskModel<T extends LivingEntity> extends HumanoidModel<T> {
	
	public SporeMedicMaskModel(ModelPart pRoot) {
		super(pRoot);
	}

	public static LayerDefinition createBodyLayer() {
		  MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
	      PartDefinition partdefinition = meshdefinition.getRoot();
	      PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(36, 2 + 32).addBox(-2.5F, -4.0F, -12.0F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
	    			.texOffs(0, 4 + 32).mirror().addBox(2.0F, -3.0F, -5.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
	    			.texOffs(5, 0 + 32).mirror().addBox(4.0F, -3.0F, -5.0F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
	    			.texOffs(17, 2 + 32).addBox(-4.0F, -3.0F, 4.0F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
	    			.texOffs(5, 0 + 32).addBox(-5.0F, -3.0F, -5.0F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
	    			.texOffs(0, 0 + 32).addBox(-4.0F, -3.0F, -5.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
	    			.texOffs(6, 0 + 32).addBox(-1.5F, -8.0F, -5.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
	    			.texOffs(18, 7 + 32).addBox(-1.5F, -10.0F, -5.0F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
	    			.texOffs(1, 14 + 32).addBox(-1.5F, -8.0F, 4.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
	      return LayerDefinition.create(meshdefinition, 64, 64);
	   }
}
