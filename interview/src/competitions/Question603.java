package competitions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ryjarvis Nov 25, 2017
 * 
 */

public class Question603 {

	public static int[] asteroidCollision(int[] a) {
		ArrayDeque<Integer> deq = new ArrayDeque<>();
		int[] res;
		if (a.length <= 1) {
			return a;
		}
		deq.push(a[0]);
		outer: for (int i = 1; i < a.length; i++) {
			int cur = a[i];
			if (deq.isEmpty()) {
				deq.push(cur);
				continue;
			}
			int prev = deq.peek();
			while (!deq.isEmpty() && !isOk(prev, cur)) {
				if (Math.abs(prev) < Math.abs(cur)) {
					deq.pop();
					if(!deq.isEmpty()){
						prev = deq.peek();
					}					
				} else if (Math.abs(prev) == Math.abs(cur)) {
					deq.pop();
					continue outer;
				} else {
					continue outer;
				}
			}
			deq.push(cur);
		}
		int size = deq.size();
		res = new int[size];
		for (int i = 0; i < size; i++) {
			res[i] = deq.pollLast();
		}
		return res;
	}

	public static boolean isOk(int i, int j) {
		return (((i >> 31) ^ (j >> 31)) == 0 || (i < 0 && j >= 0));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, -2,-2 };
		int[] res;
		res = asteroidCollision(a);
		System.out.println(Arrays.toString(res));
	}

}
