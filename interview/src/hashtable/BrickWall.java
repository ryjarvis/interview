package hashtable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ryjarvis May 9, 2018
 * 
 */
// LeetCode #554
public class BrickWall {
	public int leastBricks(List<List<Integer>> wall) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		int sum = 0;
		for (List<Integer> list : wall) {
			sum = 0;
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i);
				Integer val = map.get(sum);
				if (val == null) {
					val = 0;
				}
				map.put(sum, val + 1);
				if (val + 1 > max && i < list.size() - 1) {
					max = val + 1;
				}
			}
		}
		return wall.size() - max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
