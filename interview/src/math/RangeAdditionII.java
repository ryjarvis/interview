package math;

/**
 * @author: ryjarvis May 6, 2018
 * 
 */
// LeetCode #598
public class RangeAdditionII {
	public int maxCount(int m, int n, int[][] ops) {
		int i = m;
		int j = n;
		for (int[] ar : ops) {
			if (ar[0] < i) {
				i = ar[0];
			}
			if (ar[1] < j) {
				j = ar[1];
			}
		}
		return i * j;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
