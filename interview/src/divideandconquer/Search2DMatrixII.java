package divideandconquer;

/**
 * @author: ryjarvis
 * Feb 4, 2018
 * 
 */
//LeetCode #240
public class Search2DMatrixII {
	
	public boolean searchMatrix(int[][]mat,int t){
		int  m=mat.length;
		if(m==0){
			return false;
		}
		int r=0;
		int n=mat[0].length;
		int c=n-1;
		while(r<m&&c>=0){
			if(mat[r][c]==t){
				return true;
			}
			else if(mat[r][c]<t){
				r++;
			}
			else{
				c--;
			}
		}
		return false;
	}
	
	//This solution not going to work if the value is smaller than mid because then it can be anywher
	
	public boolean searchMatrixWrong(int[][]mat,int t){
		int m=mat.length;
		if(m==0)return false;
		int n=mat[0].length;
		int l=0;
		int r=m;
		while(l<r){
			int mid=l+(r-l)/2;
			if(mat[mid][n]==t){
				return true;
			}
			else if(mat[mid][n]<t){
				l=mid+1;
			}
			else{
				r=mid;
			}
		}
		return binarySearch(mat[r],t,0,n);
	}
	public boolean binarySearch(int[]ar,int t,int l,int r){
		if(r<0||l>=ar.length){
			return false;
		}
		if(l==r){
			return ar[l]==t;
		}
		else{
			int mid=(r-l)/2+l;
			if(ar[mid]==t){
				return true;
			}
			else if(ar[mid]<t){
				return binarySearch(ar,t,mid+1,r);
			}
			else{
				return binarySearch(ar,t,l,mid-1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


