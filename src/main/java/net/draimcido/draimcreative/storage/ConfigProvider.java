package net.draimcido.draimcreative.storage;

import net.draimcido.draimcreative.Main;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class ConfigProvider {
    private Main main;
    private FileConfiguration config;
    private String name;

    public ConfigProvider(Main main, String name) {
        setMain(main);
        setName(name);

    }

    // Метод подгрузки конфига
    public void loadCFG() {
    }

    // Методы set и get
    public void setMain(Main main) { this.main = main; }
    public Main getMain() { return main; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
}
