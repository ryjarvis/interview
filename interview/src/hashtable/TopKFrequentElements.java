package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ryjarvis Dec 29, 2017
 * 
 */
// LeetCode #374
public class TopKFrequentElements {
	public static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		List<Integer>[] bucket = new List[nums.length + 1];
		for (int i : map.keySet()) {
			int val = map.get(i);
			if (bucket[val] == null) {
				bucket[val] = new ArrayList<Integer>();
			}
			bucket[val].add(i);
		}
		List<Integer> res = new ArrayList<Integer>();
		for (int i = nums.length; i > 0 && k > 0; i--) {
			if (bucket[i] == null)
				continue;
			res.addAll(bucket[i]);
			k -= bucket[i].size();
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 2, 2,2, 3 };
		List<Integer> res = topKFrequent(nums, 2);
		System.out.println(Arrays.asList(res));

	}

}
