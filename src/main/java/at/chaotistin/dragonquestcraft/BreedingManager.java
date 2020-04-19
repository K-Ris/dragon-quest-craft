package at.chaotistin.dragonquestcraft;

import at.chaotistin.dragonquestcraft.entities.BullBirdEntity;
import at.chaotistin.dragonquestcraft.entities.PlatypunkEntity;
import at.chaotistin.dragonquestcraft.registries.MobEntities;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;

import java.util.UUID;

public class BreedingManager {

    public static AnimalEntity spawnMonsterChild(CustomTameableEntity entity, CustomTameableEntity otherEntity){

        Main.LOGGER.warn("Breeding Entity Name: " + entity.getName());
        Main.LOGGER.warn("Breeding Other Name: " + otherEntity.getName());
//        CustomTameableEntity.EntitySpecies babySpecies;
        CustomTameableEntity babyEntity;

        if(entity.entitySex == CustomTameableEntity.EntitySexes.FEMALE) {
            babyEntity = getChildMonster(entity, otherEntity);
        }else{
            babyEntity = getChildMonster(otherEntity, entity);
        }

        UUID uuid = entity.getOwnerId();
        if (uuid != null) {
            babyEntity.setOwnerId(uuid);
            babyEntity.setTamed(true);
        }

        return babyEntity;
    }

    private static CustomTameableEntity getChildMonster(CustomTameableEntity mommy, CustomTameableEntity daddy){

        CustomTameableEntity child = MobEntities.BLUESLIME.create(mommy.world);

        Main.LOGGER.warn("Daddy Name: " + daddy.getName());
        Main.LOGGER.warn("Mommy Name: " + mommy.getName());
        Main.LOGGER.warn("Mommy Species: " + mommy.entitySpecies);
        Main.LOGGER.warn("Daddy Species: " + daddy.entitySpecies);

        //Child is Beast -----------------------------------------------------------------------------------------------
        if(mommy.entitySpecies == CustomTameableEntity.EntitySpecies.BEAST){
            if(daddy.entitySpecies == CustomTameableEntity.EntitySpecies.BEAST){
                //Child is same as mommy
                if(mommy.getName().equals(MobEntities.PLATYPUNK.getName())){
                    child = MobEntities.PLATYPUNK.create(mommy.world);
                }
            }
            else if(daddy.entitySpecies == CustomTameableEntity.EntitySpecies.BIRD){
                //Child is Catfly
                child = MobEntities.CATFLY.create(mommy.world);

            }
            else if(daddy.entitySpecies == CustomTameableEntity.EntitySpecies.SLIME){
                //Child is Tonguella
            }
        }
        //Child is Bird ------------------------------------------------------------------------------------------------
        else if(mommy.entitySpecies == CustomTameableEntity.EntitySpecies.BIRD){
            if(daddy.entitySpecies == CustomTameableEntity.EntitySpecies.BIRD){
                //Child is same as mommy
                if(mommy.getName().equals(MobEntities.DRACKY.getName())){
                    child = MobEntities.DRACKY.create(mommy.world);
                }
                else if(mommy.getName().equals(MobEntities.BULLBIRD.getName())){
                    child = MobEntities.BULLBIRD.create(mommy.world);
                }
            }
            else if(daddy.entitySpecies == CustomTameableEntity.EntitySpecies.BEAST){
                child = MobEntities.BULLBIRD.create(mommy.world);

            }
            else if(daddy.entitySpecies == CustomTameableEntity.EntitySpecies.SLIME){
                //Child is Tonguella
            }
        }
        //Child is Slime -----------------------------------------------------------------------------------------------
        else if(mommy.entitySpecies == CustomTameableEntity.EntitySpecies.SLIME){

        }
        else{
            child = mommy;
        }

        return child;
    }
}
