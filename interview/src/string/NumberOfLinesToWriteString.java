package string;

/**
 * @author: ryjarvis May 2, 2018
 * 
 */
// LeetCode #806
public class NumberOfLinesToWriteString {

	public int[] numberOfLines(int[] widths, String s) {
		int rows = 1;
		int count = 0;
		for (char c : s.toCharArray()) {
			count += widths[c - 'a'];
			if (count > 100) {
				count = widths[c - 'a'];
				rows++;
			}
		}
		return new int[] { rows, count };

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
