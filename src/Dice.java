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
	
	public String getResult() {
		return String.format("The number rolled was %d.\n", rolledNumber);
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
	
	public String getStatistics() {
		int total = 0;
		for (int i : rollStatistics) {
			total += i;
		}
		
		// no need to print statistics if it was never rolled
		if(total == 0)
			return "Dice has not been rolled yet.\n";
		
		String stats = "--Dice Statistics--";
		for(int i = 0; i < rollStatistics.length; i++) {
			stats += String.format("%d was rolled %d times (%6.2f%%)\n", i + 1, rollStatistics[i], (float)rollStatistics[i] / (float)total * 100.0f);
		}
		
		return stats;
	}
	
}
