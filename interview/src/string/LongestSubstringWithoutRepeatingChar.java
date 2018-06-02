package string;

import java.util.BitSet;

public class LongestSubstringWithoutRepeatingChar {
	// leetCode 3
	public static int lengthOfLongestSubstring(String s) {
		BitSet set = new BitSet(128);
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   

	}

}
