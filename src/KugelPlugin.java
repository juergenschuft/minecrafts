import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.World;

public class KugelPlugin extends JavaPlugin {
	public void onEnabel(){
    }
	
	public void onDisable(){
	}
	
	public boolean onCommand(CommandSender sender, Command befehl, String befehlsname, String[] args){
		if(sender instanceof Player){
			Player spieler = (Player) sender;
			World welt = spieler.getWorld();
			Location position = spieler.getLocation();
			
			int r = Integer.valueOf(args[0]);
			
			int xStart = position.getBlockX();
			int yStart = position.getBlockY() + 20;
			int zStart = position.getBlockZ();
			
			for(int x = xStart - r; x <= xStart + r; x++){
				for(int y = yStart - r; y <= yStart + r; y++){
					for(int z = zStart - r; z <= zStart + r; z++){
						if((x-xStart)*(x-xStart)+(y-yStart)*(y-yStart)+(z-zStart)*(z-zStart) < r*r){
							position.setX(x);
							position.setY(y);
							position.setZ(z);
							welt.getBlockAt(position).setType(Material.OAK_PLANKS);
						}
					}
				}
			}
		}
		else{
			this.getLogger().info ("Dieser Befehl kann nur von Spielern ausgefuehrt werden");
		}
		
		return true;
	}
}