package at.chaotistin.dragonquestcraft.registries;

import at.chaotistin.dragonquestcraft.Main;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundsHandler {
    public static SoundEvent ENTITY_PLATYPUNK_AMBIENT, ENTITY_PLATYPUNK_HURT, ENTITY_PLATYPUNK_DEATH;

    public static void registerSounds(){
        ENTITY_PLATYPUNK_AMBIENT = registerSound("entity.platypunk.ambient");
        ENTITY_PLATYPUNK_HURT = registerSound("entity.platypunk.hurt");
        ENTITY_PLATYPUNK_DEATH = registerSound("entity.platypunk.death");
    }

    private static SoundEvent registerSound(String name){
        ResourceLocation location = new ResourceLocation(Main.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
