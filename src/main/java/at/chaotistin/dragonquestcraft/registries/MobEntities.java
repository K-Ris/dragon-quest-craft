package at.chaotistin.dragonquestcraft.registries;

import at.chaotistin.dragonquestcraft.Main;
import at.chaotistin.dragonquestcraft.entities.BlueSlimeEntity;
import at.chaotistin.dragonquestcraft.entities.DrackyEntity;
import at.chaotistin.dragonquestcraft.entities.PlatypunkEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.registries.ObjectHolder;

public class MobEntities {
    @ObjectHolder("dragonquestcraft:platypunk")
    public static EntityType<?> PLATYPUNK = EntityType.Builder.create(PlatypunkEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("platypunk")
            .setRegistryName(Main.MODID, "platypunk");

    @ObjectHolder("dragonquestcraft:dracky")
    public static EntityType<?> DRACKY = EntityType.Builder.create(DrackyEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("dracky")
            .setRegistryName(Main.MODID, "dracky");
    @ObjectHolder("dragonquestcraft:blueslime")
    public static EntityType<?> BLUESLIME = EntityType.Builder.create(BlueSlimeEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("blueslime")
            .setRegistryName(Main.MODID, "blueslime");

    public static void registerEntityWorldSpawns(){
        registerEntityWorldSpawn(PLATYPUNK, Biomes.FOREST, Biomes.RIVER, Biomes.WOODED_HILLS );
        registerEntityWorldSpawn(DRACKY, Biomes.FOREST, Biomes.WOODED_HILLS, Biomes.MOUNTAINS);
        registerEntityWorldSpawn(BLUESLIME, Biomes.PLAINS, Biomes.WOODED_HILLS);
    }

    private static void registerEntityWorldSpawn(EntityType<?> entity, Biome... biomes){
        for(Biome biome : biomes){
            if(biome != null){
                biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, 10, 1,3));
            }
        }
    }


}
