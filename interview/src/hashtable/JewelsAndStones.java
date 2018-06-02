package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ryjarvis May 2, 2018
 * 
 */
// LeetCode #771s
public class JewelsAndStones {
	// straightforward solution
	public int numJewelsInStones(String J, String S) {
		Set<Character> set = new HashSet<>();
		for (char c : J.toCharArray()) {
			set.add(c);
		}
		int count = 0;
		for (char c : S.toCharArray()) {
			if (set.contains(c)) {
				count++;
			}
		}
		return count;

	}

	// better solution
	public int numJewelsInStonesOptimized(String J, String S) {
		boolean[]map=new boolean[52];
		int count=0;
		for(char c:J.toCharArray())map[charToInt(c)]=true;
		for(char c:S.toCharArray())if(map[charToInt(c)]) count++;
		return count;		
	}

	public int charToInt(char c) {
		if (c >= 'a' && c <= 'z')
			return c - 'a';
		return 26 + c - 'A';
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
