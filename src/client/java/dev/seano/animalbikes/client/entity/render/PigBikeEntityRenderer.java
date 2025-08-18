package dev.seano.animalbikes.client.entity.render;

import dev.seano.animalbikes.client.entity.ABModelLayers;
import dev.seano.animalbikes.client.entity.model.PigBikeEntityModel;
import dev.seano.animalbikes.entities.PigBikeEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class PigBikeEntityRenderer extends MobEntityRenderer<PigBikeEntity, BikeEntityRenderState, PigBikeEntityModel> {

    public PigBikeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new PigBikeEntityModel(context.getPart(ABModelLayers.PIG_BIKE)), 0.7f);
    }

    @Override
    public Identifier getTexture(BikeEntityRenderState state) {
        return Identifier.ofVanilla("textures/entity/pig/temperate_pig.png");
    }

    @Override
    public BikeEntityRenderState createRenderState() {
        return new BikeEntityRenderState();
    }
}
