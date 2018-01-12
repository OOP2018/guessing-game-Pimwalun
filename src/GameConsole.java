import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 */
public class GameConsole {

	/** play the game. */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		String title = "Guessing Game";
		String prompt = "Your answer? ";
		System.out.println(game.getMessage());
		System.out.println(title);
		System.out.print(prompt);
		int guess = console.nextInt();
		// describe the game
		
		// This is just an example.
		boolean correct = game.guess(guess);
		while(!correct){
			System.out.println(game.getMessage());
			System.out.print(prompt);
			guess = console.nextInt();
			correct = game.guess(guess);
		}
		return guess;
	}
}
