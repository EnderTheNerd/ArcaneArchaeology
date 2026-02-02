package net.ender.arcane_archaeology.networking.packets;

import net.ender.arcane_archaeology.ArcaneArchaeology;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public class AbilityPacket implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<AbilityPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(ArcaneArchaeology.MODID, "second_ability"));
    public static final StreamCodec<RegistryFriendlyByteBuf, AbilityPacket> STREAM_CODEC = CustomPacketPayload.codec(AbilityPacket::write, AbilityPacket::new);

    public AbilityPacket() {
    }

    public AbilityPacket(FriendlyByteBuf buf) {
    }

    public void write(FriendlyByteBuf buf) {
    }


    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }


}



