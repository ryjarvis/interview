package math;

//LeetCode #775
public class GlobalAndLocalInversions {

	public boolean isIdealPermutation(int[] A) {
		int minLocal = 0;
		int maxLeft = 0;
		int prevLeft = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[maxLeft] && maxLeft != i - 1 || (A[i] < A[prevLeft] && prevLeft != i - 1)) {
				return false;
			}
			if (A[i] < A[i - 1]) {
				if (A[i] < A[minLocal] && minLocal != i - 1) {
					return false;
				}
				minLocal = i;
			}
			if (A[i] >= A[maxLeft]) {
				prevLeft = maxLeft;
				maxLeft = i;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
