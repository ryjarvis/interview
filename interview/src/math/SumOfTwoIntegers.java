package math;

/**
 * @author: ryjarvis
 * Dec 27, 2017
 * 
 */
//LeetCode #371
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if(b==0)return a;
        int s=a^b;
        int p=a&b;        
        return getSum(s,p<<1);       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


