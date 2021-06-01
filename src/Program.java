import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Coin coin = new Coin();
		Dice dice = new Dice();
		
		boolean quit = false;
		
		do {
			
			System.out.println(" Coin Flipper ");
			System.out.println("--------------");
			System.out.println("1. Flip Coin");
			System.out.println("2. Roll Dice");
			System.out.println("3. Print Statistics");
			System.out.println("4. Quit");
			
			switch(scan.nextInt()) {
			
			case 1: // flip coin
				coin.flip();
				coin.printSide();
				break;
				
			case 2: // roll dice
				dice.roll();
				dice.printResult();
				break;
				
			case 3: // print statistics
				coin.printStatistics();
				dice.printStatistics();
				break;
				
			case 4: // quit
				quit = true;
				break;
				
			default:
				System.out.println("Invalid input, please try again.");
				break;
				
			}
			
			System.out.println();
			
		} while (!quit);
		
		scan.close();
	}

}
