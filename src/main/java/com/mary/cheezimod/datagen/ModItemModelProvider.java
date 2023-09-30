package com.mary.cheezimod.datagen;

import com.mary.cheezimod.CheeziMod;
import com.mary.cheezimod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.units.qual.C;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CheeziMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.BRIE_CHEESE);
        simpleItem(ModItems.PARMESAN_CHEESE);
        simpleItem(ModItems.SWISS_CHEESE);
        simpleItem(ModItems.CHEDDAR_CHEESE);
        simpleItem(ModItems.MOZZARELLA_CHEESE);
        simpleItem(ModItems.STRAWBERRY);
        simpleItem(ModItems.CHOC_STRAWBERRY);
        simpleItem(ModItems.STRAWBERRY_MILK);
        simpleItem(ModItems.STRAWBERRY_SEEDS);
        simpleItem(ModItems.AVOCADO);
        simpleItem(ModItems.AVOCADO_SEEDS);
        simpleItem(ModItems.GRAPE);
        simpleItem(ModItems.GRAPE_SEEDS);
        simpleItem(ModItems.BASIL);
        simpleItem(ModItems.BASIL_SEEDS);
        simpleItem(ModItems.TOMATO);
        simpleItem(ModItems.TOMATO_SEEDS);
        withExistingParent(ModItems.MOUSE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
//        simpleItem(ModItems.STRAWBERRY_SWORD);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CheeziMod.MOD_ID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(CheeziMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CheeziMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}