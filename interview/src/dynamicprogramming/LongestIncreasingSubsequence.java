package dynamicprogramming;

import java.util.Arrays;

/**
 * @author: ryjarvis Jan 16, 2018
 * 
 */
// LeetCode #300
public class LongestIncreasingSubsequence {
	
	public int lengthOfLIS(int[] nums) {
		int l=nums.length;
		if(l==0)return 0;
		int[]mem=new int[l];
		Arrays.fill(mem, 1);
		int max=1;
		for(int i=1;i<l;i++){
			for(int j=0;j<i;j++){
				if(mem[j]+1>mem[i]&&nums[j]<nums[i]){
					mem[i]=mem[j]+1;
					if(mem[i]>max){
						max=mem[i];
						continue;
					}
				}
			}
		}
		return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
