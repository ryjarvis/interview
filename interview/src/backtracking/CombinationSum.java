package backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ryjarvis Apr 15, 2018
 * 
 */
// LeetCode #39
public class CombinationSum {
	// As you can see like other combinatorial problems with backtracking make
	// sure you draw the decision tree and understand the scenario which
	// satisfies the solution
	// One improvement can be done by first sorting the input
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		helper(candidates, res, target, new ArrayList<Integer>(), 0);
		return res;
	}

	public static void helper(int[] c, List<List<Integer>> res, int target, List<Integer> aux, int idx) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(aux));
			return;
		}
		if (target < 0) {
			return;
		}
		for (int i = idx; i < c.length; i++) {
			aux.add(c[i]);
			helper(c, res, target - c[i], aux, i);
			aux.remove(aux.size() - 1);
		}
	}

	public static List<List<Integer>> combinationSumOptimized(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		helper(candidates, res, target, new ArrayList<Integer>(), 0);
		return res;
	}

	// two times faster than above solution 16ms
	public static void helperOptimized(int[] c, List<List<Integer>> res, int target, List<Integer> aux, int idx) {
		if (target > 0) {
			for (int i = idx; i < c.length; i++) {
				if (target - c[i] < 0)
					return;
				aux.add(c[i]);
				helper(c, res, target - c[i], aux, i);
				aux.remove(aux.size() - 1);
			}
		} else if (target == 0) {
			res.add(new ArrayList<Integer>(aux));
			return;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cand = { 2, 3, 5 };
		List<List<Integer>> res = new ArrayList<>();
		res = combinationSum(cand, 8);

	}

}
