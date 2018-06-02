package dynamicprogramming;

/**
 * @author: ryjarvis Apr 23, 2018
 * 
 */
// LeetCode #312
public class BurstBalloons {
	public static int maxCoins(int[] nums) {
		int l=nums.length;
		int[][]mem=new int[l][l];
		//go from length one to l subarray
		for(int n=1;n<=l;n++){
			//go with all the first index
			for(int i=0;i+n<=l;i++){
				int j=i+n-1;
				int before=0;
				int after=0;
				int start=i-1>=0?nums[i-1]:1;
				int end=j+1<l?nums[j+1]:1;
				//choose all the ones to burst last
				for(int k=i;k<=j;k++){
					before=0;
					after=0;
					if(k>i){
						before=mem[i][k-1];
					}
					if(k<j){
						after=mem[k+1][j];
					}
					mem[i][j]=Math.max(before+after+(start*nums[k]*end), mem[i][j]);
				}
			}
		}
		return mem[0][l-1];
	}
	
	public static int maxCoinsDC(int[] iNums) {
	    int[] nums = new int[iNums.length + 2];
	    int n = 1;
	    for (int x : iNums) if (x > 0) nums[n++] = x;
	    nums[0] = nums[n++] = 1;


	    int[][] memo = new int[n][n];
	    return burst(memo, nums, 0, n - 1);
	}

	public static int burst(int[][] memo, int[] nums, int left, int right) {
	    if (left + 1 == right) return 0;
	    if (memo[left][right] > 0) return memo[left][right];
	    int ans = 0;
	    for (int i = left + 1; i < right; ++i)
	        ans = Math.max(ans, nums[left] * nums[i] * nums[right] 
	        + burst(memo, nums, left, i) + burst(memo, nums, i, right));
	    memo[left][right] = ans;
	    return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]ar={3,1,5,8};
		maxCoinsDC(ar);
	}

}
