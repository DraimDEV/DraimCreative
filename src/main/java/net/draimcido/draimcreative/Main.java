package net.draimcido.draimcreative;

import net.draimcido.draimcreative.storage.ConfigProvider;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    // Включение/Отключение дебага.
    public static boolean DEBUG = false;
    public static boolean EXTRADEBUG = false;

    public ConfigProvider cfg;
    public ConfigProvider messages;

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    // Создание config.yml и messages.yml в папке плагина
    public void loadConfig() {
        this.cfg = new ConfigProvider(this, "config.yml");
        this.messages = new ConfigProvider(this, "messages.yml");
    }

    // Перезапуск конфига и сообщений
    public void reloadConfigs() {
        this.cfg.reload();
        this.messages.reload();
    }

}
