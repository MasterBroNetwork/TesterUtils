package me.masterbro.testerutils.commands;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AttackDamageCommand implements CommandExecutor {

    private static boolean isDouble(String string) {
        try {
            Double.parseDouble(string);
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
                player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1.0f);
                player.sendMessage("Reset base attack damage attribute to 1.0f.");
            } else {
                String number = args[0];

                if(!(isDouble(number))) {
                    player.sendMessage("Error: The argument must be a number.");
                    return true;
                }

                if(Double.parseDouble(number) > 2048) {
                    player.sendMessage("Error: Attack damage can only be set up to 2048.0.");
                    return true;
                }

                player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(Double.parseDouble(number));
                player.sendMessage("Attack damage set to: " + number);
            }
        }

        return true;
    }
}
