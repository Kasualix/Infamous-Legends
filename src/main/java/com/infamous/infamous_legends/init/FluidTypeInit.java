package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.fluids.BaseFluidType;
import com.mojang.math.Vector3f;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidTypeInit {
    public static final ResourceLocation TAR_STILL = new ResourceLocation(InfamousLegends.MOD_ID, "blocks/tar_still");
    public static final ResourceLocation TAR_FLOWING = new ResourceLocation(InfamousLegends.MOD_ID, "blocks/tar_flow");
    public static final ResourceLocation TAR_OVERLAY = null;

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, InfamousLegends.MOD_ID);

    public static final RegistryObject<FluidType> TAR_FLUID_TYPE = register("tar_fluid",
            FluidType.Properties.create()
            .canSwim(false)
            .canDrown(true)
            .pathType(BlockPathTypes.LAVA)
            .adjacentPathType(null)
            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
            .density(3000)
            .viscosity(6000)
            .canConvertToSource(true)
            .motionScale(0.01)
            .supportsBoating(true));



    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(TAR_STILL, TAR_FLOWING, TAR_OVERLAY,
        		0xFFFFFFFF, new Vector3f(0, 0, 0), properties));
    }
}