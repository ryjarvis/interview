package string;

import java.util.BitSet;
//leetcode #3
public class LongestSubstringWithoutRepeatingCharacters {
	
	//my sub-optimal solution
	public static int lengthOfLongestSubstringSubOptimal(String s) {
		BitSet set = new BitSet(256);
		char[] c=s.toCharArray();
		int i=0;
		int j=0;
		int max=0;
		while(j<s.length()){
			if(set.get((int)c[j])){
				set.set((int)c[i], false);
				max=Math.max(max, (j-1-i)+1);
				i++;
			}
			else{
				set.set((int)c[j]);
				j++;
			}
		}
		max=Math.max(max, set.cardinality());
		return max;		
	}
	public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] charIndex = new int[128];
        
        for (int i = 0, j = 0; i < n; i++) {
            // Move j to the nearest same char that i is pointed to
            j = Math.max(charIndex[s.charAt(i)], j);
            
            // ans is the higher between ans itself and distance between i and j.
            // i - j + 1 - Added one to make sure that when i and j are the same, the character length is 1.
            ans = Math.max(ans, i - j + 1);
            
            // Record the index (i) with the character.
            // + 1 is to make sure we handle the next immediate char
            charIndex[s.charAt(i)] = i + 1;
        }
        
        return ans;
    }
	
		//35ms
	    public int lengthOfLongestSubstringMostOptimal(String s) {
	         int[] idx = new int[128];
	        for(int i = 0; i < idx.length; i++) idx[i] = -1;
	        
	        int ans = 0, start = 0;
	        for(int i = 0; i < s.length(); i++){
	            int cIdx = s.charAt(i);
	            if(idx[cIdx]>=start)  start = idx[cIdx]+1;               
	            idx[cIdx] = i;
	            ans = Math.max(ans, i-start+1);
	        }
	        return ans;
	    }
	

	public static void main(String[] args) {
		String s="pwwkew";
		int max=lengthOfLongestSubstring(s);
		System.out.println(max);
	}

}
