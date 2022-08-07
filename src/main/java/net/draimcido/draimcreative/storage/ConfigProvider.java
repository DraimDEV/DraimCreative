package net.draimcido.draimcreative.storage;

import com.google.common.base.Charsets;
import net.draimcido.draimcreative.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConfigProvider {
    private Main main;
    private FileConfiguration config;
    private String name;

    public ConfigProvider(Main main, String name) {
        setMain(main);
        setName(name);

        loadCFG();
    }

    /*
    Конфигурация
     */

    // Получение сообщений
    public String getMSG(String path) { return ChatColor.translateAlternateColorCodes('&', getString(path)); }
    // Получение строк в конфиге
    public String getString(String path) { return getCFG().getString(path) == null ? "" : getCFG().getString(path);}
    // Получение значений в конфиге
    public int getInt(String path) { return getCFG().getInt(path); }
    // Проверка на включение параметров
    public boolean isEnabled(String path) { return getCFG().getBoolean(path); }
    // Получение списка строк в конфиге
    public List<String> getStringList(String path) { return getCFG().getStringList(path); }
    // Получение списка матерьялов в конфиге
    public List<Material> getMaterialList(String path) {
        List<Material> list = new ArrayList<>();

        for (String m : getCFG().getStringList(path)) {
            try {
                list.add(Material.valueOf(m));
            } catch (IllegalArgumentException e) {
                Bukkit.getLogger().info("Пропущен предмет:" + e.getMessage());
            }
        }
        return  list;
    }


    /*
    МЕТОДЫ
     */

    // Метод перезапуска конфигурации
    public void reload() { loadCFG(); }

    // Метод сохранения конфига
    public void saveCFG() {
        try {
            File f = new File(getMain().getDataFolder(), getName());
            getCFG().save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод подгрузки конфига
    public void loadCFG() {
        File f = new File(getMain().getDataFolder(), getName());

        // Если файл не найден
        if (!f.exists()) {
            f.getParentFile().mkdirs();
            getMain().saveResource(getName(), false);
        }

        YamlConfiguration cfg = new YamlConfiguration();

        try {
            cfg.load(f);

            InputStream stream = getMain().getResource(getName());
            InputStreamReader reader = new InputStreamReader(stream, Charsets.UTF_8);
            YamlConfiguration defaults = YamlConfiguration.loadConfiguration(reader);

            cfg.options().copyDefaults(true);
            cfg.setDefaults(defaults);

            cfg.save(f);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        setConfig(cfg);
    }

    // Методы set и get
    public void setMain(Main main) { this.main = main; }
    public Main getMain() { return main; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setConfig(FileConfiguration cfg) { this.config = cfg; }
    public FileConfiguration getCFG() { return config; }
}
