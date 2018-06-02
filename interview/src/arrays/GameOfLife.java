package arrays;

/**
 * @author: ryjarvis Mar 17, 2018
 * 
 */
// LeetCode #289
public class GameOfLife {
	public static void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int cur = (board[i][j] & 1);
				int lives = liveNeighbours(board, i, j, cur);
				if (cur == 1 && (lives == 2 || lives == 3)) {
					board[i][j] = 3;
				} else if (cur == 0 && lives == 3) {
					board[i][j] = 2;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j]=board[i][j]>>1;
			}
		}
	}

	public static int liveNeighbours(int[][] board, int m, int n, int cur) {
		int count = 0;
		for (int i = m - 1; i < m + 2; i++) {
			if( i < 0 || i >= board.length){
				continue;
			}
			for (int j = n - 1; j < n + 2; j++) {
				if(j < 0 || j >= board[0].length){
					continue;
				}
				if ((board[i][j] & 1) == 1) {
					count++;
				}
			}
		}
		return cur == 1 ? count - 1 : count;
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int [][]board={{1,1},{1,0}};
		gameOfLife(board);
	}

}
