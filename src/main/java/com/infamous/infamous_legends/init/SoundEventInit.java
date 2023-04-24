package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundEventInit {
	
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
			InfamousLegends.MOD_ID);

	// ENTITIES
	
	// PIGMADILLO
	
	public static final RegistryObject<SoundEvent> PIGMADILLO_IDLE = SOUND_EVENTS.register("entity.pigmadillo.idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.pigmadillo.idle")));
	public static final RegistryObject<SoundEvent> PIGMADILLO_ANGRY = SOUND_EVENTS.register("entity.pigmadillo.angry", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.pigmadillo.angry")));
	public static final RegistryObject<SoundEvent> PIGMADILLO_SNORT = SOUND_EVENTS.register("entity.pigmadillo.snort", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.pigmadillo.snort")));
	public static final RegistryObject<SoundEvent> PIGMADILLO_HURT = SOUND_EVENTS.register("entity.pigmadillo.hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.pigmadillo.hurt")));
	public static final RegistryObject<SoundEvent> PIGMADILLO_DEATH = SOUND_EVENTS.register("entity.pigmadillo.death", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.pigmadillo.death")));
	public static final RegistryObject<SoundEvent> PIGMADILLO_STEP = SOUND_EVENTS.register("entity.pigmadillo.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.pigmadillo.step")));
	public static final RegistryObject<SoundEvent> PIGMADILLO_ATTACK = SOUND_EVENTS.register("entity.pigmadillo.attack", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.pigmadillo.attack")));
	public static final RegistryObject<SoundEvent> PIGMADILLO_ROLL_START = SOUND_EVENTS.register("entity.pigmadillo.roll_start", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.pigmadillo.roll_start")));
	public static final RegistryObject<SoundEvent> PIGMADILLO_ROLL = SOUND_EVENTS.register("entity.pigmadillo.roll", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.pigmadillo.roll")));
	public static final RegistryObject<SoundEvent> PIGMADILLO_ROLL_STOP = SOUND_EVENTS.register("entity.pigmadillo.roll_stop", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.pigmadillo.roll_stop")));
	public static final RegistryObject<SoundEvent> PIGMADILLO_ATTACK_FOLEY = SOUND_EVENTS.register("entity.pigmadillo.attack_foley", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.pigmadillo.attack_foley")));
	public static final RegistryObject<SoundEvent> PIGMADILLO_ROLL_START_FOLEY = SOUND_EVENTS.register("entity.pigmadillo.roll_start_foley", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.pigmadillo.roll_start_foley")));
	public static final RegistryObject<SoundEvent> PIGMADILLO_ROLL_FOLEY = SOUND_EVENTS.register("entity.pigmadillo.roll_foley", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.pigmadillo.roll_foley")));
	public static final RegistryObject<SoundEvent> PIGMADILLO_ROLL_STOP_FOLEY = SOUND_EVENTS.register("entity.pigmadillo.roll_stop_foley", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.pigmadillo.roll_stop_foley")));
	public static final RegistryObject<SoundEvent> PIGMADILLO_STEP_FOLEY = SOUND_EVENTS.register("entity.pigmadillo.step_foley", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.pigmadillo.step_foley")));
	
	// COBBLESTONE GOLEM
	
	public static final RegistryObject<SoundEvent> COBBLESTONE_GOLEM_IDLE = SOUND_EVENTS.register("entity.cobblestone_golem.idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.cobblestone_golem.idle")));
	public static final RegistryObject<SoundEvent> COBBLESTONE_GOLEM_HURT = SOUND_EVENTS.register("entity.cobblestone_golem.hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.cobblestone_golem.hurt")));
	public static final RegistryObject<SoundEvent> COBBLESTONE_GOLEM_STEP = SOUND_EVENTS.register("entity.cobblestone_golem.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.cobblestone_golem.step")));
	public static final RegistryObject<SoundEvent> COBBLESTONE_GOLEM_ATTACK = SOUND_EVENTS.register("entity.cobblestone_golem.attack", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.cobblestone_golem.attack")));
	public static final RegistryObject<SoundEvent> COBBLESTONE_GOLEM_ATTACK_IMPACT = SOUND_EVENTS.register("entity.cobblestone_golem.attack_impact", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.cobblestone_golem.attack_impact")));
}
