package math;

/**
 * @author: ryjarvis
 * Dec 19, 2017
 * 
 */
//LeetCode #9
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int d=numberOfDigits(x);
        int hi;
        int lo;
        boolean res=true;
        while(res&&d>1){
            hi=x/(int)Math.pow((double)10,(double)(d-1));
            x=x%(int)Math.pow((double)10,(double)(d-1));
            lo=x%10;
            x/=10;
            d-=2;
            if(hi!=lo){
                res=false;
            }            
        }
        return res;
    }
    
    public int numberOfDigits(int n){
        int i=0;
        if(n==0){
            return 1;
        }
        while(n>0){
            n/=10;
            i++;
        }
         return i;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


