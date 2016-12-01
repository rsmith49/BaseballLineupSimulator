
public class Hitter {
	
	private float outs;
	
	private float singles;
	
	private float doubles;
	
	private float triples;
	
	private float hrs;
	
	public Hitter(float ab, float sin, float doub, float trip, float hr) {
		singles = sin/ab;
		doubles = doub/ab;
		triples = trip/ab;
		hrs = hr/ab;
		outs = 1 - singles - doubles - triples - hrs;
	}
	
	public int Hit(int randNum) {
		if (randNum < outs*SoftballGame.CHANCE) {
			return 0;
		}
		if (randNum < singles*SoftballGame.CHANCE) {
			return 1;
		}
		if (randNum < doubles*SoftballGame.CHANCE) {
			return 2;
		}
		if (randNum < triples*SoftballGame.CHANCE) {
			return 3;
		}
		else {
			return 4;
		}
	}
	
}
