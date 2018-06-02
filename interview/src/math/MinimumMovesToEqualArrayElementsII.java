package math;

import java.util.Arrays;

/**
 * @author: ryjarvis
 * May 1, 2018
 * 
 */
//LeetCode #462
public class MinimumMovesToEqualArrayElementsII {
	//the original idea I had was to get the mean and then try to find the closest to that
	//but the idea was wrong and we should have considered the n/2 element
    public int minMoves2(int[] nums) {
    	long sum=0;
    	int n=nums.length;
        for(int i:nums){
        	sum+=i;
        }
        int mean=(int)sum/n;
        Arrays.sort(nums);
        
        long count=0;
        mean=nums[n/2];
        for(int i:nums){
        	count+=Math.abs(mean-i);
        }
        return (int)count;
    }
        

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


