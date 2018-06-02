package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryjarvis Feb 1, 2018
 * 
 */
// LeetCode #131
public class PalindromePartitioning {

	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> chosen = new ArrayList<>();
		helper(chosen, s, res, 0);
		return res;
	}

	public static void helper(List<String> chosen, String s, List<List<String>> res, int i) {
		if (i == s.length()) {
			// this is one way to copy and add
			List<String> copy = new ArrayList<>();
			copy.addAll(chosen);
			res.add(copy);
		}
		for (int j = i; j < s.length(); j++) {
			if (isPal(s.substring(i, j + 1))) {
				chosen.add(s.substring(i, j + 1));
				helper(chosen, s, res, j + 1);
				chosen.remove(chosen.size() - 1);
			}
		}
	}

	public static void helperOptimized(List<String> chosen, String s, List<List<String>> res, int i) {
		if (i == s.length()) {
			// this is the better way to copy and add

			res.add(new ArrayList(chosen));
		}
		for (int j = i; j < s.length(); j++) {
			if (isPal(s.substring(i, j + 1))) {
				chosen.add(s.substring(i, j + 1));
				helper(chosen, s, res, j + 1);
				chosen.remove(chosen.size() - 1);
			}
		}
	}

	public static boolean isPal(String s) {
		int l = s.length();
		int i = 0;
		int j = l - 1;
		while (j > i) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abba";
		List<List<String>> res = partition(s);

	}

}
