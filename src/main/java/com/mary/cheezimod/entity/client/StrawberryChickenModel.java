package com.mary.cheezimod.entity.client;

import com.mary.cheezimod.CheeziMod;
import com.mary.cheezimod.entity.custom.MouseEntity;
import com.mary.cheezimod.entity.custom.StrawberryChickenEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class StrawberryChickenModel extends GeoModel<StrawberryChickenEntity> {
    @Override
    public ResourceLocation getModelResource(StrawberryChickenEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "geo/strawberry_chicken.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StrawberryChickenEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "textures/entity/strawberry_chicken_texture.png");    }

    @Override
    public ResourceLocation getAnimationResource(StrawberryChickenEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "animations/strawberry_chicken.animation.json");    }

    @Override
    public void setCustomAnimations(StrawberryChickenEntity animatable, long instanceId, AnimationState<StrawberryChickenEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");
        if (head != null){
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
