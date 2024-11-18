package com.github.groundbreakingmc.hardcorehearts.listeners;

import com.github.retrooper.packetevents.event.PacketListener;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerJoinGame;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class PacketEventsListener implements PacketListener {

    @Override
    public void onPacketSend(final PacketSendEvent event) {
        if (event.getPacketType() == PacketType.Play.Server.JOIN_GAME) {
            final Player player = Bukkit.getPlayer(event.getUser().getUUID());
            if (player != null && player.hasPermission("hardcorehearts.see")) {
                this.sendHardcoreHearts(event);
            }
        }
    }

    private void sendHardcoreHearts(final PacketSendEvent event) {
        final WrapperPlayServerJoinGame wrapper = new WrapperPlayServerJoinGame(event);
        wrapper.setHardcore(true);
    }
}
