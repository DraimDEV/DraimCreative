package net.draimcido.draimcreative.storage;

import net.draimcido.draimcreative.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigProvider {
    private Main main;
    private FileConfiguration config;
    private String name;

    public ConfigProvider(Main main, String name) {

    }

    // Методы set
    public void setMain(Main main) {
        this.main = main;
    }

    public void setName(String name) {
        this.name = name;
    }
}
