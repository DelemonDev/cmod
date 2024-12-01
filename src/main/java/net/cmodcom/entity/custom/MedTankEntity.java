package net.cmodcom.entity.custom;

import com.sun.jna.platform.unix.solaris.LibKstat;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;

public class MedTankEntity extends MobEntity {

    public MedTankEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createMedTankAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2);
    }
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
    }
    @Override
    public void tick() {
        super.tick();
        // Add any custom behaviors or animations for the entity here
    }


}
