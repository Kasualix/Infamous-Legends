package com.infamous.infamous_legends.events;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.compress.utils.Lists;
import org.jetbrains.annotations.NotNull;

import com.google.common.collect.ImmutableMultimap;
import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.capabilities.MobHorde;
import com.infamous.infamous_legends.capabilities.MobHordeProvider;
import com.infamous.infamous_legends.hordes.HordeType;
import com.infamous.infamous_legends.hordes.MobHordeIdentity;
import com.infamous.infamous_legends.init.HordeTypeInit;
import com.infamous.infamous_legends.init.MobHordeIdentityInit;
import com.infamous.infamous_legends.network.Messages;
import com.infamous.infamous_legends.network.message.ServerToClientHordeSyncPacket;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingConversionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = InfamousLegends.MOD_ID, bus = Bus.FORGE)
public class GiveMobHordeEvent {

	public static Random random = new Random();
	
	@SubscribeEvent
    public static void giveMobHorde(EntityJoinLevelEvent event) {
		if (!event.getEntity().level.isClientSide && MobHordeIdentityInit.getMobHordeIdentitiesByEntityType(event.getEntity().getType()).size() > 0) {
	        event.getEntity().getCapability(MobHordeProvider.HORDE).ifPresent((capability) -> {
	        	boolean shouldSetHealthToMax = event.getEntity() instanceof LivingEntity && ((LivingEntity)event.getEntity()).getHealth() >= ((LivingEntity)event.getEntity()).getMaxHealth();
	        	if (!capability.hasSpawned() && capability.getHorde().getName().equals("empty")) {
	        		List<HordeType> viableHordes = Lists.newArrayList();
	        				for (MobHordeIdentity hordeIdentity : MobHordeIdentityInit.getMobHordeIdentitiesByEntityType(event.getEntity().getType())) {
	        					viableHordes.add(HordeTypeInit.getHordeTypeByName(hordeIdentity.getHorde()));
	        				}
	        		if (viableHordes.size() > 0) {
	        		HordeType biomeBasedHorde = event.getEntity().level.getBiome(event.getEntity().blockPosition()).get() != null ? HordeTypeInit.getHordeTypeByBiome(event.getEntity().level.getBiome(event.getEntity().blockPosition()), viableHordes) : null;
		        		if (biomeBasedHorde != null) {
		        			capability.setHorde(biomeBasedHorde);
		        		} else {
		        			capability.setHorde(viableHordes.get(random.nextInt(viableHordes.size())));
		        		}
	        		}
		        	if (event.getEntity() instanceof LivingEntity && capability.getHorde() != null && MobHordeIdentityInit.getMobHordeIdentityByEntityTypeAndHorde(event.getEntity().getType(), capability.getHorde()) != null && MobHordeIdentityInit.getMobHordeIdentityByEntityTypeAndHorde(event.getEntity().getType(), capability.getHorde()).modifyAttributes()) {
			        	ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
			        	capability.getHorde().getAttributes().forEach(attributeModifier -> {
			                Attribute attribute = ForgeRegistries.ATTRIBUTES.getValue(attributeModifier.getAttributeResourceLocation());
			                if (attribute != null) {
			                    builder.put(attribute, new AttributeModifier(UUID.randomUUID(), "Horde modifier", attributeModifier.getAmount(), attributeModifier.getOperation()));
			                }
			            });
			        	((LivingEntity)event.getEntity()).getAttributes().addTransientAttributeModifiers(builder.build());
			        	((LivingEntity)event.getEntity()).setHealth(((LivingEntity)event.getEntity()).getMaxHealth());
		        	}
		        	capability.setHasSpawned(true);
	        	} else {
	        		if (event.getEntity() instanceof LivingEntity && capability.getHorde() != null && MobHordeIdentityInit.getMobHordeIdentityByEntityTypeAndHorde(event.getEntity().getType(), capability.getHorde()) != null && MobHordeIdentityInit.getMobHordeIdentityByEntityTypeAndHorde(event.getEntity().getType(), capability.getHorde()).modifyAttributes()) {
		        		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
			        	capability.getHorde().getAttributes().forEach(attributeModifier -> {
			                Attribute attribute = ForgeRegistries.ATTRIBUTES.getValue(attributeModifier.getAttributeResourceLocation());
			                if (attribute != null) {
			                    builder.put(attribute, new AttributeModifier(UUID.randomUUID(), "Horde modifier", attributeModifier.getAmount(), attributeModifier.getOperation()));
			                }
			            });
			        	((LivingEntity)event.getEntity()).getAttributes().addTransientAttributeModifiers(builder.build());
			        	if (shouldSetHealthToMax) {
			        		((LivingEntity)event.getEntity()).setHealth(((LivingEntity)event.getEntity()).getMaxHealth());
			        	}
	        		}
	        	}
	        });
		}
    }
    
	@SubscribeEvent
	public static void keepHordeWhenConverted(LivingConversionEvent.Post event) {
		event.getEntity().reviveCaps();
		@NotNull LazyOptional<MobHorde> originalMobHorde = event.getEntity().getCapability(MobHordeProvider.HORDE);
		@NotNull LazyOptional<MobHorde> newMobHorde = event.getOutcome().getCapability(MobHordeProvider.HORDE);
		
		if (originalMobHorde.isPresent() && newMobHorde.isPresent()) {
			((MobHorde)newMobHorde.resolve().get()).copyFrom(((MobHorde)originalMobHorde.resolve().get()));
		}
		event.getEntity().invalidateCaps();
	}
	
	@SubscribeEvent
	public static void sendHordePacket(PlayerEvent.StartTracking event) {
    	Player player = event.getEntity();
    	event.getTarget().getCapability(MobHordeProvider.HORDE).ifPresent(capability -> {	
    		if (player instanceof ServerPlayer) {
    			Messages.sendToPlayer(new ServerToClientHordeSyncPacket(capability.getHorde(), event.getTarget().getId()), ((ServerPlayer)player));
    		}
    	});
	}
}
