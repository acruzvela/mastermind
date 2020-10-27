package cruz;

import java.util.ArrayList;

public class Validation {
	public static boolean repeatedColor(String input) {
		ArrayList<String> testColors=new ArrayList<String>();
		for(int i=0;i<input.length();i++) {
			if(testColors.contains(input.substring(i, i+1))) {
				return true;
			}
			testColors.add(input.substring(i, i+1));
		}
		return false;
	}

}
