package bitmanipulation;

/**
 * @author: ryjarvis Apr 11, 2018
 * 
 */
// LeetCode #461
public class HammingDistance {
	
	public static int countBit(int x) {
		int count = 0;
		while (x > 0) {
			x &= (x - 1);
			count++;
		}
		return count;
	}

	public int hammingDistance(int x, int y) {
		x = x ^ y;
		return countBit(x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
