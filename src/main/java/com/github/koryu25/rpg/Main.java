package com.github.koryu25.rpg;

import com.github.koryu25.rpg.adventurer.Adventurer;
import com.github.koryu25.rpg.adventurer.skill.skills.SkillListManager;
import com.github.koryu25.rpg.command.CommandManager;
import com.github.koryu25.rpg.listener.ListenerManager;
import com.github.koryu25.rpg.mysql.MySQLManager;
import com.github.koryu25.rpg.yml.MyConfig;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    private static Main main;

    private MyConfig config;
    private MySQLManager mysql;

    private SkillListManager skillListManager;// スキルマネジャー

    private ArrayList<Adventurer> allAdventurer = new ArrayList<>();// 冒険者のリスト

    @Override
    public void onEnable() {
        // instance
        main = this;

        // config
        config = new MyConfig(this);

        // mysql
        //mysql = new MySQLManager(this);

        // command
        new CommandManager(this);

        // listener
        new ListenerManager(this);

        // Skill
        skillListManager = new SkillListManager();
    }

    @Override
    public void onDisable() {
        // todo: update and save all data
    }

    // Getter
    public static Main getInstance() {
        return main;
    }

    public static Adventurer getAdventurerFromPlayer(Player player) {
        ArrayList<Adventurer> allAdventurer = main.allAdventurer;
        Adventurer adventurer = null;
        for (int i = 0; i < allAdventurer.size(); i++) {
            adventurer = allAdventurer.get(i);
            if (adventurer.getUUID().equals(player.getUniqueId().toString())) break;
        }
        return adventurer;
    }

    public MyConfig getMyConfig() {
        return config;
    }
    public MySQLManager getMysql() {
        return mysql;
    }
    public ArrayList<Adventurer> getAllAdventurer() {
        return allAdventurer;
    }
    public SkillListManager getSkillListManager() {
        return skillListManager;
    }
}
