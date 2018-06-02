package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ryjarvis Apr 15, 2018
 * 
 */
// LeetCode #560
public class SubarraySumEqualsK {
	//DP solution O(n^2)
	public static int subarraySumDP(int[] nums, int k) {
		int n=nums.length;
		int[]prev=new int[n];
		int counter=0;
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				prev[j-i]+=nums[j];
				if(prev[j-i]==k){
					counter++;
				}
			}
		}
		return counter;
	}
	
	//HashMap solution O(N)
	//Note that when you look for sum-k you look for prefix sum the sum up until that point
	public static int subarraySum(int[] nums, int k) {
		Map<Integer,Integer> map=new HashMap<>();
		map.put(0,1);
		int sum=0;
		int counter=0;
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
			Integer count=map.get(sum-k);
			if(count!=null){
				counter+=count;
			}
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		return counter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]ar={5,3,8,3,7,1};
		int ans=subarraySum(ar, 11);
		

	}

}
