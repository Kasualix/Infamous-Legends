package com.infamous.infamous_legends.capabilities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class MobHordeProvider implements ICapabilitySerializable<CompoundTag> {

    public static Capability<MobHorde> HORDE = CapabilityManager.get(new CapabilityToken<>(){});

    private MobHorde mobHorde = null;
    private final LazyOptional<MobHorde> opt = LazyOptional.of(this::createmobHorde);

    @Nonnull
    private MobHorde createmobHorde() {
        if (mobHorde == null) {
        	mobHorde = new MobHorde();
        }
        return mobHorde;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        if (cap == HORDE) {
            return opt.cast();
        }
        return LazyOptional.empty();
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return getCapability(cap);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createmobHorde().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
    	createmobHorde().loadNBTData(nbt);
    }
}