package competitions;

import java.util.Arrays;

/**
 * @author: ryjarvis
 * Nov 25, 2017
 * 
 */

public class Question602 {
	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length) {
			return false;
		}
		boolean ok;
		for (int i = 0; i < words1.length; i++) {
			ok=false;
			if (words1[i] .equals(words2[i])) {
				continue;
			}
			for(String[]s : pairs){
				if(s[0].equals(words1[i])&&s[1].equals(words2[i])){
					ok=true;
				}
				else if(s[0].equals(words2[i])&&s[1].equals(words1[i])){
					ok=true;
				}
			}
			if(ok==false){
				return false;
			}
		}
		return true;
	}
}


