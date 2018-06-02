package hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.BitSet;

/**
 * @author: ryjarvis
 * Jan 25, 2018
 * 
 */
//LeetCode #387
public class FirstUniqueCharacterInString {
	//not optimized straightforward solution
    public int firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<>();
        BitSet set=new BitSet(s.length());
        char[]arr=s.toCharArray();       
        for(int i=0;i<arr.length;i++){
        	Integer count=map.get(arr[i]);
        	if(count==null){
        		map.put(arr[i], i);
        		set.set(i);
        	}
        	else{
        		set.set(count,false);
        		set.set(i,false);
        	}
        }
        return set.nextSetBit(0);
    }
    //more optimized two path solution
    public int firstUniqCharTwoPath(String s) {
        int [] arr=new int[26];
        char[]charArray=s.toCharArray();
        for(char c:charArray){
        	int i=c-'a';
            arr[i]++;
        }
        for(int i=0;i<charArray.length;i++){
        	if(arr[charArray[i]-'a']==1){
        		return i;
        	}
        }
        return -1;
    }
    //fully Optimized solution
    public int firstUniqCharOptimized(String s){
    	int res=s.length();
    	for(char c='a';c<='z';c++){
    		if(s.indexOf(c)!=-1&&s.indexOf(c)==s.lastIndexOf(c)){
    			res=Math.min(res, s.indexOf(c));
    		}
    	}
    	return res==s.length()?-1:res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


