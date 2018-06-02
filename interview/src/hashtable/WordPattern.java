package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ryjarvis
 * May 22, 2018
 * 
 */
//LeetCode #290
public class WordPattern {
	
    public boolean wordPattern(String str, String pattern) {
        String[]st=pattern.split("\\s");
        Map<String,Character> map=new HashMap<>();
        boolean[]seen=new boolean[26];
        if(st.length!=str.length()) return false;
        for(int i=0;i<st.length;i++){
        	Character val=map.get(st[i]);
        	if(val==null){
                if(!seen[str.charAt(i)-'a']){
                    map.put(st[i], str.charAt(i));
        		    seen[str.charAt(i)-'a']=true;
        		    continue;
                }
                else{
                    return false;
                }

        	}
        	else if(val!=str.charAt(i)){
        		return false;
        	}
        	
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


