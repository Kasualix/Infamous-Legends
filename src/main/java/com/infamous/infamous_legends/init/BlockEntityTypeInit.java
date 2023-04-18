package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.blocks.entities.LegendsSpawnerBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityTypeInit {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister
            .create(ForgeRegistries.BLOCK_ENTITY_TYPES, InfamousLegends.MOD_ID);

    public static final RegistryObject<BlockEntityType<LegendsSpawnerBlockEntity>> LEGENDS_SPAWNER = BLOCK_ENTITY_TYPES.register("legends_spawner", () -> BlockEntityType.Builder.of(LegendsSpawnerBlockEntity::new, BlockInit.LEGENDS_SPAWNER_BLOCK.get()).build(null));
}
