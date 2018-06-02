package stack;

import java.util.Stack;

/**
 * @author: ryjarvis
 * Jan 22, 2018
 * 
 */
//leetCode #150
public class EvaluateReversePolishNotation {
	
    public static int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        int op1;
        int op2;
        for(String s:tokens){
        	switch(s){
        	case "/": 
        		op1=st.pop();
        		op2=st.pop();
        		st.push(op2/op1);
        		break;
        	case "*": 
        		op1=st.pop();
        		op2=st.pop();
        		st.push(op1*op2);
        		break;
        	case "-": 
        		op1=st.pop();
        		op2=st.pop();
        		st.push(op2-op1);
        		break;
        	case "+": 
        		op1=st.pop();
        		op2=st.pop();
        		st.push(op1+op2);
        		break;
        	default:
        			st.push(Integer.valueOf(s));
        			break;
        	}
        		
        }
        return st.pop();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


