package d20;

import java.util.Random;

public class NumberGenerator {

	public int roll(int faces) {
		if (faces < 1){
			throw new IllegalArgumentException("faces should be greater than 1");
		}else {
			Random rand = new Random();
			int num = rand.nextInt(faces);
			
			return 1 + num;
		
		}
	}

}
