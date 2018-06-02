package tree;

/**
 * @author: ryjarvis Apr 12, 2018
 * 
 */
// LeetCode #617
public class MergeTwoBinaryTrees {
	
	public class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		TreeNode(int x) {
			this.val = x;
		}
	}

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		}
		if (t1 == null) {
			return t2;
		}
		if (t2 == null) {
			return t1;
		}
		TreeNode left = mergeTrees(t1.left, t2.left);
		TreeNode right = mergeTrees(t1.right, t2.right);
		TreeNode root = new TreeNode(t1.val + t2.val);
		root.left = left;
		root.right = right;
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
