package com.infamous.infamous_legends.events;

import java.util.Random;
import java.util.function.Predicate;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.CobblestoneGolem;
import com.infamous.infamous_legends.entities.FirstOfOak;
import com.infamous.infamous_legends.entities.FirstOfStone;
import com.infamous.infamous_legends.entities.GrindstoneGolem;
import com.infamous.infamous_legends.entities.MossyGolem;
import com.infamous.infamous_legends.entities.PlankGolem;
import com.infamous.infamous_legends.entities.RegalTiger;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = InfamousLegends.MOD_ID, bus = Bus.FORGE)
public class AddAIEvent {
	
	   private static final Predicate<WrappedGoal> ATTACKS_IRON_GOLEM = (p_213685_0_) -> {
		      return p_213685_0_.getGoal() instanceof NearestAttackableTargetGoal && ((NearestAttackableTargetGoal)p_213685_0_.getGoal()).targetType == IronGolem.class;
		   };
		   
	public final Random random = new Random();
	
	@SubscribeEvent
	public static void addAI(EntityJoinLevelEvent event)	
	{		
		if (event.getEntity() instanceof Mob && ((Mob)event.getEntity()).targetSelector.getAvailableGoals().stream().anyMatch(ATTACKS_IRON_GOLEM)) {
			((Mob)event.getEntity()).targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(((Mob)event.getEntity()), FirstOfStone.class, true));
			((Mob)event.getEntity()).targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(((Mob)event.getEntity()), FirstOfOak.class, true));
			((Mob)event.getEntity()).targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(((Mob)event.getEntity()), CobblestoneGolem.class, true));
			((Mob)event.getEntity()).targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(((Mob)event.getEntity()), PlankGolem.class, true));
			((Mob)event.getEntity()).targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(((Mob)event.getEntity()), MossyGolem.class, true));
			((Mob)event.getEntity()).targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(((Mob)event.getEntity()), GrindstoneGolem.class, true));
		}
		
		if (event.getEntity() instanceof Creeper) {
			((Creeper)event.getEntity()).goalSelector.addGoal(3, new AvoidEntityGoal<>(((Creeper)event.getEntity()), RegalTiger.class, 8.0F, 1.1D, 1.3D));
		}
	}
}
