package stack;

import java.util.Stack;

/**
 * @author: ryjarvis Jan 26, 2018
 * 
 */
// LeetCode #735
public class AsteroidCollision {
	public int[] asteroidCollision(int[] ast) {
		int l = ast.length;
		if (l < 2)
			return ast;
		Stack<Integer> st = new Stack<>();
		st.push(ast[0]);
		for (int i = 1; i < l; i++) {
			if (!st.isEmpty()&&st.peek() > 0 && ast[i] < 0) {
				while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(ast[i])) {
					st.pop();
				}
				if(st.isEmpty()){
					st.push(ast[i]);
				}
				else if (st.peek()<0) {
					st.push(ast[i]);
				} else if (Math.abs(ast[i])==st.peek()) {
					st.pop();
				}
			} else {
				st.push(ast[i]);
			}
		}
		l = st.size();
		int[] ar = new int[l];
		for (int i = l - 1; i >= 0; i--) {
			ar[i] = st.pop();
		}

		return ar;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
