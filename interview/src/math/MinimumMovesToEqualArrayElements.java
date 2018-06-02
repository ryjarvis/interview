package math;

/**
 * @author: ryjarvis
 * May 6, 2018
 * 
 */
//LeetCode #453
public class MinimumMovesToEqualArrayElements {
	
    public int minMoves(int[] nums) {
        int sum=0;
        int min=nums[0];
        for(int i:nums){
            if(i<min){
                min=i;
            }
            sum+=i;
        }
        return sum-(nums.length*min);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


