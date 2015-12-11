package d20;

public class Die {
	
	private NumberGenerator numberGenerator = new NumberGenerator();
	private DieStringParser dieStringParser = new DieStringParser();
	private int numOfFaces;

	public int roll(String dieString) {
		
		this.numOfFaces = dieStringParser.getNumOfFaces();
		
		return numberGenerator.generateRandom(numOfFaces);
	}

}
