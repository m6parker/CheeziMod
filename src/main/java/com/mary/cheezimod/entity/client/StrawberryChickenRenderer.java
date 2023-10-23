package com.mary.cheezimod.entity.client;

import com.mary.cheezimod.CheeziMod;
import com.mary.cheezimod.entity.custom.MouseEntity;
import com.mary.cheezimod.entity.custom.StrawberryChickenEntity;
import com.mary.cheezimod.entity.custom.StrawberryCowEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class StrawberryChickenRenderer extends GeoEntityRenderer<StrawberryChickenEntity> {
    public StrawberryChickenRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new StrawberryChickenModel());
    }
    @Override
    public ResourceLocation getTextureLocation(StrawberryChickenEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "textures/entity/strawberry_chicken_texture.png");
    }

    @Override
    public void render(StrawberryChickenEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()){
            poseStack.scale(0.4f,0.4f,0.4f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
