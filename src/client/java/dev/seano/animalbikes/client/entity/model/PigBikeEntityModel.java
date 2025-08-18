package dev.seano.animalbikes.client.entity.model;

import dev.seano.animalbikes.client.entity.render.BikeEntityRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;

public class PigBikeEntityModel extends QuadrupedEntityModel<BikeEntityRenderState> {

    public PigBikeEntityModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(getModelData(), 64, 64);
    }

    private static ModelData getModelData() {
        ModelData modelData = QuadrupedEntityModel.getModelData(6, true, false, Dilation.NONE);
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(
                EntityModelPartNames.HEAD,
                ModelPartBuilder.create()
                        .uv(0, 0)
                        .cuboid(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, Dilation.NONE)
                        .uv(16, 16)
                        .cuboid(-2.0F, 0.0F, -9.0F, 4.0F, 3.0F, 1.0F, Dilation.NONE),
                ModelTransform.origin(0.0F, 12.0F, -6.0F)
        );
        return modelData;
    }
}
