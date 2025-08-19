package dev.seano.animalbikes.client;

import dev.seano.animalbikes.client.entity.ABModelLayers;
import dev.seano.animalbikes.client.entity.render.CreeperBikeEntityRenderer;
import dev.seano.animalbikes.client.entity.render.PigBikeEntityRenderer;
import dev.seano.animalbikes.entities.ABEntities;
import dev.seano.animalbikes.network.UseAnimalBikeItemS2CPayload;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnimalBikesClient implements ClientModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger(AnimalBikesClient.class);

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ABEntities.CREEPER_BIKE, CreeperBikeEntityRenderer::new);
        EntityRendererRegistry.register(ABEntities.PIG_BIKE, PigBikeEntityRenderer::new);
        ABModelLayers.init();

        ClientPlayNetworking.registerGlobalReceiver(UseAnimalBikeItemS2CPayload.ID, (payload, context) -> {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            KeyBinding sneakKey = minecraftClient.options.sneakKey;
            KeyBinding useKey = minecraftClient.options.useKey;
            context.player()
                    .sendMessage(Text.translatable("animalbikes.reclaimWheel",
                            Text.translatable(sneakKey.getBoundKeyTranslationKey()),
                            Text.translatable(useKey.getBoundKeyTranslationKey())), true);
        });
    }
}
