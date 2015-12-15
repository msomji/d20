package d20;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheBetterDieStringParser {
	private int numOfFaces;
	
	public int getNumOfFaces() {
		return numOfFaces;
	}

	public void setFields(String dieString) {
		Pattern pattern = Pattern.compile("d(<numOFFaces>)");
		
		Matcher matcher = pattern.matcher(dieString);
		matcher.matches();
		numOfFaces =Integer.parseInt(matcher.group("numOfFaces"));
	}

}
