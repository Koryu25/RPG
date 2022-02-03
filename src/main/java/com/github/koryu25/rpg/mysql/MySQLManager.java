package com.github.koryu25.rpg.mysql;

import com.github.koryu25.rpg.Main;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLManager {

    private final Main main;

    private Connection connection;
    private final String host;
    private final int port;
    private final String database;
    private final String username;
    private final String password;

    public MySQLManager(Main main) {
        this.main = main;
        this.host = main.getMyConfig().getHost();
        this.port = main.getMyConfig().getPort();
        this.database = main.getMyConfig().getDatabase();
        this.username = main.getMyConfig().getUsername();
        this.password = main.getMyConfig().getPassword();
        if (!connectionTest()) {
            main.getLogger().severe("§cデータベースへの接続テストに失敗しました。サーバーを停止します。");
            Bukkit.shutdown();
        }
    }

    public Boolean connectionTest() {
        try {
            openConnection();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    private void openConnection() throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) return;
        synchronized (this) {
            if (connection != null && !connection.isClosed())return;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+ host +":"+ port +"/"+ database, username, password);
        }
    }
    public Connection getConnection() {
        return connection;
    }
}