import java.util.Random;

public class Coin {
	
	private Random rand;
	private CoinSides currentSide;
	private int[] sideStatistics;
	
	public Coin() {
		rand = new Random();
		currentSide = CoinSides.HEADS;
		sideStatistics = new int[2];
	}
	
	public void flip() {
		int randomSideIndex = rand.nextInt(CoinSides.values().length);
		currentSide = CoinSides.values()[randomSideIndex];
		sideStatistics[randomSideIndex] += 1;
	}
	
	public void printSide() {
		switch (currentSide) {
		case HEADS:
			System.out.println("The coin is on heads.");
			break;
		case TAILS:
			System.out.println("The coin is on tails.");
			break;
		}
	}
	
	public void printResults() {
		int totalRolls = sideStatistics[0] + sideStatistics[1];
		float headsPercent = (float)sideStatistics[0] / (float)totalRolls;
		float tailsPercent = (float)sideStatistics[1] / (float)totalRolls;
		
		System.out.println("--Coin Statistics--");
		System.out.printf("Rolled Heads %d times. (%6.2f%%)\n", sideStatistics[0], headsPercent * 100.0f);
		System.out.printf("Rolled Tails %d times. (%6.2f%%)\n", sideStatistics[1], tailsPercent * 100.0f);
	}
}
