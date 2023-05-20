package com.infamous.infamous_legends.soundinstances;

import com.infamous.infamous_legends.entities.BigBeak;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BigBeakSoundInstance extends AbstractTickableSoundInstance {
   protected final BigBeak bigBeak;
   
   public BigBeakSoundInstance(BigBeak p_119621_, SoundEvent p_119622_, SoundSource p_119623_) {
      super(p_119622_, p_119623_, SoundInstance.createUnseededRandom());
      this.bigBeak = p_119621_;
      this.x = (double)((float)p_119621_.getX());
      this.y = (double)((float)p_119621_.getY());
      this.z = (double)((float)p_119621_.getZ());
      this.looping = true;
      this.delay = 0;
   }

   public void tick() {
      if (!this.bigBeak.isRemoved()) {
          if (this.bigBeak.isGliding()) {
        	 this.volume = 0.5F;
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
      return !this.bigBeak.isSilent();
   }
}