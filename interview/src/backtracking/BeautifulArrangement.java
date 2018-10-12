package backtracking;

/**
 * @author: ryjarvis Oct 11, 2018
 * 
 */
// LeetCode #526
public class BeautifulArrangement {
	public int countArrangement(int N) {
		int[] ans = new int[1];
		int[] ar = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			ar[i] = i;
		}
		helper(1, ar, ans);
		return ans[0];
	}

	public void helper(int level, int[] ar, int[] ans) {
		if (level == ar.length) {
			ans[0]++;
		}
		for (int i = level; i < ar.length; i++) {
			if (ar[i] % level == 0 || level % ar[i] == 0) {
				swap(ar, level, i);
				helper(level + 1, ar, ans);
				swap(ar, level, i);
			}
		}
	}

	public void swap(int[] ar, int i, int j) {
		int aux = ar[i];
		ar[i] = ar[j];
		ar[j] = aux;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
