package competitions;

import java.util.Arrays;

import competitions.Question623.TreeNode;

/**
 * @author: ryjarvis
 * Dec 9, 2017
 * 
 */

public class Question622 {
	//Sample Answer
    public static final int INF = (int) 1e8;
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] map = new int[N][N];
        for (int[] ints : map) {
            Arrays.fill(ints, INF);
        }
        for (int i = 0; i < N; i++) {
            map[i][i] = 0;
        }
        for (int[] time : times) {
            map[time[0] - 1][time[1] - 1] = Math.min(map[time[0] - 1][time[1] - 1], time[2]);
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        K--;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (map[K][i] >= INF) {
                return -1;
            }
            answer = Math.max(answer, map[K][i]);
        }
        return answer;
    }
    //New Sample
    
    public int networkDelayTimeSample2(int[][] times, int N, int K) {
        int inf = 1 << 29;
        int[][] f = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(f[i], inf);
            f[i][i] = 0;
        }

        for (int[] time : times) {
            int u = time[0] - 1, v = time[1] - 1, w = time[2];
            f[u][v] = Math.min(f[u][v], w);
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j]);
        }

        K--;
        int ans = 0;
        for (int i = 0; i < N; i++)
            if (i != K) {
                ans = Math.max(ans, f[K][i]);
            }
        return ans >= inf ? -1 : ans;
    }
    //

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


