package disjointset;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ryjarvis
 * Apr 30, 2018
 * 
 */
//LeetCode #565
public class ArrayNesting {
	
    public int arrayNesting(int[] nums) {
    	int max=0;
    	boolean[] seen=new boolean[nums.length];
    	for(int i=0;i<nums.length;i++){
    		if(seen[i]){
    			continue;
    		}
    		int res=traverse(seen,nums,i);
    		max=Math.max(res, max);
    		if(max>nums.length/2){
    			return max;
    		}
    	}
    	return max;
        
    }
    
    public int traverse(boolean[]seen,int[]nums,int i){
    	seen[i]=true;
    	int count=1;
    	int j=i;
    	while(nums[j]!=i){
    		j=nums[j];
    		count++;
    		seen[j]=true;    		
    	}
    	return count;
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


