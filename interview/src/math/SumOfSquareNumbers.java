package math;

/**
 * @author: ryjarvis
 * May 24, 2018
 * 
 */
//LeetCode #633
public class SumOfSquareNumbers {
	
    public boolean judgeSquareSum(int c) {
        long lo=0;
        long hi=(long)Math.sqrt(c);
        while(lo<=hi){
            long sum=lo*lo + hi*hi;
            if(sum<c) {
                lo++;
            }
            else if(sum>c) {
                hi--;
            }
            else{
              return true;  
            } 
        }
        return false;        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


