package net.draimcido.draimcreative;

import java.util.Map;
import java.util.Map.Entry;

import net.draimcido.draimcreative.commands.MainCommand;
import net.draimcido.draimcreative.storage.ConfigProvider;
import net.draimcido.draimcreative.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    // Включение/Отключение дебага.
    public static boolean DEBUG = false;
    public static boolean EXTRADEBUG = false;

    private Utils utils;

    public ConfigProvider cfg;
    public ConfigProvider messages;

    @Override
    public void onEnable() {
        loadConfig();
        registerListeners();
        registerCMDs();
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

        // Перезагрузка всех команд по типу, сообщения, альясы и прочее
        registerCMDs();
    }

    // Регистрация ивентов
    public void registerListeners() {
        // ...
    }

    // Регистрация команд плагина
    private void registerCMDs() {
        // Рег команд
        for (Entry<String, Map<String, Object>> entry : getDescription().getCommands().entrySet()) {
            String name = entry.getKey();
            PluginCommand cmd = getCommand(name);

            if (cmd == null) continue;

            cmd.setExecutor(getExecutor(name));
            cmd.setPermissionMessage(getMessages().getMSG("no-perm"));
            cmd.setDescription(getSettings().getMSG("commands." + name + ".description"));
            cmd.setUsage(getSettings().getMSG("commands." + name + ".usage"));
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

    /**
     * @return Settings provider
     */
    public ConfigProvider getSettings() { return this.cfg; }

    /**
     * @return Messages provider
     */
    public ConfigProvider getMessages() { return this.messages; }

    /**
     * @return DraimCreative plugin instance
     */
    public static Plugin getInstance() { return Bukkit.getPluginManager().getPlugin("DraimCreative"); }

    public Utils getUtils() { return utils; }
    public void setUtils(Utils utils) { this.utils = utils; }
}
