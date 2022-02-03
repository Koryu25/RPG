package com.github.koryu25.rpg.listener.listeners;

import com.github.koryu25.rpg.Main;
import com.github.koryu25.rpg.adventurer.Adventurer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Main.getInstance().getAllAdventurer().forEach(adventurer -> {
            if (adventurer.getPlayer().getUniqueId().toString().equals(event.getPlayer().getUniqueId().toString())) {
                return;
            }
        });
        Main.getInstance().getAllAdventurer().add(new Adventurer(event.getPlayer()));
    }
}