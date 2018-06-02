package dynamicprogramming;

import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: ryjarvis
 * Jan 21, 2018
 * 
 */
//LeetCode #139
public class WordBreak {
	//with bitset 23ms
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        BitSet mem=new BitSet(s.length()+1);
        mem.set(0, true);
        for(int i=1;i<=s.length();i++){
        	for(int j=0;j<i;j++){
        		if(mem.get(j)&&set.contains(s.substring(j, i))){
        			mem.set(i);
        			break;
        		}
        	}
        }
        mem.set(0,false);
        return mem.get(s.length());
        
    }
    //with boolean array 6ms
    public boolean wordBreakArray(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>();
        int l= s.length();
        int max=0;
        for(String d:wordDict){
        	if(d.length()<=l){
        		set.add(d);
        		max=Math.max(max, d.length());
        	}        	
        }
        boolean[]mem=new boolean[l+1];
        mem[0]=true;
        for(int i=1;i<=l;i++){
        	for(int j=Math.max(0, i-max-1);j<i;j++){
        		if(mem[j]&&set.contains(s.substring(j, i))){
        			mem[i]=true;
        			break;
        		}
        	}
        }
        return mem[l];        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


