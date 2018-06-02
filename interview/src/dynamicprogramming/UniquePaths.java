package dynamicprogramming;

/**
 * @author: ryjarvis Nov 25, 2017
 * 
 */

//LeetCode #62
public class UniquePaths {
	
	public static int uniquePaths(int m, int n) {
		int c=m-1+n-1;
		int k=Math.min(m, n);
		long numerator=1;
		long denominator=1;
		for(int i=0;i<k;i++){
			numerator*=c-i;
			denominator*=(i+1);
		}
		return (int)(numerator/denominator);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=uniquePaths(50,50);
		System.out.println(res);
		
	}

}
