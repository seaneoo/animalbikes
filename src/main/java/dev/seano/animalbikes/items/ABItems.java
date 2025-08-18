package dev.seano.animalbikes.items;

import dev.seano.animalbikes.AnimalBikes;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;

public class ABItems {

    public static final Item CREEPER_BIKE = register("creeper_bike", Item::new, new Item.Settings().maxCount(1));

    public static void init() {
    }

    private static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, AnimalBikes.identifier(id));
    }

    private static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = keyOf(name);
        Item item = factory.apply(settings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }
}
