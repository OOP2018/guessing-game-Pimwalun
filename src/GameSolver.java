import java.util.Scanner;

/**
 * This class is play auto game.
 * 
 * @author Pimwalun Witchawanitchanun
 *
 */
public class GameSolver {
	
	/**Play a NumberGame and return the solution.
	 * The NumberGame object must provide messages (getMessage)
	 * containing the phrase "too small" if a guess is too small
	 * and "too large" if a guess is too large, for efficient
	 * solution.
	 * @param game is the NumberGame to solve.
	 * @return the number is equal to the secret number.
	 */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		String title = "Guessing Game";
		String prompt = "Your answer? ";
		System.out.println(game.getMessage());
		System.out.println(title);
		int guess = game.getUpperBound() / 2;
		int guess2 = game.getUpperBound() / 4;
		boolean correct = game.guess(guess);
		while (!correct) {
			if (game.getMessage().contains("too small")) {	
				System.out.print(prompt);
				guess = guess + guess2;
				System.out.println(guess);
			} else if (game.getMessage().contains("too large")) {
				System.out.print(prompt);
				guess = guess - guess2;
				System.out.println(guess);
			}
			if (guess2 != 1) {
				guess2 = guess2 / 2;
			}
			correct = game.guess(guess);
			System.out.println(game.getMessage());
		}
		return guess;
	}
}
