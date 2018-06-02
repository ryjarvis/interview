package backtracking;

import java.util.ArrayDeque;

public class WordSearch {

	public static boolean exist(char[][] board, String word) {
		char[] w = word.toCharArray();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (w[0] == board[i][j] && exist(i, j, 0, board, w)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean exist(int i, int j, int level, char[][] b, char[] w) {
		if (level == w.length) {
			return true;
		}
		
		if (i < 0 || i >= b.length || j < 0 || j >= b[0].length
				|| b[i][j] != w[level]) {
			return false;
		}

		b[i][j] ^= 256;
		if (exist(i, j - 1, level + 1, b, w)
				|| exist(i, j + 1, level + 1, b, w)
				|| exist(i + 1, j, level + 1, b, w)
				|| exist(i - 1, j, level + 1, b, w)) {
			return true;

		}
		b[i][j]^=256;
		return false;

	}

	// better solution without timeout
	static boolean visited[][];

	public static boolean existBetter(char[][] board, String word) {
		int maxRow = board.length;
		int maxCol = board[0].length;
		visited = new boolean[maxRow][maxCol];
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxCol; j++) {
				if (board[i][j] == word.charAt(0)
						&& search(i, j, 0, board, word)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean search(int i, int j, int level, char[][] board,
			String word) {
		if (level == word.length()) {
			return true;
		}
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
				|| visited[i][j] || word.charAt(level) != board[i][j]) {
			return false;
		}
		visited[i][j] = true;
		if (search(i, j - 1, level + 1, board, word)
				|| search(i, j + 1, level + 1, board, word)
				|| search(i + 1, j, level + 1, board, word)
				|| search(i - 1, j, level + 1, board, word)) {
			return true;

		}
		visited[i][j] = false;
		return false;
	}

	//
	// timeout solution
	public static boolean existTimeOut(char[][] board, String word) {
		int maxRow = board.length;
		int maxCol = board[0].length;
		boolean[][] seen;
		boolean found = false;
		ArrayDeque<Integer> firstPos = new ArrayDeque<Integer>();
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxCol; j++) {
				if (board[i][j] == word.charAt(0)) {
					firstPos.offer(i);
					firstPos.offer(j);
				}
			}
		}
		while (!firstPos.isEmpty() && !found) {
			seen = new boolean[maxRow][maxCol];
			found = possible(firstPos.poll(), firstPos.poll(), 0, seen, board,
					word, maxRow, maxCol);
		}
		return found;

	}

	public static boolean possible(int i, int j, int level, boolean[][] seen,
			char[][] board, String word, int maxRow, int maxCol) {

		if (i >= 0 && j >= 0 && i < maxRow && j < maxCol && seen[i][j] == false) {

			if (board[i][j] == word.charAt(level)) {
				seen[i][j] = true;
				if (level == word.length() - 1) {
					return true;
				}
				boolean[][] temp = new boolean[maxRow][maxCol];
				copyArray(temp, seen);
				boolean left = false;
				boolean right = false;
				boolean down = false;
				boolean top = false;
				left = possible(i, j - 1, level + 1, seen, board, word, maxRow,
						maxCol);
				copyArray(seen, temp);
				if (!left) {
					right = possible(i, j + 1, level + 1, seen, board, word,
							maxRow, maxCol);
					copyArray(seen, temp);
				}
				if (!left || !right) {
					down = possible(i + 1, j, level + 1, seen, board, word,
							maxRow, maxCol);
					copyArray(seen, temp);
				}
				if (!left || !right || !down) {
					top = possible(i - 1, j, level + 1, seen, board, word,
							maxRow, maxCol);
					copyArray(seen, temp);
				}

				return (left || right || down || top);
			}

		}
		return false;
	}

	public static void copyArray(boolean[][] a, boolean[][] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] = b[i][j];
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		String word = "ABCESEEEFS";
		boolean res = exist(board, word);
		System.out.println(res);

	}

}
