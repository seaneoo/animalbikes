package dev.seano.animalbikes.client;

import dev.seano.animalbikes.client.datagen.ABEnglishLangProvider;
import dev.seano.animalbikes.client.datagen.ABModelProvider;
import dev.seano.animalbikes.client.datagen.ABRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class AnimalBikesDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ABEnglishLangProvider::new);
        pack.addProvider(ABModelProvider::new);
        pack.addProvider(ABRecipeProvider::new);
    }
}
