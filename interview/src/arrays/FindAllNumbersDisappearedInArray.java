package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryjarvis Apr 12, 2018
 * 
 */
// LeetCode #448
public class FindAllNumbersDisappearedInArray {
	// timed out solution o(n^2)
	public List<Integer> findDisappearedNumbersTimeOut(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i <= nums.length; i++) {
			res.add(i);
		}
		for (int i = 0; i < nums.length; i++) {
			if (res.indexOf(nums[i]) != -1) {
				res.remove(res.indexOf(nums[i]));
			}

		}
		return res;

	}
	//my own idea 15 ms O(1) space O(n)
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		int n = nums.length;
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			while (true) {
				if (nums[i] == nums[nums[i] - 1]) {
					break;
				}
				swap(nums[i] - 1, i, nums);
			}
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] != i + 1) {
				res.add(i + 1);
			}
		}
		return res;
	}
	 

	public static void swap(int i, int j, int[] ar) {
		int aux = ar[i];
		ar[i] = ar[j];
		ar[j] = aux;
	}
	
	//some other cool idea negate when you go to that index
	public static List<Integer> findDisappearedNumbersCoolIdea(int[] nums) {
		int n=nums.length;
		int idx;
		List<Integer> res=new ArrayList<>();
		for(int i=0;i<n;i++){
			idx=Math.abs(nums[i]);
			if(nums[idx]>0){
				nums[idx-1]=-nums[idx-1];
			}
		}
		for(int i=0;i<n;i++){
			if(nums[i]>0){
				res.add(i);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
