import java.util.Comparator;
import java.util.Map;
import java.util.UUID;

public class Vergleich implements Comparator <UUID> {
	Map<UUID, Integer> map;
	
	public Vergleich(Map<UUID, Integer> map){
		this.map = map;
	}
	
	public int compare(UUID a, UUID b){
		if(map.get(a) >= map.get(b)){
			return -1;
		}
		else{
			return 1;
		}
	}
}
