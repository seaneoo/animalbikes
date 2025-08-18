package dev.seano.animalbikes.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PigBikeEntity extends BikeEntity {

    public PigBikeEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public @Nullable Text getCustomName() {
        return Text.literal("Pig Bike").formatted(Formatting.LIGHT_PURPLE).formatted(Formatting.BOLD);
    }

    @Override
    public boolean isCustomNameVisible() {
        return true;
    }
}
