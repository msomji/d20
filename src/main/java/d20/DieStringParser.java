package d20;

public class DieStringParser {
	private int numOfFaces;
	private int numOfDie;
	private int negativeModifier;
	private int positiveModifier;
	private String afterD;
	private NumberGenerator numberGenerator = new NumberGenerator();
	
	public void rawString(String dieString) {
		this.numOfDie = dieString.split("[d]")[0].length() == 0  ? 1 : 
			Integer.parseInt(dieString.split("[d]")[0]);
		
		afterD = dieString.split("[d]")[1];

		if (afterD.contains("+")){
			setPositiveModifier(dieString);
		} else if (afterD.contains("-")){
			setNegativeModifier(dieString);
		} else {
			numOfFaces = dieString.split("d")[1].length() == 0  ? 1 : 
				Integer.parseInt(dieString.split("d")[1]);
		}
		numberGenerator.generateRandom(numOfFaces, numOfDie, negativeModifier, positiveModifier);
	}

	private void setNegativeModifier(String dieString) {
		negativeModifier = Integer.parseInt(dieString.split("[-]")[1]);
		setNumOfFaces(afterD, "[-]");
	}

	private void setPositiveModifier(String dieString) {
		positiveModifier = Integer.parseInt(dieString.split("[+]")[1]);
		setNumOfFaces(afterD, "[+]");
	}
	
	private void setNumOfFaces(String dieString, String sign) {
		numOfFaces = Integer.parseInt(dieString.split(sign)[0]);
	}
	
	public int getNegativeModifier() {
		return negativeModifier;
	}
	
	public int getPositiveModifier() {
		return positiveModifier;
	}
	public int getNumOfFaces() {
		return numOfFaces;
	}

	public int getNumOfDie() {
		return numOfDie;
	}

}
