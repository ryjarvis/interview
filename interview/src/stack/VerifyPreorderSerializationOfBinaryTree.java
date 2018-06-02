package stack;

import java.util.Stack;

/**
 * @author: ryjarvis
 * May 23, 2018
 * 
 */
//LeetCode #331
public class VerifyPreorderSerializationOfBinaryTree {
	//O(n)
    public static boolean isValidSerialization(String preorder) {
    	if(preorder.isEmpty()) return true;
        Stack<String> st=new Stack<>();
        String[]ar=preorder.split(",");
        for(String c:ar){
        	if(c.equals("#")){
        		while(!st.isEmpty()&&st.peek().equals("#")){
        			if(st.size()<2) return false;
        			st.pop();
        			st.pop();
        		}
        		st.push(c);
        	}
        	else{
        		st.push(c);
        	}
        	
        }
        return st.size()==1&&st.peek()=="#";
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="9,#,92,#,#";
		isValidSerialization(s);
	}

}


