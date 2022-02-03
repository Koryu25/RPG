package com.github.koryu25.rpg.yml;

import com.github.koryu25.rpg.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class MyConfig extends CustomConfig {

    // MySQL
    private String host;
    private int port;
    private String database;
    private String username;
    private String password;

    public MyConfig(Main main) {
        super(main, "config.yml");
        FileConfiguration config = getConfig();
        // MySQL
        host = config.getString("mysql.host");
        port = config.getInt("mysql.port");
        database = config.getString("mysql.database");
        username = config.getString("mysql.username");
        password = config.getString("mysql.password");
    }

    // Getter
    public String getHost() {
        return host;
    }
    public int getPort() {
        return port;
    }
    public String getDatabase() {
        return database;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}