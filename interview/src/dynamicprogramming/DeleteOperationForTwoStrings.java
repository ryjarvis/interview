package dynamicprogramming;

/**
 * @author: ryjarvis
 * May 24, 2018
 * 
 */
//LeetCode #583
public class DeleteOperationForTwoStrings {
	
	 public static int minDistance(String word1, String word2) {
	        int m=word1.length();
	        int n=word2.length();
	        int[]mem;
	        if(m==0||n==0){
	            return Math.max(m,n);
	        }
	        int[]pre=new int[m+1];
	        for(char c:word2.toCharArray()){
	        	mem=new int[m+1];
	        	for(int i=1;i<m+1;i++){
	        		mem[i]=Math.max(pre[i], mem[i-1]);
	        		if(c==word1.charAt(i-1)&&pre[i-1]+1>mem[i]){
	        			mem[i]=pre[i-1]+1;
	        		}
	        	}
	    		pre=mem;
	        }
	        return m-pre[m]-pre[m]+n;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="mehran";
		String t="shahram";
		minDistance(s, t);
		
	}

}


