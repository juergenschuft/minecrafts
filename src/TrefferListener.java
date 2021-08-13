import java.util.HashMap;
import java.util.UUID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.projectiles.ProjectileSource;

public class TrefferListener implements Listener {
	HashMap<UUID, Integer> punktestand;
	
	public TrefferListener(HashMap<UUID, Integer> punktestand){
		this.punktestand = punktestand;
	}

	@EventHandler
	public void onEvent(EntityDamageByEntityEvent event){
		if(event.getCause() == DamageCause.PROJECTILE){
			Projectile projektil = (Projectile) event.getDamager();
			
			if(projektil.getType() == EntityType.SNOWBALL){
				ProjectileSource angreifer = projektil.getShooter();
				Entity angegriffener = event.getEntity();
				
				if((angreifer instanceof Player) && (angegriffener instanceof Player)){
					Player a1 = (Player) angreifer;
					Player a2 = (Player) angegriffener;
					
					if(punktestand.containsKey(a1.getUniqueId())){
						punktestand.put(a1.getUniqueId(), punktestand.get(a1.getUniqueId()) - 1);
					}
					else{
						punktestand.put(a1.getUniqueId(), 1);
					}
					
					if(punktestand.containsKey(a2.getUniqueId())){
						punktestand.put(a2.getUniqueId(), punktestand.get(a2.getUniqueId()) - 1);
					}
					else{
						punktestand.put(a2.getUniqueId(), - 1);
					}
					
					a1.sendMessage("Du hast jetzt " + punktestand.get(a1.getUniqueId()) + " Punkte.");
					a2.sendMessage("Du hast jetzt " + punktestand.get(a2.getUniqueId()) + " Punkte ");
				}
			}
		}
	}
}