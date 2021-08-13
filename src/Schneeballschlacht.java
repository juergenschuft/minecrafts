import java.util.HashMap;
import java.util.UUID;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Schneeballschlacht extends JavaPlugin {
	HashMap<UUID, Integer> punktestand;
	
	public void onEnable() {
		punktestand = new HashMap<UUID, Integer>();
		
		PluginManager pluginManager = this.getServer().getPluginManager();
		
		JoinListener joinListener = new JoinListener();
		pluginManager.registerEvents(joinListener, this);
		
		RespawnListener respawnListener = new RespawnListener();
		pluginManager.registerEvents(respawnListener, this);
		
		WurfListener wurfListener = new WurfListener();
		pluginManager.registerEvents(wurfListener, this);
		
		TrefferListener trefferListener = new TrefferListener(punktestand);
		pluginManager.registerEvents(trefferListener, this);
	}

	public void onDisable() {
	}
}