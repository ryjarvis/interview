package arrays;
//LintCode #38
public class Search2DMatrixIILintCode {
	
    public int searchMatrix(int[][] mat, int target) {
        int m=mat.length;
        if(m==0) return 0;
        int n=mat[0].length;
        int j=n-1;
        int i=0;
        int count=0;
        while(j>=0&&i<m){
            if(mat[i][j]==target){
                count++;
                i++;
                j--;
            }
            else if(target<mat[i][j]){
                j--;
            }
            else{
                i++;
            }
        }
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
