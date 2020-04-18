package at.chaotistin.dragonquestcraft.entities;

import at.chaotistin.dragonquestcraft.goals.CustomBreedGoal;
import at.chaotistin.dragonquestcraft.registries.MobEntities;
import at.chaotistin.dragonquestcraft.registries.SoundsHandler;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.UUID;

public class PlatypunkEntity extends TameableEntity {

    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.createKey(PlatypunkEntity.class, DataSerializers.FLOAT);

    public PlatypunkEntity(EntityType<? extends PlatypunkEntity> type, World worldIn) {
        super(type, worldIn);
        this.setTamed(false);
        this.recalculateSize();
    }

    @Override
    protected void registerGoals(){
        this.sitGoal = new SitGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, this.sitGoal);
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.5d, true));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.5D, 5.0F, 2.0F));
        this.goalSelector.addGoal(5, new CustomBreedGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 0.6d));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
    }

    protected void updateAITasks() {
        this.dataManager.set(DATA_HEALTH_ID, this.getHealth());
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(DATA_HEALTH_ID, this.getHealth());
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.3F);
        if (this.isTamed()) {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        } else {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        }

        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
    }

    public boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        Item item = itemstack.getItem();
        if (this.isTamed()) {
            if (!itemstack.isEmpty()) {
                if (item.isFood()) {
                    if (item.getFood().isMeat() && this.dataManager.get(DATA_HEALTH_ID) < 20.0F) {
                        if (!player.abilities.isCreativeMode) {
                            itemstack.shrink(1);
                        }

                        this.heal((float)item.getFood().getHealing());
                        return true;
                    }
                }
            }

            if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(itemstack)) {
                this.sitGoal.setSitting(!this.isSitting());
                this.isJumping = false;
                this.navigator.clearPath();
                this.setAttackTarget((LivingEntity)null);
            }
        } else if (item == Items.PORKCHOP || item == Items.MUTTON || item == Items.CHICKEN || item == Items.BEEF) {
            if (!player.abilities.isCreativeMode) {
                itemstack.shrink(1);
            }

            if (!this.world.isRemote) {
                if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.setTamedBy(player);
                    this.navigator.clearPath();
                    this.setAttackTarget((LivingEntity)null);
                    this.sitGoal.setSitting(true);
                    this.setHealth(20.0F);
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte)7);
                } else {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte)6);
                    this.setAttackTarget(player);
                }
            }

            return true;
        }

        return super.processInteract(player, hand);
    }

    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        if (tamed) {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        } else {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        }

        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
    }

    public boolean canMateWith(AnimalEntity otherAnimal) {
        //System.out.println("other Animal " + otherAnimal.getDisplayName());
        LOGGER.warn("Platypunk Mate, other Animal " + otherAnimal);
        if (otherAnimal == this) {
            return false;
        } else if (!this.isTamed()) {
            return false;
        } else if ((otherAnimal instanceof DrackyEntity)) {
            DrackyEntity drackyentity = (DrackyEntity)otherAnimal;
            if(!drackyentity.isTamed()){
                return false;
            }
            else if (drackyentity.isSitting()){
                return false;
            }
            else{
                return this.isInLove() && drackyentity.isInLove();
            }
        }else{
            return false;
        }
    }

    public AnimalEntity createChild(AgeableEntity ageable) {
        BullBirdEntity bullbirdentity = MobEntities.BULLBIRD.create(this.world);
        UUID uuid = this.getOwnerId();
        if (uuid != null) {
            bullbirdentity.setOwnerId(uuid);
            bullbirdentity.setTamed(true);
        }

        return bullbirdentity;
    }

    public boolean isBreedingItem(ItemStack stack) {
        Item item = stack.getItem();
        //return item.isFood() && item.getFood().isMeat();
        return stack.getItem() == Items.WHEAT;
    }

    protected SoundEvent getAmbientSound() {
        return SoundsHandler.ENTITY_PLATYPUNK_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundsHandler.ENTITY_PLATYPUNK_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundsHandler.ENTITY_PLATYPUNK_DEATH;
    }

}
