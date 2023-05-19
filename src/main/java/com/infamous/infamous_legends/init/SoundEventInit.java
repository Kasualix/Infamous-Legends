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
	
	// LAVA LAUNCHER
	
	public static final RegistryObject<SoundEvent> LAVA_LAUNCHER_ATTACK_START = SOUND_EVENTS.register("entity.lava_launcher.attack_start", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.lava_launcher.attack_start")));
	public static final RegistryObject<SoundEvent> LAVA_LAUNCHER_ATTACK_VOCAL = SOUND_EVENTS.register("entity.lava_launcher.attack_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.lava_launcher.attack_vocal")));
	public static final RegistryObject<SoundEvent> LAVA_LAUNCHER_ATTACK = SOUND_EVENTS.register("entity.lava_launcher.attack", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.lava_launcher.attack")));
	public static final RegistryObject<SoundEvent> LAVA_LAUNCHER_DEATH = SOUND_EVENTS.register("entity.lava_launcher.death", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.lava_launcher.death")));
	public static final RegistryObject<SoundEvent> LAVA_LAUNCHER_HURT = SOUND_EVENTS.register("entity.lava_launcher.hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.lava_launcher.hurt")));
	public static final RegistryObject<SoundEvent> LAVA_LAUNCHER_IDLE = SOUND_EVENTS.register("entity.lava_launcher.idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.lava_launcher.idle")));
	public static final RegistryObject<SoundEvent> LAVA_LAUNCHER_PROJECTILE_IMPACT = SOUND_EVENTS.register("entity.lava_launcher.projectile_impact", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.lava_launcher.projectile_impact")));
	public static final RegistryObject<SoundEvent> LAVA_LAUNCHER_RIDER_CRANKING = SOUND_EVENTS.register("entity.lava_launcher.rider_cranking", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.lava_launcher.rider_cranking")));
	public static final RegistryObject<SoundEvent> LAVA_LAUNCHER_RIDER_DEATH = SOUND_EVENTS.register("entity.lava_launcher.rider_death", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.lava_launcher.rider_death")));
	public static final RegistryObject<SoundEvent> LAVA_LAUNCHER_RIDER_HURT = SOUND_EVENTS.register("entity.lava_launcher.rider_hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.lava_launcher.rider_hurt")));
	public static final RegistryObject<SoundEvent> LAVA_LAUNCHER_RIDER_IDLE = SOUND_EVENTS.register("entity.lava_launcher.rider_idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.lava_launcher.rider_idle")));
	public static final RegistryObject<SoundEvent> LAVA_LAUNCHER_RIDER_LOSE_BALANCE = SOUND_EVENTS.register("entity.lava_launcher.rider_lose_balance", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.lava_launcher.rider_lose_balance")));
	public static final RegistryObject<SoundEvent> LAVA_LAUNCHER_RIDER_SHOOT = SOUND_EVENTS.register("entity.lava_launcher.rider_shoot", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.lava_launcher.rider_shoot")));
	public static final RegistryObject<SoundEvent> LAVA_LAUNCHER_SHOOT_START = SOUND_EVENTS.register("entity.lava_launcher.shoot_start", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.lava_launcher.shoot_start")));
	public static final RegistryObject<SoundEvent> LAVA_LAUNCHER_SHOOT = SOUND_EVENTS.register("entity.lava_launcher.shoot", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.lava_launcher.shoot")));
	public static final RegistryObject<SoundEvent> LAVA_LAUNCHER_STEP = SOUND_EVENTS.register("entity.lava_launcher.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.lava_launcher.step")));
	
	// SPORE MEDIC
	
	public static final RegistryObject<SoundEvent> SPORE_MEDIC_SHOOT_LOOP = SOUND_EVENTS.register("entity.spore_medic.shoot_loop", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.spore_medic.shoot_loop")));
	public static final RegistryObject<SoundEvent> SPORE_MEDIC_SHOOT = SOUND_EVENTS.register("entity.spore_medic.shoot", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.spore_medic.shoot")));
	public static final RegistryObject<SoundEvent> SPORE_MEDIC_STEP = SOUND_EVENTS.register("entity.spore_medic.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.spore_medic.step")));
	
	// SPOREBACK
	
	public static final RegistryObject<SoundEvent> SPOREBACK_DEATH = SOUND_EVENTS.register("entity.sporeback.death", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.sporeback.death")));
	public static final RegistryObject<SoundEvent> SPOREBACK_HURT = SOUND_EVENTS.register("entity.sporeback.hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.sporeback.hurt")));
	public static final RegistryObject<SoundEvent> SPOREBACK_IDLE = SOUND_EVENTS.register("entity.sporeback.idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.sporeback.idle")));
	public static final RegistryObject<SoundEvent> SPOREBACK_PROJECTILE_IMPACT = SOUND_EVENTS.register("entity.sporeback.projectile_impact", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.sporeback.projectile_impact")));
	public static final RegistryObject<SoundEvent> SPOREBACK_STEP_VOCAL = SOUND_EVENTS.register("entity.sporeback.step_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.sporeback.step_vocal")));
	public static final RegistryObject<SoundEvent> SPOREBACK_STEP = SOUND_EVENTS.register("entity.sporeback.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.sporeback.step")));
	public static final RegistryObject<SoundEvent> SPOREBACK_THROW_PROJECTILE = SOUND_EVENTS.register("entity.sporeback.throw_projectile", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.sporeback.throw_projectile")));
	public static final RegistryObject<SoundEvent> SPOREBACK_THROW_START = SOUND_EVENTS.register("entity.sporeback.throw_start", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.sporeback.throw_start")));
	public static final RegistryObject<SoundEvent> SPOREBACK_THROW_STOP_VOCAL = SOUND_EVENTS.register("entity.sporeback.throw_stop_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.sporeback.throw_stop_vocal")));
	public static final RegistryObject<SoundEvent> SPOREBACK_THROW_STOP = SOUND_EVENTS.register("entity.sporeback.throw_stop", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.sporeback.throw_stop")));
	public static final RegistryObject<SoundEvent> SPOREBACK_THROW_VOCAL = SOUND_EVENTS.register("entity.sporeback.throw_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.sporeback.throw_vocal")));
	public static final RegistryObject<SoundEvent> SPOREBACK_THROW = SOUND_EVENTS.register("entity.sporeback.throw", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.sporeback.throw")));
	
	// PIGLIN BUILDER
	
	public static final RegistryObject<SoundEvent> PIGLIN_BUILDER_LOOP = SOUND_EVENTS.register("entity.piglin_builder.loop", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.piglin_builder.loop")));
	public static final RegistryObject<SoundEvent> PIGLIN_BUILDER_PROJECTILE_IMPACT = SOUND_EVENTS.register("entity.piglin_builder.projectile_impact", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.piglin_builder.projectile_impact")));
	public static final RegistryObject<SoundEvent> PIGLIN_BUILDER_SHOOT_FURNACE = SOUND_EVENTS.register("entity.piglin_builder.shoot_furnace", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.piglin_builder.shoot_furnace")));
	public static final RegistryObject<SoundEvent> PIGLIN_BUILDER_SHOOT_START = SOUND_EVENTS.register("entity.piglin_builder.shoot_start", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.piglin_builder.shoot_start")));
	public static final RegistryObject<SoundEvent> PIGLIN_BUILDER_SHOOT = SOUND_EVENTS.register("entity.piglin_builder.shoot", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.piglin_builder.shoot")));
	public static final RegistryObject<SoundEvent> PIGLIN_BUILDER_STEP = SOUND_EVENTS.register("entity.piglin_builder.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.piglin_builder.step")));
	
	// PIGLIN BRUISER
	
	public static final RegistryObject<SoundEvent> PIGLIN_BRUISER_ANGRY = SOUND_EVENTS.register("entity.piglin_bruiser.angry", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.piglin_bruiser.angry")));
	public static final RegistryObject<SoundEvent> PIGLIN_BRUISER_ATTACK_START_VOCAL = SOUND_EVENTS.register("entity.piglin_bruiser.attack_start_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.piglin_bruiser.attack_start_vocal")));
	public static final RegistryObject<SoundEvent> PIGLIN_BRUISER_ATTACK_VOCAL = SOUND_EVENTS.register("entity.piglin_bruiser.attack_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.piglin_bruiser.attack_vocal")));
	public static final RegistryObject<SoundEvent> PIGLIN_BRUISER_ATTACK = SOUND_EVENTS.register("entity.piglin_bruiser.attack", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.piglin_bruiser.attack")));
	public static final RegistryObject<SoundEvent> PIGLIN_BRUISER_DEATH = SOUND_EVENTS.register("entity.piglin_bruiser.death", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.piglin_bruiser.death")));
	public static final RegistryObject<SoundEvent> PIGLIN_BRUISER_HURT = SOUND_EVENTS.register("entity.piglin_bruiser.hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.piglin_bruiser.hurt")));
	public static final RegistryObject<SoundEvent> PIGLIN_BRUISER_IDLE = SOUND_EVENTS.register("entity.piglin_bruiser.idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.piglin_bruiser.idle")));
	public static final RegistryObject<SoundEvent> PIGLIN_BRUISER_SPIN_ATTACK_VOCAL = SOUND_EVENTS.register("entity.piglin_bruiser.spin_attack_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.piglin_bruiser.spin_attack_vocal")));
	public static final RegistryObject<SoundEvent> PIGLIN_BRUISER_SPIN_ATTACK = SOUND_EVENTS.register("entity.piglin_bruiser.spin_attack", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.piglin_bruiser.spin_attack")));
	public static final RegistryObject<SoundEvent> PIGLIN_BRUISER_STEP = SOUND_EVENTS.register("entity.piglin_bruiser.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.piglin_bruiser.step")));
	
	// PORTAL GUARD
	
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_ANGRY = SOUND_EVENTS.register("entity.portal_guard.angry", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.angry")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_ATTACK_VOCAL = SOUND_EVENTS.register("entity.portal_guard.attack_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.attack_vocal")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_ATTACK = SOUND_EVENTS.register("entity.portal_guard.attack", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.attack")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_DEATH = SOUND_EVENTS.register("entity.portal_guard.death", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.death")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_HURT = SOUND_EVENTS.register("entity.portal_guard.hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.hurt")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_IDLE = SOUND_EVENTS.register("entity.portal_guard.idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.idle")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_REEL_IN_BALL_START = SOUND_EVENTS.register("entity.portal_guard.reel_in_ball_start", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.reel_in_ball_start")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_REEL_IN_BALL_STOP = SOUND_EVENTS.register("entity.portal_guard.reel_in_ball_stop", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.reel_in_ball_stop")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_SHOOT_START_VOCAL = SOUND_EVENTS.register("entity.portal_guard.shoot_start_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.shoot_start_vocal")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_SHOOT_START = SOUND_EVENTS.register("entity.portal_guard.shoot_start", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.shoot_start")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_SHOOT_VOCAL = SOUND_EVENTS.register("entity.portal_guard.shoot_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.shoot_vocal")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_SHOOT = SOUND_EVENTS.register("entity.portal_guard.shoot", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.shoot")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_PROJECTILE_IMPACT = SOUND_EVENTS.register("entity.portal_guard.projectile_impact", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.projectile_impact")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_SNORT = SOUND_EVENTS.register("entity.portal_guard.snort", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.snort")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_STEP_ARM = SOUND_EVENTS.register("entity.portal_guard.step_arm", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.step_arm")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_STEP_FOOT = SOUND_EVENTS.register("entity.portal_guard.step_foot", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.step_foot")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_STEP_VOCAL = SOUND_EVENTS.register("entity.portal_guard.step_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.step_vocal")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_SWING_START_VOCAL = SOUND_EVENTS.register("entity.portal_guard.swing_start_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.swing_start_vocal")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_SWING_START = SOUND_EVENTS.register("entity.portal_guard.swing_start", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.swing_start")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_SWING_VOCAL = SOUND_EVENTS.register("entity.portal_guard.swing_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.swing_vocal")));
	public static final RegistryObject<SoundEvent> PORTAL_GUARD_SWING = SOUND_EVENTS.register("entity.portal_guard.swing", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.portal_guard.swing")));
	
	// REGAL TIGER
	
	public static final RegistryObject<SoundEvent> REGAL_TIGER_ANGRY = SOUND_EVENTS.register("entity.regal_tiger.angry", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.regal_tiger.angry")));
	public static final RegistryObject<SoundEvent> REGAL_TIGER_ATTACK_START = SOUND_EVENTS.register("entity.regal_tiger.attack_start", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.regal_tiger.attack_start")));
	public static final RegistryObject<SoundEvent> REGAL_TIGER_ATTACK_STOP = SOUND_EVENTS.register("entity.regal_tiger.attack_stop", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.regal_tiger.attack_stop")));
	public static final RegistryObject<SoundEvent> REGAL_TIGER_ATTACK = SOUND_EVENTS.register("entity.regal_tiger.attack", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.regal_tiger.attack")));
	public static final RegistryObject<SoundEvent> REGAL_TIGER_DEATH = SOUND_EVENTS.register("entity.regal_tiger.death", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.regal_tiger.death")));
	public static final RegistryObject<SoundEvent> REGAL_TIGER_EAT = SOUND_EVENTS.register("entity.regal_tiger.eat", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.regal_tiger.eat")));
	public static final RegistryObject<SoundEvent> REGAL_TIGER_HURT = SOUND_EVENTS.register("entity.regal_tiger.hurt", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.regal_tiger.hurt")));
	public static final RegistryObject<SoundEvent> REGAL_TIGER_IDLE = SOUND_EVENTS.register("entity.regal_tiger.idle", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.regal_tiger.idle")));
	public static final RegistryObject<SoundEvent> REGAL_TIGER_LICK = SOUND_EVENTS.register("entity.regal_tiger.lick", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.regal_tiger.lick")));
	public static final RegistryObject<SoundEvent> REGAL_TIGER_SIT = SOUND_EVENTS.register("entity.regal_tiger.sit", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.regal_tiger.sit")));
	public static final RegistryObject<SoundEvent> REGAL_TIGER_STAND = SOUND_EVENTS.register("entity.regal_tiger.stand", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.regal_tiger.stand")));
	public static final RegistryObject<SoundEvent> REGAL_TIGER_STEP_VOCAL = SOUND_EVENTS.register("entity.regal_tiger.step_vocal", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.regal_tiger.step_vocal")));
	public static final RegistryObject<SoundEvent> REGAL_TIGER_STEP = SOUND_EVENTS.register("entity.regal_tiger.step", () -> new SoundEvent(new ResourceLocation(InfamousLegends.MOD_ID, "entity.regal_tiger.step")));
}
