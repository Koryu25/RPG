package com.github.koryu25.rpg.listener;

import com.github.koryu25.rpg.Main;
import com.github.koryu25.rpg.listener.listeners.*;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class ListenerManager {

    private final Main main;

    public ListenerManager(Main main) {
        this.main = main;

        List<Listener> list = new ArrayList<>();
        // Player
        list.add(new PlayerDropItemListener());
        list.add(new PlayerInteractListener());
        list.add(new PlayerItemHeldListener());
        list.add(new PlayerJoinListener());
        list.add(new PlayerSwapHandItemsListener());
        list.forEach(listener -> main.getServer().getPluginManager().registerEvents(listener, main));
    }
}
