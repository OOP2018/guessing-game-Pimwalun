package guessinggame;
import java.util.Random;

/**
 * This class is Guessing secret number
 * 
 * @author Pimwalun Witchawanitchanun
 *
 */
public class PimwalunGame extends NumberGame {
	private int upperBound;
	private int secret;
	private int count;

	/**
	 * Initialize a new game
	 * @param upperBound is the max value for the secret number (>1).
	 */
	public PimwalunGame(int upperBound) {
		this.upperBound = upperBound;
		long seed = System.nanoTime();
		Random rand = new Random(seed);
		this.secret = rand.nextInt(upperBound) + 1;
		setMessage("I'm thinking of a number between 1 and " + upperBound);
	}

	/**
	 * Create evaluation a guess.
	 * @param number is the number from guessing
	 * @return evaluation a guess
	 */
	@Override
	public boolean guess(int number) {
		this.count++;
		if (number == this.secret) {
			setChanged();
			notifyObservers(number);
			setMessage("Right! The secret number is " + this.secret);
			return true;
		} else if (number < this.secret) {
			setMessage("too small");
		} else if (number > this.secret){
			setMessage("too large");
		}
		setChanged();
		notifyObservers(number);
		return false;
	}

	/**
	 * Get max number.
	 * @return max number.
	 */
	public int getUpperBound() {
		return this.upperBound;
	}

	/** 
	 *Return a string representation of this Game. 
	 *@return a string representation of this Game.
	 */
	@Override
	public String toString() {
		return "Guess a secret number between 1 and " + this.upperBound;
	}
	
	/**
	 * Return the recent count.
	 * @return the recent count.
	 */
	public int getCount(){
		return this.count;
	}
	
}
