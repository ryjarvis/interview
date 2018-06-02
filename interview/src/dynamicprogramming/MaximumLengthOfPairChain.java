package dynamicprogramming;

import java.util.Arrays;

/**
 * @author: ryjarvis
 * May 9, 2018
 * 
 */
//LeetCode #646
public class MaximumLengthOfPairChain {
	//DP solution which works in O(n^2)
	//very similar to the longest increasing subsequence we try to increase the chain's length
	public int findLongestChain(int[][] p) {
		//note that whenever you have a comparator you can pass it in the java 8 format
		Arrays.sort(p,(a,b)->(a[0]-b[0]));
		int n=p.length;
		int[]map=new int[n];
		int max=1;
		for(int i=0;i<n;i++){
			map[i]=1;
			for(int j=0;j<i;j++){
				if(p[i][0]>p[j][1]&&1+map[j]>map[i]){
					map[i]=1+map[j];
					if(map[i]>max){
						max=map[i];
					}
				}
			}
		}
		return max;
	}
	
	//Better solution using greedy method also mentioned in the design manual by Skienna
	//this algorithm works in O(NLogn) 
	//note that if we use bucket sort we may get o(n) amortized which makes this algorithm o(n) amortized
	public int findLongestChainGreedy(int[][] p) {
		//here we sort based on the ones finishes sooner, because when you finish sooner you have
		//lower chance of interference so we keep choosing from the ones that are finished sooner
		Arrays.sort(p,(a,b)->(a[1]-b[1]));
		int ans=1;
		int prev=p[0][1];
		for(int i=1;i<p.length;i++){
			if(p[i][0]>prev){
				ans++;
				prev=p[i][1];
			}			
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


