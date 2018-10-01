package dynamicprogramming;

//LeetCode #32
public class LongestValidParentheses {
	// LTE solution
	public static int longestValidParenthesesLTE(String s) {
		int n = s.length();
		int[][] mem = new int[n][n];
		int max = 0;
		for (int j = 0; j < n - 1; j++) {
			if (s.charAt(j) == '(' && s.charAt(j + 1) == ')') {
				mem[j][j + 1] = 2;
				max = 2;
			}
		}
		for (int i = 4; i <= n; i += 2) {
			for (int j = 0; j < n - 1; j++) {
				for (int k = 2; k < i; k += 2) {
					if (j + i - 1 < n && ((mem[j][j + k - 1] != 0 && mem[j + k][j + i - 1] != 0)
							|| (mem[j + 1][j + i - 2] != 0 && s.charAt(j) == '(' && s.charAt(j + i - 1) == ')'))) {
						max = Math.max(i, max);
						mem[j][j + i - 1] = i;
					}
				}

			}
		}
		return max;

	}
	
	//these types of questions are very tricky with edge cases
	public static int longestValidParentheses(String s) {
		int n = s.length();
		int[] mem = new int[n];
		int max = 0;
		int past;
		for (int i = 1; i < n; i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					past = i - 2 >= 0 ? mem[i - 2] : 0;
					mem[i] = past + 2;
				}

				else if (i - mem[i - 1] - 1 >= 0 &&s.charAt(i - mem[i - 1] - 1) == '(') {
					past=i-mem[i-1]-2>=0?mem[i-mem[i-1]-2]:0;
					mem[i] = mem[i - 1] + 2 + past;
				}
			}
			max = Math.max(mem[i], max);
		}
		return max;

	}

	public static void main(String[] args) {
		String s = "())";
		int count=longestValidParentheses(s);
		System.out.println(count);
		// TODO Auto-generated method stub

	}

}
