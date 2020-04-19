package at.chaotistin.dragonquestcraft;

import at.chaotistin.dragonquestcraft.entities.BullBirdEntity;
import at.chaotistin.dragonquestcraft.entities.PlatypunkEntity;
import at.chaotistin.dragonquestcraft.registries.MobEntities;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import javax.swing.*;
import java.util.Random;
import java.util.UUID;

public class CustomTameableEntity extends TameableEntity implements DragonQuestMonster{

    public CustomTameableEntity breedingPartner;
    public EntitySexes entitySex = EntitySexes.FEMALE;
    public EntitySpecies entitySpecies = EntitySpecies.BEAST;


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
        this.world.setEntityState(this.breedingPartner, (byte)3);
        this.world.setEntityState(this, (byte)3);

        return BreedingManager.spawnMonsterChild(this, breedingPartner);
    }

    public boolean isBreedingItem(ItemStack stack) {
        Item item = stack.getItem();
        return stack.getItem() == Items.WHEAT;
    }

    public void afterBreeding(){
        this.world.setEntityState(this, (byte)3);

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

    public static enum EntitySpecies{
        BEAST,
        SLIME,
        BIRD
    }
}
