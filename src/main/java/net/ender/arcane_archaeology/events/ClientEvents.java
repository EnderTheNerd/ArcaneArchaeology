package net.ender.arcane_archaeology.events;

import net.ender.arcane_archaeology.ArcaneArchaeology;
import net.ender.arcane_archaeology.util.Keybinding;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

import javax.swing.text.JTextComponent;

public class ClientEvents {
   @EventBusSubscriber(modid = ArcaneArchaeology.MODID, value = Dist.CLIENT)
    public static class ClientKeyPressed {
        @SubscribeEvent
       public static void onKeyRegister (RegisterKeyMappingsEvent event){
         event.register(Keybinding.SPELL_KEY);
        }

        @SubscribeEvent
        public static void onKeyInput (InputEvent.Key event){
         if (Keybinding.SPELL_KEY.consumeClick()){
             assert Minecraft.getInstance().player != null;
             Minecraft.getInstance().player.sendSystemMessage(Component.literal("I am pressing this key right now!!!"));
         }
        }
    }
}
