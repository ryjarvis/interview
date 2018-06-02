package hashtable;

import java.util.BitSet;

//LeetCode #36
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			BitSet set = new BitSet(9);
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				if (set.get(board[i][j] - '1')) {
					return false;
				}
				set.set(board[i][j] - '1');
			}
		}

		for (int k = 0; k < board[0].length; k++) {
			BitSet set = new BitSet(9);
			for (int l = 0; l < board.length; l++) {
				if (board[l][k] == '.') {
					continue;
				}
				if (set.get(board[l][k] - '1')) {
					return false;
				}
				set.set(board[l][k] - '1');
			}
		}
		int counter = 1;
		int m = 0;
		int n = 0;
		while (counter < 82) {
			BitSet set = new BitSet(9);
			for (int i = 3 * n; i < 3 * n + 3; i++) {
				for (int j = 3 * m; j < 3 * m + 3; j++) {
					counter++;
					if (board[i][j] == '.') {
						continue;
					}
					if (set.get(board[i][j] - '1')) {
						return false;
					}
					set.set(board[i][j] - '1');
				}
			}
			m = counter % 27;
			m = m % 9;
			n = counter / 27;

		}
		return true;
	}

    public static boolean isValidSudokuImproved(char[][] board) {
		for (int i = 0; i < 9; i++) {
			BitSet row = new BitSet(9);
			BitSet col = new BitSet(9);
			BitSet block = new BitSet(9);
			int blockRowStart = 3 * (i / 3);
			int blockColStart = 3 * (i % 3);
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' ){
                    if(row.get(board[i][j] - '1')){
					    return false;
				    }
                    row.set(board[i][j] - '1');
                }
				if (board[j][i] != '.' ) {
                    if(col.get(board[j][i] - '1')){
                        return false;
                    }
					col.set(board[j][i] - '1');
				}				
				int blockRowOffset = j / 3;
				int blockColOffset = j % 3;
				int blockRow = blockRowStart + blockRowOffset;
				int blockCol = blockColStart + blockColOffset;
				if (board[blockRow][blockCol] != '.' ) {
                    if(block.get(board[blockRow][blockCol] - '1')){
                        return false;
                    }
					block.set(board[blockRow][blockCol] - '1');
				}				
			}
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
