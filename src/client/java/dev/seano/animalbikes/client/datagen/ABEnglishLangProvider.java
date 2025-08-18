package dev.seano.animalbikes.client.datagen;

import dev.seano.animalbikes.items.ABItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ABEnglishLangProvider extends FabricLanguageProvider {

    public ABEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.animalbikes", "Animal Bikes");
        translationBuilder.add(ABItems.CREEPER_BIKE, "Creeper Bike");
        translationBuilder.add(ABItems.PIG_BIKE, "Pig Bike");
    }
}
