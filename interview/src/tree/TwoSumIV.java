package tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ryjarvis
 * Apr 30, 2018
 * 
 */
//LeetCode #653
public class TwoSumIV {
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int x){
			val=x;
		}
	}
	
    public boolean findTarget(TreeNode root, int k) {
    	Set<Integer> set=new HashSet<>();  	
    	return helper(root,k,set);      
    }
    
    public boolean helper(TreeNode t,int k,Set<Integer>set){
    	if(t==null) return false;
    	if(set.contains(k-t.val)){
    		return true;
    	}
    	set.add(t.val);
    	return helper(t.left,k,set)||helper(t.right,k,set);	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


