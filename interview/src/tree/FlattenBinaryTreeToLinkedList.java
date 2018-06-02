package tree;

/**
 * @author: ryjarvis Apr 14, 2018
 * 
 */
// LeetCode #114
public class FlattenBinaryTreeToLinkedList {
	public class TreeNode{
		TreeNode right;
		TreeNode left;
		int val;
		TreeNode(int x){
			val=x;
		}
	}
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		TreeNode aux = root.right;
		flatten(root.left);
		if (root.left != null) {
			root.right = root.left;
		}
		flatten(aux);
		TreeNode cur = root;
		root.right = root.left;
		root.left = null;
		while (cur.right != null) {
			cur = cur.right;
		}
		cur.right = aux;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
