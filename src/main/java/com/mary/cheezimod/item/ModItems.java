package com.mary.cheezimod.item;

import com.mary.cheezimod.CheeziMod;
import com.mary.cheezimod.block.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CheeziMod.MOD_ID);

    // items
    public static final RegistryObject<Item> STRAWBERRY_SWORD = ITEMS.register("strawberry_sword",
            () -> new Item(new Item.Properties().stacksTo(1)));

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
    public static final RegistryObject<Item> STRAWBERRY_MILK = ITEMS.register("strawberry_milk",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY_MILK)));

    public static final RegistryObject<Item> CHOC_STRAWBERRY = ITEMS.register("choc_strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.CHOC_STRAWBERRY)));
    public static final RegistryObject<Item> AVOCADO = ITEMS.register("avocado",
            () -> new Item(new Item.Properties().food(ModFoods.AVOCADO)));
    public static final RegistryObject<Item> BASIL = ITEMS.register("basil",
            () -> new Item(new Item.Properties().food(ModFoods.BASIL)));
    public static final RegistryObject<Item> GRAPE = ITEMS.register("grape",
            () -> new Item(new Item.Properties().food(ModFoods.GRAPE)));
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().food(ModFoods.TOMATO)));

    public static final RegistryObject<Item> STRAWBERRY_SEEDS = ITEMS.register("strawberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> AVOCADO_SEEDS = ITEMS.register("avocado_seeds",
            () -> new ItemNameBlockItem(ModBlocks.AVOCADO_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> GRAPE_SEEDS = ITEMS.register("grape_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GRAPE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> BASIL_SEEDS = ITEMS.register("basil_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BASIL_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
