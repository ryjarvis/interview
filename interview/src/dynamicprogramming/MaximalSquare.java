package dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ryjarvis Apr 14, 2018
 * 
 */
// LeetCode #221
public class MaximalSquare {
	public static int maximalSquare(char[][] mat) {
		int m = mat.length;
		if (m == 0)
			return 0;
		int n = mat[0].length;
		int counter = 0;
		Set<int[]> set = new HashSet<>();
		Set<int[]> temp = new HashSet<>();
		boolean[][] bool=new boolean[m][n];
		boolean[][]tmp=new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == '1') {
					set.add(new int[] { i, j });
					bool[i][j]=true;
				}
			}
		}
		while (!set.isEmpty() && counter < Math.min(m, n)) {
			temp = new HashSet<>();
			tmp=new boolean[m][n];
			for (int[] i : set) {
				if ( i[0] + 1<m&&i[1]+1<n&&bool[i[0]][i[1]+1]&&bool[i[0]+1][i[1]+1]&&bool[i[0]+1][i[1]]) {
					temp.add(i);
					tmp[i[0]][i[1]]=true;
				}

			}
			set = temp;
			bool=tmp;
			counter++;
		}
		return counter * counter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] mat = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		int ans=maximalSquare(mat);

	}

}
