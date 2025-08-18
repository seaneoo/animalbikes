package dev.seano.animalbikes.entities;

import dev.seano.animalbikes.AnimalBikes;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ABEntities {

    public static final EntityType<CreeperBikeEntity> CREEPER_BIKE = register("creeper_bike",
            CreeperBikeEntity::new,
            0.6f,
            1.75f);
    public static final EntityType<PigBikeEntity> PIG_BIKE = register("pig_bike",
            PigBikeEntity::new,
            0.9f,
            0.9f);

    public static void init() {
        FabricDefaultAttributeRegistry.register(CREEPER_BIKE, AbstractBikeEntity.createBikeAttributes());
        FabricDefaultAttributeRegistry.register(PIG_BIKE, AbstractBikeEntity.createBikeAttributes());
    }

    private static RegistryKey<EntityType<?>> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.ofVanilla(id));
    }

    private static <T extends Entity> EntityType<T> register(String name, EntityType.EntityFactory<T> factory, float width, float height) {
        RegistryKey<EntityType<?>> key = keyOf(name);
        return Registry.register(Registries.ENTITY_TYPE,
                AnimalBikes.identifier(name),
                EntityType.Builder.create(factory, SpawnGroup.CREATURE)
                        .dimensions(width, height)
                        .build(key));
    }
}
