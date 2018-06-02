package dynamicprogramming;

/**
 * @author: ryjarvis May 28, 2018
 * 
 */
// LeetCode #392
public class IsSubsequence {
	// O(n^2) the idea is similar to longest common subsequence if the length of
	// it similar to t then
	// we found a match if not then we don't have a match
	public boolean isSubsequence(String s, String t) {
		int n = s.length();
		int[] prev = new int[n + 1];
		for (char c : t.toCharArray()) {
			int[] mem = new int[n + 1];
			for (int i = 1; i < n + 1; i++) {
				if (c == s.charAt(i - 1) && prev[i - 1] + 1 > mem[i]) {
					mem[i] = prev[i - 1] + 1;
				} else {
					mem[i] = Math.max(mem[i - 1], prev[i]);
				}
			}
			prev = mem;
		}
		return prev[n] == n;
	}

	public boolean isSubsequenceOptimized(String s, String t) {
		for (int i = 0, pos = 0; i < s.length(); i++, pos++) {
			pos = t.indexOf(s.charAt(i), pos);
			if (pos == -1)
				return false;
		}
		return true;
	}

	public boolean isSubsequenceTwoPointer(String s, String t) {
		if (s.length() == 0)
			return true;
		int indexS = 0, indexT = 0;
		while (indexT < t.length()) {
			if (s.charAt(indexS) == t.charAt(indexT)) {
				indexS++;
				if (indexS == s.length()) {
					return true;
				}
			}
			indexT++;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
