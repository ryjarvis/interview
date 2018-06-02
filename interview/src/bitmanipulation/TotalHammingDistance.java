package bitmanipulation;

/**
 * @author: ryjarvis May 6, 2018
 * 
 */
// LeetCode #477
public class TotalHammingDistance {

	public int totalHammingDistance(int[] nums) {
		int[] map = new int[32];
		int sum = 0;
		for (int i : nums) {
			int k = 0;
			while (i != 0) {
				if ((i & 1) == 1) {
					map[k]++;
				}
				i = i >> 1;
				k++;
			}
		}
		for (int i : map) {
			if (i != 0) {
				sum += i * (nums.length - i);
			}

		}

		return sum;
	}

	// better solution
	public int totalHammingDistanceOptimized(int[] nums) {

		int sum = 0;
		int count = 0;
        int n=nums.length;
		for (int i = 0; i < 32; i++) {
            count=0;
			for (int num : nums) {
				count+= (num >> i) & 1;
			}
			sum+=count*(n-count);
		}
		return sum;
	}

	// O(n^2) Time out solution
	public int totalHammingDistanceTimeOut(int[] nums) {
		int sum = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				sum += calc(nums[i], nums[j]);
			}
		}
		return sum;
	}

	public int calc(int i, int j) {
		return numberOfOnes(i ^ j);
	}

	public int numberOfOnes(int i) {
		int sum = 0;
		while (i != 0) {
			i = i & (i - 1);
			sum++;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
