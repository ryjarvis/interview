package disjointset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//LeetCode #128
public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
		int max = 0;
		Map<Integer, Integer> mapIdx = new HashMap<>();
		Map<Integer, Integer> mapMax = new HashMap<>();
		for (int i : nums) {
			if (mapIdx.containsKey(i)) {
				continue;
			}
			if (mapIdx.containsKey(i + 1)) {
				mapIdx.put(i + 1, i);
			}
			mapIdx.put(i, i);
			mapMax.put(i, mapMax.get(i + 1) == null ? 1 : mapMax.get(i + 1) + 1);
			max = Math.max(max, mapMax.get(i));
			if (mapIdx.get(i - 1) != null) {
				mapIdx.put(i, i - 1);
				int idx = mapIdx.get(i - 1);
				while (mapIdx.get(idx) != idx) {
					idx = mapIdx.get(idx);
				}
				int val= mapMax.get(idx) + mapMax.get(i);
				max = Math.max(max, val);
				mapMax.put(idx,val);
			}
		}
		return max;
	}
	
	//interesting solution
	public int longestConsecutiveImproved(int[] nums) {
		Set<Integer> set=new HashSet<>();
		for(int i:nums){
			set.add(i);
		}
		int max=0;
		for(int i:nums){
			if(!set.contains(i-1)){
				int local=1;
				while(set.contains(i+1)){
					i++;
					local++;
				}
				max=Math.max(local, max);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
