import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

class Quader extends Viereckig{
	private int tiefe;
	
	public Quader(int hoehe, int breite, int tiefe, Material material){
		super(hoehe, breite, material);
		this.tiefe = tiefe;
	}
	
	public void bauen(Player spieler, Location position){
		World welt = spieler.getWorld();
		
		double xStart = position.getX() + 2;
		double yStart = position.getY();
		double zStart = position.getZ();
		
		for(int x = 0; x < this.tiefe; x++){
			position.setX(xStart + x);
			
			for(int y = 0; y < this.hoehe; y++){
				position.setY(yStart + y);
				
				for(int z = 0; z < this.breite; z++){
					position.setZ(zStart + z);
					welt.getBlockAt(position).setType(this.material);
				}
			}
		}
	}
}