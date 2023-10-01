package com.mary.cheezimod.event;

import com.mary.cheezimod.CheeziMod;
import com.mary.cheezimod.entity.ModEntityTypes;
import com.mary.cheezimod.entity.custom.LadybugEntity;
import com.mary.cheezimod.entity.custom.MouseEntity;
import com.mary.cheezimod.entity.custom.StrawberryCowEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CheeziMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event){
        event.put(ModEntityTypes.MOUSE.get(), MouseEntity.setAttributes());
        event.put(ModEntityTypes.LADYBUG.get(), LadybugEntity.setAttributes());
        event.put(ModEntityTypes.STRAWBERRY_COW.get(), StrawberryCowEntity.setAttributes());
    }

}
