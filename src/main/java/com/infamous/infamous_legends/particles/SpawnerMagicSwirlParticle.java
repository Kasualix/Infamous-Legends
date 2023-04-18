package com.infamous.infamous_legends.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class SpawnerMagicSwirlParticle extends TextureSheetParticle {
	
	private float angle;
	   
    protected SpawnerMagicSwirlParticle(ClientLevel level, double xCoord, double yCoord, double zCoord,
    		SpriteSet spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);

        this.quadSize *= 2.5F;
        this.lifetime = 40 + this.random.nextInt(120);
        this.hasPhysics = false;
        
        this.xd = 0;
        this.yd = 0.025;
        this.zd = 0;
        
        this.pickSprite(spriteSet);
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
           this.remove();
        } else {
           this.xd += (double)(1.2F * Mth.cos(this.angle));
           this.zd += (double)(1.2F * Mth.sin(this.angle));
           this.xd *= 0.07D;
           this.zd *= 0.07D;
           this.move(this.xd, this.yd, this.zd);

           this.angle += 0.08F;
        }
        this.fadeOut();
     }

    private void fadeOut() {
        this.alpha = (-(1/(float)lifetime) * age + 1);
    }
    
    public int getLightColor(float pPartialTick) {
        int i = super.getLightColor(pPartialTick);
        int j = 240;
        int k = i >> 16 & 255;
        return 240 | k << 16;
     }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
                                       double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new SpawnerMagicSwirlParticle(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }
}
