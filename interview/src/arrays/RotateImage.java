package arrays;

public class RotateImage {

	public static void rotate(int[][] matrix) {
		int n=matrix.length;
		int j=0;
		int size=n;
		while(size>0){
			int maxRow=n-1-j;
			int minRow=j;
			int maxCol=n-1-j;
			int minCol=j;
			for(int i=0;i<(size-1);i++){
				int temp=matrix[minRow][i+j];
				matrix[minRow][i+j]=matrix[size-1-i+j][minCol];
				matrix[size-1-i+j][minCol]=matrix[maxRow][size-1-i+j];
				matrix[maxRow][size-1-i+j]=matrix[i+j][maxCol];
				matrix[i+j][maxCol]=temp;
			}
			j++;
			size-=2;
		}
	}
	
    public void rotateOptimized(int[][] mat) {
        // write your code here
        int n=mat.length;
        int level=n+1>>1;
        int i=0;
        int j=n-1;
       for(int k=0;k<level;k++){
           for(int c=i;c<j;c++){
               int temp=mat[i][c];
               mat[i][c]=mat[j-c+i][i];
               mat[j-c+i][i]=mat[j][j-c+i];
               mat[j][j-c+i]=mat[c][j];
               mat[c][j]=temp;
           }
           i++;
           j--;
       }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]mat={{1,2,3},{4,5,6},{7,8,9}};
		rotate(mat);

	}

}
