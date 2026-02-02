package net.ender.arcane_archaeology.registries;

import net.ender.arcane_archaeology.ArcaneArchaeology;
import net.ender.arcane_archaeology.items.items.WoodenWand;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;
import java.util.List;

public class AAItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ArcaneArchaeology.MODID);


    //ICE
    public static final DeferredItem<Item> PRETEND_WAND = ITEMS.register("wooden_wand",
            WoodenWand::new);

    public static Collection<DeferredHolder<Item, ? extends Item>> getItems() {
        return ITEMS.getEntries();
    }


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}