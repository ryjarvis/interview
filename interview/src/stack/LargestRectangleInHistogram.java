package stack;

import java.util.Stack;

//LeetCode #84
public class LargestRectangleInHistogram {
	// divide and conquer solution which is very interesting and heuristic
	public int largestRectangleAreaDivideAndConquer(int[] h) {
		return helper(0, h.length, h);
	}

	public int helper(int i, int j, int[] h) {
		if (i == j) {
			return 0;
		}
		if (j == i + 1) {
			return h[i];
		}
		int minIdx = i;
		for (int k = i + 1; k < j; k++) {
			if (h[k] < h[minIdx]) {
				minIdx = k;
			}
		}
		return Math.min(Math.min(helper(i, minIdx, h), helper(minIdx + 1, j, h)), h[minIdx] * (j - i));
	}

	// Here is the stack solution
	public int largestRectangleAreaStack(int[] h) {
		int i = 0;
		int n = h.length;
		int max = 0;
		// note that we only push index to the stack
		Stack<Integer> st = new Stack<>();
		// the trick here is to avoid repeating the same loop by assigning i to
		// n at the end we can intentionally
		// empty the stack and get the max
		for (i = 0; i <= n; i++) {
			int cur = i == n ? 0 : h[i];
			if (!st.isEmpty() && h[st.peek()] <= cur || st.isEmpty()) {
				st.push(i);
			} else {
				int topIdx = st.pop();
				int val = (st.isEmpty()) ? h[topIdx] * i : h[topIdx] * (i - 1 - st.peek());
				max=Math.max(val, max);
				i--;
			}

		}
		return max;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
