import java.util.Random;

public class Dice {
	
	private Random rand;
	private int rolledNumber;
	
	public Dice() {
		rolledNumber = 1;
		rand = new Random();
	}
	
	public void roll() {
		rolledNumber = rand.nextInt(6) + 1;
	}
	
	public void printResult() {
		System.out.printf("The number rolled was %d.\n", rolledNumber);
	}
	
}
