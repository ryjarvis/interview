package tree;

/**
 * @author: ryjarvis Jan 5, 2018
 * 
 */
//LeetCode #112
public class PathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			if (root.val == sum)
				return true;
			return false;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
