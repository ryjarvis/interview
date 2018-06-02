package math;

/**
 * @author: ryjarvis
 * May 7, 2018
 * 
 */
//LeetCode #343 
public class IntegerBreak {
	
    public int integerBreak(int n) {
        if(n<4){
            return n-1;
        }
        int div=n/3;
        int res=n-div*3;
        if(res==1){
            res=4;
            div--;
        }
        res=res==0?1:res;
        
        
        return (int)Math.pow(3,div)*res;
        
    }
    public static int integerBreakDP(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    int max = 0;
    for(int i = 1; i < n; i++){
        for(int j = i; j <= n; j++){
            dp[j] = Math.max(dp[j], dp[j - i] * i);
            if(j == n){
                if(max < dp[j])
                    max = dp[j];
            }
        }
    }
    return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		integerBreakDP(5);
	}

}


