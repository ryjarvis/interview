package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryjarvis May 17, 2018
 * 
 */
// LeetCode #442
public class FindAllDuplicatesInArray {

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int idx = Math.abs(nums[i]) - 1;
			if (nums[idx] < 0) {
				res.add(idx + 1);
			}
			nums[idx] = -nums[idx];
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
