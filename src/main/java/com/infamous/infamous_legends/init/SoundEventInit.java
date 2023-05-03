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
	
	// PLANK GOLEM
	
	public static final RegistryObject<SoundEvent> PLANK_GOLEM_IDLE = SOUND_EVENTS.register("entity.plank_golem.idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.plank_golem.idle")));
	public static final RegistryObject<SoundEvent> PLANK_GOLEM_HURT = SOUND_EVENTS.register("entity.plank_golem.hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.plank_golem.hurt")));
	public static final RegistryObject<SoundEvent> PLANK_GOLEM_DEATH = SOUND_EVENTS.register("entity.plank_golem.death", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.plank_golem.death")));
	public static final RegistryObject<SoundEvent> PLANK_GOLEM_STEP = SOUND_EVENTS.register("entity.plank_golem.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.plank_golem.step")));
	public static final RegistryObject<SoundEvent> PLANK_GOLEM_START_ATTACKING = SOUND_EVENTS.register("entity.plank_golem.start_attacking", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.plank_golem.start_attacking")));
	public static final RegistryObject<SoundEvent> PLANK_GOLEM_SHOOT = SOUND_EVENTS.register("entity.plank_golem.shoot", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.plank_golem.shoot")));
	public static final RegistryObject<SoundEvent> PLANK_GOLEM_PROJECTILE_IMPACT = SOUND_EVENTS.register("entity.plank_golem.projectile_impact", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.plank_golem.projectile_impact")));
	
	// GRINDSTONE GOLEM
	
	public static final RegistryObject<SoundEvent> GRINDSTONE_GOLEM_IDLE = SOUND_EVENTS.register("entity.grindstone_golem.idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.grindstone_golem.idle")));
	public static final RegistryObject<SoundEvent> GRINDSTONE_GOLEM_HURT = SOUND_EVENTS.register("entity.grindstone_golem.hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.grindstone_golem.hurt")));
	public static final RegistryObject<SoundEvent> GRINDSTONE_GOLEM_DEATH = SOUND_EVENTS.register("entity.grindstone_golem.death", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.grindstone_golem.death")));
	public static final RegistryObject<SoundEvent> GRINDSTONE_GOLEM_STEP = SOUND_EVENTS.register("entity.grindstone_golem.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.grindstone_golem.step")));
	public static final RegistryObject<SoundEvent> GRINDSTONE_GOLEM_ATTACK = SOUND_EVENTS.register("entity.grindstone_golem.attack", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.grindstone_golem.attack")));
	public static final RegistryObject<SoundEvent> GRINDSTONE_GOLEM_ROLL_START = SOUND_EVENTS.register("entity.grindstone_golem.roll_start", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.grindstone_golem.roll_start")));
	public static final RegistryObject<SoundEvent> GRINDSTONE_GOLEM_ROLL = SOUND_EVENTS.register("entity.grindstone_golem.roll", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.grindstone_golem.roll")));
	public static final RegistryObject<SoundEvent> GRINDSTONE_GOLEM_ROLL_STOP = SOUND_EVENTS.register("entity.grindstone_golem.roll_stop", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.grindstone_golem.roll_stop")));
	
	// MOSSY GOLEM
	
	public static final RegistryObject<SoundEvent> MOSSY_GOLEM_IDLE = SOUND_EVENTS.register("entity.mossy_golem.idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.mossy_golem.idle")));
	public static final RegistryObject<SoundEvent> MOSSY_GOLEM_HURT = SOUND_EVENTS.register("entity.mossy_golem.hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.mossy_golem.hurt")));
	public static final RegistryObject<SoundEvent> MOSSY_GOLEM_DEATH = SOUND_EVENTS.register("entity.mossy_golem.death", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.mossy_golem.death")));
	public static final RegistryObject<SoundEvent> MOSSY_GOLEM_STEP = SOUND_EVENTS.register("entity.mossy_golem.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.mossy_golem.step")));
	public static final RegistryObject<SoundEvent> MOSSY_GOLEM_SHOOT_A = SOUND_EVENTS.register("entity.mossy_golem.shoot_a", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.mossy_golem.shoot_a")));
	public static final RegistryObject<SoundEvent> MOSSY_GOLEM_SHOOT_B = SOUND_EVENTS.register("entity.mossy_golem.shoot_b", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.mossy_golem.shoot_b")));
	
	// FIRST OF STONE
	
	public static final RegistryObject<SoundEvent> FIRST_OF_STONE_ATTACK_STOP = SOUND_EVENTS.register("entity.first_of_stone.attack_stop", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_stone.attack_stop")));
	public static final RegistryObject<SoundEvent> FIRST_OF_STONE_ATTACK_VOCAL = SOUND_EVENTS.register("entity.first_of_stone.attack_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_stone.attack_vocal")));
	public static final RegistryObject<SoundEvent> FIRST_OF_STONE_ATTACK = SOUND_EVENTS.register("entity.first_of_stone.attack", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_stone.attack")));
	public static final RegistryObject<SoundEvent> FIRST_OF_STONE_DEATH = SOUND_EVENTS.register("entity.first_of_stone.death", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_stone.death")));
	public static final RegistryObject<SoundEvent> FIRST_OF_STONE_HURT = SOUND_EVENTS.register("entity.first_of_stone.hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_stone.hurt")));
	public static final RegistryObject<SoundEvent> FIRST_OF_STONE_IDLE = SOUND_EVENTS.register("entity.first_of_stone.idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_stone.idle")));
	public static final RegistryObject<SoundEvent> FIRST_OF_STONE_PROJECTILE_IMPACT = SOUND_EVENTS.register("entity.first_of_stone.projectile_impact", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_stone.projectile_impact")));
	public static final RegistryObject<SoundEvent> FIRST_OF_STONE_RANGED_ATTACK_DRAG = SOUND_EVENTS.register("entity.first_of_stone.ranged_attack_drag", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_stone.ranged_attack_drag")));
	public static final RegistryObject<SoundEvent> FIRST_OF_STONE_RANGED_ATTACK_START = SOUND_EVENTS.register("entity.first_of_stone.ranged_attack_start", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_stone.ranged_attack_start")));
	public static final RegistryObject<SoundEvent> FIRST_OF_STONE_RANGED_ATTACK_STOP = SOUND_EVENTS.register("entity.first_of_stone.ranged_attack_stop", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_stone.ranged_attack_stop")));
	public static final RegistryObject<SoundEvent> FIRST_OF_STONE_RANGED_ATTACK_THROW_VOCAL = SOUND_EVENTS.register("entity.first_of_stone.ranged_attack_throw_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_stone.ranged_attack_throw_vocal")));
	public static final RegistryObject<SoundEvent> FIRST_OF_STONE_RANGED_ATTACK_THROW = SOUND_EVENTS.register("entity.first_of_stone.ranged_attack_throw", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_stone.ranged_attack_throw")));
	public static final RegistryObject<SoundEvent> FIRST_OF_STONE_RANGED_ATTACK_VOCAL = SOUND_EVENTS.register("entity.first_of_stone.ranged_attack_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_stone.ranged_attack_vocal")));
	public static final RegistryObject<SoundEvent> FIRST_OF_STONE_STEP_RUNNING = SOUND_EVENTS.register("entity.first_of_stone.step_running", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_stone.step_running")));
	public static final RegistryObject<SoundEvent> FIRST_OF_STONE_STEP = SOUND_EVENTS.register("entity.first_of_stone.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_stone.step")));
	
	// FIRST OF OAK
	
	public static final RegistryObject<SoundEvent> FIRST_OF_OAK_DEATH = SOUND_EVENTS.register("entity.first_of_oak.death", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_oak.death")));
	public static final RegistryObject<SoundEvent> FIRST_OF_OAK_HURT = SOUND_EVENTS.register("entity.first_of_oak.hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_oak.hurt")));
	public static final RegistryObject<SoundEvent> FIRST_OF_OAK_IDLE = SOUND_EVENTS.register("entity.first_of_oak.idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_oak.idle")));
	public static final RegistryObject<SoundEvent> FIRST_OF_OAK_PROJECTILE_IMPACT = SOUND_EVENTS.register("entity.first_of_oak.projectile_impact", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_oak.projectile_impact")));
	public static final RegistryObject<SoundEvent> FIRST_OF_OAK_SHOOT_START = SOUND_EVENTS.register("entity.first_of_oak.shoot_start", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_oak.shoot_start")));
	public static final RegistryObject<SoundEvent> FIRST_OF_OAK_SHOOT_STOP = SOUND_EVENTS.register("entity.first_of_oak.shoot_stop", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_oak.shoot_stop")));
	public static final RegistryObject<SoundEvent> FIRST_OF_OAK_SHOOT_VOCAL = SOUND_EVENTS.register("entity.first_of_oak.shoot_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_oak.shoot_vocal")));
	public static final RegistryObject<SoundEvent> FIRST_OF_OAK_SHOOT = SOUND_EVENTS.register("entity.first_of_oak.shoot", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_oak.shoot")));
	public static final RegistryObject<SoundEvent> FIRST_OF_OAK_STEP = SOUND_EVENTS.register("entity.first_of_oak.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.first_of_oak.step")));
	
	// MACE RUNT
	
	public static final RegistryObject<SoundEvent> MACE_RUNT_ANGRY = SOUND_EVENTS.register("entity.mace_runt.angry", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.mace_runt.angry")));
	public static final RegistryObject<SoundEvent> MACE_RUNT_ATTACK_VOCAL = SOUND_EVENTS.register("entity.mace_runt.attack_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.mace_runt.attack_vocal")));
	public static final RegistryObject<SoundEvent> MACE_RUNT_ATTACK = SOUND_EVENTS.register("entity.mace_runt.attack", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.mace_runt.attack")));
	public static final RegistryObject<SoundEvent> MACE_RUNT_DEATH = SOUND_EVENTS.register("entity.mace_runt.death", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.mace_runt.death")));
	public static final RegistryObject<SoundEvent> MACE_RUNT_HURT = SOUND_EVENTS.register("entity.mace_runt.hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.mace_runt.hurt")));
	public static final RegistryObject<SoundEvent> MACE_RUNT_IDLE = SOUND_EVENTS.register("entity.mace_runt.idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.mace_runt.idle")));
	public static final RegistryObject<SoundEvent> MACE_RUNT_STEP = SOUND_EVENTS.register("entity.mace_runt.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.mace_runt.step")));
	public static final RegistryObject<SoundEvent> MACE_RUNT_WALKING_MACE_DRAG = SOUND_EVENTS.register("entity.mace_runt.walking_mace_drag", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.mace_runt.walking_mace_drag")));
	
	// BLAZE RUNT
	
	public static final RegistryObject<SoundEvent> BLAZE_RUNT_ANGRY = SOUND_EVENTS.register("entity.blaze_runt.angry", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.blaze_runt.angry")));
	public static final RegistryObject<SoundEvent> BLAZE_RUNT_ATTACK = SOUND_EVENTS.register("entity.blaze_runt.attack", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.blaze_runt.attack")));
	public static final RegistryObject<SoundEvent> BLAZE_RUNT_DEATH = SOUND_EVENTS.register("entity.blaze_runt.death", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.blaze_runt.death")));
	public static final RegistryObject<SoundEvent> BLAZE_RUNT_HURT = SOUND_EVENTS.register("entity.blaze_runt.hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.blaze_runt.hurt")));
	public static final RegistryObject<SoundEvent> BLAZE_RUNT_IDLE = SOUND_EVENTS.register("entity.blaze_runt.idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.blaze_runt.idle")));
	public static final RegistryObject<SoundEvent> BLAZE_RUNT_PROJECTILE_IMPACT = SOUND_EVENTS.register("entity.blaze_runt.projectile_impact", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.blaze_runt.projectile_impact")));
	public static final RegistryObject<SoundEvent> BLAZE_RUNT_STEP = SOUND_EVENTS.register("entity.blaze_runt.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.blaze_runt.step")));
	public static final RegistryObject<SoundEvent> BLAZE_RUNT_THROW = SOUND_EVENTS.register("entity.blaze_runt.throw", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.blaze_runt.throw")));
	
	// WARBOAR
	
	public static final RegistryObject<SoundEvent> WAR_BOAR_ATTACK_VOCAL = SOUND_EVENTS.register("entity.war_boar.attack_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.war_boar.attack_vocal")));
	public static final RegistryObject<SoundEvent> WAR_BOAR_ATTACK = SOUND_EVENTS.register("entity.war_boar.attack", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.war_boar.attack")));
	public static final RegistryObject<SoundEvent> WAR_BOAR_CHARGE = SOUND_EVENTS.register("entity.war_boar.charge", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.war_boar.charge")));
	public static final RegistryObject<SoundEvent> WAR_BOAR_DEATH = SOUND_EVENTS.register("entity.war_boar.death", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.war_boar.death")));
	public static final RegistryObject<SoundEvent> WAR_BOAR_HURT = SOUND_EVENTS.register("entity.war_boar.hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.war_boar.hurt")));
	public static final RegistryObject<SoundEvent> WAR_BOAR_IDLE = SOUND_EVENTS.register("entity.war_boar.idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.war_boar.idle")));
	public static final RegistryObject<SoundEvent> WAR_BOAR_STEP_CHARGING = SOUND_EVENTS.register("entity.war_boar.step_charging", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.war_boar.step_charging")));
	public static final RegistryObject<SoundEvent> WAR_BOAR_STEP = SOUND_EVENTS.register("entity.war_boar.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.war_boar.step")));
	
	// SEEKER
	
	public static final RegistryObject<SoundEvent> SEEKER_ATTACK_VOCAL = SOUND_EVENTS.register("entity.seeker.attack_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.seeker.attack_vocal")));
	public static final RegistryObject<SoundEvent> SEEKER_ATTACK = SOUND_EVENTS.register("entity.seeker.attack", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.seeker.attack")));
	public static final RegistryObject<SoundEvent> SEEKER_DEATH = SOUND_EVENTS.register("entity.seeker.death", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.seeker.death")));
	public static final RegistryObject<SoundEvent> SEEKER_HURT = SOUND_EVENTS.register("entity.seeker.hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.seeker.hurt")));
	public static final RegistryObject<SoundEvent> SEEKER_IDLE = SOUND_EVENTS.register("entity.seeker.idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.seeker.idle")));
	public static final RegistryObject<SoundEvent> SEEKER_RUN_VOCAL = SOUND_EVENTS.register("entity.seeker.run_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.seeker.run_vocal")));
	public static final RegistryObject<SoundEvent> SEEKER_STEP = SOUND_EVENTS.register("entity.seeker.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.seeker.step")));
	public static final RegistryObject<SoundEvent> SEEKER_TARGET_SPOTTED = SOUND_EVENTS.register("entity.seeker.target_spotted", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.seeker.target_spotted")));
}
