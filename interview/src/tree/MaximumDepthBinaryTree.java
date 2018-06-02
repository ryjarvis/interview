package tree;

/**
 * @author: ryjarvis
 * Dec 5, 2017
 * 
 */
//LeetCode #104
public class MaximumDepthBinaryTree {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){this.val=x;}
	}
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(1+maxDepth(root.left),1+maxDepth(root.right));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}


