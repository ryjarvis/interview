package string;

/**
 * @author: ryjarvis Apr 30, 2018
 * 
 */
// LeetCode #788
public class RotatedDigits {

	public int rotatedDigits(int N) {
		int res = 0;
		for (int i = 0; i <= N; i++) {
			String num = String.valueOf(i);
			if (num.contains("7") || num.contains("3") || num.contains("4")) {
				continue;
			}
			if (num.contains("2") || num.contains("5") || num.contains("6") || num.contains("9")) {
				res++;
			}
		}
		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
