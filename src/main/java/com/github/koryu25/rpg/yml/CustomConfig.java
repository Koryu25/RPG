package com.github.koryu25.rpg.yml;

import com.github.koryu25.rpg.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;

public class CustomConfig {

    private final Main main;
    private FileConfiguration config = null;
    private final File configFile;
    private final String fileName;

    public CustomConfig(Main main, String fileName) {
        this.main = main;
        this.fileName = fileName;
        this.configFile = new File(main.getDataFolder(), fileName);
        saveDefaultConfig();
        reloadConfig();
    }
    // ファイルが存在しなかったらデフォルト値を保存する
    public void saveDefaultConfig() {
        if (!configFile.exists()) {
            main.saveResource(fileName, false);
        }
    }
    // ファイルを取得する
    public FileConfiguration getConfig() {
        if (config == null) {
            reloadConfig();
        }
        return config;
    }
    // ファイルを保存する
    public void saveConfig() {
        if (config == null) return;
        try {
            getConfig().save(configFile);
        } catch (IOException ex) {
            main.getLogger().log(Level.SEVERE, "Could not save config to " + configFile, ex);
        }
    }
    // ファイルをロードする
    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
        final InputStream defConfigStream = main.getResource(fileName);
        if (defConfigStream == null) return;
        config.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, StandardCharsets.UTF_8)));
    }
}