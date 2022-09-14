package me.masterbro.testerutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class DestroyEntityCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used in-game.");
            return true;
        }

        Player player = (Player) sender;

        if(args.length == 0) {
            player.sendMessage("Error: No arguments provided.");
            player.sendMessage("Correct usage: /destroyentity <worldName> <entityType>");
        } else {

            EntityType entityType = EntityType.valueOf(args[1]);

            String worldName = args[0];

            if(Bukkit.getWorld(worldName) == null) {
                player.sendMessage("Error: The world that was specified doesn't exist.");
                return true;
            }

            if(entityType == EntityType.PLAYER) {
                player.sendMessage("Error: You can't destroy an entity of type: PLAYER");
                return true;
            }

//            if(/** Check if entity type exists at all. **/) {
//                player.sendMessage("Error: The entity type that was specified doesn't exist.");
//                player.sendMessage("Please check the spelling and try again.");
//                return true;
//            }

            World world = Bukkit.getWorld(worldName);

            Integer entityCount = 0;

            List<Entity> entityList = new ArrayList<>(world.getEntitiesByClass(entityType.getEntityClass()));

            for(Entity entity : entityList) {
                entityCount += 1;
                entity.remove();
            }

            player.sendMessage("Destroyed " + entityCount + " entities of type: " + args[1] + " in " + args[0]);
            //entityCount = 0;
            return true;
        }
        return true;
    }
}
