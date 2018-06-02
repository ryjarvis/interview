package arrays;

/**
 * @author: ryjarvis May 9, 2018
 * 
 */
// LeetCode #167
public class TwoSumIISortedInputArray {

	public int[] twoSum(int[] num, int target) {
		int n = num.length;
		int lo = 0;
		int hi = n - 1;
		while (lo < hi) {
			int cur = num[lo] + num[hi];
			if (cur == target)
				return new int[] { lo + 1, hi + 1 };
			else if (cur > target)
				hi--;
			else
				lo++;
		}
		return new int[2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
