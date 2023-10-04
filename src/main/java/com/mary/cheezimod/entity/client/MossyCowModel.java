package com.mary.cheezimod.entity.client;

import com.mary.cheezimod.CheeziMod;
import com.mary.cheezimod.entity.custom.DairyCowEntity;
import com.mary.cheezimod.entity.custom.MossyCowEntity;
import com.mary.cheezimod.entity.custom.StrawberryCowEntity;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class MossyCowModel extends GeoModel<MossyCowEntity> {

    @Override
    public ResourceLocation getModelResource(MossyCowEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "geo/mossy_cow.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(MossyCowEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "textures/entity/mossy_cow_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MossyCowEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "animations/mossy_cow.animation.json");
    }
    @Override
    public void setCustomAnimations(MossyCowEntity animatable, long instanceId, AnimationState<MossyCowEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");
        if (head != null){
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }

}
