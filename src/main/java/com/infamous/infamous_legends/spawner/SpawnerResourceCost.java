package com.infamous.infamous_legends.spawner;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class SpawnerResourceCost {
    public static final Codec<SpawnerResourceCost> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(data -> data.item),
                    Codec.INT.optionalFieldOf("count", 1).forGetter(data -> data.count)
            ).apply(builder, SpawnerResourceCost::new));
    private Item item;
    private Integer count;

    public SpawnerResourceCost(Item item, Integer count) {
        this.item = item;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public Integer getCount() {
        return count;
    }
}
