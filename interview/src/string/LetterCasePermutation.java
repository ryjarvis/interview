package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryjarvis Apr 25, 2018
 * 
 */
// LeetCode #784
public class LetterCasePermutation {

	public static List<String> letterCasePermutation(String s) {
		List<String> res = new ArrayList<>();
		permute(s.toCharArray(), 0, res);
		return res;
	}

	public static void permute(char[] ar, int idx, List<String> res) {
		if (idx == ar.length) {
			res.add(String.valueOf(ar));
			return;
		}
		char c=ar[idx];
		permute(ar, idx + 1, res);
		
		if (ar[idx] - 'a' >= 0) {
			ar[idx] = (char) ((ar[idx] - 'a') + 'A');
			permute(ar, idx + 1, res);
		} else if (ar[idx] - 'A' >= 0&&ar[idx]-'a'<0) {
			ar[idx] = (char) ((ar[idx] - 'A') + 'a');
			permute(ar, idx + 1, res);
		}
		ar[idx]=c;
	

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a1b2";
		List<String> res = letterCasePermutation(s);

	}

}
