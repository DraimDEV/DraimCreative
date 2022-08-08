package net.draimcido.draimcreative.commands;

import net.draimcido.draimcreative.Main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SwitchCommand implements CommandExecutor {

    private Main main;
    private GameMode gm;

    public SwitchCommand(Main pl, GameMode gm) {
        this.main = pl;
        this.gm = gm;
    }

    private Main getMain() {
        return this.main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        switch (args.length) {
            case 0:
                if (!(sender instanceof Player)) return false;

            Player p = (Player) sender;
        }

        return true;
    }
}
