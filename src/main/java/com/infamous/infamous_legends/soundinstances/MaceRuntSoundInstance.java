package com.infamous.infamous_legends.soundinstances;

import com.infamous.infamous_legends.entities.MaceRunt;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MaceRuntSoundInstance extends AbstractTickableSoundInstance {
   protected final MaceRunt maceRunt;
   
   public MaceRuntSoundInstance(MaceRunt p_119621_, SoundEvent p_119622_, SoundSource p_119623_) {
      super(p_119622_, p_119623_, SoundInstance.createUnseededRandom());
      this.maceRunt = p_119621_;
      this.x = (double)((float)p_119621_.getX());
      this.y = (double)((float)p_119621_.getY());
      this.z = (double)((float)p_119621_.getZ());
      this.looping = true;
      this.delay = 0;
   }

   public void tick() {
      if (!this.maceRunt.isRemoved()) {
         this.x = (double)((float)this.maceRunt.getX());
         this.y = (double)((float)this.maceRunt.getY());
         this.z = (double)((float)this.maceRunt.getZ());
 		 Vec3 velocity = this.maceRunt.getDeltaMovement();
 		 float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));
         if (speed <= 0.1 && speed > 0) {
        	 this.volume = 0.25F;
         } else {
        	 this.volume = 0;
         }
      } else {
         this.stop();
      }
   }

   public boolean canStartSilent() {
      return true;
   }

   public boolean canPlaySound() {
      return !this.maceRunt.isSilent();
   }
}