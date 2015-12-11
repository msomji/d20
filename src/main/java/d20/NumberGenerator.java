package d20;

import java.util.Random;

public class NumberGenerator {
	

	public int generateRandom(int numOfFaces) {
		
		Random rand = new Random();
		int num = rand.nextInt(numOfFaces);
		
		return 1 + num;	
	}

}
