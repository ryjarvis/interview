package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ryjarvis
 * Apr 2, 2018
 * 
 */
//LeetCode #542
public class ZeroOneMatrix {
	
	public int[][] updateMatrix(int[][] mat) {
		Queue<int[]> q=new LinkedList<>();
		int m=mat.length;
		int n=mat[0].length;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(mat[i][j]==0){
					q.offer(new int[]{i,j});
				}
				else{
					mat[i][j]=Integer.MAX_VALUE;
				}
			}
		}
		int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
		while(!q.isEmpty()){
			int[]temp=q.poll();
			for(int i=0;i<dir.length;i++){
				int r=dir[i][0]+temp[0];
				int c=dir[i][1]+temp[1];
				if(r>=m||r<0||c<0||c>=n||mat[temp[0]][temp[1]]>=mat[r][c]){
					continue;
				}
				else{
					mat[r][c]=mat[temp[0]][temp[1]]+1;
					q.offer(new int[]{r,c});
				}
			}
		}
		return mat;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


