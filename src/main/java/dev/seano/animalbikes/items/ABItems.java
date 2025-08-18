package dev.seano.animalbikes.items;

import dev.seano.animalbikes.AnimalBikes;
import dev.seano.animalbikes.entities.ABEntities;
import dev.seano.animalbikes.entities.AbstractBikeEntity;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

import java.util.Map;
import java.util.function.BiFunction;

public class ABItems {

    public static final AnimalBikeItem CREEPER_BIKE = register("creeper_bike",
            ABEntities.CREEPER_BIKE,
            AnimalBikeItem::new);
    public static final AnimalBikeItem PIG_BIKE = register("pig_bike", ABEntities.PIG_BIKE, AnimalBikeItem::new);

    public static final RegistryKey<ItemGroup> AB_ITEM_GROUP = registerItemGroup("animal_bikes", CREEPER_BIKE);

    public static final Map<EntityType<? extends AbstractBikeEntity>, AnimalBikeItem> ENTITY_ANIMAL_BIKE_ITEM_MAP = Map.ofEntries(
            Map.entry(ABEntities.CREEPER_BIKE, CREEPER_BIKE),
            Map.entry(ABEntities.PIG_BIKE, PIG_BIKE));

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(AB_ITEM_GROUP).register(entries -> {
            entries.add(CREEPER_BIKE);
            entries.add(PIG_BIKE);
        });
    }

    private static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, AnimalBikes.identifier(id));
    }

    private static AnimalBikeItem register(String name, EntityType<? extends AbstractBikeEntity> entityType, BiFunction<RegistryKey<Item>, EntityType<? extends AbstractBikeEntity>, Item> factory) {
        RegistryKey<Item> key = keyOf(name);
        Item item = factory.apply(key, entityType);
        return (AnimalBikeItem) Registry.register(Registries.ITEM, key, item);
    }

    @SuppressWarnings("SameParameterValue")
    private static RegistryKey<ItemGroup> registerItemGroup(String name, Item item) {
        RegistryKey<ItemGroup> key = RegistryKey.of(RegistryKeys.ITEM_GROUP, AnimalBikes.identifier(name));
        ItemGroup itemGroup = FabricItemGroup.builder()
                .icon(item::getDefaultStack)
                .displayName(Text.translatable("itemGroup.animalbikes"))
                .build();
        Registry.register(Registries.ITEM_GROUP, key, itemGroup);
        return key;
    }
}
