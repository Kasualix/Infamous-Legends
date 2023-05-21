package com.infamous.infamous_legends.events;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.capabilities.MobHorde;
import com.infamous.infamous_legends.capabilities.MobHordeProvider;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InfamousLegends.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MobHordeEvents {
	
    public static void onAttachCapabilitiesLivingEntity(AttachCapabilitiesEvent<Entity> event){
        if (event.getObject() instanceof LivingEntity) {
            if (!event.getObject().getCapability(MobHordeProvider.HORDE).isPresent()) {
                event.addCapability(new ResourceLocation(InfamousLegends.MOD_ID, "mob_horde"), new MobHordeProvider());
            }
        }
    }
    
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(MobHorde.class);
    }
    
    public static void setup() {
        IEventBus bus = MinecraftForge.EVENT_BUS;
        bus.addGenericListener(Entity.class, MobHordeEvents::onAttachCapabilitiesLivingEntity);
        bus.addListener(MobHordeEvents::onRegisterCapabilities);
    }
}