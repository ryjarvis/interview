package competition87;

import java.util.Stack;

/**
 * @author: ryjarvis
 * Jun 2, 2018
 * 
 */

public class Question1 {
	
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> st1=helper(S);
        Stack<Character> st2=helper(T);
        if(st1.size()!=st2.size()) return false;
        while(!st1.isEmpty()){
        	if(st1.pop()!=st2.pop()){
        		return false;
        	}
        }
        return true;
    }
    
    public Stack<Character> helper(String s){
    	Stack<Character>st=new Stack<>();
    	for(char c:s.toCharArray()){
    		if(c=='#'){
    			if(st.size()>0){
    				st.pop();
    			}
    			continue;
    		}
    		st.push(c);
    	}
    	return st;
    }
    
    public boolean backspaceCompare2(String S, String T) {
    	return sim(S).equals(sim(T));
    }
    
    String sim(String s)
    {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0;i < s.length();i++){
    		if(s.charAt(i) == '#'){
    			if(sb.length() > 0){
    				sb.deleteCharAt(sb.length()-1);
    			}
    		}else{
    			sb.append(s.charAt(i));
    		}
    	}
    	return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


