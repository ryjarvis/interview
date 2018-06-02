package arrays;

//LeetCode #53
//kadane's algorithm
public class MaximumSubarray {
	
	public static int maxSubArray(int[]nums){
		int currentMax;
		int globalMax;
		globalMax=currentMax=nums[0];
		for(int i=1;i<nums.length;i++){
			currentMax=Math.max(nums[i], currentMax+nums[i]);
			globalMax=currentMax>globalMax?currentMax:globalMax;
		}
		return globalMax;
	}
	
	public static int maxSubArrayRecursive(int[] nums) {		
		return maxSubArrayHelper(nums,0,nums.length-1);
	}
	
	public static int maxSubArrayHelper(int[]nums,int i,int j){
		if(i<0||j>=nums.length||i>=nums.length||j<0|i>j){
			return 0;
		}

		if(i==j){
			return nums[i];
		}
		else{
			int mid=(i+j)/2;
			int left=maxSubArrayHelper(nums, i, mid-1);
			int right=maxSubArrayHelper(nums, mid+1, j);
			return Math.max(Math.max(left, right), Math.max(nums[mid], sum(nums,i,j)));			
		}
	}
	
	public static int sum(int []nums,int i,int j){
		int sum=0;
		for(int k=i;k<=j;k++){
			sum+=nums[k];
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={-2,1,-3,4,-1,2,1,-5,4};
		int res=maxSubArray(nums);
		System.out.println(res);

	}

}
