package at.chaotistin.dragonquestcraft.registries;

import at.chaotistin.dragonquestcraft.Main;
import at.chaotistin.dragonquestcraft.entities.DrackyEntity;
import at.chaotistin.dragonquestcraft.entities.PlatypunkEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
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


}
