package arrays;

//LeetCode #59
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int count = 1;
		int up = 0;
		int down = n - 1;
		int left = 0;
		int right = n - 1;
		for (int i = 0; i < (n + 1) / 2; i++) {
			for (int j = left; j <= right; j++) {
				res[up][j]=count;
				count++;
			}
			for (int j = up+1; j <= down; j++) {
				res[j][right]=count;
				count++;
			}
			for (int j = right-1; j >= left; j--) {
				res[down][j]=count;
				count++;
			}
			for (int j = down-1; j >up; j--) {
				res[j][left]=count;
				count++;
			}
			up++;
			down--;
			left++;
			right--;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
