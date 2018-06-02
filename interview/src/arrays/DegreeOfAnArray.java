package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ryjarvis
 * May 7, 2018
 * 
 */
//LeetCode #697
public class DegreeOfAnArray {
	//O(n) solution
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> mapFreq=new HashMap<>();
        Map<Integer,Integer> mapIdx=new HashMap<>();
        int min=Integer.MAX_VALUE;
        int maxFreq=0;
        for(int i=0;i<nums.length;i++){
            Integer start=mapIdx.get(nums[i]);
            if(start==null){
                mapIdx.put(nums[i],i);
                start=i;
            }
            Integer freq=mapFreq.get(nums[i]);
            freq=freq==null?1:freq+1;            
            mapFreq.put(nums[i],freq);
            if(freq>maxFreq){
                maxFreq=freq;
                min=i-start+1;
            }
            else if(freq==maxFreq){
                min=Math.min(min,i-start+1);
            }
            
        }
        
        return min;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


