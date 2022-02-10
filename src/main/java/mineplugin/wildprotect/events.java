package mineplugin.wildprotect;

import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import dev.espi.protectionstones.PSRegion;
import dev.espi.protectionstones.ProtectionStones;
import io.papermc.paper.event.block.BlockBreakBlockEvent;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.List;

public class events implements Listener {
    private static Wildprotect pl = Wildprotect.getPlugin(Wildprotect.class);
    public static List<String> blacklistworld = null;

    @EventHandler
    public static void onPlace(BlockPlaceEvent event){
        if (event.getPlayer() != null) {
            Player p = event.getPlayer();
            Block block = event.getBlock();
            blacklistworld = (List<String>) pl.getConfig().getList("blacklist-world");
            if (!(blacklistworld.isEmpty())){
                for (int i = 0; i < blacklistworld.size(); i++) {
                    if (p.getWorld().getName().equalsIgnoreCase(blacklistworld.get(i))){
                        return;
                    }
                }
            }
            if (p.isOp()) { return; }
            PSRegion r1 = PSRegion.fromLocation(p.getLocation());
            if (r1 == null) {
                if (!ProtectionStones.isProtectBlockType(block)) {
                    event.setCancelled(true);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',pl.getConfig().getString("deny-message")));
                }
            }
        }
    }

    @EventHandler
    public static void onBreak(BlockBreakEvent event){
        if (event.getPlayer() != null) {
            Player p = event.getPlayer();
            blacklistworld = (List<String>) pl.getConfig().getList("blacklist-world");
            if (!(blacklistworld.isEmpty())){
                for (int i = 0; i < blacklistworld.size(); i++) {
                    if (p.getWorld().getName().equalsIgnoreCase(blacklistworld.get(i))){
                        return;
                    }
                }
            }
            if (p.isOp()) { return; }
            PSRegion r1 = PSRegion.fromLocation(p.getLocation());
            if (r1 == null) {
                event.setCancelled(true);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&',pl.getConfig().getString("deny-message")));
            }
        }
    }

}
