package dev.seano.animalbikes.client.entity.model;

import dev.seano.animalbikes.client.entity.render.BikeEntityRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

public class CreeperBikeEntityModel extends EntityModel<BikeEntityRenderState> {

    private final ModelPart head;
    private final ModelPart rightHindLeg;
    private final ModelPart leftHindLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart leftFrontLeg;

    public CreeperBikeEntityModel(ModelPart root) {
        super(root);
        head = root.getChild("head");
        rightHindLeg = root.getChild("right_hind_leg");
        leftHindLeg = root.getChild("left_hind_leg");
        rightFrontLeg = root.getChild("right_front_leg");
        leftFrontLeg = root.getChild("left_front_leg");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("head",
                ModelPartBuilder.create().uv(0, 0).cuboid(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f),
                ModelTransform.origin(0.0f, 6.0f, 0.0f));
        modelPartData.addChild("body",
                ModelPartBuilder.create().uv(16, 16).cuboid(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f),
                ModelTransform.origin(0.0f, 6.0f, 0.0f));
        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create()
                .uv(0, 16)
                .cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 6.0f, 4.0f);
        modelPartData.addChild("right_hind_leg", modelPartBuilder, ModelTransform.origin(-2.0f, 18.0f, 4.0f));
        modelPartData.addChild("left_hind_leg", modelPartBuilder, ModelTransform.origin(2.0f, 18.0f, 4.0f));
        modelPartData.addChild("right_front_leg", modelPartBuilder, ModelTransform.origin(-2.0f, 18.0f, -4.0f));
        modelPartData.addChild("left_front_leg", modelPartBuilder, ModelTransform.origin(2.0f, 18.0f, -4.0f));
        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public void setAngles(BikeEntityRenderState state) {
        super.setAngles(state);
        head.yaw = state.relativeHeadYaw * ((float) Math.PI / 180f);
        head.pitch = state.pitch * ((float) Math.PI / 180f);
        float f = state.limbSwingAmplitude;
        float g = state.limbSwingAnimationProgress;
        rightHindLeg.pitch = MathHelper.cos(g * 0.6662f + (float) Math.PI) * 1.4f * f;
        leftHindLeg.pitch = MathHelper.cos(g * 0.6662f) * 1.4f * f;
        rightFrontLeg.pitch = MathHelper.cos(g * 0.6662f) * 1.4f * f;
        leftFrontLeg.pitch = MathHelper.cos(g * 0.6662f + (float) Math.PI) * 1.4f * f;
    }
}
