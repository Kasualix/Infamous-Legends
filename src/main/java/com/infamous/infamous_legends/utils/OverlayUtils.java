package com.infamous.infamous_legends.utils;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;

import net.minecraft.Util;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.overlay.ForgeGui;

public class OverlayUtils {

	protected static int lastHealth;
	protected static int displayHealth;
	protected static long lastHealthTime;
	protected static long healthBlinkTime;
	   
	public static void renderScreenOverlay(ResourceLocation p_168709_, float p_168710_, int screenWidth, int screenHeight) {
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, p_168710_);
        RenderSystem.setShaderTexture(0, p_168709_);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(0.0D, (double)screenHeight, -90.0D).uv(0.0F, 1.0F).endVertex();
        bufferbuilder.vertex((double)screenWidth, (double)screenHeight, -90.0D).uv(1.0F, 1.0F).endVertex();
        bufferbuilder.vertex((double)screenWidth, 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
        bufferbuilder.vertex(0, 0, -90.0D).uv(0.0F, 0.0F).endVertex();
        tesselator.end();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
     }
	
	public static void renderCustomHearts(ForgeGui gui, RandomSource random, int width, int height, PoseStack pStack, ResourceLocation heartTexture)
    {
		gui.getMinecraft().getProfiler().push("health");
        RenderSystem.enableBlend();

        Player player = (Player) gui.getMinecraft().getCameraEntity();
        int health = Mth.ceil(player.getHealth());
        boolean highlight = healthBlinkTime > (long) gui.getGuiTicks() && (healthBlinkTime - (long) gui.getGuiTicks()) / 3L % 2L == 1L;

        if (health < lastHealth && player.invulnerableTime > 0)
        {
        	lastHealthTime = Util.getMillis();
        	healthBlinkTime = (long) (gui.getGuiTicks() + 20);
        }
        else if (health > lastHealth && player.invulnerableTime > 0)
        {
        	lastHealthTime = Util.getMillis();
        	healthBlinkTime = (long) (gui.getGuiTicks() + 10);
        }

        if (Util.getMillis() - lastHealthTime > 1000L)
        {
        	lastHealth = health;
        	displayHealth = health;
        	lastHealthTime = Util.getMillis();
        }

        lastHealth = health;
        int healthLast = displayHealth;

        AttributeInstance attrMaxHealth = player.getAttribute(Attributes.MAX_HEALTH);
        float healthMax = Math.max((float) attrMaxHealth.getValue(), Math.max(healthLast, health));
        int absorb = Mth.ceil(player.getAbsorptionAmount());
        
        int healthRows = Mth.ceil((healthMax + absorb) / 2.0F / 10.0F);
        int rowHeight = Math.max(10 - (healthRows - 2), 3);

        random.setSeed((long) (gui.getGuiTicks() * 312871));

        int left = width / 2 - 91;
        int top = height - gui.leftHeight;

        int regen = -1;
        if (player.hasEffect(MobEffects.REGENERATION))
        {
            regen = gui.getGuiTicks() % Mth.ceil(healthMax + 5.0F);
        }

        renderHearts(gui, random, pStack, player, left, top, rowHeight, regen, healthMax, health, healthLast, absorb, highlight, heartTexture);

        RenderSystem.disableBlend();
        gui.getMinecraft().getProfiler().pop();
    }
	
	protected static void renderHearts(ForgeGui gui, RandomSource random, PoseStack pStack, Player player, int left,
			int top, int rowHeight, int regen, float healthMax, int health, int healthLast, int absorb, boolean highlight, ResourceLocation heartTexture) {
	      int i = player.level.getLevelData().isHardcore() ? 9 : 0;
	      int j = Mth.ceil((double)healthMax / 2.0D);

	      for(int i1 = j - 1; i1 >= 0; --i1) {
	         int j1 = i1 / 10;
	         int k1 = i1 % 10;
	         int l1 = left + k1 * 8;
	         int i2 = top - j1 * rowHeight;
	         if (health + absorb <= 4) {
	             i2 += random.nextInt(2);
	          }
	         
	         if (i1 < j && i1 == regen) {
	            i2 -= 2;
	         }
	         
	         int j2 = i1 * 2;

	         int healthRows = Mth.ceil((healthMax + absorb) / 2.0F / 10.0F);
	         int heightCorrection;	       
	         
	         if (healthRows > 9) {
	        	 heightCorrection = 37 + (healthRows - 10) * 3;
	         } else {
	        	 heightCorrection = 11 + (((healthRows - 1) * 9) - ((healthRows - 2) * (healthRows - 2)));
	         }
	 		RenderSystem.setShaderTexture(0, ForgeGui.GUI_ICONS_LOCATION);
	 		renderContainerHeart(gui, pStack, l1, i2 + heightCorrection, false, highlight);
	 		
			RenderSystem.setShaderTexture(0, heartTexture);
	         if (highlight && j2 < healthLast) {
	            boolean flag2 = j2 + 1 == healthLast;
	            renderHeart(gui, pStack, l1, i2 + heightCorrection, i, true, flag2);
	         }

	         if (j2 < health) {
	            boolean flag3 = j2 + 1 == health;
	            renderHeart(gui, pStack, l1, i2 + heightCorrection, i, false, flag3);
	         }
	      }

	   }

    public static int getHeartX(boolean blinking, boolean half) {
        int i;
		int j = blinking ? 1 : 0;
		int k = half ? 2 : 0;
		i = j + k;

        return i * 9;
     }
    
	   private static void renderHeart(ForgeGui gui, PoseStack pStack, int screenX, int screenY, int textureY, boolean half, boolean blinking) {
		   gui.blit(pStack, screenX, screenY, getHeartX(blinking, half), textureY, 9, 9, 36, 18);
	   }
	   
	   private static void renderContainerHeart(ForgeGui gui, PoseStack pStack, int screenX, int screenY, boolean half, boolean blinking) {
		   gui.blit(pStack, screenX, screenY, 52 + getHeartX(blinking, half), 9, 9, 9, 256, 256);
	   }
}
