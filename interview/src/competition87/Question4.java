package competition87;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: ryjarvis Jun 2, 2018
 * 
 */

public class Question4 {

	public int shortestPathLength(int[][] graph) {
		int n = graph.length;
		int[][] g = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(g[i], 9999999);
			g[i][i] = 0;
		}
		for (int i = 0; i < n; i++) {
			for (int e : graph[i]) {
				g[i][e] = g[e][i] = 1;
			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (g[i][j] > g[i][k] + g[k][j]) {
						g[i][j] = g[i][k] + g[k][j];
					}
				}
			}
		}

		long[][] dp = new long[1 << n][n];
		for (int i = 1; i < 1 << n; i++) {
			Arrays.fill(dp[i], 99999999);
			if (Integer.bitCount(i) == 1) {
				dp[i][Integer.numberOfTrailingZeros(i)] = 0;
			} else {
				for (int j = 0; j < n; j++) {
					if (i << ~j < 0) {
						for (int k = 0; k < n; k++) {
							if (i << ~k < 0 && j != k) {
								// k -> j
								dp[i][j] = Math.min(dp[i][j], dp[i ^ 1 << j][k] + g[k][j]);
							}
						}
					}
				}
			}
		}
		long ret = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			ret = Math.min(ret, dp[(1 << n) - 1][i]);
		}
		return (int) ret;
	}

	public int shortestPathLength2(int[][] graph) {
		int[][] dp = new int[graph.length][1 << graph.length];
		LinkedList<State> q = new LinkedList<State>();
		for (int i = 0; i < graph.length; i++) {
			Arrays.fill(dp[i], 1 << 25);
			dp[i][1 << i] = 0;
			q.add(new State(1 << i, i));
		}
		while (!q.isEmpty()) {
			State curr = q.removeFirst();
			for (int j : graph[curr.d]) {
				int nmask = curr.mask | (1 << j);
				if (dp[j][nmask] > dp[curr.d][curr.mask] + 1) {
					dp[j][nmask] = dp[curr.d][curr.mask] + 1;
					q.add(new State(nmask, j));
				}
			}
		}
		int ret = Integer.MAX_VALUE;
		for (int i = 0; i < graph.length; i++) {
			ret = Math.min(ret, dp[i][dp[0].length - 1]);
		}
		return ret;
	}

	class State {
		public int mask, d;

		public State(int a, int b) {
			mask = a;
			d = b;
		}
	}
	
    public int shortestPathLength3(int[][] graph) {
        int n = graph.length;
        int n2 = 1<<n;
        int[] dp = new int[n*n2];
        for (int i = 0; i < n*n2; i++) {
            dp[i] = 1000;
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            q.add(i*n2+(1<<i));
            dp[i*n2+(1<<i)] = 0;
        }
        while (!q.isEmpty()) {
            int rem = q.removeFirst();
            int u = rem/n2;
            int bm = rem-u*n2;
            if (bm == n2-1)
                return dp[rem];
            for (int v : graph[u]) {
                int dpc = (bm|(1<<v))+v*n2;
                if (dp[rem]+1<dp[dpc]) {
                    q.add(dpc);
                    dp[dpc] = dp[rem]+1;
                }
            }
        }
        return -1;
    }
    
    private Integer[][] Memo;
    public int shortestPathLength4(int[][] graph) {
        int n = graph.length;
        if (n == 1) {
            return 0;
        }
        Memo = new Integer[n + 1][(1 << n) + 1];
        int [][]sp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(sp[i], -1);
        }
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                sp[i][j] = 1;
            }
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (sp[i][k] != -1 && sp[k][j] !=-1) {
                        if (sp[i][j] == -1 || sp[i][j] > sp[i][k] + sp[k][j]) {
                            sp[i][j] = sp[i][k] + sp[k][j];
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min,dfs(sp, i, 1 << i));
        }
        return min;
    }

    private int dfs(int [][]sp, int start, int state) {
        if (Memo[start][state] != null) {
            return Memo[start][state];
        }
        if (Integer.bitCount(state) == sp.length) {
            return Memo[start][state] = 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < sp.length; i++) {
            if (sp[start][i] > 0 && ((state >> i) & 1) == 0) {
                int a = dfs(sp, i, state | (1 << i));
                if (a != Integer.MAX_VALUE) {
                    ans = Math.min(ans, sp[start][i] + a);
                }
            }
        }
   
        return Memo[start][state] = ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
