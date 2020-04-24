package at.chaotistin.dragonquestcraft.breeding;

import at.chaotistin.dragonquestcraft.Main;

import java.util.*;

public class MonsterManager {

    List<DQMonsterCrossBreed> dqm_breedingList;
    Map<EntityName, EntitySpecies> dqm_monsterList;


    public MonsterManager(){
        dqm_breedingList = new ArrayList<DQMonsterCrossBreed>();
        dqm_monsterList = new HashMap<EntityName, EntitySpecies>();
    }

    public void init(){
        initBreedingList();
    }

    private void initBreedingList(){
        dqm_monsterList.put(EntityName.BLUESLIME, EntitySpecies.SLIME);
        dqm_monsterList.put(EntityName.SPOTSLIME, EntitySpecies.SLIME);
        dqm_monsterList.put(EntityName.WINGSLIME, EntitySpecies.SLIME);
        dqm_monsterList.put(EntityName.DRACKY, EntitySpecies.BIRD);
        dqm_monsterList.put(EntityName.PICKY, EntitySpecies.BIRD);
        dqm_monsterList.put(EntityName.BULLBIRD, EntitySpecies.BIRD);
        dqm_monsterList.put(EntityName.PLATYPUNK, EntitySpecies.BEAST);
        dqm_monsterList.put(EntityName.CATFLY, EntitySpecies.BEAST);
        dqm_monsterList.put(EntityName.TONGUELLA, EntitySpecies.BEAST);

        //Add breeding recipes (female, male, result)
        //child species is inherited from female
        dqm_breedingList.add(new DQMonsterCrossBreed(EntityName.DRACKY, EntityName.PLATYPUNK, EntityName.BULLBIRD));
        dqm_breedingList.add(new DQMonsterCrossBreed(EntityName.PLATYPUNK, EntityName.DRACKY, EntityName.CATFLY));


    }

    public EntityName getBreedingResult(EntityName mother, EntityName father){

        Main.LOGGER.warn("Breeding Entity Name: " + mother);
        Main.LOGGER.warn("Breeding Other Name: " + father);

        EntityName breedingResult = mother;

        if(mother == father) {
            return breedingResult;
        }else{
            EntitySpecies motherSpecies = dqm_monsterList.get(mother);
            EntitySpecies fatherSpecies = dqm_monsterList.get(father);

            Main.LOGGER.warn("mommy species breed: " + motherSpecies);
            Main.LOGGER.warn("daddy species breed: " + fatherSpecies);
            if(motherSpecies == fatherSpecies){
                return breedingResult;
            }
            else if(motherSpecies == EntitySpecies.BEAST && fatherSpecies == EntitySpecies.BIRD){
                breedingResult = EntityName.CATFLY;
            }else if(motherSpecies == EntitySpecies.BIRD && fatherSpecies == EntitySpecies.BEAST){
                breedingResult = EntityName.BULLBIRD;
            }else if(motherSpecies == EntitySpecies.SLIME && fatherSpecies == EntitySpecies.BEAST){
                breedingResult = EntityName.SPOTSLIME;
            }else if(motherSpecies == EntitySpecies.SLIME && fatherSpecies == EntitySpecies.BIRD){
                breedingResult = EntityName.WINGSLIME;
            }else if(motherSpecies == EntitySpecies.BIRD && fatherSpecies == EntitySpecies.SLIME){
                breedingResult = EntityName.PICKY;
            }else if(motherSpecies == EntitySpecies.BEAST && fatherSpecies == EntitySpecies.SLIME){
                breedingResult = EntityName.TONGUELLA;
            }
            else{
                return breedingResult;
            }

            return breedingResult;
        }



    }

    public static enum EntitySpecies{
        BEAST,
        SLIME,
        BIRD
    }

    public static enum EntityName{
        BLUESLIME,
        SPOTSLIME,
        WINGSLIME,
        DRACKY,
        PICKY,
        BULLBIRD,
        PLATYPUNK,
        CATFLY,
        TONGUELLA
    }

    private static class DQMonsterCrossBreed{

        private EntityName dqm_father;
        private EntityName dqm_mother;
        private EntityName dqm_result;

        DQMonsterCrossBreed(EntityName mother, EntityName father, EntityName result){
            dqm_father = father;
            dqm_mother = mother;
            dqm_result = result;
        }

        public EntityName getFather(){
            return dqm_father;
        }

        public EntityName getMother(){
            return dqm_mother;
        }

        public EntityName getResult(){
            return dqm_result;
        }

    }

}
