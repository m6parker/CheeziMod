package com.mary.cheezimod.entity;

import com.mary.cheezimod.CheeziMod;
import com.mary.cheezimod.entity.custom.MouseEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CheeziMod.MOD_ID);

    public static final RegistryObject<EntityType<MouseEntity>> MOUSE =
            ENTITY_TYPES.register("mouse",
                    () -> EntityType.Builder.of(MouseEntity::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f)
                            .build(new ResourceLocation(CheeziMod.MOD_ID, "mouse").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
