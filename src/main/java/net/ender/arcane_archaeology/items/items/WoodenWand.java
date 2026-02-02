package net.ender.arcane_archaeology.items.items;

import net.ender.arcane_archaeology.registries.AAItemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WoodenWand extends Item {

    public WoodenWand() {
        super(new Item.Properties().attributes(SwordItem.createAttributes(Tiers.WOOD, 1, -1.2F)));
    }
    public static final int COOLDOWN = 20;
    public static final int ALT_COOLDOWN = 40;

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add(Component.translatable("item.arcane_archaeology.pretend_wand_ui").
                withStyle(ChatFormatting.ITALIC));

    }

    ;

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        level.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!level.isClientSide && !player.isShiftKeyDown()) {
            Snowball stick = new Snowball(level, player);
            stick.setItem(itemstack);
            stick.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(stick);
            player.getCooldowns().addCooldown(AAItemRegistry.PRETEND_WAND.get(), WoodenWand.COOLDOWN);
        }
        else if (!level.isClientSide && player.isShiftKeyDown()) {
            Snowball stick = new Snowball(level, player);
            stick.setItem(itemstack);
            stick.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 5F, 0F);
            level.addFreshEntity(stick);
            player.getCooldowns().addCooldown(AAItemRegistry.PRETEND_WAND.get(), WoodenWand.ALT_COOLDOWN);

        }


        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }

}
