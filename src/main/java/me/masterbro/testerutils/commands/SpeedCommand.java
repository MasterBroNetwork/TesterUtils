package me.masterbro.testerutils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand implements CommandExecutor {

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
                player.setFlySpeed(0.2f);
                player.setWalkSpeed(0.2f);
                player.sendMessage("Reset speed to 0.2f.");
            } else {
                String number = args[0];

                if(!(isFloat(number))) {
                    player.sendMessage("Error: The argument must be a float.");
                    return true;
                }

                if(Float.parseFloat(number) > 1) {
                    player.sendMessage("Error: Speed can only be set up to 1.0f.");
                    return true;
                }

                player.setFlySpeed(Float.parseFloat(number));
                player.setWalkSpeed(Float.parseFloat(number));
                player.sendMessage("Speed set to: " + number);
            }
        }

        return true;
    }
}
