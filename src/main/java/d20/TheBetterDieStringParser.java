package d20;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheBetterDieStringParser {
	private static final Pattern PATTERN = Pattern.compile("(?<numOfDie>\\d*)d(?<numOfFaces>\\d+)(?<modifier>[\\+-]\\d+)?");
	private int numOfFaces;
	private int numOfDie;
	private int modifier;

	public void setFields(String dieString) {
		Matcher matcher = parseString(dieString);
		
		numOfFaces = Integer.parseInt(matcher.group("numOfFaces"));
		numOfDie =  nullCheck(matcher, "numOfDie", 1); 
		modifier =  nullCheck(matcher, "modifier", 0);
	}

	private Matcher parseString(String dieString) {
		Matcher matcher = PATTERN.matcher(dieString);
		matcher.matches();
		return matcher;
	}

	private int nullCheck(Matcher matcher, String group, int defaultValue) {
		return matcher.group(group) == null ||  matcher.group(group).equals("") ? defaultValue : Integer.parseInt(matcher.group(group));
	}

	public int getNumOfFaces() {
		return numOfFaces;
	}
	
	public int getNumOfDie() {
		return numOfDie;
	}
	
	public int getModifier() {
		return modifier;
	}


}
