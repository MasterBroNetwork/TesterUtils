package me.masterbro.testerutils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used in-game.");
            return true;
        }

        Player player = (Player) sender;

        if(player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.sendMessage("Flight disabled.");
        } else {
            player.setAllowFlight(true);
            player.sendMessage("Flight enabled.");
        }

        return true;
    }
}
