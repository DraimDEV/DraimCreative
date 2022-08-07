package net.draimcido.draimcreative.commands;

import net.draimcido.draimcreative.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {
    private Main main;

    public MainCommand(Main pl) {
        this.main = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) return false;
    }
}
