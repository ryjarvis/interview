package arrays;

/**
 * @author: ryjarvis
 * May 13, 2018
 * 
 */
//LeetCode #832
public class FlippingAnImage {
	
    public int[][] flipAndInvertImage(int[][] A) {
        for(int[]ar:A){
        	helper(ar);
        }
        return A;
    }
    
    public void helper(int[]ar){
    	int n=ar.length;
    	int lo=0;
    	int hi=n-1;
    	if(n%2==1){
    		ar[n/2]=ar[n/2]^1;
    	}
    	while(lo<hi){
    		if((ar[lo]^ar[hi])==0){
    			ar[lo]=ar[lo]^1;
    			ar[hi]=ar[lo];
    		}
    		lo++;
    		hi--;
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


