package net.draimcido.draimcreative;

import java.util.Map;
import java.util.Map.Entry;

import net.draimcido.draimcreative.commands.MainCommand;
import net.draimcido.draimcreative.commands.SwitchCommand;
import net.draimcido.draimcreative.storage.ConfigProvider;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
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

    // Регистрация команд плагина
    private void registerCMDs() {
        // Рег команд
        for (Entry<String, Map<String, Object>> entry : getDescription().getCommands().entrySet()) {
            String name = entry.getKey();
            PluginCommand cmd = getCommand(name);

            if (cmd == null) { continue; }

        }
    }

    public CommandExecutor getExecutor(String name) {
        switch (name) {
        case "dcreative":
            return new MainCommand(this);
        default:
            return null;
        }
    }
}
