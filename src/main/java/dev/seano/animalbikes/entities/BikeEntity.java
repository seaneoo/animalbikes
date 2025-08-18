package dev.seano.animalbikes.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class BikeEntity extends PathAwareEntity {

    public BikeEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createBikeAttributes() {
        return createMobAttributes();
    }

    @Override
    protected void initGoals() {
        goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 6f));
        goalSelector.add(2, new LookAroundGoal(this));
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (getWorld().isClient) {
            return ActionResult.SUCCESS;
        }
        if (!hasPassengers() && !player.shouldCancelInteraction()) {
            player.startRiding(this);
        }
        return super.interactMob(player, hand);
    }
}
