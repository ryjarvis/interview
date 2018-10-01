package tree;

/**
 * @author: ryjarvis Mar 18, 2018
 * 
 */
// LeetCode #124

public class BinaryTreeMaximumPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}
	private int max;
	
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        dfs(root);
        return max;
    }
    
    public int dfs(TreeNode node){
    	if(node==null) return 0;
    	int left=Math.max(0, dfs(node.left));
    	int right=Math.max(0, dfs(node.right));
    	max=Math.max(max,left+right+node.val);
    	return node.val+Math.max(left, right);
    	
    }
	
	



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
