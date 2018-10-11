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
    
    public void setZeroesOptimized(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int row=-1;
        int col=-1;
        for(int i=0;i<m;i++){
            if(row!=-1&&i==row){
                continue;
            }
            for(int j=0;j<n;j++){
                if(col!=-1&&j==col){
                    continue;
                }
                if(mat[i][j]==0){
                    if(row==-1){
                       row=i;
                        col=j; 
                    }
                    else{
                        mat[i][col]=0;
                        mat[row][j]=0;
                    }
                }
            }
        }
        if(row==-1){
            return;
        }
        for(int i=0;i<m;i++){
            if(i==row){
                continue;
            }
            if(mat[i][col]==0){
                Arrays.fill(mat[i],0);
            }
        }
        for(int j=0;j<n;j++){
            if(mat[row][j]==0){
                for(int i=0;i<m;i++){
                    mat[i][j]=0;
                }
            }
        }
        
        Arrays.fill(mat[row],0); 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


