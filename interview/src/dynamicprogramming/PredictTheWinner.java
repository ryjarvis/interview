package dynamicprogramming;

/**
 * @author: ryjarvis
 * May 31, 2018
 * 
 */
//LeetCode #486
public class PredictTheWinner {
	public boolean PredictTheWinner(int[] nums) {
		int n=nums.length;
		int[]mem=new int[n];
		for(int i=n-1;i>=0;i--){
			for(int j=i;j<n;j++){
				if(i==j){
					mem[i]=nums[i];
				}
				else{
					mem[j]=Math.max(nums[j]-mem[j-1], nums[i]-mem[j]);
				}
			}
		}
		return mem[n-1]>=0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


