package arrays;

import java.util.ArrayDeque;

//leetcode 79
public class WordSearch {

	public static boolean exist(char[][] board, String word) {
		int maxColumn = board[0].length;
		int maxRow = board.length;
		boolean found = false;
		ArrayDeque<Integer> firstPos = new ArrayDeque<Integer>();
		char firstChar = word.charAt(0);
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxColumn; j++) {
				if (board[i][j] == firstChar) {
					firstPos.offer(i);
					firstPos.offer(j);
				}
			}
		}

		while (!found && !firstPos.isEmpty()) {
			ArrayDeque<Integer> moves = new ArrayDeque<Integer>();
			moves.push(0);
			moves.push(1);
			moves.push(2);
			moves.push(3);
			found = helperExist(firstPos.poll(), firstPos.poll(), moves, 1, board, word);
		}
		return found;

	}

	// left 0, right 1, up 2, down 3
	public static boolean helperExist(int i, int j, ArrayDeque<Integer> moves, int level, char[][] board, String word) {
		boolean left = false;
		boolean right = false;
		boolean up = false;
		boolean down = false;

		if (level == word.length() && (board[i][j] == word.charAt(level - 1))) {
			return true;
		}
		if (level == word.length() && (board[i][j] != word.charAt(level - 1))) {
			return false;
		}
		if (moves.isEmpty()) {
			return false;
		}
		while (!moves.isEmpty()&&!left&&!right&&!up&&!down) {
			int move = moves.pop();
			if (move == 0) {
			
				boolean leftP = possible(i,j-1,level + 1, board, word);
				if(leftP){
					ArrayDeque<Integer> temp=new ArrayDeque<Integer>();
					temp.addAll(moves);
					moves.push(0);
					moves.push(2);
					moves.push(3);
					left=helperExist(i, j - 1, moves, level + 1, board, word);
					moves=temp;
				}
				
			}

			if (move == 1) {
				boolean rightP = possible(i,j+1,level + 1, board, word);
				if(rightP){
					ArrayDeque<Integer> temp=new ArrayDeque<Integer>();
					temp.addAll(moves);
					moves.clear();
					moves.push(1);
					moves.push(2);
					moves.push(3);
					right=helperExist(i, j + 1, moves, level + 1, board, word);
					moves=temp;
				}
			}

			if (move == 2) {
				boolean upP = possible(i-1,j,level + 1, board, word);
				if(upP){
					ArrayDeque<Integer> temp=new ArrayDeque<Integer>();
					temp.addAll(moves);
					moves.push(0);
					moves.push(1);
					moves.push(2);
					up=helperExist(i - 1, j, moves, level + 1, board, word);
					moves=temp;
				}

			}

			if (move == 3) {
				boolean downP = possible(i+1,j,level + 1, board, word); 
				if(downP){
					ArrayDeque<Integer> temp=new ArrayDeque<Integer>();
					temp.addAll(moves);
					moves.push(0);
					moves.push(1);
					moves.push(3);
					down=helperExist(i + 1, j, moves, level + 1, board, word);
					moves=temp;
				}

			}
		}
		return (left || right || up || down);
	}
	
	public static boolean possible(int i, int j, int level, char[][] board, String word){
		if (i >= 0 && i < board.length && j >=0 && j < board[0].length&&board[i][j] == word.charAt(level - 1)) {
			
			return true;
		}
		return false;
		
	}

	public static void main(String[] args) {
		char board[][] = { {  'A', 'B', 'C', 'E' }, 
							{ 'S', 'F', 'C', 'S' }, 
							{ 'A', 'D', 'E', 'E' } };
		char board2[][] = { {'A', 'A','A', 'A'},{'A', 'A','A', 'A'},{'A', 'A','A', 'A'}};
		String word="ABCCED";
		String word2="AAAAAAAAAAAAA";
		boolean res=exist(board2, word2);
		System.out.println(res);
	}

}
