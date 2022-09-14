package me.masterbro.testerutils;

import me.masterbro.testerutils.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/** This plugin was designed by MasterBro Network (MasterBroNetwork) under the MIT License.
    https://github.com/MasterBroNetwork/TesterUtils
    https://choosealicense.com/licenses/mit/

    You are free to remove this comment from the code if you want to.
    Credit isn't necessary but is appreciated. (Be sure to link the GitHub repository if you credit the original source.) **/

public final class TesterUtils extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        // Register command executors
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("health").setExecutor(new HealthCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("speed").setExecutor(new SpeedCommand());
        getCommand("armor").setExecutor(new ArmorCommand());
        getCommand("toggleknockback").setExecutor(new KnockbackCommand());
        getCommand("attackdamage").setExecutor(new AttackDamageCommand());
        getCommand("attackspeed").setExecutor(new AttackSpeedCommand());
        getCommand("destroyentity").setExecutor(new DestroyEntityCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Plugin disabled.");
    }
}
