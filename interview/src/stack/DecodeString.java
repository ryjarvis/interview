package stack;

import java.util.Stack;

/**
 * @author: ryjarvis Apr 16, 2018
 * 
 */
// LeetCode #294
public class DecodeString {

	public static String decodeString(String s) {
		if (s.isEmpty()) {
			return s;
		}
		char[] c = s.toCharArray();
		Stack<String> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c.length; i++) {
			if (Character.isDigit(c[i])) {
				int idx = s.indexOf('[', i);
				String num = s.substring(i, idx + 1);
				st.push(num);
				i = idx;
			} else if (c[i] == ']') {
				sb = new StringBuilder();
				while (!st.peek().contains("[")) {
					sb.insert(0, st.pop());
				}
				String ap = sb.toString();
				String val = st.pop();
				int num = Integer.valueOf(val.substring(0, val.length() - 1));
				for (int j = 0; j < num - 1; j++) {
					sb.append(ap);
				}
				st.push(sb.toString());
			} else {
				st.push(String.valueOf(c[i]));
			}

		}
		sb = new StringBuilder();
		while (st.size() > 1) {
			sb.insert(0, st.pop());
			sb.insert(0, st.pop());
			st.push(sb.toString());
			sb = new StringBuilder();
		}
		return st.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2[abc]3[cd]ef";
		String res = decodeString(s);
		System.out.println(res);
	}

}
