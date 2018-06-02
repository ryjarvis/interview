package string;

/**
 * @author: ryjarvis May 4, 2018
 * 
 */
// LeetCode #383
public class RansomNote {

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] map = new int[26];
		for (char c : magazine.toCharArray()) {
			map[c - 'a']++;
		}
		for (char c : ransomNote.toCharArray()) {
			map[c - 'a']--;
			if (map[c - 'a'] < 0) {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
