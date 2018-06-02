package string;

import java.util.LinkedList;

/**
 * @author: ryjarvis Jan 26, 2018
 * 
 */
// LeetCode #227
public class BasicCalculatorII {

	public static int calculate(String s) {
		s = s.replaceAll("\\s", "");
		LinkedList<String> stack = new LinkedList<>();
		String[] strArray = s.split("\\D");
		int i = 0;
		int j = 0;
		int op1;
		int op2;
		while (i < s.length()) {
			if (s.charAt(i) == '/') {
				op1 = Integer.valueOf(stack.pop());
				i += strArray[j].length() + 1;
				op2 = Integer.valueOf(strArray[j++]);
				stack.push(String.valueOf(op1 / op2));
			} else if (s.charAt(i) == '*') {
				op1 = Integer.valueOf(stack.pop());
				i += strArray[j].length() + 1;
				op2 = Integer.valueOf(strArray[j++]);
				stack.push(String.valueOf(op1 * op2));
			} else if (s.charAt(i) == '-') {
				i++;
				stack.push("-");
			} else if (s.charAt(i) == '+') {
				i++;
				stack.push("+");
			}

			else {
				i+=strArray[j].length();
				stack.push(strArray[j++]);
			}
		}
		while(stack.size()>2){
			op1=Integer.valueOf(stack.removeLast());
			String operand=stack.removeLast();
			op2=Integer.valueOf(stack.removeLast());
			if(operand.equals("-")){
				op1=op1-op2;
				stack.addLast(String.valueOf(op1));
			}
			else{
				op1=op1+op2;
				stack.addLast(String.valueOf(op1));
			}
		}
		return Integer.valueOf(stack.pop());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="3+2*2";
		int res=calculate(s);

	}

}
