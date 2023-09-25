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

    // items

    // foods
    public static final RegistryObject<Item> CHEDDAR_CHEESE = ITEMS.register("cheddar_cheese",
            () -> new Item(new Item.Properties().food(ModFoods.CHEDDAR_CHEESE)));
    public static final RegistryObject<Item> SWISS_CHEESE = ITEMS.register("swiss_cheese",
            () -> new Item(new Item.Properties().food(ModFoods.SWISS_CHEESE)));
    public static final RegistryObject<Item> BRIE_CHEESE = ITEMS.register("brie_cheese",
            () -> new Item(new Item.Properties().food(ModFoods.BRIE_CHEESE)));
    public static final RegistryObject<Item> PARMESAN_CHEESE  = ITEMS.register("parmesan_cheese",
            () -> new Item(new Item.Properties().food(ModFoods.PARMESAN_CHEESE)));
    public static final RegistryObject<Item> MOZZARELLA_CHEESE = ITEMS.register("mozzarella_cheese",
            () -> new Item(new Item.Properties().food(ModFoods.MOZZARELLA_CHEESE)));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
        () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

    public static final RegistryObject<Item> CHOC_STRAWBERRY = ITEMS.register("choc_strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.CHOC_STRAWBERRY)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
