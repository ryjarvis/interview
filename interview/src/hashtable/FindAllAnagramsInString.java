package hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryjarvis
 * Apr 18, 2018
 * 
 */
//LeetCode #438
public class FindAllAnagramsInString {
	
    public static List<Integer> findAnagrams(String s, String p) {    	
        List<Integer> res=new ArrayList<>();
        if(s==null||p==null||p.length()>s.length()) return res;
        int count=p.length();
        int[]hash=new int[256];
        int left=0;
        int right=0;
        for(int i=0;i<p.length();i++){
        	hash[p.charAt(i)]++;
        }
        while(right<s.length()){
        	if(hash[s.charAt(right++)]-->0){
        		count--;
        	}
        	if(count==0){
        		res.add(left);
        	}
        	if(right-left==p.length()){
        		if(hash[s.charAt(left)]>=0){
        			count++;
        		}
        		hash[s.charAt(left)]++;
        		left++;
        	}
        	
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer>res=findAnagrams("cbaebabacd", "abc");
		

	}

}


