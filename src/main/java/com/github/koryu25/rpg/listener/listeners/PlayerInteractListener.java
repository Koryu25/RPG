package com.github.koryu25.rpg.listener.listeners;

import com.github.koryu25.rpg.Main;
import com.github.koryu25.rpg.adventurer.Adventurer;
import com.github.koryu25.rpg.adventurer.skill.SkillAction;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Adventurer adventurer = Main.getAdventurerFromPlayer(event.getPlayer());
        if (adventurer != null) {
            adventurer.inputToSkill(SkillAction.fromPlayerAction(event.getPlayer(), event.getAction()));
        }
    }
}