package me.masterbro.testerutils.commands;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArmorCommand implements CommandExecutor {

    private static boolean isFloat(String string) {
        try {
            Float.parseFloat(string);
        } catch(NumberFormatException exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used in-game.");
            return true;
        } else {
            Player player = (Player) sender;
            if(args.length == 0) {
                player.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(0.0f);
                player.sendMessage("Reset base armor attribute to 0.0f.");
            } else {
                String number = args[0];

                if(!(isFloat(number))) {
                    player.sendMessage("Error: The argument must be a float.");
                    return true;
                }

                if(Float.parseFloat(number) > 30) {
                    player.sendMessage("Error: Armor can only be set up to 30.0f.");
                    return true;
                }

                player.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(Double.parseDouble(number));
                player.sendMessage("Armor set to: " + number);
            }
        }

        return true;
    }
}
