package com.infamous.infamous_legends.utils;

import com.infamous.infamous_legends.entities.MaceRunt;
import com.infamous.infamous_legends.entities.SporeMedic;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.soundinstances.MaceRuntSoundInstance;
import com.infamous.infamous_legends.soundinstances.SporeMedicSoundInstance;

import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;

public class HandleLoopingSoundInstances {

	public static void addMaceRuntAudio(MaceRunt object, Level level) {
		if (level.isClientSide) {
		  	Minecraft.getInstance().getSoundManager().queueTickingSound(new MaceRuntSoundInstance(object, SoundEventInit.MACE_RUNT_WALKING_MACE_DRAG.get(), object.getSoundSource()));
		}
	}
	
	public static void addSporeMedicAudio(SporeMedic object, Level level) {
		if (level.isClientSide) {
		  	Minecraft.getInstance().getSoundManager().queueTickingSound(new SporeMedicSoundInstance(object, SoundEventInit.SPORE_MEDIC_SHOOT_LOOP.get(), object.getSoundSource()));
		}
	}
	
}