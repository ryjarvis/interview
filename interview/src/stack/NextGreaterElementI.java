package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: ryjarvis
 * Apr 23, 2018
 * 
 */
//LeetCode #496
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[]res=new int[nums1.length];
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        for(int n:nums2){
            while(!st.isEmpty()&&st.peek()<n){
                int val=st.pop();
                map.put(val,n);
            }
            st.push(n);
        }
        for(int i=0;i<nums1.length;i++){
            Integer val=map.get(nums1[i]);
            if(val==null){
                res[i]=-1;
            }
            else{
                res[i]=val;
            }
        }
        return res;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


