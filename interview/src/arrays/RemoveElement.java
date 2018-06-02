package arrays;

/**
 * @author: ryjarvis
 * Dec 24, 2017
 * 
 */
//LeetCode #27
public class RemoveElement {
	
	public int removeElement(int[] nums, int val) {
		int l = nums.length;
		int j = lastValidElement(nums, val, l-1);
		int i = 0;
		while (i <= j) {
			if (nums[i] == val) {
				swap(nums, i, j);
				i++;
				j = lastValidElement(nums, val, j);
			} else {
				i++;
			}
		}
		return i;
	}

	public static void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public static int lastValidElement(int[] nums, int val, int i) {
		while (i >= 0 && nums[i] == val) {
			i--;
		}
		return i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


