package dynamicprogramming;

/**
 * @author: ryjarvis Nov 29, 2017
 * 
 */
// LeetCode #70
public class ClimbingStairs {

	// recursive solution that takes exponential time O(phi^n)=>phi=1.62
	public int climbStairsRec(int n) {
		if (n <= 2) {
			return n;
		}
		return climbStairsRec(n - 2) + climbStairsRec(n - 1);
	}

	// This is the top Down approach
	public static int climbStairsTopDown(int n) {
		int[] memo = new int[n];
		if (memo[n] == 0) {
			if (n <= 2) {
				memo[n] = n;
			} else {
				memo[n] = climbStairsTopDown(n - 1) + climbStairsTopDown(n - 2);
			}
		}
		return memo[n];
	}
	// This is the bottom up approach which takes O(1) memory in comparison to 
	//the top down approach which takes O(n) memory
	public static int climbStairsBottomUp(int n){
		if(n<=2){
			return n;
		}
		int prev=1;
		int cur=2;
		int temp;
		for(int i=3;i<=n;i++){
			temp=cur;
			cur=prev+cur;
			prev=temp;
		}
		return cur;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
