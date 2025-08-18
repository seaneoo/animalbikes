package dev.seano.animalbikes.entities;

import dev.seano.animalbikes.items.ABItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

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
        if (!hasPassengers()) {
            if (player.isSneaking()) {
                discard();
                ItemStack itemStack = ABItems.ENTITY_ANIMAL_BIKE_ITEM_MAP.get(getType()).getDefaultStack();
                player.giveItemStack(itemStack);
            } else {
                player.setYaw(getYaw());
                player.setPitch(getPitch());
                player.startRiding(this);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public @Nullable LivingEntity getControllingPassenger() {
        return getFirstPassenger() instanceof LivingEntity entity ? entity : null;
    }

    @Override
    protected Vec3d getControlledMovementInput(PlayerEntity controllingPlayer, Vec3d movementInput) {
        // todo adjust speeds
        if (controllingPlayer == null) {
            return Vec3d.ZERO;
        }

        float sideways = controllingPlayer.sidewaysSpeed * 0.5f;
        float forward = controllingPlayer.forwardSpeed * 0.5f;
        if (forward <= 0.0f) {
            forward *= 0.25f;
        }

        float yawRad = (float) Math.toRadians(controllingPlayer.getYaw());
        double x = -Math.sin(yawRad) * forward + Math.cos(yawRad) * sideways;
        double z = Math.cos(yawRad) * forward + Math.sin(yawRad) * sideways;

        return new Vec3d(x, 0.0, z);
    }

    @Override
    protected void tickControlled(PlayerEntity controllingPlayer, Vec3d movementInput) {
        Vec2f vec2f = new Vec2f(controllingPlayer.getPitch() * 0.5f, controllingPlayer.getYaw());
        setRotation(vec2f.y, vec2f.x);
        lastYaw = bodyYaw = headYaw = getYaw();

        Vec3d vec3d = getControlledMovementInput(controllingPlayer, movementInput);
        move(MovementType.PLAYER, vec3d);
    }
}
