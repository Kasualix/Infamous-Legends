package com.infamous.infamous_legends.blocks;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.blocks.entities.PreservedMobBlockEntity;
import com.infamous.infamous_legends.init.BlockEntityTypeInit;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class PreservedMobBlock extends BaseEntityBlock {

	public String entityType;
	public CompoundTag tag;
	public BlockPos renderTranslation;
	public BlockPos renderRotation;
	public BlockPos renderScale;
	public FreeMethod freeMethod;
	public String itemType;
	
	public PreservedMobBlock(String entityType, Supplier<CompoundTag> tag, BlockPos renderTranslation, BlockPos renderRotation, BlockPos renderScale, FreeMethod freeMethod, String itemType, Properties pProperties) {
		super(pProperties);
		this.renderTranslation = renderTranslation;
		this.renderRotation = renderRotation;
		this.renderScale = renderScale;
		this.entityType = entityType;
		this.tag = tag.get();
		this.freeMethod = freeMethod;
		this.itemType = itemType;
	}

	   public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		   PreservedMobBlockEntity blockEntity = BlockEntityTypeInit.PRESERVED_MOB.get().create(pPos, pState);
		   blockEntity.renderTranslation = renderTranslation;
		   blockEntity.renderRotation = renderRotation;
		   blockEntity.renderScale = renderScale;
		   blockEntity.setEntityType(ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(entityType)));
		   if (itemType != null && blockEntity.getEntityType() == EntityType.ITEM) {
			   this.tag.put("Item", new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemType))).save(new CompoundTag()));
		   }
		   blockEntity.tag = tag;
		   blockEntity.freeMethod = freeMethod;
	       return blockEntity;
	    }
	   
	   @Nullable
		public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153094_, BlockState p_153095_,
				BlockEntityType<T> p_153096_) {
			return createTickerHelper(p_153096_, BlockEntityTypeInit.PRESERVED_MOB.get(),
					PreservedMobBlockEntity::tick);
		}

	   public RenderShape getRenderShape(BlockState pState) {
	      return RenderShape.MODEL;
	   }
	   
	   public enum FreeMethod {
		   WASH("wash"),
		   MELT("melt");
		   
		   public String name;
		   
		   FreeMethod(String name) {
			   this.name = name;
		   }
		   
		   public static FreeMethod byName(String name) {
		         for(FreeMethod freeMethod : values()) {
		            if (name == freeMethod.name) {
		               return freeMethod;
		            }
		         }

		         return WASH;
		      }
		}
}
