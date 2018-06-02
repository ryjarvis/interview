package stack;

import java.util.Stack;

/**
 * @author: ryjarvis
 * May 5, 2018
 * 
 */
//LeetCode #503
public class NextGreaterElementII {
	
    public int[] nextGreaterElements(int[] nums) {
    	int n=nums.length;
        int[]res=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=2*n-1;i>=0;i--){
        	while(!st.isEmpty()&&nums[i%n]>=nums[st.peek()]){
        		st.pop();
        	}
        	res[i%n]=st.isEmpty()?-1:nums[st.peek()];
        	st.push(i%n);
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


