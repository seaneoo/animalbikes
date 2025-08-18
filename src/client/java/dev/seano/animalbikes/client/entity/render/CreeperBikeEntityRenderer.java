package dev.seano.animalbikes.client.entity.render;

import dev.seano.animalbikes.client.entity.ABModelLayers;
import dev.seano.animalbikes.client.entity.model.CreeperBikeEntityModel;
import dev.seano.animalbikes.entities.CreeperBikeEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CreeperBikeEntityRenderer extends MobEntityRenderer<CreeperBikeEntity, BikeEntityRenderState, CreeperBikeEntityModel> {

    public CreeperBikeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CreeperBikeEntityModel(context.getPart(ABModelLayers.CREEPER_BIKE)), 0.5f);
    }

    @Override
    public Identifier getTexture(BikeEntityRenderState state) {
        return Identifier.ofVanilla("textures/entity/creeper/creeper.png");
    }

    @Override
    public BikeEntityRenderState createRenderState() {
        return new BikeEntityRenderState();
    }
}
