package arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {
		int count=1;
		for(int i=1;i<nums.length;i++){
			if(nums[count-1]==nums[i]){
				continue;
			}
			else{
				nums[count++]=nums[i];
			}
		}
		return count;
	}
	
	public static void swap(int[]nums,int i,int j){
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}

	public static void main(String[] args) {
		int[]nums={1,1,2,2,4,5,6,6};
		int res=removeDuplicates(nums);
		System.out.println(res);
		System.out.println(Arrays.toString(nums));
		

	}

}
