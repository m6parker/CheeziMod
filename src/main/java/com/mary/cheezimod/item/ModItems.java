package com.mary.cheezimod.item;

import com.mary.cheezimod.CheeziMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CheeziMod.MOD_ID);
    public static final RegistryObject<Item> CHEDDAR_CHEESE = ITEMS.register("cheddar_cheese",
            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
//            () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
