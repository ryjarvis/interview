package dynamicprogramming;

/**
 * @author: ryjarvis
 * Jan 9, 2018
 * 
 */
//LeetCode #91
public class DecodeWays {
	//optimize this code
    public static int numDecodings2(String s) {
    	if(s.equals("")){
    		return 0;
    	}
    	char[]c=s.toCharArray();
    	int l=s.length();
    	int[]mem=new int[l+1];
    	mem[0]=1;
    	mem[1]=s.length()>=1&&s.charAt(l-1)!='0'?1:0;
    	int i=l-2;
    	while(i>=0){
    		if(c[i]=='0'){
    			mem[l-i]=0;
    		}
    		else{
        		String str=""+c[i]+c[i+1];
        		if(Integer.valueOf(str)<27){
        			mem[l-i]=mem[l-i-1]+mem[l-i-2];
        		}
        		else{
        			mem[l-i]=mem[l-i-1];
        		}
    		}
    		i--;

    	}
    	return mem[l];
    }
    
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i-1) >= '1' && s.charAt(i-1) <= '9')
                dp[i] = dp[i-1];
            if (i > 1) {
                if (s.charAt(i-2) == '1' || s.charAt(i-2) == '2' && s.charAt(i-1) <= '6') {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=numDecodings("1");
		System.out.println(res);

	}

}


