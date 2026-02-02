package net.ender.arcane_archaeology.items;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

import java.util.Random;

public class ArtifactItem extends Item {
    protected static final Random random = new Random();
    protected boolean isPlaceholder;

    //BASED ON ENIGMATIC LEGACY's ITEM BASE
    public ArtifactItem() {
        this(ArtifactItem.getDefaultProperties());
    }

    public ArtifactItem(Properties props) {
        super(props);
        this.isPlaceholder = false;
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {

    }



    public static Properties getDefaultProperties() {
        Properties props = new Item.Properties();

        props.stacksTo(64);
        props.rarity(Rarity.COMMON);

        return props;
    }


    public Item setPlaceholder() {
        this.isPlaceholder = true;
        return this;
    }

    public boolean isPlaceholder() {
        return this.isPlaceholder;
    }


}
