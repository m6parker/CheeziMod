package com.mary.cheezimod.entity.client;

import com.mary.cheezimod.CheeziMod;
import com.mary.cheezimod.entity.custom.MouseEntity;
import com.mary.cheezimod.entity.custom.StrawberryCowEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class StrawberryCowModel extends GeoModel<StrawberryCowEntity> {
    @Override
    public ResourceLocation getModelResource(StrawberryCowEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "geo/strawberry_cow.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StrawberryCowEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "textures/entity/strawberry_cow_texture.png");    }

    @Override
    public ResourceLocation getAnimationResource(StrawberryCowEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "animations/strawberry_cow.animation.json");    }

    @Override
    public void setCustomAnimations(StrawberryCowEntity animatable, long instanceId, AnimationState<StrawberryCowEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");
        if (head != null){
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
