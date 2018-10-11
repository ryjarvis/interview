package heap;

import java.util.TreeSet;

//LeetCode #239
public class SlidingWindowMaximum {
	// the idea here is find the upper max from the node and find the lower max
	// then get the max of both-> you have the max of that subarray
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;

		int max[] = new int[n - k + 1];
		if (n == 0)
			return new int[0];
		int[] lowerMax = new int[n];
		int[] higherMax = new int[n];
		int m = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (i % k == 0) {
				lowerMax[i] = nums[i];
				m = nums[i];
			} else {
				m = Math.max(m, nums[i]);
				lowerMax[i] = m;
			}
		}
		m = Integer.MIN_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			if (i % k == 0) {
				higherMax[i] = nums[i];
				m = nums[i];
			} else {
				m = Math.max(m, nums[i]);
				higherMax[i] = m;
			}
		}
		for (int i = 0; i <= n - k; i++) {
			max[i] = Math.max(higherMax[i], lowerMax[i + k - 1]);
		}
		return max;
	}
	
	public static int[] maxSlidingWindowTreeSet(int[] nums, int k) {
		if(nums.length==0) return new int[0];
		TreeSet<Integer> set=new TreeSet<>((a,b)->{
			if(nums[a]!=nums[b]){
				return nums[b]-nums[a];
			}
			else{
				return b-a;
			}
			
		});
		int []max=new int[nums.length-k+1];
		for(int i=0;i<k;i++){
			set.add(i);
		}
		for(int i=k;i<nums.length;i++){
			max[i-k]=nums[set.first()];
			set.remove(i-k);
			set.add(i);
		}
		max[max.length-1]=nums[set.first()];
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = { -7,-8,7,5,7,1,6,0};
		int[] res = maxSlidingWindowTreeSet(ar, 4);

	}

}
