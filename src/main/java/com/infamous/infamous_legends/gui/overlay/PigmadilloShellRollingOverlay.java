package com.infamous.infamous_legends.gui.overlay;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.init.ItemInit;
import com.infamous.infamous_legends.utils.OverlayUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class PigmadilloShellRollingOverlay {
	
	public static RandomSource random = RandomSource.create();
	
	public static final IGuiOverlay ROLLING_OVERLAY = ((gui, poseStack, partialTick, screenWidth, screenHeight) -> {
		poseStack.pushPose();
		gui.setupOverlayRenderState(true, false);
		ResourceLocation OVERLAY = new ResourceLocation(InfamousLegends.MOD_ID,
				"textures/gui/pigmadillo_shell_rolling_overlay.png");
		OverlayUtils.renderScreenOverlay(OVERLAY, Minecraft.getInstance().options.getCameraType().isFirstPerson() && Minecraft.getInstance().player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ItemInit.PIGMADILLO_SHELL.get() && Minecraft.getInstance().player.getCooldowns().getCooldownPercent(ItemInit.PIGMADILLO_SHELL.get(), 0) >= 0.84 ? 1 : 0, screenWidth, (int) (screenHeight + 4 + (random.nextGaussian() * 4)));
		poseStack.popPose();
    });    
}
