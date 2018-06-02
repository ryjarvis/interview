package arrays;

/**
 * @author: ryjarvis
 * Apr 28, 2018
 * 
 */
//LeetCode #667 
public class BeautifulArrangementII {
	
    public int[] constructArray(int n, int k) {
    	int[]res=new int[n];
    	int j=k+1;
        for(int i=0;i<=k;i++){
        	res[i]=i%2==0?i+1:j--;
        }
        for(int i=k+1;i<n;i++){
        	res[i]=i+1;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


