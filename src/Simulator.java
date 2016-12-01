import java.util.ArrayList;

public class Simulator {
	
	public static final Hitter Kinsey = new Hitter(16,7,0,0,0);
	public static final Hitter Curtis = new Hitter(12,5,0,0,1);
	public static final Hitter Logsdon = new Hitter(15,5,1,1,1);
	public static final Hitter Borglin = new Hitter(13,5,1,1,1);
	public static final Hitter Jim = new Hitter(11,7,0,0,0);
	public static final Hitter Mitch = new Hitter(11,4,0,0,0);
	public static final Hitter Chad = new Hitter(14,4,0,1,0);
	public static final Hitter Joey = new Hitter(14,6,0,0,1);
	public static final Hitter Smith = new Hitter(14,6,1,1,0);
	public static final Hitter Justin = new Hitter(9,3,0,0,1);
	public static final Hitter Sergio = new Hitter(10,3,3,0,0);
	public static final Hitter Josh = new Hitter(11,7,0,0,0);
	
	public static void main(String[] args) {
		ArrayList<Hitter> battingOrder = new ArrayList<Hitter>();
		
		battingOrder.add(Jim);
		battingOrder.add(Smith);
		battingOrder.add(Curtis);
		battingOrder.add(Logsdon);
		battingOrder.add(Borglin);
		battingOrder.add(Sergio);
		battingOrder.add(Josh);
		battingOrder.add(Mitch);
		battingOrder.add(Kinsey);
		battingOrder.add(Chad);
		battingOrder.add(Joey);
		battingOrder.add(Justin);
		
		SoftballGame game1 = new SoftballGame(battingOrder);
		for (int i=0;i<10000;i++) {
			game1.playGame();
		}
		System.out.println(game1.getTotalRuns()*1.0/10000.0);
	}
	
}
