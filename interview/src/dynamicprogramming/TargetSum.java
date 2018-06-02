package dynamicprogramming;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ryjarvis Apr 20, 2018
 * 
 */
// LeetCode #494
public class TargetSum {
	// My BFS solution which gives me TLE
	public static int findTargetSumWaysBFS(int[] nums, int s) {
		int n = nums.length;
		if (n == 0) {
			if (s == 0) {
				return 1;
			} else {
				return 0;
			}

		}
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> aux;
		q.add(s);
		int count = 0;
		for (int i = n - 1; i >= 0; i--) {
			count = 0;
			aux = new LinkedList<Integer>();
			while (!q.isEmpty()) {
				int top = q.poll();
				int lo = top - nums[i];
				int hi = top + nums[i];
				if (hi == 0)
					count++;
				if (lo == 0)
					count++;
				aux.add(lo);
				aux.add(hi);
			}
			q = aux;
		}
		return count;

	}

	// DFS solution
	public static int findTargetSumWaysDFS(int[] nums, int s) {
		int[] count = { 0 };
		dfs(0, nums, 0, count, s);
		return count[0];
	}

	public static void dfs(int level, int[] nums, int sum, int[] count, int target) {
		if (level == nums.length) {
			if (sum == target) {
				count[0]++;
			}
			return;
		}
		dfs(level + 1, nums, sum + nums[level], count, target);
		dfs(level + 1, nums, sum - nums[level], count, target);
	}

	// DP algorithm with O(L) or range of sum and O(N*L)
	public static int findTargetSumWaysDP(int[] nums, int s) {
		// this 2001 comes from the fact that sum is -1000<=s<=1000
		int[] dp = new int[2001];
		int[] next;
		dp[nums[0] + 1000] = 1;
		dp[1000 - nums[0]] += 1;
		for (int i = 1; i < nums.length; i++) {
			next = new int[2001];
			for (int j = -1000; j <= 1000; j++) {
				if (dp[j + 1000] > 0) {
					next[j + nums[i] + 1000] += dp[j + 1000];
					next[j - nums[i] + 1000] += dp[j + 1000];
				}
			}
			dp = next;
		}
		return s > 1000 ? 0 : dp[s + 1000];
	}

	// more efficient DP we don't need to go through all the 2001 bacause if we
	// consider [1,3,6,5,4] sum of
	// these values can be between [-19,19] so it is pointless to check for all
	// the 2001 cases when we need to check only 39 cases
	public static int findTargetSumWays(int[]nums,int s){
		int sum=0;
		for(int i:nums)sum+=i;
		if(s>sum||s<-sum) return 0;
		int[]dp=new int[2*sum+1];
		int[]next;
		//when you didn't choose anything and sum is 0 
		dp[sum]=1;
		for(int i=0;i<nums.length;i++){
			next=new int[2*sum+1];
			for(int j=0;j<=2*sum+1;j++){
				if(dp[j]>0){
					next[j+nums[i]+sum]+=dp[j];
					next[j-nums[i]+sum]+=dp[j];					
				}
			}
			dp=next;
		}
		return dp[sum+s];
	}
	
	//Best Solution comes from the knapsack 0/1 sub array sum problem
	
    public int findTargetSumWaysBestSolution(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1); 
    }   

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1]; 
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n]; 
        return dp[s];
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
