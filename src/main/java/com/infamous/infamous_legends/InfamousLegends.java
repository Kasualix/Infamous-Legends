package com.infamous.infamous_legends;

import com.infamous.infamous_legends.entities.BigBeak;
import com.infamous.infamous_legends.entities.BlazeRunt;
import com.infamous.infamous_legends.entities.CobblestoneGolem;
import com.infamous.infamous_legends.entities.FirstOfOak;
import com.infamous.infamous_legends.entities.FirstOfStone;
import com.infamous.infamous_legends.entities.GrindstoneGolem;
import com.infamous.infamous_legends.entities.LavaLauncher;
import com.infamous.infamous_legends.entities.MaceRunt;
import com.infamous.infamous_legends.entities.MossyGolem;
import com.infamous.infamous_legends.entities.PiglinBruiser;
import com.infamous.infamous_legends.entities.PiglinBuilder;
import com.infamous.infamous_legends.entities.Pigmadillo;
import com.infamous.infamous_legends.entities.PlankGolem;
import com.infamous.infamous_legends.entities.PortalGuard;
import com.infamous.infamous_legends.entities.RegalTiger;
import com.infamous.infamous_legends.entities.Seeker;
import com.infamous.infamous_legends.entities.SporeMedic;
import com.infamous.infamous_legends.entities.Sporeback;
import com.infamous.infamous_legends.entities.WarBoar;
import com.infamous.infamous_legends.events.MobHordeEvents;
import com.infamous.infamous_legends.init.ActivityInit;
import com.infamous.infamous_legends.init.BlockEntityTypeInit;
import com.infamous.infamous_legends.init.BlockInit;
import com.infamous.infamous_legends.init.EntityTypeInit;
import com.infamous.infamous_legends.init.FirstOfOakWood1TypeInit;
import com.infamous.infamous_legends.init.FirstOfOakWood2TypeInit;
import com.infamous.infamous_legends.init.FluidInit;
import com.infamous.infamous_legends.init.FluidTypeInit;
import com.infamous.infamous_legends.init.ItemInit;
import com.infamous.infamous_legends.init.LegendsSpawnerDataInit;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.init.PlankGolemTypeInit;
import com.infamous.infamous_legends.init.SensorTypeInit;
import com.infamous.infamous_legends.init.SoundEventInit;
import com.infamous.infamous_legends.network.Messages;

import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fluids.FluidInteractionRegistry.InteractionInformation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("infamous_legends")
@Mod.EventBusSubscriber(modid = InfamousLegends.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class InfamousLegends {

    public static final String MOD_ID = "infamous_legends";

    public InfamousLegends() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::addAttributes);
        bus.addListener(this::clientSetup);
        
        MobHordeEvents.setup();
        
        SoundEventInit.SOUND_EVENTS.register(bus);
        ActivityInit.ACTIVITIES.register(bus);
        EntityTypeInit.ENTITY_TYPES.register(bus);
        BlockInit.BLOCKS.register(bus);
        BlockEntityTypeInit.BLOCK_ENTITY_TYPES.register(bus);
        ItemInit.ITEMS.register(bus);
        ParticleTypeInit.PARTICLE_TYPES.register(bus);
        MemoryModuleTypeInit.MEMORY_MODULE_TYPES.register(bus);
        SensorTypeInit.SENSOR_TYPES.register(bus);
        FluidInit.FLUIDS.register(bus);
        FluidTypeInit.FLUID_TYPES.register(bus);

        bus.addListener(this::commonSetup);

        LegendsSpawnerDataInit.LEGENDS_SPAWNER_DATA_REGISTRY.subscribeAsSyncable(Messages.INSTANCE, LegendsSpawnerDataInit::toPacket);
        PlankGolemTypeInit.PLANK_GOLEM_TYPE_REGISTRY.subscribeAsSyncable(Messages.INSTANCE, PlankGolemTypeInit::toPacket);
        FirstOfOakWood1TypeInit.FIRST_OF_OAK_WOOD_1_TYPE_REGISTRY.subscribeAsSyncable(Messages.INSTANCE, FirstOfOakWood1TypeInit::toPacket);
        FirstOfOakWood2TypeInit.FIRST_OF_OAK_WOOD_2_TYPE_REGISTRY.subscribeAsSyncable(Messages.INSTANCE, FirstOfOakWood2TypeInit::toPacket);

        MinecraftForge.EVENT_BUS.register(this);
    }
    
	private void addAttributes(final EntityAttributeCreationEvent event) {
	        event.put(EntityTypeInit.MACE_RUNT.get(), MaceRunt.createAttributes().build());
	        event.put(EntityTypeInit.BLAZE_RUNT.get(), BlazeRunt.createAttributes().build());
	        event.put(EntityTypeInit.SPORE_MEDIC.get(), SporeMedic.createAttributes().build());
	        event.put(EntityTypeInit.PIGLIN_BRUISER.get(), PiglinBruiser.createAttributes().build());
	        event.put(EntityTypeInit.WAR_BOAR.get(), WarBoar.createAttributes().build());
	        event.put(EntityTypeInit.PIGLIN_BUILDER.get(), PiglinBuilder.createAttributes().build());
	        event.put(EntityTypeInit.SEEKER.get(), Seeker.createAttributes().build());
	        event.put(EntityTypeInit.SPOREBACK.get(), Sporeback.createAttributes().build());
	        event.put(EntityTypeInit.LAVA_LAUNCHER.get(), LavaLauncher.createAttributes().build());
	        event.put(EntityTypeInit.PIGMADILLO.get(), Pigmadillo.createAttributes().build());
	        event.put(EntityTypeInit.PORTAL_GUARD.get(), PortalGuard.createAttributes().build());
	        event.put(EntityTypeInit.COBBLESTONE_GOLEM.get(), CobblestoneGolem.createAttributes().build());
	        event.put(EntityTypeInit.PLANK_GOLEM.get(), PlankGolem.createAttributes().build());
	        event.put(EntityTypeInit.GRINDSTONE_GOLEM.get(), GrindstoneGolem.createAttributes().build());
	        event.put(EntityTypeInit.MOSSY_GOLEM.get(), MossyGolem.createAttributes().build());
	        event.put(EntityTypeInit.FIRST_OF_STONE.get(), FirstOfStone.createAttributes().build());
	        event.put(EntityTypeInit.FIRST_OF_OAK.get(), FirstOfOak.createAttributes().build());
	        event.put(EntityTypeInit.BIG_BEAK.get(), BigBeak.createAttributes().build());
	        event.put(EntityTypeInit.REGAL_TIGER.get(), RegalTiger.createAttributes().build());
	}
	
    public void commonSetup(final FMLCommonSetupEvent event) {    
    	Messages.register();
        event.enqueueWork(Messages::register);
        
        FluidInteractionRegistry.addInteraction(FluidTypeInit.TAR_FLUID_TYPE.get(), new InteractionInformation(
                ForgeMod.WATER_TYPE.get(),
                fluidState -> Blocks.MUD.defaultBlockState()
        ));
        
        FluidInteractionRegistry.addInteraction(FluidTypeInit.TAR_FLUID_TYPE.get(), new InteractionInformation(
                ForgeMod.LAVA_TYPE.get(),
                fluidState -> Blocks.MAGMA_BLOCK.defaultBlockState()
        ));
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        BlockInit.initRenderTypes();
    }
}