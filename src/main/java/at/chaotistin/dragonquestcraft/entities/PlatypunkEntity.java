package at.chaotistin.dragonquestcraft.entities;

import at.chaotistin.dragonquestcraft.CustomDamageSource;
import at.chaotistin.dragonquestcraft.breeding.BreedingManager;
import at.chaotistin.dragonquestcraft.breeding.CustomTameableEntity;
import at.chaotistin.dragonquestcraft.DragonQuestMonster;
import at.chaotistin.dragonquestcraft.breeding.MonsterManager;
import at.chaotistin.dragonquestcraft.goals.CustomBreedGoal;
import at.chaotistin.dragonquestcraft.registries.ModItems;
import at.chaotistin.dragonquestcraft.registries.SoundsHandler;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.ForgeEventFactory;

public class PlatypunkEntity extends CustomTameableEntity{

    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.createKey(PlatypunkEntity.class, DataSerializers.FLOAT);


    public PlatypunkEntity(EntityType<? extends PlatypunkEntity> type, World worldIn) {
        super(type, worldIn);
        this.setTamed(false);
        this.recalculateSize();
        //this.entitySex = EntitySexes.getRandomSex();
        this.entitySpecies = MonsterManager.EntitySpecies.BEAST;
        this.entityName = MonsterManager.EntityName.PLATYPUNK;
    }

    @Override
    protected void registerGoals(){
        this.sitGoal = new SitGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, this.sitGoal);
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.1d, true));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.addGoal(5, new CustomBreedGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
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
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
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
//                else if(item == ModItems.LOVECRYSTAL){
//                    if (!this.world.isRemote) {
//                        player.sendMessage(new StringTextComponent("Your " + this.entityName.toString() + " is " + this.entitySex.toString()));
//                    }
//                }
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
                if (this.rand.nextInt(3) == 0 && !ForgeEventFactory.onAnimalTame(this, player)) {
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
        return SoundsHandler.ENTITY_PLATYPUNK_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundsHandler.ENTITY_PLATYPUNK_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundsHandler.ENTITY_PLATYPUNK_DEATH;
    }

}
