package dynamicprogramming;
//LeetCode #10
public class RegularExpressionMatching {
	
    public static boolean isMatch(String s, String p) {
       int dp[][]=new int[s.length()+1][p.length()+1];
       return matcher(dp,0,0,s,p);
    }
    
    public static boolean matcher(int[][] dp,int i,int j,String s,String p){
    	if(dp[i][j]!=0){
    		return dp[i][j]==2;
    	}
    	if(j==p.length()){
    		return i==s.length();
    	}
    	boolean ans=false;
    	boolean isFirstMatch=i<s.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.');
    	if(j+1<p.length()&&p.charAt(j+1)=='*'){
    		ans=(isFirstMatch&&matcher(dp, i+1, j, s, p))||matcher(dp, i, j+2, s, p);
    	}
    	else{
    		ans=isFirstMatch&&matcher(dp, i+1, j+1, s, p);
    	}
    	if(i<s.length()&&j<p.length()){
    		dp[i][j]=ans?2:1; 
    	}
    	
    	return ans;
    }
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean ans=isMatch("aa", "aaa");
		System.out.println(ans);
	}

}
