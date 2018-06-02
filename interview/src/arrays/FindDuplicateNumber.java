package arrays;

/**
 * @author: ryjarvis
 * Jan 26, 2018
 * 
 */
//LeetCode #287
//it is important to look at the arrays sometimes similar way as we look at linked lists
//The evidence of that obvious when you design max or mean heap or even on disjoint sets ds
public class FindDuplicateNumber {
	
	public int findDuplicate(int[] nums) {
		int slow=nums[0];
		int fast=nums[nums[0]];
		while(slow!=fast){
			fast=nums[nums[fast]];
			slow=nums[slow];
		}
		slow=0;
		while(slow!=fast){
			slow=nums[slow];
			fast=nums[fast];
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


