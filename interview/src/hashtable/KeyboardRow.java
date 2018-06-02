package hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryjarvis May 28, 2018
 * 
 */
// LeetCode #500
public class KeyboardRow {

	public String[] findWords(String[] words) {
		String row1 = "qwertyuiopQWERTYUIOP";
		String row2 = "asdfghjklASDFGHJKL";
		String row3 = "zxcvbnmZXCVBNM";
		String chosen;
		List<String> list = new ArrayList<>();
		for (String s : words) {
			if (row1.indexOf(s.charAt(0)) >= 0) {
				chosen = row1;
			} else if (row2.indexOf(s.charAt(0)) >= 0) {
				chosen = row2;
			} else {
				chosen = row3;
			}
			if (isPossible(s, chosen)) {
				list.add(s);
			}
		}
		String[] ar = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ar[i] = list.get(i);
		}
		return ar;
	}

	public boolean isPossible(String s, String t) {
		for (int i = 1; i < s.length(); i++) {
			int pos = t.indexOf(s.charAt(i));
			if (pos == -1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
