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
	
	public String getSide() {
		return String.format("The coin is on %s.\n", currentSide == CoinSides.HEADS ? "heads" : "Tails");
	}
	
	public String getStatistics() {
		int totalRolls = sideStatistics[0] + sideStatistics[1];
		
		if(totalRolls == 0)
			return "Coin has not been flipped";
		
		float headsPercent = (float)sideStatistics[0] / (float)totalRolls;
		float tailsPercent = (float)sideStatistics[1] / (float)totalRolls;
		
		String stats = "--Coin Statistics--\n";
		stats += String.format("Rolled Heads %d times. (%6.2f%%)\n", sideStatistics[0], headsPercent * 100.0f);
		stats += String.format("Rolled Tails %d times. (%6.2f%%)\n", sideStatistics[1], tailsPercent * 100.0f);
		
		return stats;
	}
}
