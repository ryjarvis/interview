package tree;

import java.util.LinkedList;
import java.util.Queue;

//LintCode #630
public class KnightShortestPathII {

	public static int shortestPath2(boolean[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		if (grid[m - 1][n - 1]) {
			return -1;
		}
		final int[][] PT = { { 2, 1 }, { -2, 1 }, { 1, 2 }, { -1, 2 } };
		boolean[][] seen = new boolean[grid.length][grid[0].length];
		seen[0][0] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 0 });
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			for (int[] p : PT) {
				int x = p[0] + pos[0];
				int y = p[1] + pos[1];
				if(x<0||x>=m||y>=n){
					continue;
				}
				if (grid[x][y]) {
					continue;
				}
				if (x == m - 1 && y == n - 1) {
					return pos[2] + 1;
				}
				if (!seen[x][y]) {
					seen[x][y] = true;
					q.add(new int[] { x, y, pos[2] + 1 });
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] grid = new boolean[3][4];
		grid[2][1]=true;
		int res=shortestPath2(grid);
	}

}
