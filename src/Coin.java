import java.util.Random;

public class Coin {
	
	private Random rand;
	private CoinSides currentSide;
	
	public Coin() {
		rand = new Random();
		currentSide = CoinSides.HEADS;
	}
	
	public void flip() {
		currentSide = CoinSides.values()[rand.nextInt(CoinSides.values().length)];
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
}
