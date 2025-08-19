package dev.seano.animalbikes;

import dev.seano.animalbikes.entities.ABEntities;
import dev.seano.animalbikes.items.ABItems;
import dev.seano.animalbikes.network.UseAnimalBikeItemS2CPayload;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnimalBikes implements ModInitializer {

    public static final String ID = "animalbikes";
    public static final Logger LOGGER = LoggerFactory.getLogger(AnimalBikes.class);

    public static Identifier identifier(String path) {
        return Identifier.of(ID, path);
    }

    @Override
    public void onInitialize() {
        ABEntities.init();
        ABItems.init();

        PayloadTypeRegistry.playS2C().register(UseAnimalBikeItemS2CPayload.ID, UseAnimalBikeItemS2CPayload.CODEC);
    }
}
