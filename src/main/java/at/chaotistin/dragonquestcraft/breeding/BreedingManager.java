package at.chaotistin.dragonquestcraft.breeding;

import at.chaotistin.dragonquestcraft.Main;
import at.chaotistin.dragonquestcraft.registries.MobEntities;
import net.minecraft.entity.passive.AnimalEntity;

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

        MonsterManager.EntityName breedingResult =  Main.mm.getBreedingResult(mommy.entityName, daddy.entityName);

        if(breedingResult == MonsterManager.EntityName.BLUESLIME){
            child = MobEntities.BLUESLIME.create(mommy.world);
        }
        else if(breedingResult == MonsterManager.EntityName.DRACKY){
            child = MobEntities.DRACKY.create(mommy.world);
        }
        else if(breedingResult == MonsterManager.EntityName.PLATYPUNK){
            child = MobEntities.PLATYPUNK.create(mommy.world);
        }
        else if(breedingResult == MonsterManager.EntityName.BULLBIRD){
            child = MobEntities.BULLBIRD.create(mommy.world);
        }

        //Breeding Rules
        //- Same & Same = Same

//        //Child is Beast -----------------------------------------------------------------------------------------------
//        if(mommy.entitySpecies == CustomTameableEntity.EntitySpecies.BEAST){
//            if(daddy.entitySpecies == CustomTameableEntity.EntitySpecies.BEAST){
//                //Child is same as mommy
//                if(mommy.getName().equals(MobEntities.PLATYPUNK.getName())){
//                    child = MobEntities.PLATYPUNK.create(mommy.world);
//                }
//            }
//            else if(daddy.entitySpecies == CustomTameableEntity.EntitySpecies.BIRD){
//                //Child is Catfly
//                child = MobEntities.CATFLY.create(mommy.world);
//
//            }
//            else if(daddy.entitySpecies == CustomTameableEntity.EntitySpecies.SLIME){
//                //Child is Tonguella
//            }
//        }
//        //Child is Bird ------------------------------------------------------------------------------------------------
//        else if(mommy.entitySpecies == CustomTameableEntity.EntitySpecies.BIRD){
//            if(daddy.entitySpecies == CustomTameableEntity.EntitySpecies.BIRD){
//                //Child is same as mommy
//                if(mommy.getName().equals(MobEntities.DRACKY.getName())){
//                    child = MobEntities.DRACKY.create(mommy.world);
//                }
//                else if(mommy.getName().equals(MobEntities.BULLBIRD.getName())){
//                    child = MobEntities.BULLBIRD.create(mommy.world);
//                }
//            }
//            else if(daddy.entitySpecies == CustomTameableEntity.EntitySpecies.BEAST){
//                child = MobEntities.BULLBIRD.create(mommy.world);
//
//            }
//            else if(daddy.entitySpecies == CustomTameableEntity.EntitySpecies.SLIME){
//                //Child is Tonguella
//            }
//        }
//        //Child is Slime -----------------------------------------------------------------------------------------------
//        else if(mommy.entitySpecies == CustomTameableEntity.EntitySpecies.SLIME){
//            if(daddy.entitySpecies == CustomTameableEntity.EntitySpecies.SLIME){
//                //Child is same as mommy
//                if(mommy.getName().equals(MobEntities.BLUESLIME.getName())){
//                    child = MobEntities.BLUESLIME.create(mommy.world);
//                }
//            }
//            else if(daddy.entitySpecies == CustomTameableEntity.EntitySpecies.BEAST){
//                child = MobEntities.BULLBIRD.create(mommy.world);
//
//            }
//            else if(daddy.entitySpecies == CustomTameableEntity.EntitySpecies.BIRD){
//                //Child is Tonguella
//            }
//        }
//        else{
//            child = mommy;
//        }

        return child;
    }
}
