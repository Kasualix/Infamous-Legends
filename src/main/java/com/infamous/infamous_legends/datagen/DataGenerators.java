package com.infamous.infamous_legends.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeClient()) {
            generator.addProvider(true, new ModBlockStateProvider(generator, event.getExistingFileHelper()));
            generator.addProvider(true, new ModItemModelProvider(generator, event.getExistingFileHelper()));
        }
        if (event.includeServer()) {
        }
    }
}