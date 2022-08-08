package net.draimcido.draimcreative.utils;

import org.bukkit.command.CommandSender;

public class Utils {

    // Отправка сообщения
    public static void sendMSG(CommandSender sender, String msg) { if (!msg.equalsIgnoreCase("")) sender.sendMessage(msg); }
}
