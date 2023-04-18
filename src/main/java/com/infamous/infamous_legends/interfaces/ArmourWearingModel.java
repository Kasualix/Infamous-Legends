package com.infamous.infamous_legends.interfaces;

import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.mojang.blaze3d.vertex.PoseStack;

public interface ArmourWearingModel {
	void translateArmour(CustomArmourLayer.ArmourModelPart modelPart, PoseStack stack, boolean innerModel);
}
