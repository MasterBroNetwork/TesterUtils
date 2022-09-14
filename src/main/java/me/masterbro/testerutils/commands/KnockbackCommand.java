package me.masterbro.testerutils.commands;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KnockbackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used in-game.");
            return true;
        }

        Player player = (Player) sender;

        if(player.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).getBaseValue() == 1.0f) {
            player.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(0.0f);
            player.sendMessage("You will now receive knockback.");
        } else {
            player.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(1.0f);
            player.sendMessage("You will no-longer receive knockback.");
        }

        return true;
    }
}
