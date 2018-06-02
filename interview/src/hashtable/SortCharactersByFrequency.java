package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ryjarvis
 * Apr 19, 2018
 * 
 */
//LeetCode 451
public class SortCharactersByFrequency {
	 public static String frequencySort(String s) {
	        char[]c=s.toCharArray();
	        Arrays.sort(c);
	        List<Character>[]bucket=new List[s.length()];
	        int prev=0;
	        int max=0;
	        for(int i=1;i<s.length();i++){
	            if(c[i]!=c[prev]||i==s.length()-1){
	            	if(i-prev>max){
	            		max=i-prev;
	            	}
	                if(bucket[i-prev]==null){
	                	bucket[i-prev]=new ArrayList<Character>();
	                }
	                bucket[i-prev].add(c[prev]);
	                prev=i;
	            }
	        }
	        StringBuilder sb=new StringBuilder();
	        for(int i=max;i>0;i--){
	            if(bucket[i]==null) continue;
	        	for(char ch:bucket[i]){
	            	for(int j=0;j<i;j++){
	            		sb.append(ch);
	            	}
	        	}
	        }
	        return sb.toString();
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="rmeetttt";
		String st=frequencySort(s);
	}

}


