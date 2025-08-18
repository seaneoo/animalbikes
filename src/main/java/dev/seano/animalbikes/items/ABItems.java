package dev.seano.animalbikes.items;

import dev.seano.animalbikes.AnimalBikes;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

import java.util.function.Function;

public class ABItems {

    public static final Item CREEPER_BIKE = register("creeper_bike", Item::new, new Item.Settings().maxCount(1));

    public static final RegistryKey<ItemGroup> AB_ITEM_GROUP = registerItemGroup("animal_bikes", CREEPER_BIKE);

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(AB_ITEM_GROUP).register(entries -> entries.add(CREEPER_BIKE));
    }

    private static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, AnimalBikes.identifier(id));
    }

    private static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = keyOf(name);
        Item item = factory.apply(settings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    @SuppressWarnings("SameParameterValue")
    private static RegistryKey<ItemGroup> registerItemGroup(String name, Item item) {
        RegistryKey<ItemGroup> key = RegistryKey.of(RegistryKeys.ITEM_GROUP, AnimalBikes.identifier(name));
        //noinspection NoTranslation
        ItemGroup itemGroup = FabricItemGroup.builder()
                .icon(item::getDefaultStack)
                .displayName(Text.translatable("itemGroup.animalbikes"))
                .build();
        Registry.register(Registries.ITEM_GROUP, key, itemGroup);
        return key;
    }
}
