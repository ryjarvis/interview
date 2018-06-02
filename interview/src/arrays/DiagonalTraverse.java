package arrays;

/**
 * @author: ryjarvis
 * May 29, 2018
 * 
 */
//LeetCode 498
public class DiagonalTraverse {
	
    public static int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[] res=new int[m*n];
        if(m==0) return res;
        traverse(res,0,0,mat,true,0,m,n);
        return res;
    }
    
    public static void traverse(int[]res,int x,int y,int[][]mat,boolean up,int idx,int m,int n){
    	if(x==m-1&&y==n-1){
    		res[idx]=mat[x][y];
    		return;
    	}
    	if(up){
    		while(x>=0&&y<n){
    			res[idx++]=mat[x--][y++];
    		}
    		x++;
    		y--;
    		if(y==n-1) {
    			x++;   			
    		}
    		else{
    			y++;
    		}
    		traverse(res,x,y,mat,false,idx,m,n);
    	}
    	else{
    		while(x<m&&y>=0){
    			res[idx++]=mat[x++][y--];
    		}
    		x--;
    		y++;
    		if(x==m-1) {
    			y++;   			
    		}
    		else{
    			x++;
    		}
    		traverse(res,x,y,mat,true,idx,m,n);
    	}
    }
    
    //cleaner solution
    public int[] findDiagonalOrderOptimized(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        
        int[] result = new int[m * n];
        int row = 0, col = 0, d = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};
        
        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            row += dirs[d][0];
            col += dirs[d][1];
            
            if (row >= m) { row = m - 1; col += 2; d = 1 - d;}
            if (col >= n) { col = n - 1; row += 2; d = 1 - d;}
            if (row < 0)  { row = 0; d = 1 - d;}
            if (col < 0)  { col = 0; d = 1 - d;}
        }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]mat={{1,2,3},{4,5,6},{7,8,9}};
		findDiagonalOrder(mat);

	}

}


