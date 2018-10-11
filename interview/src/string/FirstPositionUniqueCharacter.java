package string;

import java.util.Arrays;

//LintCode #646
public class FirstPositionUniqueCharacter {

	public int firstUniqChar(String s) {
		int[] last_idx = new int[128];
		int[] first_idx = new int[128];
		Arrays.fill(first_idx, -1);
		for (int i = 0; i < s.length(); i++) {
			last_idx[(int) s.charAt(i)] = i;
		}
		for (int i = 0; i < s.length(); i++) {
			if (first_idx[(int) s.charAt(i)] == -1) {
				first_idx[(int) s.charAt(i)] = i;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (last_idx[(int) s.charAt(i)] == first_idx[(int) s.charAt(i)]) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
