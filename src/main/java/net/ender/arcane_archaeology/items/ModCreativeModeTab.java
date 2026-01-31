package net.ender.arcane_archaeology.items;

import net.ender.arcane_archaeology.ArcaneArchaeology;
import net.ender.arcane_archaeology.registries.AAItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModCreativeModeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
          DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ArcaneArchaeology.MODID);


    public static final Supplier<CreativeModeTab> MOD_ITEMS_TAB = CREATIVE_MODE_TAB.register("mod_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(AAItemRegistry.PRETEND_WAND.get()))
                    .title(Component.translatable("creative_tab.arcane_archeology_items"))

                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(AAItemRegistry.PRETEND_WAND);
                    })


                    .build());



    public static void register(IEventBus eventBus) {
      CREATIVE_MODE_TAB.register(eventBus);
  }

}
