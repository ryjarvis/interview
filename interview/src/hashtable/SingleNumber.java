package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ryjarvis
 * Dec 19, 2017
 * 
 */
//LeetCode #136
public class SingleNumber {
    public int singleNumber(int[] nums) {
    Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.remove(nums[i]);
            } 
            else{
                map.put(nums[i],i);
            }
        }
        for(Integer i:map.values()){
            res=i;
        }
        return nums[res];       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


