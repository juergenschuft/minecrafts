

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.*;

public class HalloServerPlugin extends JavaPlugin {
	public void onEnable() {
		this.getLogger().info("Moin!");
	}

	public void onDisable() {
	}

	public boolean onCommand(CommandSender sender, Command befehl, String befehlsName, String[] args) {
		Bukkit.broadcastMessage("Gute Nacht fetter " + args[0]);
		return true;
	}
}
