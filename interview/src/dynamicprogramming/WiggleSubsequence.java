package dynamicprogramming;

import java.util.Arrays;

/**
 * @author: ryjarvis
 * May 22, 2018
 * 
 */
//LeetCode #376
public class WiggleSubsequence {
	//O(n^2)
	public static int wiggleMaxLength(int[] nums) {
    	int n=nums.length;
    	if(n<2) return n; 
    	int[] mem=new int[n];
    	int diff;
    	int max=1;
    	Arrays.fill(mem, 1);
    	for(int i=1;i<n;i++){
    		for(int j=i-1;j>=0;j--){
    			diff=nums[i]-nums[j];
    			if(j==0){
    				if(nums[j]!=nums[i]&&Math.abs(mem[i])<2){
    					if(diff>0){
    						mem[i]=2;
    					}
    					else{
    						mem[i]=-2;
    					}
    				}   				
    			}
    			else if(diff==0){
    				if(Math.abs(mem[i])<Math.abs(mem[j])){
    					mem[i]=mem[j];
    				}
    			}
    			else if(mem[j]*diff>0){
    				continue;
    			}
    			else{
    				if(Math.abs(mem[i])<Math.abs(mem[j])){
    					if(diff>0){
    						mem[i]=Math.abs(mem[j])+1;
    					}
    					else{
    						mem[i]=-(mem[j]+1);
    					}
    				}
    			}
    		}
    		if(Math.abs(mem[i])>max){
    			max=Math.abs(mem[i]);
    		}
    	}
    	return max;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]nums={1,17,5,10,13,15,10,5,16,8};
		wiggleMaxLength(nums);
	}

}


