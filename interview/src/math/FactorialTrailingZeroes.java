package math;

/**
 * @author: ryjarvis
 * Dec 25, 2017
 * 
 */
//LeetCode #172
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int res=0;
        long div=5;
        while(n>=div){
            res+=(n/div);
            div*=5;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


