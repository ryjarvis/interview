package arrays;

//LeetCode #807
public class MaxIncreaseToKeepCitySkyline {
	public int maxIncreaseKeepingSkyline(int[][] g) {
		int m = g.length;
		if (m == 0)
			return 0;
		int n = g[0].length;
		int[] right = new int[m];
		int[] top = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (g[i][j] > right[i]) {
					right[i] = g[i][j];
				}
				if (g[i][j] > top[j]) {
					top[j] = g[i][j];
				}
			}
		}
		int tot = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				tot+=Math.min(top[j], right[i])-g[i][j];
			}
		}
		return tot;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
