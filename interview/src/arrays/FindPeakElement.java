package arrays;

/**
 * @author: ryjarvis Jan 5, 2018
 * 
 */
// LeetCode #162
public class FindPeakElement {

	public int findPeakElementNotOptimal(int[] nums) {
		int l = nums.length;
		if (l <= 0) {
			return -1;
		}
		if (l == 1) {
			return 0;
		}
		if (l == 2) {
			if (nums[1] > nums[0]) {
				return 1;
			} else {
				return 0;
			}
		}
		return peakHelper(0, l - 1, nums);
	}

	public int peakHelper(int first, int last, int[] nums) {
		if (first == last) {
			return first;
		}
		int mid = ((last - first) >> 1) + first;
		if (mid == first) {
			if (nums[first] > nums[first + 1]) {
				return first;
			}
			return first + 1;
		}
		if (nums[mid] <= nums[first]) {
			if (first > mid - 1) {
				return first;
			} else {
				return peakHelper(first, mid - 1, nums);
			}

		} else if (nums[mid] <= nums[last]) {
			if (mid + 1 > last) {
				return last;
			} else {
				return peakHelper(mid + 1, last, nums);
			}

		} else {
			if (nums[mid] > nums[mid + 1]) {
				if (nums[mid] > nums[mid - 1]) {
					return mid;
				} else {
					if (first > mid - 1) {
						return first;
					}
					return peakHelper(first, mid - 1, nums);
				}
			} else {
				if (mid + 1 > last)
					return last;
				return peakHelper(mid + 1, last, nums);
			}
		}
	}
	
	public int findPeakElement(int[]nums){
		return helper(0,nums.length-1,nums);
	}
	
	public int helper(int l,int r,int n[]){
		if(l==r){
			return l;
		}
		int m=((r-l)/2)+l;
		if(n[m]>n[m+1]){
			return helper(l,m,n);
		}
		return helper(m+1,r,n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
