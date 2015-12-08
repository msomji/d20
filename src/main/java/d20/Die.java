package d20;

public class Die {

	
	private NumberGenerator number = new NumberGenerator();

	public int roll(int faces) {
		return number.roll(faces);
	}
	
	public int multiDie(int dieCount, int faces){
		int sum = 0;
		
		for (int i=0; i<dieCount; i++){
			sum += number.roll(faces);
		}
			
		return sum;
	}
//is there a way to have optional params instead of overloading?
	public int roll(int faces, int modifier) {
		return Math.max(0, roll(faces) + modifier);
	}

	public int rollWithMin(int faces, int modifier) {
		return Math.max(1, roll(faces) + modifier);
	}

}
