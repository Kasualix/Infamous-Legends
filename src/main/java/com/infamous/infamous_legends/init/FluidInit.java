package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.fluids.TarFluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidInit {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, InfamousLegends.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_TAR = FLUIDS.register("tar_source",
            () -> new TarFluid.Source(FluidInit.TAR_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TAR = FLUIDS.register("flowing_tar",
            () -> new TarFluid.Flowing(FluidInit.TAR_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties TAR_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            FluidTypeInit.TAR_FLUID_TYPE, SOURCE_TAR, FLOWING_TAR)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(() -> BlockInit.TAR_BLOCK.get()).bucket(() -> ItemInit.TAR_BUCKET.get());

}