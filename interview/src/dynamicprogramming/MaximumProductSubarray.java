package dynamicprogramming;

import java.util.Arrays;

/**
 * @author: ryjarvis Jan 23, 2018
 * 
 */
// LeetCode 152
public class MaximumProductSubarray {

	public static int maxProduct(int[] nums) {
		int l=nums.length;
		if(l==0) return 0;
		int max=Integer.MIN_VALUE;
		int[] prod=new int[l];
		for(int i=0;i<l;i++){
			prod[i]=nums[i];
			max=Math.max(max, prod[i]);
		}
		
		for(int i=2;i<=l;i++){
			for(int j=0;j<l-i+1;j++){
				prod[j]=nums[j]*prod[j+1];
				max=Math.max(max,prod[j]);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar={3,7,1,2,-5,3};
		int res=maxProduct(ar);

	}

}
