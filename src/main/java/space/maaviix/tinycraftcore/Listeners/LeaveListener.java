package space.maaviix.tinycraftcore.Listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import space.maaviix.tinycraftcore.TinyCraftCore;

public class LeaveListener implements Listener{
    Plugin plugin = TinyCraftCore.getInstance();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerQuitEvent e){
        Player player = e.getPlayer();
        String leaveMsg = plugin.getConfig().getConfigurationSection("Messages").getString("LeaveMsg").replace("{playerName}", player.getName());
        Component component = MiniMessage.miniMessage().deserialize(leaveMsg);

        e.quitMessage(null);
        Bukkit.getServer().broadcast(component);
    }
}
