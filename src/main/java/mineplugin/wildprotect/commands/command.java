package mineplugin.wildprotect.commands;

import mineplugin.wildprotect.Wildprotect;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class command implements CommandExecutor {
    private static Wildprotect pl = Wildprotect.getPlugin(Wildprotect.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.isOp()) {
            if (args[0].equalsIgnoreCase("reload")) {
                pl.reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "Reload Complete");
            }else{
                sender.sendMessage(ChatColor.RED + "Please use : /wildprotect reload");
            }
        }
        return true;
    }
}
