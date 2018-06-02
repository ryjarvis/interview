package math;

/**
 * @author: ryjarvis May 10, 2018
 * 
 */
// LeetCode #357
public class CountNumbersWithUniqueDigits {

	public int countNumbersWithUniqueDigits(int n) {
		int[] mem = new int[11];
		mem[0] = 10;
		mem[1] = 81;

		for (int i = 2; i < 10; i++) {
			mem[i] = mem[i - 1] + (mem[i - 1] * (10 - i));
			if (n == i) {
				return mem[i];
			}
		}
		return mem[10];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
