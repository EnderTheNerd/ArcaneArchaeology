package net.ender.arcane_archaeology.registries;

import net.ender.arcane_archaeology.ArcaneArchaeology;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;

public class AAItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ArcaneArchaeology.MODID);


public static final DeferredItem<SwordItem> PRETEND_WAND = ITEMS.register("wooden_wand",
        () -> new SwordItem(Tiers.WOOD, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.WOOD, 1, -1.2F))));


    public static Collection<DeferredHolder<Item, ? extends Item>> getItems() {
        return ITEMS.getEntries();
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
