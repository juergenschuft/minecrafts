import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class MasterListener implements Listener {
    public void schneebaelleGeben(PlayerEvent event) {
    	Player spieler = event.getPlayer();
    	PlayerInventory inventar = spieler.getInventory();
    	
    	if(inventar.contains(Material.SNOWBALL)){
    		//Spieler hat bereits mindestens einen Schneeball
    		inventar.getItem(inventar.first(Material.SNOWBALL)).setAmount(16);
    		}
    	else {
    		//Spieler hat noch keinen Schneeball
    		if (inventar.firstEmpty() < 0 | inventar.firstEmpty() > 35) {
    			inventar.remove(inventar.getItem(0));
    		}
    		inventar.addItem(new ItemStack(Material.SNOWBALL, 16));
    	}
    }
}