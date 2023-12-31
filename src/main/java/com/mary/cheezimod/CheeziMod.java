package com.mary.cheezimod;

import com.mary.cheezimod.block.ModBlocks;
import com.mary.cheezimod.entity.ModEntityTypes;
import com.mary.cheezimod.entity.client.*;
import com.mary.cheezimod.item.ModCreativeModeTabs;
import com.mary.cheezimod.item.ModItems;
import com.mary.cheezimod.loot.ModLootModifiers;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CheeziMod.MOD_ID)
public class CheeziMod {
    public static final String MOD_ID = "cheezimod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CheeziMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModEntityTypes.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS){
//            event.accept(ModItems.CHEDDAR_CHEESE);
//            event.accept(ModItems.STRAWBERRY);
//            event.accept(ModItems.CHOC_STRAWBERRY);
//            event.accept(ModBlocks.CHEDDAR_BLOCK.get());
//            event.accept(ModBlocks.STRAWBERRY_BLOCK.get());
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.MOUSE.get(), MouseRenderer::new);
            EntityRenderers.register(ModEntityTypes.LADYBUG.get(), LadybugRenderer::new);
            EntityRenderers.register(ModEntityTypes.STRAWBERRY_COW.get(), StrawberryCowRenderer::new);
            EntityRenderers.register(ModEntityTypes.DAIRY_COW.get(), DairyCowRenderer::new);
            EntityRenderers.register(ModEntityTypes.MOSSY_COW.get(), MossyCowRenderer::new);
            EntityRenderers.register(ModEntityTypes.STRAWBERRY_CHICKEN.get(), StrawberryChickenRenderer::new);
        }
    }
}
