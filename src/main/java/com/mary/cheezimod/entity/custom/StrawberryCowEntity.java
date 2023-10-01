package com.mary.cheezimod.entity.custom;

import com.mary.cheezimod.entity.ModEntityTypes;
import com.mary.cheezimod.item.ModItems;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;

public class StrawberryCowEntity extends Animal implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public StrawberryCowEntity(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2F).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(ModItems.STRAWBERRY.get()), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

//    @Override
//    public Cow getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
//        return ModEntityTypes.STRAWBERRY_COW.get().create(level);
//    }
    protected SoundEvent getAmbientSound() {
    return SoundEvents.COW_AMBIENT;
}

    protected SoundEvent getHurtSound(DamageSource p_28306_) {
        return SoundEvents.COW_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.COW_DEATH;
    }

    protected void playStepSound(BlockPos p_28301_, BlockState p_28302_) {
        this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    public InteractionResult mobInteract(Player p_28298_, InteractionHand p_28299_) {
        ItemStack itemstack = p_28298_.getItemInHand(p_28299_);
        if (itemstack.is(Items.BUCKET) && !this.isBaby()) {
            p_28298_.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
            ItemStack itemstack1 = ItemUtils.createFilledResult(itemstack, p_28298_, ModItems.STRAWBERRY_MILK.get().getDefaultInstance());
            p_28298_.setItemInHand(p_28299_, itemstack1);
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        } else {
            return super.mobInteract(p_28298_, p_28299_);
        }
    }
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return ModEntityTypes.STRAWBERRY_COW.get().create(level);
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this,"controller",0,this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if(tAnimationState.isMoving()){
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.strawberry_cow.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.strawberry_cow.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }


}


