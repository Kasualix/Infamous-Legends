package com.infamous.infamous_legends.capabilities;

import com.infamous.infamous_legends.hordes.HordeType;
import com.infamous.infamous_legends.init.HordeTypeInit;
import com.infamous.infamous_legends.network.Messages;
import com.infamous.infamous_legends.network.message.ServerToClientHordeSyncPacket;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public class MobHorde {

    private String horde = new String();
    private boolean hasSpawned = false;

    public HordeType getHorde() {
        return HordeTypeInit.getHordeTypeByName(horde) != null ? HordeTypeInit.getHordeTypeByName(horde) : HordeTypeInit.getHordeTypeByName("empty");
    }

    public void setHorde(HordeType horde) {
        this.horde = horde.getName();
    }
    
    public boolean hasSpawned() {
        return hasSpawned;
    }

    public void setHasSpawned(boolean value) {
        this.hasSpawned = value;
    }

    public void copyFrom(MobHorde source) {
    	horde = source.horde;
    	hasSpawned = source.hasSpawned;
    }
    
    public void saveNBTData(CompoundTag compound) {
        compound.putString("Horde", horde);
        compound.putBoolean("HasSpawned", hasSpawned);
    }

    public void loadNBTData(CompoundTag compound) {
    	horde = compound.getString("Horde");
    	hasSpawned = compound.getBoolean("HasSpawned");
    }
}