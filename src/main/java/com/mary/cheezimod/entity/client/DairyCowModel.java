package com.mary.cheezimod.entity.client;

import com.mary.cheezimod.CheeziMod;
import com.mary.cheezimod.entity.custom.DairyCowEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class DairyCowModel extends GeoModel<DairyCowEntity> {

    @Override
    public ResourceLocation getModelResource(DairyCowEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "geo/dairy_cow.geo.json");
    }

    public ResourceLocation getTextureResource(DairyCowEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "textures/entity/dairy_cow_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DairyCowEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "animations/dairy_cow.animation.json");
    }
    @Override
    public void setCustomAnimations(DairyCowEntity animatable, long instanceId, AnimationState<DairyCowEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");
        if (head != null){
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }

}
