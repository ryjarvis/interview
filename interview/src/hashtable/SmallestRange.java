package hashtable;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: ryjarvis Oct 11, 2018
 * 
 */
// LeetCode #632
public class SmallestRange {

	public int[] smallestRange(List<List<Integer>> nums) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		int max = Integer.MIN_VALUE;
		int i = 0;
		int val;
		for (List<Integer> l : nums) {
			val = l.remove(0);
			if (val > max) {
				max = val;
			}
			pq.add(new int[] { val, i++ });
		}
		int[] dist = { 0, Integer.MAX_VALUE };
		while (true) {
			int[] top = pq.poll();
			if (max - top[0] < dist[1] - dist[0]) {
				dist = new int[] { top[0], max };
			}
			if (nums.get(top[1]).isEmpty()) {
				return dist;
			}
			val = nums.get(top[1]).remove(0);
			if (val > max) {
				max = val;
			}
			pq.add(new int[] { val, top[1] });
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
