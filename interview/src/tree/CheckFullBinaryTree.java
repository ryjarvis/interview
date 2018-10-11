package tree;

//LintCode #726
public class CheckFullBinaryTree {
	public boolean isFullTree(TreeNode root) {

		if (root.left != null && root.right != null) {
			return isFullTree(root.left) && isFullTree(root.right);
		} else if (root.left == null && root.right == null) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
