package com.github.koryu25.rpg.listener.listeners;

import com.github.koryu25.rpg.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class PlayerSwapHandItemsListener implements Listener {

    @EventHandler
    public void onPlayerSwapHandItems(PlayerSwapHandItemsEvent event) {
        event.setCancelled(true);
        Main.getAdventurerFromPlayer(event.getPlayer()).onF();
    }
}