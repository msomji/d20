package d20;

import java.util.Random;

public class NumberGenerator {

	private int numOfDie;
	private int numOfFaces;
	private int negativeModifier;
	private int positiveModifier;
	private Random random = new Random();
	private int sum;
	

	public int generateRandom(int numOfFaces, int numOfDie, int negativeModifier, int positiveModifier) {
		this.numOfFaces = numOfFaces;
		this.numOfDie = numOfDie;
		this.negativeModifier = negativeModifier;
		this.positiveModifier = positiveModifier;
		return total();
	}

	public int total() {
		while(numOfDie > 0){
			sumItterationalTotal();
		}
		return Math.max(0, sum);
	}

	private void sumItterationalTotal() {
		sum += returnRandom(numOfFaces);
		sum -= negativeModifier;
		sum += positiveModifier;
		numOfDie--;
	}
	
	public int returnRandom(int faces){
		return 1 + random.nextInt(faces);	
	}

}
