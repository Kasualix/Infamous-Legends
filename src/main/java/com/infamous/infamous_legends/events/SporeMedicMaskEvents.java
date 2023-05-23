package com.infamous.infamous_legends.events;

import java.util.Random;
import java.util.UUID;

import org.jetbrains.annotations.NotNull;

import com.google.common.collect.ImmutableMultimap;
import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.capabilities.MobHorde;
import com.infamous.infamous_legends.capabilities.MobHordeProvider;
import com.infamous.infamous_legends.init.DamageSourceInit;
import com.infamous.infamous_legends.init.HordeTypeInit;
import com.infamous.infamous_legends.init.ItemInit;
import com.infamous.infamous_legends.init.MobHordeIdentityInit;
import com.infamous.infamous_legends.network.Messages;
import com.infamous.infamous_legends.network.message.ServerToClientHordeSyncPacket;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingConversionEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = InfamousLegends.MOD_ID, bus = Bus.FORGE)
public class SporeMedicMaskEvents {

	public static Random random = new Random();
	
	@SubscribeEvent
    public static void negateNetherspores(LivingDamageEvent event) {
		if (event.getSource() == DamageSourceInit.NETHERSPORES && event.getEntity().getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemInit.SPORE_MEDIC_MASK.get()) {
			event.setCanceled(true);
		}
    }
    
	@SubscribeEvent
    public static void shortenEffectDuration(MobEffectEvent.Added event) {
		if (!event.getEffectInstance().getEffect().isBeneficial() && event.getEntity().getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemInit.SPORE_MEDIC_MASK.get()) {
			event.getEffectInstance().duration = event.getEffectInstance().duration / 2;
		}
    }
}