//public class MushroomCow extends Cow implements Shearable, net.minecraftforge.common.IForgeShearable {
//    private static final EntityDataAccessor<String> DATA_TYPE = SynchedEntityData.defineId(net.minecraft.world.entity.animal.MushroomCow.class, EntityDataSerializers.STRING);
//    private static final int MUTATE_CHANCE = 1024;
//    @javax.annotation.Nullable
//    private MobEffect effect;
//    private int effectDuration;
//    @javax.annotation.Nullable
//    private UUID lastLightningBoltUUID;
//
//    public MushroomCow(EntityType<? extends net.minecraft.world.entity.animal.MushroomCow> p_28914_, Level p_28915_) {
//        super(p_28914_, p_28915_);
//    }
//
//    public float getWalkTargetValue(BlockPos p_28933_, LevelReader p_28934_) {
//        return p_28934_.getBlockState(p_28933_.below()).is(Blocks.MYCELIUM) ? 10.0F : p_28934_.getPathfindingCostFromLightLevels(p_28933_);
//    }
//
//    public static boolean checkMushroomSpawnRules(EntityType<net.minecraft.world.entity.animal.MushroomCow> p_218201_, LevelAccessor p_218202_, MobSpawnType p_218203_, BlockPos p_218204_, RandomSource p_218205_) {
//        return p_218202_.getBlockState(p_218204_.below()).is(BlockTags.MOOSHROOMS_SPAWNABLE_ON) && isBrightEnoughToSpawn(p_218202_, p_218204_);
//    }
//
//    public void thunderHit(ServerLevel p_28921_, LightningBolt p_28922_) {
//        UUID uuid = p_28922_.getUUID();
//        if (!uuid.equals(this.lastLightningBoltUUID)) {
//            this.setVariant(this.getVariant() == net.minecraft.world.entity.animal.MushroomCow.MushroomType.RED ? net.minecraft.world.entity.animal.MushroomCow.MushroomType.BROWN : net.minecraft.world.entity.animal.MushroomCow.MushroomType.RED);
//            this.lastLightningBoltUUID = uuid;
//            this.playSound(SoundEvents.MOOSHROOM_CONVERT, 2.0F, 1.0F);
//        }
//
//    }
//
//    protected void defineSynchedData() {
//        super.defineSynchedData();
//        this.entityData.define(DATA_TYPE, net.minecraft.world.entity.animal.MushroomCow.MushroomType.RED.type);
//    }
//
//    public InteractionResult mobInteract(Player p_28941_, InteractionHand p_28942_) {
//        ItemStack itemstack = p_28941_.getItemInHand(p_28942_);
//        if (itemstack.is(Items.BOWL) && !this.isBaby()) {
//            boolean flag = false;
//            ItemStack itemstack1;
//            if (this.effect != null) {
//                flag = true;
//                itemstack1 = new ItemStack(Items.SUSPICIOUS_STEW);
//                SuspiciousStewItem.saveMobEffect(itemstack1, this.effect, this.effectDuration);
//                this.effect = null;
//                this.effectDuration = 0;
//            } else {
//                itemstack1 = new ItemStack(Items.MUSHROOM_STEW);
//            }
//
//            ItemStack itemstack2 = ItemUtils.createFilledResult(itemstack, p_28941_, itemstack1, false);
//            p_28941_.setItemInHand(p_28942_, itemstack2);
//            SoundEvent soundevent;
//            if (flag) {
//                soundevent = SoundEvents.MOOSHROOM_MILK_SUSPICIOUSLY;
//            } else {
//                soundevent = SoundEvents.MOOSHROOM_MILK;
//            }
//
//            this.playSound(soundevent, 1.0F, 1.0F);
//            return InteractionResult.sidedSuccess(this.level().isClientSide);
//        } else if (false && itemstack.getItem() == Items.SHEARS && this.readyForShearing()) { //Forge: Moved to onSheared
//            this.shear(SoundSource.PLAYERS);
//            this.gameEvent(GameEvent.SHEAR, p_28941_);
//            if (!this.level().isClientSide) {
//                itemstack.hurtAndBreak(1, p_28941_, (p_28927_) -> {
//                    p_28927_.broadcastBreakEvent(p_28942_);
//                });
//            }
//
//            return InteractionResult.sidedSuccess(this.level().isClientSide);
//        } else if (this.getVariant() == net.minecraft.world.entity.animal.MushroomCow.MushroomType.BROWN && itemstack.is(ItemTags.SMALL_FLOWERS)) {
//            if (this.effect != null) {
//                for(int i = 0; i < 2; ++i) {
//                    this.level().addParticle(ParticleTypes.SMOKE, this.getX() + this.random.nextDouble() / 2.0D, this.getY(0.5D), this.getZ() + this.random.nextDouble() / 2.0D, 0.0D, this.random.nextDouble() / 5.0D, 0.0D);
//                }
//            } else {
//                Optional<Pair<MobEffect, Integer>> optional = this.getEffectFromItemStack(itemstack);
//                if (!optional.isPresent()) {
//                    return InteractionResult.PASS;
//                }
//
//                Pair<MobEffect, Integer> pair = optional.get();
//                if (!p_28941_.getAbilities().instabuild) {
//                    itemstack.shrink(1);
//                }
//
//                for(int j = 0; j < 4; ++j) {
//                    this.level().addParticle(ParticleTypes.EFFECT, this.getX() + this.random.nextDouble() / 2.0D, this.getY(0.5D), this.getZ() + this.random.nextDouble() / 2.0D, 0.0D, this.random.nextDouble() / 5.0D, 0.0D);
//                }
//
//                this.effect = pair.getLeft();
//                this.effectDuration = pair.getRight();
//                this.playSound(SoundEvents.MOOSHROOM_EAT, 2.0F, 1.0F);
//            }
//
//            return InteractionResult.sidedSuccess(this.level().isClientSide);
//        } else {
//            return super.mobInteract(p_28941_, p_28942_);
//        }
//    }
//
//    @Override
//    public java.util.List<ItemStack> onSheared(@org.jetbrains.annotations.Nullable Player player, @org.jetbrains.annotations.NotNull ItemStack item, Level world, BlockPos pos, int fortune) {
//        this.gameEvent(GameEvent.SHEAR, player);
//        return shearInternal(player == null ? SoundSource.BLOCKS : SoundSource.PLAYERS);
//    }
//
//    public void shear(SoundSource p_28924_) {
//        shearInternal(p_28924_).forEach(s -> this.level().addFreshEntity(new ItemEntity(this.level(), this.getX(), this.getY(1.0D), this.getZ(), s)));
//    }
//
//    private java.util.List<ItemStack> shearInternal(SoundSource p_28924_) {
//        this.level().playSound((Player)null, this, SoundEvents.MOOSHROOM_SHEAR, p_28924_, 1.0F, 1.0F);
//        if (!this.level().isClientSide()) {
//            Cow cow = EntityType.COW.create(this.level());
//            if (cow != null) {
//                ((ServerLevel)this.level()).sendParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(0.5D), this.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
//                this.discard();
//                cow.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
//                cow.setHealth(this.getHealth());
//                cow.yBodyRot = this.yBodyRot;
//                if (this.hasCustomName()) {
//                    cow.setCustomName(this.getCustomName());
//                    cow.setCustomNameVisible(this.isCustomNameVisible());
//                }
//
//                if (this.isPersistenceRequired()) {
//                    cow.setPersistenceRequired();
//                }
//
//                cow.setInvulnerable(this.isInvulnerable());
//                this.level().addFreshEntity(cow);
//
//                java.util.List<ItemStack> items = new java.util.ArrayList<>();
//                for(int i = 0; i < 5; ++i) {
//                    items.add(new ItemStack(this.getVariant().blockState.getBlock()));
//                }
//                return items;
//            }
//        }
//        return java.util.Collections.emptyList();
//
//    }
//
//    public boolean readyForShearing() {
//        return this.isAlive() && !this.isBaby();
//    }
//
//    public void addAdditionalSaveData(CompoundTag p_28944_) {
//        super.addAdditionalSaveData(p_28944_);
//        p_28944_.putString("Type", this.getVariant().getSerializedName());
//        if (this.effect != null) {
//            p_28944_.putInt("EffectId", MobEffect.getId(this.effect));
//            net.minecraftforge.common.ForgeHooks.saveMobEffect(p_28944_, "forge:effect_id", this.effect);
//            p_28944_.putInt("EffectDuration", this.effectDuration);
//        }
//
//    }
//
//    public void readAdditionalSaveData(CompoundTag p_28936_) {
//        super.readAdditionalSaveData(p_28936_);
//        this.setVariant(net.minecraft.world.entity.animal.MushroomCow.MushroomType.byType(p_28936_.getString("Type")));
//        if (p_28936_.contains("EffectId", 99)) {
//            this.effect = MobEffect.byId(p_28936_.getInt("EffectId"));
//            this.effect = net.minecraftforge.common.ForgeHooks.loadMobEffect(p_28936_, "forge:effect_id", this.effect);
//        }
//
//        if (p_28936_.contains("EffectDuration", 99)) {
//            this.effectDuration = p_28936_.getInt("EffectDuration");
//        }
//
//    }
//
//    private Optional<Pair<MobEffect, Integer>> getEffectFromItemStack(ItemStack p_28957_) {
//        SuspiciousEffectHolder suspiciouseffectholder = SuspiciousEffectHolder.tryGet(p_28957_.getItem());
//        return suspiciouseffectholder != null ? Optional.of(Pair.of(suspiciouseffectholder.getSuspiciousEffect(), suspiciouseffectholder.getEffectDuration())) : Optional.empty();
//    }
//
//    public void setVariant(net.minecraft.world.entity.animal.MushroomCow.MushroomType p_28929_) {
//        this.entityData.set(DATA_TYPE, p_28929_.type);
//    }
//
//    public net.minecraft.world.entity.animal.MushroomCow.MushroomType getVariant() {
//        return net.minecraft.world.entity.animal.MushroomCow.MushroomType.byType(this.entityData.get(DATA_TYPE));
//    }
//
//    @javax.annotation.Nullable
//    public net.minecraft.world.entity.animal.MushroomCow getBreedOffspring(ServerLevel p_148942_, AgeableMob p_148943_) {
//        net.minecraft.world.entity.animal.MushroomCow mushroomcow = EntityType.MOOSHROOM.create(p_148942_);
//        if (mushroomcow != null) {
//            mushroomcow.setVariant(this.getOffspringType((net.minecraft.world.entity.animal.MushroomCow)p_148943_));
//        }
//
//        return mushroomcow;
//    }
//
//    private net.minecraft.world.entity.animal.MushroomCow.MushroomType getOffspringType(net.minecraft.world.entity.animal.MushroomCow p_28931_) {
//        net.minecraft.world.entity.animal.MushroomCow.MushroomType mushroomcow$mushroomtype = this.getVariant();
//        net.minecraft.world.entity.animal.MushroomCow.MushroomType mushroomcow$mushroomtype1 = p_28931_.getVariant();
//        net.minecraft.world.entity.animal.MushroomCow.MushroomType mushroomcow$mushroomtype2;
//        if (mushroomcow$mushroomtype == mushroomcow$mushroomtype1 && this.random.nextInt(1024) == 0) {
//            mushroomcow$mushroomtype2 = mushroomcow$mushroomtype == net.minecraft.world.entity.animal.MushroomCow.MushroomType.BROWN ? net.minecraft.world.entity.animal.MushroomCow.MushroomType.RED : net.minecraft.world.entity.animal.MushroomCow.MushroomType.BROWN;
//        } else {
//            mushroomcow$mushroomtype2 = this.random.nextBoolean() ? mushroomcow$mushroomtype : mushroomcow$mushroomtype1;
//        }
//
//        return mushroomcow$mushroomtype2;
//    }
//
//    @Override
//    public boolean isShearable(@org.jetbrains.annotations.NotNull ItemStack item, Level world, BlockPos pos) {
//        return readyForShearing();
//    }
//
//    public static enum MushroomType implements StringRepresentable {
//        RED("red", Blocks.RED_MUSHROOM.defaultBlockState()),
//        BROWN("brown", Blocks.BROWN_MUSHROOM.defaultBlockState());
//
//        public static final StringRepresentable.EnumCodec<net.minecraft.world.entity.animal.MushroomCow.MushroomType> CODEC = StringRepresentable.fromEnum(net.minecraft.world.entity.animal.MushroomCow.MushroomType::values);
//        final String type;
//        final BlockState blockState;
//
//        private MushroomType(String p_28967_, BlockState p_28968_) {
//            this.type = p_28967_;
//            this.blockState = p_28968_;
//        }
//
//        public BlockState getBlockState() {
//            return this.blockState;
//        }
//
//        public String getSerializedName() {
//            return this.type;
//        }
//
//        static net.minecraft.world.entity.animal.MushroomCow.MushroomType byType(String p_28977_) {
//            return CODEC.byName(p_28977_, RED);
//        }
//    }
//}
