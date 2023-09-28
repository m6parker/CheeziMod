package com.mary.cheezimod.datagen;

import com.mary.cheezimod.CheeziMod;
import com.mary.cheezimod.block.ModBlocks;
import com.mary.cheezimod.block.custom.AvocadoCropBlock;
import com.mary.cheezimod.block.custom.BasilCropBlock;
import com.mary.cheezimod.block.custom.GrapeCropBlock;
import com.mary.cheezimod.block.custom.StrawberryCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CheeziMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CHEDDAR_BLOCK);
        blockWithItem(ModBlocks.STRAWBERRY_BLOCK);
        makeStrawberryCrop((CropBlock) ModBlocks.STRAWBERRY_CROP.get(), "strawberry_stage", "strawberry_stage");
        makeAvocadoCrop((CropBlock) ModBlocks.AVOCADO_CROP.get(), "avocado_stage", "avocado_stage");
        makeGrapeCrop((CropBlock) ModBlocks.GRAPE_CROP.get(), "grape_stage", "grape_stage");
        makeBasilCrop((CropBlock) ModBlocks.BASIL_CROP.get(), "basil_stage", "basil_stage");

    }

    public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
                new ResourceLocation(CheeziMod.MOD_ID, "block/" + textureName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeAvocadoCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> avocadoStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] avocadoStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((AvocadoCropBlock) block).getAgeProperty()),
                new ResourceLocation(CheeziMod.MOD_ID, "block/" + textureName + state.getValue(((AvocadoCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    public void makeGrapeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> grapeStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] grapeStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((GrapeCropBlock) block).getAgeProperty()),
                new ResourceLocation(CheeziMod.MOD_ID, "block/" + textureName + state.getValue(((GrapeCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    public void makeBasilCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> basilStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] basilStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((BasilCropBlock) block).getAgeProperty()),
                new ResourceLocation(CheeziMod.MOD_ID, "block/" + textureName + state.getValue(((BasilCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
