package com.infamous.infamous_legends.soundinstances;

import com.infamous.infamous_legends.entities.SporeMedic;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SporeMedicSoundInstance extends AbstractTickableSoundInstance {
   protected final SporeMedic sporeMedic;
   
   public SporeMedicSoundInstance(SporeMedic p_119621_, SoundEvent p_119622_, SoundSource p_119623_) {
      super(p_119622_, p_119623_, SoundInstance.createUnseededRandom());
      this.sporeMedic = p_119621_;
      this.x = (double)((float)p_119621_.getX());
      this.y = (double)((float)p_119621_.getY());
      this.z = (double)((float)p_119621_.getZ());
      this.looping = true;
      this.delay = 0;
   }

   public void tick() {
      if (!this.sporeMedic.isRemoved()) {
         this.x = (double)((float)this.sporeMedic.getX());
         this.y = (double)((float)this.sporeMedic.getY());
         this.z = (double)((float)this.sporeMedic.getZ());
         if (!this.sporeMedic.shooting) {
        	 if (this.pitch > 0) {
        	     this.pitch = this.pitch -0.05F;
        	 }
        	 
        	 if (this.volume > 0) {
        	     this.volume = this.volume -0.075F;
        	 }
         } else {
        	 if (this.pitch < 1) {
        		 this.pitch = this.pitch + 0.05F;
        	 } else {
        		 this.pitch = 1;
        	 }
        	 if (this.volume < 1) {
        		 this.volume = this.pitch + 0.075F;
        	 } else {
        		 this.volume = 1;
        	 }
         }
      } else {
         this.stop();
      }
   }

   public boolean canStartSilent() {
      return true;
   }

   public boolean canPlaySound() {
      return !this.sporeMedic.isSilent();
   }
}