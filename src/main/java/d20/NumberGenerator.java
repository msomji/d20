package d20;

import java.util.Random;

public class NumberGenerator {

	private int numOfDie;
	private int numOfFaces;
	private int negativeModifier;
	private int positiveModifier;
	private int minValue = 0;
	private Random random = new Random();
	private int sum;
	

	public int generateRandom(int numOfFaces, int numOfDie, int negativeModifier, int positiveModifier) {
		this.numOfFaces = numOfFaces;
		this.numOfDie = numOfDie;
		this.negativeModifier = negativeModifier;
		this.positiveModifier = positiveModifier;
		
		return total();
	}
	
	public int generateRandom(int numOfFaces, int numOfDie, int negativeModifier, int positiveModifier, int minValue) {
		this.minValue = minValue;
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
		sum += positiveModifier;
		sum -= negativeModifier;
		
		return Math.max(minValue, sum);
	}

	private void sumItterationalTotal() {
		sum += returnRandom(numOfFaces);
		numOfDie--;
	}
	
	public int returnRandom(int faces){
		return 1 + random.nextInt(faces);	
	}

}
