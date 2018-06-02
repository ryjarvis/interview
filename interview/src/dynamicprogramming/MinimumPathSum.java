package dynamicprogramming;

/**
 * @author: ryjarvis
 * Apr 15, 2018
 * 
 */
//LeetCode #64
public class MinimumPathSum {
	//do the first row differently speed up the process
	//Time complexity is o(n^2)
    public int minPathSum(int[][] grid) {
    	int m=grid.length;
    	int n=grid[0].length;
        int prev;
        for(int k=1;k<n;k++){
            grid[0][k]+=grid[0][k-1];
        }
        for(int i=1;i<m;i++){
        	prev=Integer.MAX_VALUE;
        	for(int j=0;j<n;j++){
        		grid[i][j]+=Math.min(prev, grid[i-1][j]);
        		prev=grid[i][j];
        	}	
        }
        return grid[m-1][n-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


