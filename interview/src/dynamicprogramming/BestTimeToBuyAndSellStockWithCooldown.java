package dynamicprogramming;

import java.util.Arrays;

/**
 * @author: ryjarvis Apr 10, 2018
 * 
 */
// LeetCode #309
public class BestTimeToBuyAndSellStockWithCooldown {
	
	public static int maxProfit(int[] p) {
		int n = p.length;
		int[] mem = new int[n];
		int max = 0;
		int prevMax=0;
		Arrays.fill(mem, 0);
		int cont = 0;
		int sep = 0;
		int maxId = 0;
		for (int i = 1; i < n; i++) {
			if (i <= maxId + 2) {
				sep = prevMax;
			} else {
				sep = max;
			}

			cont = mem[i - 1];
			mem[i] = Math.max(sep, cont) + p[i] - p[i - 1];
			mem[i] = mem[i] >= 0 ? mem[i] : 0;
			if (mem[i] > max) {
				prevMax=max;
				max = mem[i];
				maxId = i;
			}
		}
		return max;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] p={8,6,4,3,3,2,3,5,8,3,8,2,6};
		int res=maxProfit(p);
	}

}
