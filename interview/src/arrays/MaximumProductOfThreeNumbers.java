package arrays;

import java.util.Arrays;

/**
 * @author: ryjarvis
 * May 26, 2018
 * 
 */
//LeetCode #628
public class MaximumProductOfThreeNumbers {
	//O(log(n)) 
    public int maximumProduct(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1],nums[n-2]*nums[n-3])*nums[n-1];       
    }
    
    //O(n)
    public int maximumProductOptimized(int[]nums){
    	int min1=Integer.MAX_VALUE;
    	int min2=Integer.MAX_VALUE;
    	int max1=Integer.MIN_VALUE;
    	int max2=Integer.MIN_VALUE;
    	int max3=Integer.MIN_VALUE;
    	for(int n:nums){  		
    		if(n<min1){
    			min2=min1;
    			min1=n;			
    		}
    		else if(n<min2){
    			min2=n;
    		}
    		if(n>max1){
    			max3=max2;
    			max2=max1;    			
    			max1=n;
    		}
    		else if(n>max2){
    			max3=max2;
    			max2=n;   					
    		}
    		else if(n>max3){
    			max3=n;
    		}
    	}
    	return Math.max(max3*max2*max1, min1*min2*max1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


