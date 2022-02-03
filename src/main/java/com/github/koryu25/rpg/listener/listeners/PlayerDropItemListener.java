package com.github.koryu25.rpg.listener.listeners;

import com.github.koryu25.rpg.Main;
import com.github.koryu25.rpg.adventurer.Adventurer;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDropItemListener implements Listener {

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (event.getPlayer().getGameMode() != GameMode.CREATIVE) {
            event.setCancelled(true);
        } else {
            Adventurer adventurer = Main.getAdventurerFromPlayer(event.getPlayer());
            if (adventurer == null) return;
            if (adventurer.getAdventurerSkill().getF()) {
                adventurer.onF();
            }
        }
    }
}
