package at.chaotistin.dragonquestcraft.entities;

import at.chaotistin.dragonquestcraft.BreedingManager;
import at.chaotistin.dragonquestcraft.CustomTameableEntity;
import at.chaotistin.dragonquestcraft.DragonQuestMonster;
import at.chaotistin.dragonquestcraft.goals.CustomBreedGoal;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

import java.util.Random;

public class CatflyEntity extends CustomTameableEntity implements IFlyingAnimal, DragonQuestMonster {

    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.createKey(CatflyEntity.class, DataSerializers.FLOAT);

    public float flap;
    public float flapSpeed;
    public float oFlapSpeed;
    public float oFlap;
    public float flapping = 1.0F;
    private boolean partyParrot;
    private BlockPos jukeboxPosition;

    public CatflyEntity(EntityType<? extends CatflyEntity> type, World worldIn) {
        super(type, worldIn);
        this.setTamed(false);
        this.entitySex = EntitySexes.getRandomSex();
        this.moveController = new FlyingMovementController(this);
        this.entitySpecies = EntitySpecies.BIRD;
    }

    @Override
    protected void registerGoals(){
        this.sitGoal = new SitGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.5D));
        this.goalSelector.addGoal(1, this.sitGoal);
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.5d, true));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 5.0F, 1.0F));
        this.goalSelector.addGoal(5, new CustomBreedGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(7, new FollowMobGoal(this, 1.0D, 3.0F, 7.0F));
        this.goalSelector.addGoal(7, new FollowMobGoal(this, 1.0D, 3.0F, 7.0F));
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
        this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.3F);
        this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue((double)0.4F);
        if (this.isTamed()) {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        } else {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        }

        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
    }

    protected PathNavigator createNavigator(World worldIn) {
        FlyingPathNavigator flyingpathnavigator = new FlyingPathNavigator(this, worldIn);
        flyingpathnavigator.setCanOpenDoors(false);
        flyingpathnavigator.setCanSwim(true);
        flyingpathnavigator.setCanEnterDoors(true);
        return flyingpathnavigator;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return sizeIn.height * 0.6F;
    }

    public static boolean func_223317_c(EntityType<ParrotEntity> p_223317_0_, IWorld p_223317_1_, SpawnReason p_223317_2_, BlockPos p_223317_3_, Random p_223317_4_) {
        Block block = p_223317_1_.getBlockState(p_223317_3_.down()).getBlock();
        return (block.isIn(BlockTags.LEAVES) || block == Blocks.GRASS_BLOCK || block instanceof LogBlock || block == Blocks.AIR) && p_223317_1_.getLightSubtracted(p_223317_3_, 0) > 8;
    }

    public void fall(float distance, float damageMultiplier) {
    }

    protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
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

    public AnimalEntity createChild(AgeableEntity ageable) {
        this.world.setEntityState(super.breedingPartner, (byte)3);
        this.world.setEntityState(this, (byte)3);

        return BreedingManager.spawnMonsterChild(this, breedingPartner);
    }

    public boolean isBreedingItem(ItemStack stack) {
        return super.isBreedingItem(stack);
    }

    public void afterBreeding(){
        this.world.setEntityState(this, (byte)3);

    }

    public boolean isFlying() {
        return !this.onGround;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CAT_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_CAT_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CAT_DEATH;
    }
}