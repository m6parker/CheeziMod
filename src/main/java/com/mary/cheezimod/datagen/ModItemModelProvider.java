package com.mary.cheezimod.datagen;

import com.mary.cheezimod.CheeziMod;
import com.mary.cheezimod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

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
//        simpleItem(ModItems.STRAWBERRY_SWORD);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CheeziMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}