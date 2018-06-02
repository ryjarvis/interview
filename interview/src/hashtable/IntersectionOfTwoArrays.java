package hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: ryjarvis Apr 28, 2018
 * 
 */
// LeetCode #349
public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		List<Integer> res = new ArrayList<>();
		for (int n : nums1) {
			set.add(n);
		}
		for (int n : nums2) {
			if (set.contains(n)) {
				set.remove(n);
				res.add(n);
			}
		}
		int[] ans = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
