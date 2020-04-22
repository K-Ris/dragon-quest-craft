package at.chaotistin.dragonquestcraft.entities;

import at.chaotistin.dragonquestcraft.breeding.BreedingManager;
import at.chaotistin.dragonquestcraft.breeding.CustomTameableEntity;
import at.chaotistin.dragonquestcraft.breeding.MonsterManager;
import at.chaotistin.dragonquestcraft.goals.CustomBreedGoal;
import at.chaotistin.dragonquestcraft.registries.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.AnimalEntity;
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
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class BlueSlimeEntity extends CustomTameableEntity implements IMob {
    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.createKey(BlueSlimeEntity.class, DataSerializers.FLOAT);

    public BlueSlimeEntity(EntityType<? extends BlueSlimeEntity> type, World worldIn) {
        super(type, worldIn);
        this.setTamed(false);
        this.recalculateSize();
        this.entitySex = EntitySexes.getRandomSex();
        this.entitySpecies = MonsterManager.EntitySpecies.SLIME;
        this.entityName = MonsterManager.EntityName.BLUESLIME;
    }

    @Override
    protected void registerGoals(){
        this.sitGoal = new SitGoal(this);
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, this.sitGoal);
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.6F));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.5d, false));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.addGoal(5, new CustomBreedGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.4d));
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
                else if(item == ModItems.LOVECRYSTAL){
                    if (!this.world.isRemote) {
                        player.sendMessage(new StringTextComponent("Your " + this.entityName.toString() + " is " + this.entitySex.toString()));
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
        return super.canMateWith(otherAnimal);
    }

    public AnimalEntity createChild(AgeableEntity ageable) {
        AnimalEntity cte = BreedingManager.spawnMonsterChild(this, breedingPartner);
        breedingPartner.afterBreeding();
        this.afterBreeding();
        return cte;
    }

    public boolean isBreedingItem(ItemStack stack) {
        return super.isBreedingItem(stack);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SLIME_JUMP;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SLIME_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SLIME_DEATH;
    }

}
