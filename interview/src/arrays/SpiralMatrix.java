package arrays;
import java.util.List;
import java.util.ArrayList;

//LeetCode #54
public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer>res=new ArrayList<Integer>();
		if(matrix.length==0){
			return new ArrayList<Integer>();
		}
		int row=matrix.length;
		int col=matrix[0].length;
		int min=Math.min(row, col);
		int minRow=0;
		int minCol=0;
		min=(int) Math.ceil((double)min/2);
		for(int i=0;i<min;i++){
			for(int j=minCol;j<col;j++){
				res.add(matrix[minRow][j]);
			}
			for(int k=minRow+1;k<row;k++){
				res.add(matrix[k][col-1]);
			}
			if(row-minRow>1){
				for(int h=col-2;h>=minCol;h--){
					res.add(matrix[row-1][h]);
				}
			}
			if(col-minCol>1){
				for(int m=row-2;m>minRow;m--){
					res.add(matrix[m][minCol]);
				}
			}

			minRow++;
			minCol++;
			col--;
			row--;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]nums={{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
		List<Integer>res=spiralOrder(nums);
		for(Integer i:res){
			System.out.print(i+" ");
		}
	}

}
