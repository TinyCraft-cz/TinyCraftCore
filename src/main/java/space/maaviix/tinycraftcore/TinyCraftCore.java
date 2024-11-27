package space.maaviix.tinycraftcore;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import space.maaviix.tinycraftcore.Listeners.JoinListener;
import space.maaviix.tinycraftcore.Listeners.LeaveListener;

public final class TinyCraftCore extends JavaPlugin{
    private static TinyCraftCore instance;

    public static TinyCraftCore getInstance(){
        return instance;
    }

    @Override
    public void onEnable(){
        instance = this;

        getLogger().info("Plugin se zapíná...");
        saveDefaultConfig();
        this.loadListeners();

        getLogger().info("Plugin byl úspěšně zapnut!");
    }

    @Override
    public void onDisable(){
        getLogger().info("Plugin se vypíná...");
    }

    public void loadListeners(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new JoinListener(),this);
        pm.registerEvents(new LeaveListener(),this);
    }
}
