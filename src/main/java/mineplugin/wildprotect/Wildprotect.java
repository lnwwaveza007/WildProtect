package mineplugin.wildprotect;

import mineplugin.wildprotect.commands.command;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Wildprotect extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "=====================================================");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "              WildProtect just started!");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "                  Version : 1.0");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "=====================================================");
        // Commands
        getCommand("wildprotect").setExecutor(new command());
        // Event
        getServer().getPluginManager().registerEvents(new events(), this);
        // Configs
        this.getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "=====================================================");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "              WildProtect just stopped!");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "                  Version : 1.0");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "=====================================================");
    }
}
