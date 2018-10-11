package backtracking;

import java.util.ArrayList;
import java.util.List;

//LeetCode #89
public class GrayCode {

	public static List<Integer> grayCode(int n) {
		int num = 0;
		List<Integer> res = new ArrayList<>();
		res.add(num);
		int size = (int) Math.pow(2, n);
		boolean[] seen = new boolean[size];
		seen[0] = true;
		helper(res, seen, size, n);
		return res;
	}

	public static boolean helper(List<Integer> res, boolean[] seen, int size, int n) {
		if (res.size() == size) {
			return true;
		}
		for (int i = 0; i < n; i++) {
			int mask = 1 << i;
			int next = res.get(res.size() - 1)^mask;
			if (!seen[next]) {
				res.add(next);
				seen[next] = true;
				if(!helper(res, seen, size, n)){
					seen[next] = false;
					res.remove(res.size() - 1);
				}
				else{
					return true;
				}
			}
		}
		return false;

	}
	
    public static List<Integer> grayCodeI(int n) {
        List<Integer> res = new ArrayList<> ();
        int num = 0;
        res.add (num);
        if (n == 0)
            return res;
        int[] flip_indices = new int[1 << n];
        flip_indices[n - 1] = 0;
        dfs (flip_indices, n - 1);
        for (int i = 0; i < flip_indices.length - 1; i++) {
            int flip_idx = flip_indices[i];
            num ^= (1 << flip_idx);
            res.add (num);
        }
        return res;
    }

    // The last element of INDICES stores the next INDEX in it to be updated
    public static void dfs (int[] indices, int depth) {
        if (depth < 0)
            return;
        dfs (indices, depth - 1);
        indices[indices[indices.length - 1]++] = depth;
        dfs (indices, depth - 1);
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer>res=grayCodeI(3);
	}

}
