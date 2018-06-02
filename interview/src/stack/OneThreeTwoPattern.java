package stack;

/**
 * @author: ryjarvis
 * Apr 11, 2018
 * 
 */
//LeetCode #456
public class OneThreeTwoPattern {
	
    public static boolean find132pattern(int[] nums) {
    	int leftMin=nums[0];
        for(int i=1;i<nums.length-1;i++){
        	if(nums[i]<=leftMin){
        		leftMin=nums[i];
        		continue;
        	}
        	for(int j=i+1;j<nums.length;j++){
        		if(nums[j]>leftMin&&nums[j]<nums[i]){
        			return true;
        		}
        	}
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


