package com.github.groundbreakingmc.hardcorehearts;

import com.github.groundbreakingmc.hardcorehearts.listeners.PacketEventsListener;
import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListenerCommon;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import org.bukkit.plugin.java.JavaPlugin;

public final class HardcoreHearts extends JavaPlugin {

    private PacketListenerCommon packetListener;

    @Override
    public void onEnable() {
        final PacketEventsListener listener = new PacketEventsListener();
        final PacketListenerPriority priority = PacketListenerPriority.LOWEST;
        this.packetListener = PacketEvents.getAPI().getEventManager().registerListener(listener, priority);
    }

    @Override
    public void onDisable() {
        PacketEvents.getAPI().getEventManager().unregisterListener(packetListener);
    }
}
