package com.mary.cheezimod.item;

import com.mary.cheezimod.CheeziMod;
import com.mary.cheezimod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CheeziMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CHEEZI_TAB = CREATIVE_MODE_TABS.register("cheezi_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CHEDDAR_CHEESE.get()))
                    .title(Component.translatable("creativetab.cheezi_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.CHEDDAR_CHEESE.get());
                        pOutput.accept(ModItems.SWISS_CHEESE.get());
                        pOutput.accept(ModItems.BRIE_CHEESE.get());
                        pOutput.accept(ModItems.PARMESAN_CHEESE.get());
                        pOutput.accept(ModItems.MOZZARELLA_CHEESE.get());


                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.CHOC_STRAWBERRY.get());
                        pOutput.accept(ModItems.STRAWBERRY_MILK.get());
                        pOutput.accept(ModItems.STRAWBERRY_SEEDS.get());
                        pOutput.accept(ModItems.STRAWBERRY_SWORD.get());
                        pOutput.accept(ModItems.AVOCADO.get());
                        pOutput.accept(ModItems.AVOCADO_SEEDS.get());
                        pOutput.accept(ModItems.GRAPE.get());
                        pOutput.accept(ModItems.GRAPE_SEEDS.get());
                        pOutput.accept(ModItems.BASIL.get());
                        pOutput.accept(ModItems.BASIL_SEEDS.get());
                        pOutput.accept(ModItems.TOMATO.get());
                        pOutput.accept(ModItems.TOMATO_SEEDS.get());

//                        pOutput.accept(Items.DIAMOND);

                        pOutput.accept(ModBlocks.CHEDDAR_BLOCK.get());
                        pOutput.accept(ModBlocks.STRAWBERRY_BLOCK.get());

                        pOutput.accept(ModItems.MOUSE_SPAWN_EGG.get());
                        pOutput.accept(ModItems.LADYBUG_SPAWN_EGG.get());
                        pOutput.accept(ModItems.STRAWBERRY_COW_SPAWN_EGG.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
