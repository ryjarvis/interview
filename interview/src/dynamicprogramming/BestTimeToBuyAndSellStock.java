package dynamicprogramming;

/**
 * @author: ryjarvis Jan 28, 2018
 * 
 */
// LeetCode #121
public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int p : prices) {
			if (p <= min) {
				min = p;
			} else {
				max = Math.max(p - min, max);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
