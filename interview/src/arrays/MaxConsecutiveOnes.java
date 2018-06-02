package arrays;

/**
 * @author: ryjarvis
 * Apr 25, 2018
 * 
 */
//LeetCode #485
public class MaxConsecutiveOnes {
	
    public static int findMaxConsecutiveOnes(int[] nums) {
    	int start=-1;
    	int end=0;
    	int max=0;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==1){
    			if(start<0){
    				start=i;
    				end=i;
    			}
    			else{
    				end++;
    			}
    		}
    		else{
    			if(i-1>=0&&nums[i-1]==1){
    				max=Math.max(end-start+1, max);
    				start=-1;
    			}
    			else{
    				continue;
    			}
    		}
    	}
        if(start>=0){
           max=Math.max(max,end+1-start); 
        }
    	return max;        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


