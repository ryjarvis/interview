package dynamicprogramming;

import java.util.Set;

import java.util.Arrays;

/**
 * @author: ryjarvis Apr 14, 2018
 * 
 */
// LeetCode #416
public class PartitionEqualSubsetSum {

	public static boolean canPartition(int[] nums) {		
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			
			sum += nums[i];
		}
		if ((sum & 1) != 0) {
			return false;
		}
		sum >>= 1;

		int[]mem = new int[sum + 1];
		int[]prev = new int[sum + 1];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < sum + 1; j++) {
				int aux = j - nums[i] >= 0 ? prev[j - nums[i]] : Integer.MIN_VALUE;
				mem[j] = Math.max(nums[i] + aux, prev[j]);
				if (mem[j] == sum) {
					return true;
				}
				
			}
			prev=Arrays.copyOf(mem,mem.length);
		}
		return false;

	}

	// Doing this to convert the problem to distinct knapsack 0/1 problem
	public static void addToSet(Set<Integer> set, int i) {
		if (set.contains(i)) {
			set.remove(i);
			addToSet(set, i * 2);
		} else {
			set.add(i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar={1,5,2};
		boolean ans=canPartition(ar);

	}

}
