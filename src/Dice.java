import java.util.Random;

public class Dice {
	
	private Random rand;
	private int rolledNumber;
	private int[] rollStatistics;
	
	public Dice() {
		rolledNumber = 1;
		rand = new Random();
		rollStatistics = new int[6];
	}
	
	public void roll() {
		int newSide = rand.nextInt(6);
		rolledNumber = newSide + 1;
		rollStatistics[newSide] += 1;
	}
	
	public void printResult() {
		System.out.printf("The number rolled was %d.\n", rolledNumber);
	}
	
	public void printStatistics() {
		
		int total = 0;
		for (int i : rollStatistics) {
			total += i;
		}
		
		// no need to print statistics if it was never rolled
		if(total == 0)
			return;
		
		System.out.println("--Dice Statistics--");
		for(int i = 0; i < rollStatistics.length; i++) {
			System.out.printf("%d was rolled %d times (%6.2f%%)\n", i + 1, rollStatistics[i], (float)rollStatistics[i] / (float)total * 100.0f);
		}
	}
	
}
