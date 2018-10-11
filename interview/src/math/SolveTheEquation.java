package math;

//learn this https://www.rexegg.com/regex-lookarounds.html
//positive lookahead can be used here to split the string and then we can
//follow super easy

//LeetCode #640
public class SolveTheEquation {
	public String solveEquation(String eq) {
		int j = eq.indexOf('=');
		int[] left = helper(0, j, eq);
		int[] right = helper(j + 1, eq.length(), eq);
		int x = left[1] - right[1];
		int num = right[0] - left[0];
		if (x == 0) {
			if (num == 0) {
				return "Infinite solutions";
			} else {
				return "No solution";
			}
		}
		int ans = num / x;
		return "x=" + ans;

	}

	public int[] helper(int i, int j, String eq) {
		int num = 0;
		int x = 0;
		boolean pos = eq.charAt(i) == '-' ? false : true;
		if (!pos) {
			i++;
		}
		int val = 0;
		while (i < j) {
			int next = Math.min(
					Math.min(eq.indexOf('+', i) == -1 ? Integer.MAX_VALUE : eq.indexOf('+', i),
							eq.indexOf('-', i) == -1 ? Integer.MAX_VALUE : eq.indexOf('-', i)),
					eq.indexOf('x', i) == -1 ? Integer.MAX_VALUE : eq.indexOf('x', i));
			if (next > j) {
				next = j;
			}

			if (i != next) {
				val = Integer.valueOf(eq.substring(i, next));
			} else {
				val = 1;
			}
			if (next < j && eq.charAt(next) == 'x') {
				x = pos ? x + val : x - val;
				if (next + 1 < j) {
					pos = eq.charAt(next + 1) == '-' ? false : true;
				}
				i = next + 2;
			}

			else {
				num = pos ? num + val : num - val;
				if (next < j) {
					pos = eq.charAt(next) == '-' ? false : true;
				}
				i = next + 1;
			}

		}
		return new int[] { num, x };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
