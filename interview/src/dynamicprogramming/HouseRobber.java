package dynamicprogramming;

/**
 * @author: ryjarvis
 * Dec 26, 2017
 * 
 */
//LeetCode #198
public class HouseRobber {
    public static int rob(int[] nums) {
		int[]ar=new int[nums.length];
		for(int i=0;i<nums.length;i++){
			ar[i]=-1;
		}
    	return robHelper(nums,0, 0,ar);           
    }
	public static int robHelper(int []nums,int sum,int level,int[]mem){

		if(level>nums.length-1){
			return sum;
		}
		if(mem[level]!=-1){
			return sum+mem[level];
		}
		if(level==nums.length-1){
			return sum+nums[level];
		}
		int l=robHelper(nums,sum+nums[level],level+2,mem);
		int r=robHelper(nums, sum, level+1,mem);
		if(level<nums.length){
			mem[level]=Math.max(l,r)-sum;
		}
		
		return Math.max(l,r);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


