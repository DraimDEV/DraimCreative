package net.draimcido.draimcreative.utils;

import net.draimcido.draimcreative.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class Utils {

    /* --- Статик методы --- */
    // Отправка сообщения
    public static void sendMSG(CommandSender sender, String msg) { if (!msg.equalsIgnoreCase("")) sender.sendMessage(msg); }

    // Отправка ошибок в консоль
    public static void log(String msg) { Bukkit.getLogger().severe(msg); }

    /* --- Не статик методы --- */
    private final Main main;
    public Utils(Main main) { this.main = main; }
    private Main getMain() {return this.main;}


}
