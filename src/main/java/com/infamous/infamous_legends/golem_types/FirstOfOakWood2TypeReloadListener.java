package com.infamous.infamous_legends.golem_types;

import static com.infamous.infamous_legends.InfamousLegends.MOD_ID;

import com.infamous.infamous_legends.init.FirstOfOakWood2TypeInit;

import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FirstOfOakWood2TypeReloadListener {

    @SubscribeEvent
    public static void onAddReloadListeners(AddReloadListenerEvent event)
    {
        event.addListener(FirstOfOakWood2TypeInit.FIRST_OF_OAK_WOOD_2_TYPE_REGISTRY);
    }
}
