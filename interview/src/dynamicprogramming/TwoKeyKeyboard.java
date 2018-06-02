package dynamicprogramming;

/**
 * @author: ryjarvis Apr 5, 2018
 * 
 */
// LeetCode #650
public class TwoKeyKeyboard {
	int total = 0;

	public int minSteps(int n) {
		if (n == 2) {
			return total + 2;
		}
		if (n < 2) {
			return total;
		}

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				total += i;
				return minSteps(n / i);
			}
		}
		total += n;
		return total;
	}
}
