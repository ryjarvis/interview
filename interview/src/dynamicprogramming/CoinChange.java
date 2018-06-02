package dynamicprogramming;

import java.util.Arrays;

/**
 * @author: ryjarvis
 * Jan 25, 2018
 * 
 */
//LeetCode #322
public class CoinChange {
	
    public int coinChange(int[] coins, int amount) {
        int[] mem=new int[amount+1];
        int l=mem.length;
        Arrays.fill(mem,Integer.MAX_VALUE-1);
        mem[0]=0;
        for(int i:coins){
        	for(int j=i;j<l;j++){
        		mem[j]=Math.min(mem[j-i]+1, mem[j]);
        	}
        }
        return mem[l-1]<Integer.MAX_VALUE-1?mem[l-1]:-1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


