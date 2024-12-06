package net.cmodcom.entity.custom;

import net.cmodcom.entity.ModEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MedTankEntity extends AnimalEntity {

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
}