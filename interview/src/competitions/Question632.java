package competitions;

import java.util.BitSet;

/**
 * @author: ryjarvis
 * Dec 16, 2017
 * 
 */

public class Question632 {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
    	String s=licensePlate.replaceAll("[^A-Za-z]", "");
    	int[] b=new int[26];
    	for(int i=0;i<s.length();i++){
    		int j=s.charAt(i)-'A'>=26?s.charAt(i)-'a':s.charAt(i)-'A';
    		b[j]++;
    	}
    	
    	String res="";
    	boolean first=true;
    	for(int i=0;i<words.length;i++){
        	int[] w=new int[26];
        	String t=new String(words[i]);
        	for(int k=0;k<t.length();k++){
        		int j=t.charAt(i)-'a';
        		w[j]++;
        	}
        	if(ok(b,w)){
        		if(first){
        			res=words[i];
        			first=false;
        		}
        		else if(!first&&words[i].length()<res.length()){
        			res=words[i];
        		}
        	}
    	}
    	return res;   	
    }
	
    public static boolean ok(int[]m,int[]n){
    	for(int i=0;i<26;i++){
    		if(m[i]>0){
    			if(m[i]!=n[i]){
    				return false;
    			}
    		}
    	}
    	return true;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []w={"step","steps","stripe","stepple"};
		String s="1s3 PSt";
		String res=shortestCompletingWord(s, w);
	}

}


