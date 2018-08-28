package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//LeetCode #18
public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Set<String> set = new HashSet<>();
		List<Integer> curList = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int cur, next, before, end;
		int n = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				before = j + 1;
				end = n - 1;
				while (before < end) {
					int sum = nums[i] + nums[j] + nums[before] + nums[end];
					if (sum > target) {
						end--;
					} else if (sum < target) {
						before++;
					} else {
						String resStr = nums[i] + ":" + nums[j] + ":" + nums[before] + ":" + nums[end];
						if (!set.contains(resStr)) {
							set.add(resStr);
							curList.add(nums[i]);
							curList.add(nums[j]);
							curList.add(nums[before]);
							curList.add(nums[end]);
							res.add(new ArrayList<>(curList));
							curList = new ArrayList<>();
						}
						before++;
						end--;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
