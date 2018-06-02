package string;

/**
 * @author: ryjarvis
 * Mar 24, 2018
 * 
 */

public class LongestSubstringwithAtLeastKRepeatingCharacters {
	
    public static int longestSubstring(String s, int k) {
    	if(k<=1) return s.length();
        int[] map=new int[26];
        char[]c=s.toCharArray();
        for(char ch:c){
        	map[ch-'a']++;
        }
        return helper(0,c.length-1,k,c,map);
    }
    
    public static int helper(int l,int r,int k,char[]c,int[]map){
    	int i=l;
    	while(i<c.length&&map[c[i]-'a']>=k) i++;
    	int left=
    	return Math.max(i-l, helper(i+1,r,k,c,map));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestSubstring("aaabb", 3);

	}

}


