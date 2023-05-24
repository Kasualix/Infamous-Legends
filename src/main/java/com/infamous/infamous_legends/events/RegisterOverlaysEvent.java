package com.infamous.infamous_legends.events;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.gui.overlay.PigmadilloShellRollingOverlay;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InfamousLegends.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterOverlaysEvent {
	
	@SubscribeEvent
	public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
		event.registerBelowAll("pigmadillo_shell_rolling", PigmadilloShellRollingOverlay.ROLLING_OVERLAY);
	}
}
