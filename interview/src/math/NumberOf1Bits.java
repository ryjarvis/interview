package math;

/**
 * @author: ryjarvis
 * Dec 25, 2017
 * 
 */
//LeetCode #191
public class NumberOf1Bits {
    public static int hammingWeight(long n) {
        int res=0;
        while(n>0){
            if((n&1)==1){
                res++;
            }
            n=n>>1;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=hammingWeight(2147483648l);
		System.out.println(res);
	}

}


