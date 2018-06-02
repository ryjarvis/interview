package competitions;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ryjarvis
 * Jan 13, 2018
 * 
 */

public class Question671 {
	
    public int orderOfLargestPlusSign(int n, int[][] m) {
    	if(n==0){
    		return 0;
    	}
    	if(m.length==0){
    		return (n+1)/2;
    	}
    	boolean[][]ar=new boolean[n][n];
    	for(int i=0;i<m.length;i++){
    		ar[m[i][0]][m[i][1]]=true;
    	}
    	int max=0;
        for(int i=0;i<n;i++){
        	for(int j=0;j<n;j++){
        		if(!ar[i][j]){
        			max=Math.max(max, help(i,j,ar));
        		}
        	}
        }
        return max;
    }
    
    public int help(int i,int j,boolean[][]a){
    	int res=0;
    	int s=a.length;
    	int left=i;
    	int right=i;
    	int up=j;
    	int down=j;
    	
    	while(right<s){
    		if(a[right][j]){
    			break;
    		}
    		right++;
    	}
    	res=right-i;
    	while(left>=0&&i-left<=res){
    		if(a[left][j]){
    			break;
    		}
    		left--;
    	}
    	res=Math.min(res, i-left);
    	while(up>=0&&j-up<=res){
    		if(a[i][up]){
    			break;
    		}
    		up--;
    	}
    	res=Math.min(res, j-up);
    	
    	while(down<s&&down-j<=res){
    		if(a[i][down]){
    			break;
    		}
    		down++;
    	}
    	res=Math.min(res, down-j);
    	return res;
    	
    }
    


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


