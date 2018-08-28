package heap;

//LeetCode #239
public class SlidingWindowMaximum {
	// the idea here is find the upper max from the node and find the lower max
	// then get the max of both-> you have the max of that subarray
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;

		int max[] = new int[n - k + 1];
		if (n == 0)
			return new int[0];
		int[] lowerMax = new int[n];
		int[] higherMax = new int[n];
		int m = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (i % k == 0) {
				lowerMax[i] = nums[i];
				m = nums[i];
			} else {
				m = Math.max(m, nums[i]);
				lowerMax[i] = m;
			}
		}
		m = Integer.MIN_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			if (i % k == 0) {
				higherMax[i] = nums[i];
				m = nums[i];
			} else {
				m = Math.max(m, nums[i]);
				higherMax[i] = m;
			}
		}
		for (int i = 0; i <= n - k; i++) {
			max[i] = Math.max(higherMax[i], lowerMax[i + k - 1]);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int[] res = maxSlidingWindow(ar, 3);

	}

}
