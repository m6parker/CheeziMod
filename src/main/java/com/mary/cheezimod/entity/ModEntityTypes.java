package com.mary.cheezimod.entity;

import com.mary.cheezimod.CheeziMod;
import com.mary.cheezimod.entity.custom.*;
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
    public static final RegistryObject<EntityType<LadybugEntity>> LADYBUG =
            ENTITY_TYPES.register("ladybug",
                    () -> EntityType.Builder.of(LadybugEntity::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f)
                            .build(new ResourceLocation(CheeziMod.MOD_ID, "ladybug").toString()));
    public static final RegistryObject<EntityType<StrawberryCowEntity>> STRAWBERRY_COW =
            ENTITY_TYPES.register("strawberry_cow",
                    () -> EntityType.Builder.of(StrawberryCowEntity::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f)
                            .build(new ResourceLocation(CheeziMod.MOD_ID, "strawberry_cow").toString()));
    public static final RegistryObject<EntityType<DairyCowEntity>> DAIRY_COW =
            ENTITY_TYPES.register("dairy_cow",
                    () -> EntityType.Builder.of(DairyCowEntity::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f)
                            .build(new ResourceLocation(CheeziMod.MOD_ID, "dairy_cow").toString()));
    public static final RegistryObject<EntityType<MossyCowEntity>> MOSSY_COW =
            ENTITY_TYPES.register("mossy_cow",
                    () -> EntityType.Builder.of(MossyCowEntity::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f)
                            .build(new ResourceLocation(CheeziMod.MOD_ID, "mossy_cow").toString()));
    public static final RegistryObject<EntityType<StrawberryChickenEntity>> STRAWBERRY_CHICKEN =
            ENTITY_TYPES.register("strawberry_chicken",
                    () -> EntityType.Builder.of(StrawberryChickenEntity::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f)
                            .build(new ResourceLocation(CheeziMod.MOD_ID, "strawberry_chicken").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
