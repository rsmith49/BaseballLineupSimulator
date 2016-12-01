import java.util.ArrayList;
import java.util.Random;


public class SoftballGame {
	private static final int SAC_FLY_CHANCE = 333;
	private static final int ERROR_CHANCE = 50;
	private static final int SCORE_FROM_SECOND_CHANCE = 500;
	private static final int SCORE_FROM_FIRST_CHANCE = 200;
	public static final int CHANCE = 1000;
	
	private int score = 0;
	private int ttlRuns = 0;
	
	private ArrayList<Hitter> hitters;
	
	private Random rand = new Random();
	
	private boolean[] bases = new boolean[3];
	
	private int inning = 1;
	
	private int outs = 0;
	
	public SoftballGame(ArrayList<Hitter> hitters) {
		this.hitters = hitters;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getTotalRuns() {
		return ttlRuns;
	}
	
	public ArrayList<Hitter> getHitters() {
		return hitters;
	}
	
	public int getInn() {
		return inning;
	}
	
	public int getOuts() {
		return outs;
	}
	
	public void setScore(int s) {
		score = s;
	}
	
	public void setHitters(ArrayList<Hitter> h) {
		hitters = h;
	}
	
	public void setInn(int i) {
		inning = i;
	}
	
	public void setOuts(int o) {
		outs = o;
	}
	
	// Important Methods
	public void playGame() {
		score = 0;
		int hitNum = 0;
		int tmpHit;
		while (inning < 8) {
			while (outs < 3) {
				tmpHit = hitters.get(hitNum++).Hit(rand.nextInt(CHANCE));
				if (tmpHit==0) {
					if (rand.nextInt(CHANCE) < ERROR_CHANCE) {
						tmpHit = 1;
					}
					else {
						if (outs < 2 && bases[2]) {
							if (rand.nextInt(CHANCE) < SAC_FLY_CHANCE) {
								score++;
								bases[2] = false;
							}
						}
						outs++;
					}
				}
				if (tmpHit==1) {
					if (bases[2]) {
						score++;
						bases[2] = false;
					}
					if (bases[1]) {
						if (rand.nextInt(CHANCE) < SCORE_FROM_SECOND_CHANCE) {
							score++;
							bases[1] = false;
						}
						else {
							bases[1] = false;
							bases[2] = true;
						}
					}
					if (bases[0]) {
						bases[0] = false;
						bases[1] = true;
					}
					bases[0] = true;
				}
				if (tmpHit==2) {
					if (bases[2]) {
						bases[2] = false;
						score++;
					}
					if (bases[1]) {
						bases[1] = false;
						score++;
					}
					if (bases[0]) {
						if (rand.nextInt(CHANCE) < SCORE_FROM_FIRST_CHANCE) {
							bases[0] = false;
							score++;
						}
						else {
							bases[0] = false;
							bases[2] = true;
						}
					}
					bases[1] = true;
				}
				if (tmpHit==3) {
					if (bases[2]) {
						bases[2] = false;
						score++;
					}
					if (bases[1]) {
						bases[1] = false;
						score++;
					}
					if (bases[0]) {
						bases[0] = false;
						score++;
					}
					bases[2] = true;
				}
				if (tmpHit==4) {
					if (bases[2]) {
						bases[2] = false;
						score++;
					}
					if (bases[1]) {
						bases[1] = false;
						score++;
					}
					if (bases[0]) {
						bases[0] = false;
						score++;
					}
					score++;
				}
				if (hitNum==hitters.size()) {
					hitNum = 0;
				}
			}
			outs = 0;
			for (int i=0;i<3;i++) {
				bases[i] = false;
			}
			inning++;
		}
		ttlRuns = ttlRuns+score;
		inning = 1;
	}
	
}
