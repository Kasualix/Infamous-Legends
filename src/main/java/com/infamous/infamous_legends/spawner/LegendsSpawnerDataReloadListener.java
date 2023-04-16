package com.infamous.infamous_legends.spawner;

import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.infamous.infamous_legends.InfamousLegends.MOD_ID;
import static com.infamous.infamous_legends.init.LegendsSpawnerDataInit.LEGENDS_SPAWNER_DATA_REGISTRY;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LegendsSpawnerDataReloadListener {

    @SubscribeEvent
    public static void onAddReloadListeners(AddReloadListenerEvent event)
    {
        event.addListener(LEGENDS_SPAWNER_DATA_REGISTRY);
    }
}
