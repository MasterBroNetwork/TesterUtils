package me.masterbro.testerutils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used in-game.");
            return true;
        }

        Player player = (Player) sender;

        if(player.isInvulnerable()) {
            player.sendMessage("You are no-longer invulnerable.");
            player.setInvulnerable(false);
        } else {
            player.sendMessage("You are now invulnerable.");
            player.setInvulnerable(true);
        }

        return true;
    }
}
