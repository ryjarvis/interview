package dynamicprogramming;

//LeetCode #72
public class EditDistance {
	public  static int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int mem[] = new int[n + 1];
		int prev = 0;
		int temp;
		for (int i = 0; i <= m; i++) {
			prev = 0;
			for (int j = 0; j <= n; j++) {
				if (j == 0) {
					prev=mem[j];
					mem[j] = i;
				} else if (i == 0) {
					mem[j] = j;
				} else if (i >= 1 && j >= 1 && word1.charAt(i - 1) == word2.charAt(j - 1)) {
					temp = prev;
					prev = mem[j];
					mem[j] = temp;
				} else {
					int min = Math.min(Math.min(mem[j - 1], mem[j]), prev);
					prev = mem[j];
					mem[j] = min + 1;
				}

			}
		}
		return mem[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minDistance("horse", "ros");

	}

}
