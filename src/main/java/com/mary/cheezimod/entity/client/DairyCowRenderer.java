package com.mary.cheezimod.entity.client;

import com.mary.cheezimod.CheeziMod;
import com.mary.cheezimod.entity.custom.DairyCowEntity;
import com.mary.cheezimod.entity.custom.StrawberryCowEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.CowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cow;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DairyCowRenderer extends GeoEntityRenderer<DairyCowEntity> {

    public DairyCowRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DairyCowModel());
    }
    @Override
    public ResourceLocation getTextureLocation(DairyCowEntity animatable) {
        return new ResourceLocation(CheeziMod.MOD_ID, "textures/entity/dairy_cow_texture.png");
    }

    @Override
    public void render(DairyCowEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()){
            poseStack.scale(0.4f,0.4f,0.4f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
