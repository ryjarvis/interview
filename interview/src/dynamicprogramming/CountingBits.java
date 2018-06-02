package dynamicprogramming;

/**
 * @author: ryjarvis
 * Apr 14, 2018
 * 
 */
//LeetCode #338
public class CountingBits {
	//non DP solution
    public static int[] countBitsNonDP(int num) {
        int[] ans=new int[num+1];
        for(int i=0;i<ans.length;i++){
            ans[i]=bitCounter(i);
        }
       return ans; 
        
    }
    
    public static int bitCounter(int i){
        int counter=0;
        while(i>0){
            i&=(i-1);
            counter++;
        }
        return counter;
    }
    
    //DP solution
    public static int[] countBits(int num) {
    	int[]ans=new int[num+1];
    	for(int i=1;i<=num;i++){
    		ans[i]=ans[i>>1]+(i&1);
    	}
    	return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


