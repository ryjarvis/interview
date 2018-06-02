package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ryjarvis
 * May 12, 2018
 * 
 */
//LeetCode #804 
public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[]morse={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set=new HashSet<>();
        
        for(String s:words){
            StringBuilder sb=new StringBuilder();
            for(char c:s.toCharArray()){
                sb.append(morse[c-'a']);
            }
            if(!set.contains(sb.toString())){
                set.add(sb.toString());
            }
        }
       return set.size(); 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


