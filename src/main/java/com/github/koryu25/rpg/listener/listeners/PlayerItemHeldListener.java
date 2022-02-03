package com.github.koryu25.rpg.listener.listeners;

import com.github.koryu25.rpg.Main;
import com.github.koryu25.rpg.adventurer.Adventurer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class PlayerItemHeldListener implements Listener {

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        // スキル宣言キャンセル
        Adventurer adventurer = Main.getAdventurerFromPlayer(event.getPlayer());
        if (adventurer == null) return;
        if (adventurer.getAdventurerSkill().getF()) {
            adventurer.onF();
        }
    }
}
