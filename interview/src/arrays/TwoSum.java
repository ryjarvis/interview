package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.spi.DirStateFactory.Result;

public class TwoSum {
	//first version
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> targetMap=new HashMap<Integer,Integer>(nums.length);
        int num1,num2;
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            targetMap.put(nums[i], i);
        }
        int number=0;
        for(Entry<Integer, Integer> entry:targetMap.entrySet()){
        	int n=entry.getKey();
            if(targetMap.containsKey(target-n)){
                /*result[0]=Math.min(entry.getValue(), targetMap.get(target-n));
                result[1]=Math.max(entry.getValue(), targetMap.get(target-n));*/
            	number=n;
                break;
            }
        }

        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(idx>1){
                break;
            }
            else{
                if(nums[i]==number){
                    result[idx++]=i;
                    
                }
                else if(nums[i]==target-number){
                    result[idx++]=i;
                }
            }            
        }
        return result;
    }
    //improved version
    public static int[] improvedTwoSum(int[]nums,int target){
    	Map<Integer,Integer> targetMap=new HashMap<Integer,Integer>();
    	int[]result={-1,-1};
    	//int[]result=new int[2];
    	for(int i=0;i<nums.length;i++){
    		if(targetMap.containsKey(target-i)){
    			 result=new int[]{target-i,i};
    			break;
    		}
    		targetMap.put(nums[i],i);
    	}
    	return result;
    }
}
