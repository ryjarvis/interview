package tree;

import tree.BinaryTreeInorderTraversal.TreeNode;

/**
 * @author: ryjarvis
 * May 6, 2018
 * 
 */
//LeetCode #404
public class SumOfLeftLeaves {
	
	//it is O(N) number of nodes
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val=val;
		}
	}
	
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root,false);
    }
    
    public int helper(TreeNode root,boolean dir){
        if(root==null){
            return 0;
        }
        if(root.left==null&&dir&&root.right==null){
            return root.val;
        }
        return helper(root.left,true)+helper(root.right,false);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


