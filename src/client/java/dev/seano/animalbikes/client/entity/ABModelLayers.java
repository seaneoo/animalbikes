package dev.seano.animalbikes.client.entity;

import dev.seano.animalbikes.AnimalBikes;
import dev.seano.animalbikes.client.entity.model.CreeperBikeEntityModel;
import dev.seano.animalbikes.client.entity.model.PigBikeEntityModel;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class ABModelLayers {

    public static final EntityModelLayer CREEPER_BIKE = new EntityModelLayer(AnimalBikes.identifier("creeper_bike"),
            "main");
    public static final EntityModelLayer PIG_BIKE = new EntityModelLayer(AnimalBikes.identifier("pig_bike"), "main");

    public static void init() {
        EntityModelLayerRegistry.registerModelLayer(CREEPER_BIKE, CreeperBikeEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(PIG_BIKE, PigBikeEntityModel::getTexturedModelData);
    }
}
