package dynamicprogramming;

import java.util.Arrays;

/**
 * @author: ryjarvis
 * Apr 29, 2018
 * 
 */
//LeetCode #712 
public class MinimumASCIIDeleteSumForTwoStrings {
	//this is very similar approach to the longest common subsequence O(n^2) and O(n) space
    public static int minimumDeleteSum(String s1, String s2) {
    	int[] next=new int[s1.length()+1];
        int[] ar=new int[s1.length()+1];
        ar[0]=0;
        for(int j=1;j<s1.length()+1;j++){
        	ar[j]=(int)s1.charAt(j-1)+ar[j-1];
        }
        for(int i=1;i<s2.length()+1;i++){
        	next=new int[s1.length()+1];
        	next[0]=ar[0]+s2.charAt(i-1);
        	for(int j=1;j<s1.length()+1;j++){
        		if(s2.charAt(i-1)==s1.charAt(j-1)){
        			next[j]=ar[j-1];
        		}
        		else{
        			next[j]=Math.min(next[j-1]+s1.charAt(j-1), ar[j]+s2.charAt(i-1));
        		}
        	}
        	ar=next;
        }
        return ar[s1.length()];
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="sea";
		String s2="eat";
		int ans=minimumDeleteSum(s1, s2);
	}

}


