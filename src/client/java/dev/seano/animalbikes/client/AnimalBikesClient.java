package dev.seano.animalbikes.client;

import dev.seano.animalbikes.client.entity.ABModelLayers;
import dev.seano.animalbikes.client.entity.render.CreeperBikeEntityRenderer;
import dev.seano.animalbikes.client.entity.render.PigBikeEntityRenderer;
import dev.seano.animalbikes.entities.ABEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnimalBikesClient implements ClientModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger(AnimalBikesClient.class);

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ABEntities.CREEPER_BIKE, CreeperBikeEntityRenderer::new);
        EntityRendererRegistry.register(ABEntities.PIG_BIKE, PigBikeEntityRenderer::new);
        ABModelLayers.init();
    }
}
