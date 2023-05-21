package com.infamous.infamous_legends.hordes;

import static com.infamous.infamous_legends.InfamousLegends.MOD_ID;

import com.infamous.infamous_legends.init.MobHordeIdentityInit;

import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MobHordeIdentityReloadListener {

    @SubscribeEvent
    public static void onAddReloadListeners(AddReloadListenerEvent event)
    {
        event.addListener(MobHordeIdentityInit.MOB_HORDE_IDENTITY_REGISTRY);
    }
}
