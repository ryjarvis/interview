package design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//LeetCode #688
public class KnightProbabilityInChessboard {
	public static final int[][] MOVES = { { 2, 1 }, { -2, 1 }, { 2, -1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 },
			{ -1, -2 } };

	public static double knightProbability(int N, int K, int r, int c) {
		int[][]mem=new int[N][N];
		double res=1;
		if(K==0){
			return res;
		}
		return helper(mem, new HashMap<>(), N,K, new int[]{r,c});
	}
	
	public static double helper(int[][]mem,Map<int[],List<int[]>>map,int n,int k,int[]ar){
		if(k==0){
			return 1;
		}
		if(map.get(ar)==null){
			compute(mem,map,ar);
		}
		double result=0;
		for(int[]l:map.get(ar)){
			 result+=(1d/(n*n)-1)*helper(mem,map,n,k-1,l);
		}
		return result;
		                 
	}
	
	public static void compute(int[][]mem,Map<int[],List<int[]>>map,int[]ar){
		map.put(ar,new ArrayList<>());
		int r=ar[0];
		int c=ar[1];
		for(int[]m:MOVES){
			if(r+m[0]<mem.length&&r+m[0]>=0&&c+m[1]<mem.length&&c+m[1]>=0){
				List<int[]> list=map.get(ar);
				list.add(new int[]{r+m[0],c+m[1]});
				map.put(ar,list);
			}
		}
	}
	
	 static int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
	public static double knightProbability2(int N, int K, int r, int c) {
	    int len = N;
	    double dp0[][] = new double[len][len];
	    for(double[] row : dp0) Arrays.fill(row, 1);
	    for(int l = 0; l < K; l++) {
	        double[][] dp1 = new double[len][len];
	        for(int i = 0; i < len; i++) {
	            for(int j = 0; j < len; j++) {
	                for(int[] move : moves) {
	                    int row = i + move[0];
	                    int col = j + move[1];
	                    if(isLegal(row, col, len)) dp1[i][j] += dp0[row][col];
	                }
	            }
	        }
	        dp0 = dp1;
	    }
	    return dp0[r][c] / Math.pow(8, K); 
	}
	private static boolean isLegal(int r, int c, int len) {
	    return r >= 0 && r < len && c >= 0 && c < len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		knightProbability(3, 2, 0, 0);
		knightProbability2(3, 2, 0, 0);
		
	}

}
