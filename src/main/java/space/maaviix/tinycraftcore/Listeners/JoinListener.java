package space.maaviix.tinycraftcore.Listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import space.maaviix.tinycraftcore.TinyCraftCore;

public class JoinListener implements Listener{
    Plugin plugin = TinyCraftCore.getInstance();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        String joinMsg = plugin.getConfig().getConfigurationSection("Messages").getString("JoinMsg").replace("{playerName}", player.getName());
        Component component = MiniMessage.miniMessage().deserialize(joinMsg);

        e.joinMessage(null);
        Bukkit.getServer().broadcast(component);
    }
}
