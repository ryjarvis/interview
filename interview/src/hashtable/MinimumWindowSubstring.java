package hashtable;

import java.util.Arrays;

//LeetCode #76
public class MinimumWindowSubstring {
	// FIRST IDEA THAT CAME TO MY MIND WAS TO KEEP THE SECOND INDEX
	// THE PROBLEM WITH THIS METHOD IS YOU WILL SOON WILL HAVE A PROBLEM KEEPING
	// THE SECOND PROBLEM.
	// EVEN IF YOU INTRODUCE THIRD ELEMENT CONCEPT AFTER TWO STEP YOU WILL LOSE
	// YOUR SECOND ELEMENT IDX
	public static String minWindow(String s, String t) {
		String ans = "";
		int n = t.length();
		int m = s.length();
		if (n == 0) {
			return ans;
		}
		int[] map = new int[256];
		for (char c : t.toCharArray()) {
			map[(int) c]++;
		}
		int firstIdx = 0;
		int end = 0;
		int head = -1;
		int count = 0;
		int minCount = Integer.MAX_VALUE;
		while (end < m) {
			if (map[(int) s.charAt(end)]--> 0) {
				count++;
			}
            end++;
			while (count == n) {
				if (end - firstIdx< minCount) {
					minCount = end - firstIdx;
					head = firstIdx;
				}
				if (map[(int) s.charAt(firstIdx)]++ == 0) {
					count--;
				}
				firstIdx++;                                       
			}
		
		}
		return head == -1 ? "" : s.substring(head, head+minCount);

	}
	
    public static String minWindowCopy(String s, String t) {
        
        int s_len = s.length();
        int t_len = t.length();
        int ruler = t_len;
        
        int res = Integer.MAX_VALUE;
        int start = 0;
        
        int[] freq = new int[128];
        
        char[] c_s = s.toCharArray();
        char[] c_t = t.toCharArray();
        
        // count char in t
        for (char c : c_t)
            freq[c]++;
        
        int i = 0, j = 0;
        while (j < s_len) {
            
            // whether ruler can expand
            if (freq[c_s[j++]]-- >= 1)
                ruler--;
            
            // if ruler == 0, it means all char in t has been contained in window now
            while (ruler == 0) {
                
                // choose min window
                if (res > j - i) {
                    res = j - i;
                    start = i;
                }
                
                // narrow left border
                if (freq[c_s[i++]]++ == 0)
                    ruler++;
                    
            }
            
        }
        
        return res == Integer.MAX_VALUE ? "" : s.substring(start, start + res);
        
    }
	// BETTER WAY OF SOLVING THIS WOULD BE WHILE LOADING THE ELEMENTS MAKE SURE
	// TO -- ALL THE ELEMENTS
	// IN THAT CASE IF THE ELEMENT NOT PRESENT IN T WOULD BE -1 THEN TO FIND THE
	// NEXT ELEM YOU GO AS FAR AS THE POINT THAT YOU
	// SEE 0 ELEMENT IN YOUR MAP.
	// OTHER SOLUTION WOULD BE KEEPING THE ORIGINAL MAP WHILE WORKING WITH THE
	// TEMP MAP AND GOING FORWARD AS LONG
	// AS YOU SEE MAPPED ELEMENT IS PRESENT. This method won't work because won't bring us to the closest element from end. if they are two elements with the same values 
	//this method always choose the closest one to the 0 idx. better way would be try and solve this backwards firstidx going from end to the beginning that also won't work we need to solve it 
	//using just map

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="ADOBECODEBANC";
		String t="ABC";	
		String ans=minWindow(s, t);
		System.out.println(ans);
		String val=minWindowCopy(s,t);
		System.out.println(val);
	}

}
