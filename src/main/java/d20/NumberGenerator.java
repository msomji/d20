package d20;

import java.util.Random;

public class NumberGenerator {

	private int numOfDie;
	private int numOfFaces;
	private int negativeModifier;
	private int positiveModifier;
	private int total;
	private Random random = new Random();
	

	public int generateRandom(int numOfFaces, int numOfDie, int negativeModifier, int positiveModifier) {
		
		this.numOfFaces = numOfFaces;
		this.numOfDie = numOfDie;
		this.negativeModifier = negativeModifier;
		this.positiveModifier = positiveModifier;
		return total();
	}

	public int total() {
//		for(int i = 0; i <=numOfDie; i++){
//			total += random(numOfFaces);
//			total += positiveModifier;
//			total-=negativeModifier;
//		}
//		return Math.max(0, total);
	}
	
	public int random(int faces){
		return 1 + random.nextInt(faces);	
	}

}
