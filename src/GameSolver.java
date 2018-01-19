
/**
 * Automatically find the secret to any NumberGame.
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
		int min,max,guess,guess2,lastguess;
		min = 1;
		max = game.getUpperBound();
		guess = min + (max - min)/2;
		guess2 = guess/2;
		boolean correct = game.guess(guess);
		while (!correct){
			lastguess = guess;
			if (game.getMessage().contains("too small")) {	
				guess = guess + guess2;
			} else if (game.getMessage().contains("too large")) {
				guess = guess - guess2;
			}
			if (guess2 > 1) {
				guess2 /= 2;
			}
			if (lastguess == guess){
				guess++;
			}
			correct = game.guess(guess);
		}
		return guess;
	}
}
