package com.infamous.infamous_legends.soundinstances;

import com.infamous.infamous_legends.entities.PiglinBuilder;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PiglinBuilderSoundInstance extends AbstractTickableSoundInstance {
   protected final PiglinBuilder piglinBuilder;
   
   public PiglinBuilderSoundInstance(PiglinBuilder p_119621_, SoundEvent p_119622_, SoundSource p_119623_) {
      super(p_119622_, p_119623_, SoundInstance.createUnseededRandom());
      this.piglinBuilder = p_119621_;
      this.x = (double)((float)p_119621_.getX());
      this.y = (double)((float)p_119621_.getY());
      this.z = (double)((float)p_119621_.getZ());
      this.volume = 0.5F;
      this.looping = true;
      this.delay = 0;
   }

   public void tick() {
      if (!this.piglinBuilder.isRemoved()) {
         this.x = (double)((float)this.piglinBuilder.getX());
         this.y = (double)((float)this.piglinBuilder.getY());
         this.z = (double)((float)this.piglinBuilder.getZ());
      } else {
         this.stop();
      }
   }

   public boolean canStartSilent() {
      return true;
   }

   public boolean canPlaySound() {
      return !this.piglinBuilder.isSilent();
   }
}