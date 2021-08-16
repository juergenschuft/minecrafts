import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected.Half;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.type.Bed;
import org.bukkit.block.data.type.Door;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class NotunterkunftPlugin extends JavaPlugin {
	public void onEnable(){
}

	public void onDisable(){
	}
	
	public boolean onCommand(CommandSender sender, Command befehl, String befehlsname, String[] args){
		if(sender instanceof Player){
			Player spieler = (Player) sender;
			World welt = spieler.getWorld();
			
			Location pos = spieler.getLocation();
			Location aussenQuaderPosition = new Location(welt, pos.getX()+4, pos.getY(), pos.getZ());
			Location innenQuaderPosition = new Location(welt, pos.getX()+5, pos.getY(), pos.getZ()+1);
			
			Quader aussen = new Quader(4, 10, 10, Material.BIRCH_PLANKS);
			Quader innen = new Quader(3, 8, 8, Material.AIR);
			
			aussen.bauen(spieler, aussenQuaderPosition);
			innen.bauen(spieler, innenQuaderPosition);
			
			pos = spieler.getLocation();
			pos.setX(pos.getX() + 9);
			
			//Tuer platzieren
			Block tuerUntenBlock = welt.getBlockAt(pos);
			tuerUntenBlock.setType(Material.OAK_DOOR);
			
			Door tuerUnten = (Door) tuerUntenBlock.getBlockData();
			tuerUnten.setHalf(Half.BOTTOM);
			tuerUnten.setFacing(BlockFace.NORTH);
			
			tuerUntenBlock.setBlockData(tuerUnten);
			
			Block tuerObenBlock = tuerUntenBlock.getRelative(BlockFace.UP);
			tuerObenBlock.setType(Material.OAK_DOOR, false);
			
			Door tuerOben = (Door) tuerObenBlock.getBlockData();
			tuerOben.setHalf(Half.TOP);
			tuerOben.setFacing(BlockFace.NORTH);
			
			tuerObenBlock.setBlockData(tuerOben);
			
			//Bett platzieren
			pos = spieler.getLocation();
			pos.setX(pos.getX() + 9);
			pos.setZ(pos.getZ() + 7);
			
			Block bettFussBlock = welt.getBlockAt(pos);
			bettFussBlock.setType(Material.ORANGE_BED);
			
			Bed bettFuss = (Bed) bettFussBlock.getBlockData();
			bettFuss.setPart(Bed.Part.FOOT);
			bettFuss.setFacing(BlockFace.SOUTH);
			
			bettFussBlock.setBlockData(bettFuss);
			
			Block bettKopfBlock = bettFussBlock.getRelative(BlockFace.SOUTH);
			bettKopfBlock.setType(Material.ORANGE_BED, false);
			
			Bed bettKopf = (Bed) bettKopfBlock.getBlockData();
			bettKopf.setPart(Bed.Part.HEAD);
			bettKopf.setFacing(BlockFace.SOUTH);
			
			bettKopfBlock.setBlockData(bettKopf);
			
			//Fackel platzieren
			pos.setY(pos.getY() + 2);
			pos.setZ(pos.getZ() + 1);
			
			Block fackelBlock = welt.getBlockAt(pos);
			fackelBlock.setType(Material.WALL_TORCH, false);
			
			Directional fackel = (Directional) fackelBlock.getBlockData();
			fackel.setFacing(BlockFace.NORTH);
			
			fackelBlock.setBlockData(fackel);
		}
		else{
			this.getLogger().info ("Dieser Befehl kann nur von Spielern ausgefuehrt werden.");
		}
		
		return true;
	}
}