package string;

//LeetCode #14
public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		int i = 0;
		while (i < strs[0].length()) {
			if (!isPrefix(i,strs)) {
				break;
			}
			i++;
		}
		return strs[0].substring(0, i);

	}

	public static String longestCommonPrefixSuboptimal(String[] strs) {
		int idx = longestCommonPrefix(0, strs[0].length() - 1, strs);
		if (isPrefix(idx, strs)) {
			// System.out.println(strs[0].substring(0, idx));
			return strs[0].substring(0, idx);
		}
		return "";
	}

	public static boolean isPrefix(int j, String[] strs) {
		for (int i = 1; i < strs.length; i++) {

			if (j+1 > strs[i].length() || !strs[0].substring(0, j + 1).equals(strs[i].substring(0, j + 1))) {
				return false;
			}
		}
		return true;
	}

	public static int longestCommonPrefix(int lo, int hi, String[] str) {
		if (hi < lo) {
			return lo;
		}
		int mid = (lo + hi) % 2 == 0 ? ((lo + hi) / 2) : ((lo + hi + 1) / 2);
		if (isPrefix(lo, str)) {
			return longestCommonPrefix(mid, hi, str);
		} else {
			return longestCommonPrefix(lo, mid, str);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "aa", "a"};
		String res = longestCommonPrefix(strs);
		System.out.println(res);
	}

}
