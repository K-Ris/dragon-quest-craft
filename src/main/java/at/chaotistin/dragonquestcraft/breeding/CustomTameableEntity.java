package at.chaotistin.dragonquestcraft.breeding;

import at.chaotistin.dragonquestcraft.CustomDamageSource;
import at.chaotistin.dragonquestcraft.DragonQuestMonster;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.Random;

public class CustomTameableEntity extends TameableEntity implements DragonQuestMonster {

    public CustomTameableEntity breedingPartner;
    public EntitySexes entitySex = EntitySexes.FEMALE;
    public MonsterManager.EntitySpecies entitySpecies = MonsterManager.EntitySpecies.SLIME;
    public MonsterManager.EntityName entityName = MonsterManager.EntityName.BLUESLIME;


    protected CustomTameableEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public boolean canMateWith(AnimalEntity otherAnimal) {
        if (otherAnimal == this) {
            return false;
        } else if (!this.isTamed()) {
            return false;
        }else if(otherAnimal instanceof DragonQuestMonster){
            breedingPartner = (CustomTameableEntity) otherAnimal;
            if(this.entitySex != breedingPartner.entitySex)
                return this.isInLove() && otherAnimal.isInLove();
            else
                return false;
        }else{
            return false;
        }
    }

    public AnimalEntity createChild(AgeableEntity ageable) {
//        this.world.setEntityState(this.breedingPartner, (byte)3);
//        this.world.setEntityState(this, (byte)3);

        return BreedingManager.spawnMonsterChild(this, breedingPartner);
    }

    public boolean isBreedingItem(ItemStack stack) {
        Item item = stack.getItem();
        return stack.getItem() == Items.WHEAT;
    }

    public void afterBreeding(){
        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }
    }

    public static enum EntitySexes{
        MALE,
        FEMALE;
        //NEUTRAL;

        public static EntitySexes getRandomSex() {
            Random random = new Random();
            EntitySexes sex = values()[random.nextInt(values().length)];
//            if (sex == EntitySexes.NEUTRAL)
//                sex = values()[random.nextInt(values().length)];
            return sex;
        }
    }

}
