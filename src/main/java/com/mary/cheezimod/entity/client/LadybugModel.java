package com.mary.cheezimod.entity.client;

import com.mary.cheezimod.CheeziMod;
import com.mary.cheezimod.entity.custom.LadybugEntity;
import com.mary.cheezimod.entity.custom.MouseEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class LadybugModel extends GeoModel<LadybugEntity> {
    @Override
    public ResourceLocation getModelResource(LadybugEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "geo/ladybug.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LadybugEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "textures/entity/ladybug_texture.png");    }

    @Override
    public ResourceLocation getAnimationResource(LadybugEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "animations/ladybug.animation.json");    }

    @Override
    public void setCustomAnimations(LadybugEntity animatable, long instanceId, AnimationState<LadybugEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");
        if (head != null){
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
