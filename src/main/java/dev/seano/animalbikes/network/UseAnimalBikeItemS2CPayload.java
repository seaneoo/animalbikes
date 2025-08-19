package dev.seano.animalbikes.network;

import dev.seano.animalbikes.AnimalBikes;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record UseAnimalBikeItemS2CPayload() implements CustomPayload {

    public static final Identifier USE_ANIMAL_BIKE_ITEM_PAYLOAD = AnimalBikes.identifier("use_animal_bike_item");
    public static final CustomPayload.Id<UseAnimalBikeItemS2CPayload> ID = new CustomPayload.Id<>(
            USE_ANIMAL_BIKE_ITEM_PAYLOAD);
    public static final PacketCodec<RegistryByteBuf, UseAnimalBikeItemS2CPayload> CODEC = PacketCodec.unit(new UseAnimalBikeItemS2CPayload());

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
