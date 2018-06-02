package dynamicprogramming;

/**
 * @author: ryjarvis Apr 17, 2018
 * 
 */
// LeetCode #647
public class PalindromicSubstrings {

	public static int countSubstrings(String s) {
		boolean[][] mem = new boolean[s.length()][s.length()];
		int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (j - i < 2) {
						mem[i][j] = true;
					} else {
						mem[i][j] = mem[i + 1][j - 1];
					}
				}

				if (mem[i][j]) {
					count++;
				}
			}
		}
		return count;
	}
	
	

	// this solution called expand around the center which can be any of the
	// 2N-1 centers
	
	public static int countSubstringsExpand(String s) {
		int N=s.length();
		int res=0;
		for(int c=0;c<2*N-1;c++){
			int left=c/2;
			int right=left+c%2;		
			while(left>=0&&right<N&&s.charAt(left)==s.charAt(right)){
				res++;
				right++;
				left--;		
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaa";
		int c = countSubstrings(s);
	}

}
