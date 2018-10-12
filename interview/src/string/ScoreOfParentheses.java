package string;

/**
 * @author: ryjarvis Oct 12, 2018
 * 
 */
// LeetCode #856
public class ScoreOfParentheses {
	
	public int scoreOfParentheses(String s) {
		if (s.length() == 0) {
			return 0;
		}
		if (s.length() == 2) {
			return 1;
		}
		int i = 1;
		int count = 1;
		while (count != 0) {
			if (s.charAt(i) == ')') {
				count--;
			} else {
				count++;
			}
			i++;
		}
		if (i == s.length()) {
			return 2 * (scoreOfParentheses(s.substring(1, s.length() - 1)));
		}
		return scoreOfParentheses(s.substring(0, i)) + scoreOfParentheses(s.substring(i, s.length()));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
