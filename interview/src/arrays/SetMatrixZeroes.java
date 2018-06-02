package arrays;
import java.util.BitSet;

/**
 * @author: ryjarvis
 * Nov 26, 2017
 * 
 */
//LeetCode #73
public class SetMatrixZeroes {
    public static void setZeroes(int[][] mat) {
    	int m=mat.length;
    	int n=mat[0].length;
    	BitSet row=new BitSet(m);
    	BitSet col=new BitSet(n);
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++){
    			if(mat[i][j]==0){
    				row.set(i);
    				col.set(j);
    			}
    		}
    	}
    	int set=0;
    	for(int i=0;i<row.cardinality();i++){
    		set=row.nextSetBit(set);
    		for(int k=0;k<n;k++){
    			mat[set][k]=0;
    		}
    		set++;
    	}
    	set=0;
    	for(int i=0;i<col.cardinality();i++){
    		set=col.nextSetBit(set);
    		for(int j=0;j<m;j++){
    			mat[j][set]=0;
    		}
    		set++;
    	}
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


