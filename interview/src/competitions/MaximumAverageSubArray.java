package competitions;

public class MaximumAverageSubArray {
	 public double findMaxAverage(int[] nums, int k) {
		 	int maxSum=Integer.MIN_VALUE;
		 	int sum=0;
		 	for(int i=0;i<k;i++){
		 		sum+=nums[i];
		 	}
	        maxSum=sum;
	        for(int j=k;j<nums.length;j++){
	        	sum-=nums[j-k];
	        	sum+=nums[j];
	        	if(sum>maxSum){
	        		maxSum=sum;
	        	}
	        }
	        return (double)maxSum/(double)k;
	    }
}
