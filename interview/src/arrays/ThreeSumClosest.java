package arrays;

import java.util.Arrays;

//LeetCode #16
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		int minDist=Integer.MAX_VALUE;
		int cur,next,end,sum,minSum;
		minSum=0;
		int n=nums.length;
		Arrays.sort(nums);
		for(int i=0;i<n-2;i++){
			cur=nums[i];
			next=i+1;
			end=n-1;
			while(next!=end){
				sum=cur+nums[next]+nums[end];
				if(sum-target>0){
					end--;
				}
				else if(sum-target<0){
					next++;
				}
				else{
					return sum;
				}
				if(Math.abs(target-sum)<minDist){
					minSum=sum;
					minDist=Math.abs(target-sum);
				}
			}
		}
		return minSum;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
