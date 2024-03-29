package at.chaotistin.dragonquestcraft.registries;

import at.chaotistin.dragonquestcraft.Main;
import at.chaotistin.dragonquestcraft.entities.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.registries.ObjectHolder;

@SuppressWarnings("unchecked")
public class MobEntities {
    @ObjectHolder("dragonquestcraft:platypunk")
    public static EntityType<PlatypunkEntity> PLATYPUNK = (EntityType<PlatypunkEntity>) EntityType.Builder.create(PlatypunkEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("platypunk")
            .setRegistryName(Main.MODID, "platypunk");

    @ObjectHolder("dragonquestcraft:dracky")
    public static EntityType<DrackyEntity> DRACKY = (EntityType<DrackyEntity>) EntityType.Builder.create(DrackyEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("dracky")
            .setRegistryName(Main.MODID, "dracky");
    @ObjectHolder("dragonquestcraft:blueslime")
    public static EntityType<BlueSlimeEntity> BLUESLIME = (EntityType<BlueSlimeEntity>) EntityType.Builder.create(BlueSlimeEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("blueslime")
            .setRegistryName(Main.MODID, "blueslime");
    @ObjectHolder("dragonquestcraft:bullbird")
    public static EntityType<BullBirdEntity> BULLBIRD = (EntityType<BullBirdEntity>) EntityType.Builder.create(BullBirdEntity::new, EntityClassification.CREATURE)
            .size(3, 2)
            .setShouldReceiveVelocityUpdates(false)
            .build("bullbird")
            .setRegistryName(Main.MODID, "bullbird");
    @ObjectHolder("dragonquestcraft:catfly")
    public static EntityType<CatflyEntity> CATFLY = (EntityType<CatflyEntity>) EntityType.Builder.create(CatflyEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("catfly")
            .setRegistryName(Main.MODID, "catfly");
    @ObjectHolder("dragonquestcraft:spotslime")
    public static EntityType<SpotSlimeEntity> SPOTSLIME = (EntityType<SpotSlimeEntity>) EntityType.Builder.create(SpotSlimeEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("spotslime")
            .setRegistryName(Main.MODID, "spotslime");
    @ObjectHolder("dragonquestcraft:wingslime")
    public static EntityType<WingSlimeEntity> WINGSLIME = (EntityType<WingSlimeEntity>) EntityType.Builder.create(WingSlimeEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("wingslime")
            .setRegistryName(Main.MODID, "wingslime");
    @ObjectHolder("dragonquestcraft:picky")
    public static EntityType<PickyEntity> PICKY = (EntityType<PickyEntity>) EntityType.Builder.create(PickyEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("picky")
            .setRegistryName(Main.MODID, "picky");
    @ObjectHolder("dragonquestcraft:tonguella")
    public static EntityType<TonguellaEntity> TONGUELLA = (EntityType<TonguellaEntity>) EntityType.Builder.create(TonguellaEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("tonguella")
            .setRegistryName(Main.MODID, "tonguella");


    public static void registerEntityWorldSpawns(){
        registerEntityWorldSpawn(PLATYPUNK, Biomes.RIVER, Biomes.MOUNTAINS, Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.TALL_BIRCH_FOREST );
        registerEntityWorldSpawn(DRACKY, Biomes.FOREST, Biomes.WOODED_HILLS, Biomes.MOUNTAINS, Biomes.MOUNTAIN_EDGE, Biomes.DARK_FOREST, Biomes.DARK_FOREST_HILLS);
        registerEntityWorldSpawn(BLUESLIME, Biomes.PLAINS, Biomes.SWAMP, Biomes.SAVANNA_PLATEAU, Biomes.BADLANDS_PLATEAU, Biomes.SUNFLOWER_PLAINS, Biomes.WOODED_BADLANDS_PLATEAU);

        EntitySpawnPlacementRegistry.register(DRACKY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DrackyEntity::func_223325_c);

    }

    private static void registerEntityWorldSpawn(EntityType<?> entity, Biome... biomes){
        for(Biome biome : biomes){
            if(biome != null){
                biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, 10, 1,3));
            }
        }
    }


}
