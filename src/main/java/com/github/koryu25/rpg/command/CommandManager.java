package com.github.koryu25.rpg.command;

import com.github.koryu25.rpg.Main;
import com.github.koryu25.rpg.command.commands.Test;
import org.bukkit.command.CommandExecutor;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private final Main main;

    public CommandManager(Main main) {
        this.main = main;

        main.getCommand("test").setExecutor(new Test());
    }
}