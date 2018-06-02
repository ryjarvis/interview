package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: ryjarvis Apr 15, 2018
 * 
 */
// LeetCode #581
public class ShortestUnsortedContinuousSubarray {
	public static int findUnsortedSubarray(int[] nums) {
		int[]copy=Arrays.copyOf(nums, nums.length);
		Arrays.sort(copy);
		int start=-2;
		int last=nums.length-1;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==copy[i]){
				continue;
			}
			else if(start>=-1){
				last=i;
			}
			else{
				start=i-1;
			}
		}
		return start>=-1?last-start:0;
	}
	
	//much better solution
    public int findUnsortedSubarrayOptimized(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = -1, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        for (int l = 0; l < nums.length; l++) {
            max = Math.max(max, nums[l]);
            if (max != nums[l]) j = l;
        }
        for (int r =nums.length - 1; r >= 0; r--) {
            min = Math.min(min, nums[r]);
            if (min != nums[r]) i = r;
        }
        
        return j - i + 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]ar={2,3,3,2,4};
		findUnsortedSubarray(ar);
	}

}
