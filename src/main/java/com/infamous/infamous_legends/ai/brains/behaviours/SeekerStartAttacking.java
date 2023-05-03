package com.infamous.infamous_legends.ai.brains.behaviours;

import java.util.Optional;
import java.util.function.Function;

import com.infamous.infamous_legends.entities.Seeker;
import com.infamous.infamous_legends.init.SoundEventInit;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.StartAttacking;

public class SeekerStartAttacking<E extends Seeker> extends StartAttacking<E> {

	public SeekerStartAttacking(Function<E, Optional<? extends LivingEntity>> p_24193_) {
		super(p_24193_);
	}
	
	@Override
	protected void start(ServerLevel p_24208_, E p_24209_, long p_24210_) {
		super.start(p_24208_, p_24209_, p_24210_);
		p_24209_.playSound(SoundEventInit.SEEKER_TARGET_SPOTTED.get(), 3, p_24209_.getVoicePitch());
	}

}
