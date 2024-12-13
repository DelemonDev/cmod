package net.cmodcom.entity.custom;

import net.cmodcom.entity.ModEntities;
import net.cmodcom.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MedTankEntity extends AnimalEntity {

    private int ammoCooldown = 0;
    private static final int AMMO_COOLDOWN_TIME = 20; //to not spam ammo I swear

    public int getAmmoCooldown() {
        return ammoCooldown;
    }

    public MedTankEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
    }

    public static DefaultAttributeContainer.Builder createMedTankAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10);
    }

    @Override
    @Nullable
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.MEDTANK.create(world);
    }

    @Override
    public boolean canBreedWith(AnimalEntity other) {
        return false;
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!this.getWorld().isClient) {
            player.startRiding(this);
        }
        return super.interactMob(player, hand);
    }

    @Override
    public double getMountedHeightOffset() {
        return 1.0F;
    }

    @Override
    public void travel(Vec3d movementInput) {
        if (this.hasPassengers() && this.getPrimaryPassenger() instanceof PlayerEntity player) {
            this.setYaw(player.getYaw());
            this.prevYaw = this.getYaw();
            this.setPitch(player.getPitch() * 0.5F);
            this.setRotation(this.getYaw(), this.getPitch());
            this.bodyYaw = this.getYaw();
            this.headYaw = this.bodyYaw;
            float forward = player.forwardSpeed;
            float strafe = player.sidewaysSpeed;
            if (this.isLogicalSideForUpdatingMovement()) {
                this.setMovementSpeed((float) this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
                Vec3d vec3d = new Vec3d(strafe, movementInput.y, forward);
                if (this.horizontalCollision && this.isOnGround()) {
                    this.jump();
                }
                super.travel(vec3d);
            } else {
                this.setVelocity(Vec3d.ZERO);
            }
        } else {
            super.travel(movementInput);
        }
    }

    private Entity getPrimaryPassenger() {
        return this.getPassengerList().isEmpty() ? null : this.getPassengerList().get(0);
    }

    @Override
    public void tick() {
        super.tick();
        if (ammoCooldown > 0) {
            ammoCooldown--;
        }
    }

    public void fireAmmo() {
        if (ammoCooldown == 0 && !this.getWorld().isClient && this.getPrimaryPassenger() instanceof PlayerEntity player) {
            if (player.getInventory().count(ModItems.TANKAMMO) > 0) {
                Vec3d eyePosition = player.getEyePos();
                Vec3d targetPosition = player.raycast(100.0, 1.0F, false).getPos();
                Vec3d direction = targetPosition.subtract(eyePosition).normalize();

                TankAmmoEntity ammo = new TankAmmoEntity(ModEntities.TANKAMMO, this.getWorld());
                ammo.setPosition(eyePosition.x, eyePosition.y, eyePosition.z);
                double speedMultiplier = 2.0; // Speed changleable
                ammo.setVelocity(direction.x * speedMultiplier, direction.y * speedMultiplier, direction.z * speedMultiplier);
                this.getWorld().spawnEntity(ammo);
                this.playSound(SoundEvents.ENTITY_TNT_PRIMED, 1.0F, 1.0F);
                ammoCooldown = AMMO_COOLDOWN_TIME; // Reset cooldown
                player.getInventory().removeStack(player.getInventory().getSlotWithStack(new ItemStack(ModItems.TANKAMMO)), 1); // Removes one Tank Ammo item
            }
        }
    }
}