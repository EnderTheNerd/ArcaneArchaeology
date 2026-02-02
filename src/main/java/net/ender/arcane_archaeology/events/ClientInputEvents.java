package net.ender.arcane_archaeology.events;

import net.ender.arcane_archaeology.ArcaneArchaeology;
import net.ender.arcane_archaeology.networking.packets.AbilityPacket;
import net.ender.arcane_archaeology.util.Keybinding;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.ArrayList;

@EventBusSubscriber (modid = ArcaneArchaeology.MODID, value = Dist.CLIENT)
public class ClientInputEvents {
    private static final ArrayList<KeyState> KEY_STATES = new ArrayList<>();
    private static final KeyState ABILITY_KEY = register(Keybinding.SPELL_KEY);

    private static void handleInputEvent(int button, int action) {
        var minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null) {
            return;
        }

        if (ABILITY_KEY.wasPressed() && minecraft.screen == null) {
            PacketDistributor.sendToServer(new AbilityPacket());
        }

    }



    @SubscribeEvent
    public static void onMouseInput(InputEvent.MouseButton.Pre event) {
        handleInputEvent(event.getButton(), event.getAction());
    }


    private static KeyState register(KeyMapping key) {
        var k = new KeyState(key);
        KEY_STATES.add(k);
        return k;
    }
}
