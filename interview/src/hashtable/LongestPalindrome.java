package hashtable;

/**
 * @author: ryjarvis
 * May 28, 2018
 * 
 */
//LeetCode #409
public class LongestPalindrome {
	//O(n)
    public int longestPalindrome(String s) {
        int[]count=new int[128];
        int total=0;
        for(char c:s.toCharArray()){
            count[c]++;
        }
        for(int i:count){
            total+=i/2*2;
            if((total&1)==0&&(i&1)==1){
                total++;
            }
        }
        return total;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


