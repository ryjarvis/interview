package arrays;

import java.util.Arrays;

//LeetCode #238
public class ProductOfArrayExceptSelf {

	public static int[] productExceptSelf(int[] nums) {
		int l=nums.length;
		if(l==0){
			return nums;
		}
		int[]output=new int[l];
		Arrays.fill(output, 1);
		for(int i=1;i<l;i++){
			output[i]=output[i-1]*nums[i-1];
		}
		int post=nums[l-1];
		for(int j=l-2;j>=0;j--){
			output[j]*=post;
			post*=nums[j];
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test={1,3,5};
		int[]res=productExceptSelf(test);
		System.out.println(Arrays.toString(res));
	}

}
