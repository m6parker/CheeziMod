package com.mary.cheezimod.entity.client;

import com.mary.cheezimod.CheeziMod;
import com.mary.cheezimod.entity.custom.MouseEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class MouseModel extends GeoModel<MouseEntity> {
    @Override
    public ResourceLocation getModelResource(MouseEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "geo/mouse.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MouseEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "textures/entity/mouse_texture.png");    }

    @Override
    public ResourceLocation getAnimationResource(MouseEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "animations/mouse.animation.json");    }

    @Override
    public void setCustomAnimations(MouseEntity animatable, long instanceId, AnimationState<MouseEntity> animationState) {
//        super.setCustomAnimations(animatable, instanceId, animationState);
        CoreGeoBone head = getAnimationProcessor().getBone("head");
        if (head != null){
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
